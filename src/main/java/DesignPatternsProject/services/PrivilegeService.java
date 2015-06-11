package DesignPatternsProject.services;


import DesignPatternsProject.DTO.PrivilegeDTOInfo;
import DesignPatternsProject.entities.personalData.Privilege;

import java.util.Set;

/**
 * Created by lucjan on 25.05.15.
 */
public interface PrivilegeService {
    long createPrivilege(Privilege privilege);
    void deletePrivilege(long privilegeId);
    Privilege getPrivilege(long privilegeId) throws IllegalArgumentException;
    Set<Privilege> getAllPrivileges();
    Set<PrivilegeDTOInfo> getAllPrivilegeDtoInfos();
}
