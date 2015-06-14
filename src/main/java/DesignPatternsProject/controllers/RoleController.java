package DesignPatternsProject.controllers;

import DesignPatternsProject.DTO.DTOConverter;
import DesignPatternsProject.DTO.RoleDTOInfo;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.repositories.RoleRepository;
import DesignPatternsProject.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 14.06.15.
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<RoleDTOInfo> getAllRoles() {
        return roleService.getAllRolesInfos();
    }
}
