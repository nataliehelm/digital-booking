package com.grupo9.db.util.Loader;

import com.grupo9.db.dto.Auth.SignupDto;
import com.grupo9.db.model.ERole;
import com.grupo9.db.model.Role;
import com.grupo9.db.model.User;
import com.grupo9.db.repository.ILocationRepository;
import com.grupo9.db.repository.IRoleRepository;
import com.grupo9.db.repository.IUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsersLoader {

    IUserRepository iUserRepository;
    IRoleRepository iRoleRepository;
    ILocationRepository iLocationRepository;

    public UsersLoader(IUserRepository iUserRepository, IRoleRepository iRoleRepository, ILocationRepository iLocationRepository) {
        this.iUserRepository = iUserRepository;
        this.iRoleRepository = iRoleRepository;
        this.iLocationRepository = iLocationRepository;
    }

    public void Loader (){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user1 = new User("admin", "admin", "admin@admin.com", passwordEncoder.encode("admin"), iLocationRepository.findById(1L).get(), true);
        user1.setRoles(iRoleRepository.findByName(ERole.ROLE_ADMIN).get());

        User user2 = new User("user", "user", "user@user.com", passwordEncoder.encode("user"), iLocationRepository.findById(1L).get(),true);
        user2.setRoles(iRoleRepository.findByName(ERole.ROLE_USER).get());

        iUserRepository.save(user1);
        iUserRepository.save(user2);

    }
}
