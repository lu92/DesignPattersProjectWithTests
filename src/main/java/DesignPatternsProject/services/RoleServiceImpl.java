package DesignPatternsProject.services;


import DesignPatternsProject.entities.personalData.Privilege;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.repositories.PrivilegeRepository;
import DesignPatternsProject.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 25.05.15.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public long createRole(Role role) {
        return roleRepository.save(role).getRole_id();
    }

    @Override
    public void deleteRole(long roleId) {
        roleRepository.delete(roleId);
    }

    @Override
    public Role getRole(long roleId) throws IllegalArgumentException{
        return roleRepository.findOne(roleId);
    }

    @Override
    public Set<Role> getAllRoles() {
        Set<Role> roleSet = new HashSet<>();
        for (Role role : roleRepository.findAll())
            roleSet.add(role);
        return roleSet;
    }

    @Override
    public boolean addPrivilegeToRole(long roleId, long privilegeId) throws IllegalArgumentException {
        Role role = null;
        Privilege privilege = null;

        try {
            role = roleRepository.findOne(roleId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Role with id " + roleId + " doesn't exists");
        }

        try {
            privilege = privilegeRepository.findOne(privilegeId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Privilege with id " + privilegeId + " doesn't exists");
        }

        role.addPrivileges(privilege);
        roleRepository.save(role);
        return true;
    }
}
