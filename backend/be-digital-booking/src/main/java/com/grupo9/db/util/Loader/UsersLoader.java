package com.grupo9.db.util.Loader;

import com.grupo9.db.dto.Auth.SignupDto;
import com.grupo9.db.model.ERole;
import com.grupo9.db.model.Role;
import com.grupo9.db.model.User;
import com.grupo9.db.repository.IRoleRepository;
import com.grupo9.db.repository.IUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsersLoader {

    IUserRepository iUserRepository;
    IRoleRepository iRoleRepository;

    public UsersLoader(IUserRepository iUserRepository, IRoleRepository iRoleRepository) {
        this.iUserRepository = iUserRepository;
        this.iRoleRepository = iRoleRepository;
    }

    public void Loader (){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user1 = new User("admin", "admin", "admin@admin.com", passwordEncoder.encode("admin"));
        user1.setRoles(iRoleRepository.findByName(ERole.ROLE_ADMIN).get());

        iUserRepository.save(user1);
    }
}
