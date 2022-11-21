package com.grupo9.db.service;

import com.grupo9.db.dto.Auth.JwtResponse;
import com.grupo9.db.dto.Auth.LoginDto;
import com.grupo9.db.dto.Auth.ResendEmailDto;
import com.grupo9.db.dto.Auth.SignupDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
import com.grupo9.db.repository.ILocationRepository;
import com.grupo9.db.repository.IRoleRepository;
import com.grupo9.db.repository.IUserRepository;
import com.grupo9.db.security.jwt.JwtUtils;
import com.grupo9.db.security.services.UserDetailsImpl;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AuthService {

    private AuthenticationManager authenticationManager;
    private ResponsesBuilder responsesBuilder;
    private JwtUtils jwtUtils;
    private IUserRepository userRepository;
    private IRoleRepository roleRepository;
    private ILocationRepository locationRepository;
    private PasswordEncoder encoder;
    private EmailServiceImpl emailService;

    @Value("${digitalBooking.app.crypt-password}")
    private String cryptPassword;
    @Value("${digitalBooking.app.activate-user-url}")
    private String activateUserUrl;

    public AuthService(AuthenticationManager authenticationManager, ResponsesBuilder responsesBuilder, JwtUtils jwtUtils, IUserRepository userRepository, IRoleRepository roleRepository, ILocationRepository locationRepository, PasswordEncoder encoder, EmailServiceImpl emailService) {
        this.authenticationManager = authenticationManager;
        this.responsesBuilder = responsesBuilder;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.locationRepository = locationRepository;
        this.encoder = encoder;
        this.emailService = emailService;
    }

    public ResponseEntity<ApiResponse<?, Object>>  login(LoginDto loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"User login successfully", new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles), null);
    }

    public ResponseEntity<ApiResponse<?, Object>>  signup(SignupDto signUpRequest) throws BadRequestException {
        try{
            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                throw new BadRequestException("El correo ya se encuentra registrado");
            }


            User user = new User(signUpRequest.getName(), signUpRequest.getLastname(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
            Role role = roleRepository.findByName(ERole.ROLE_USER).get();

            user.setRoles(role);
            User savedUser = userRepository.save(user);

            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword(cryptPassword);
            String encrypted = encryptor.encrypt(String.valueOf(savedUser.getId()));

            while (encrypted.contains("/")){
                encrypted = encryptor.encrypt(String.valueOf(savedUser.getId()));
            }
            String confirmUrl = activateUserUrl + encrypted + "/activate";

            EmailDetails emailDetails = new EmailDetails();

            emailDetails.setRecipient(signUpRequest.getEmail());
            emailDetails.setSubject("Gracias por tu registro en Digital Booking!");
            emailDetails.setMsgBody("Hola " + signUpRequest.getName() + "! Desde el grupo 9 de Digital Booking te damos la bienvenida. \n\nPara poder continuar con tu registro es necesario que actives tu cuenta. \n\nPor favor da click en el siguiente link: " + confirmUrl);

            sendEmail(emailDetails);

            return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"User registered successfully", user, null);
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }

    public ResponseEntity<ApiResponse<?, Object>>  activateEmail(String id) throws ResourceNotFoundException {
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(cryptPassword);
        String decryptedId = decryptor.decrypt(id);

        Optional<User> user = userRepository.findById(Long.valueOf(decryptedId));
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
        User userToActivate = user.get();
        userToActivate.setActive(true);
        User response = userRepository.save(userToActivate);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"User activated successfully", response, null);
    }


    public ResponseEntity<ApiResponse<?, Object>>  resendEmail(ResendEmailDto resendEmailDto) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findByEmail(resendEmailDto.getEmail());

        if(user.isEmpty()){
            throw new ResourceNotFoundException("User with email " + resendEmailDto.getEmail() + " not found");
        }

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(cryptPassword);
        String confirmUrl = activateUserUrl + encryptor.encrypt(String.valueOf(user.get().getId())) + "/activate";

        EmailDetails emailDetails = new EmailDetails();

        emailDetails.setRecipient(resendEmailDto.getEmail());
        emailDetails.setSubject("Gracias por tu registro en Digital Booking!");
        emailDetails.setMsgBody("Hola " + user.get().getName() + "! Desde el grupo 9 de Digital Booking te damos la bienvenida. \n\nPara poder continuar con tu registro es necesario que actives tu cuenta. \n\nPor favor da click en el siguiente link: " + confirmUrl);

        sendEmail(emailDetails);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"User activated successfully", user, null);
    }

    private void sendEmail(EmailDetails emailDetails) {
        emailService.sendSimpleMail(emailDetails);
    }

}
