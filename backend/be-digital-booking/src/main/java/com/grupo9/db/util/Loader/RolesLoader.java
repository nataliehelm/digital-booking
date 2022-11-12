package com.grupo9.db.util.Loader;

import com.grupo9.db.model.ERole;
import com.grupo9.db.model.Role;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.repository.IRoleRepository;
import com.grupo9.db.repository.ISubPolicyRepository;

public class RolesLoader {

    IRoleRepository iRoleRepository;

    public RolesLoader(IRoleRepository iRoleRepository) {
        this.iRoleRepository = iRoleRepository;
    }

    public void Loader (){

        Role role1 = new Role(ERole.ROLE_USER);
        Role role2 = new Role(ERole.ROLE_ADMIN);

        iRoleRepository.save(role1);
        iRoleRepository.save(role2);
    }
}
