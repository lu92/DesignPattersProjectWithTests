package DesignPatternsProject.entities.personalData;

import DesignPatternsProject.entities.actors.Person;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 10.03.15.
 */
@NodeEntity
public class Role {

    @GraphId
    private Long role_id;

    @Indexed(unique = true)
    private String name;

    @Fetch @RelatedTo(type = "ROLE_PRIVILEGE", direction = Direction.BOTH)
    private Set<Privilege> privilegeStorage = new HashSet<>();


    @Fetch @RelatedTo(type = "PERSON_ROLE", direction = Direction.BOTH)
    private Person person;

    public Role() {
    }

    public Role(String roleName) throws IllegalArgumentException{
        if (roleName == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else if (roleName.isEmpty())
            throw new IllegalArgumentException("one or many parameter is empty");
        else if (!roleName.matches("[a-zA-Z ]+"))
            throw new IllegalArgumentException("privilege doesn't consist of only chars, numbers and spaces");
        else
            this.name = roleName;
    }

    public Role(Long role_id, String name) throws IllegalArgumentException{
        this(name);
        if (role_id == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else
            this.role_id = role_id;

    }

    //              METHODS

    public void addPrivileges(Privilege ... newPrivileges) throws IllegalArgumentException{
        for (Privilege privilege : newPrivileges)
            if (privilege == null)
                throw new IllegalArgumentException("detect one or many null parameter pointers");

        for (Privilege privilege : newPrivileges)
            privilegeStorage.add(privilege);
    }


    //          END OF METHODS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (privilegeStorage != null ? !privilegeStorage.equals(role.privilegeStorage) : role.privilegeStorage != null) return false;
        if (!name.equals(role.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (privilegeStorage != null ? privilegeStorage.hashCode() : 0);
        return result;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Privilege> getPrivilegeStorage() {
        return privilegeStorage;
    }

    public void setPrivilegeStorage(Set<Privilege> privilegeStorage) {
        this.privilegeStorage = privilegeStorage;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", name='" + name + '\'' +
                ", privilegeStorage=" + privilegeStorage +
                '}';
    }
}
