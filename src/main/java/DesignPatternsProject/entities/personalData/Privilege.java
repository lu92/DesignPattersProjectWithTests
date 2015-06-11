package DesignPatternsProject.entities.personalData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 10.03.15.
 */
@NodeEntity
@TypeAlias("Privilege")
public class Privilege {
    @GraphId
    private Long privilege_id;

    @Indexed(unique = true)
    private String privilege;


    @Fetch
    @RelatedTo(type = "ROLE_PRIVILEGE", direction = Direction.BOTH)
    @JsonIgnore
    private Set<Role> roleStorage = new HashSet<>();

    public Privilege() {
    }

    public Privilege(String privilege) throws IllegalArgumentException{
        if (privilege == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else if (privilege.isEmpty())
            throw new IllegalArgumentException("one or many parameter is empty");
        else if (!privilege.matches("[0-9a-zA-Z ]+"))
            throw new IllegalArgumentException("privilege doesn't consist of only chars, numbers and spaces");
        else
            this.privilege = privilege;
    }
    public Privilege(Long privilege_id, String privilege) {
        this(privilege);
        if (privilege_id == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else
            this.privilege = privilege;
    }


    public static boolean isPrivilegeValid(String zipCode) {
        boolean retval = false;
        String zipCodePattern = "\\[a-zA-Z]+";
        retval = zipCode.matches(zipCodePattern);
        return retval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege1 = (Privilege) o;

        if (!privilege.equals(privilege1.privilege)) return false;
        if (privilege_id != null ? !privilege_id.equals(privilege1.privilege_id) : privilege1.privilege_id != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = privilege_id != null ? privilege_id.hashCode() : 0;
        result = 31 * result + privilege.hashCode();
        return result;
    }

    public Long getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(Long privilege_id) {
        this.privilege_id = privilege_id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilege_id=" + privilege_id +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
