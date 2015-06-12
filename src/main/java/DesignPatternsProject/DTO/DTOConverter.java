package DesignPatternsProject.DTO;

import DesignPatternsProject.builders.PersonBuilder;
import DesignPatternsProject.entities.actors.*;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.personalData.Privilege;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Category;

import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * Created by lucjan on 08.06.15.
 */
public class DTOConverter {

    private static Format formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static Person toPerson(PersonFormDTO personFormDTO) {
        PersonBuilder personBuilder = new PersonBuilder(
                personFormDTO.getUsername(), personFormDTO.getPassword(),
                personFormDTO.getEmail(), personFormDTO.getPersonType().toString());
        personBuilder.setPersonality(personFormDTO.getName(), personFormDTO.getLastName(),
                personFormDTO.getBirth(), personFormDTO.getTelephoneNumber());
        personBuilder.setAddress(personFormDTO.getCountry(),
                personFormDTO.getCity(), personFormDTO.getStreet(), personFormDTO.getZipCode());
        return personBuilder.getBuildResult();
    }

    public static PersonFormDTO toPersonFormDTO(Person person) {

        PersonFormDTO personFormDTO = new PersonFormDTO(
                person.getUsername(), person.getPassword(), person.getEmail(), person.getPersonality().getName(),
                person.getPersonality().getLastname(), formatter.format(person.getPersonality().getBirth()), person.getPersonality().getTelephoneNumber(),
                person.getAddress().getCountry(), person.getAddress().getCity(), person.getAddress().getStreet(), person.getAddress().getZipCode()
        );
        if (person instanceof Manager)
            personFormDTO.setPersonType(PersonType.MANAGER);

        if (person instanceof Client)
            personFormDTO.setPersonType(PersonType.CLIENT);

        if (person instanceof Student)
            personFormDTO.setPersonType(PersonType.STUDENT);

        if (person instanceof Worker)
            personFormDTO.setPersonType(PersonType.WORKER);

        return personFormDTO;
    }

    public static PersonDTOInfo toPersonDTOInfo(Person person) {
        PersonDTOInfo personDTOInfo = new PersonDTOInfo();
        if (person != null) {
            personDTOInfo.setId(person.getId());
            if (person instanceof Manager)
                personDTOInfo.setPersonType(PersonType.MANAGER);

            if (person instanceof Worker)
                personDTOInfo.setPersonType(PersonType.WORKER);

            if (person instanceof Student)
                personDTOInfo.setPersonType(PersonType.STUDENT);

            personDTOInfo.setUsername(person.getUsername());
            personDTOInfo.setPassword(person.getPassword());
            personDTOInfo.setEmail(person.getEmail());

            personDTOInfo.setName(person.getPersonality().getName());
            personDTOInfo.setLastName(person.getPersonality().getLastname());
            personDTOInfo.setBirth(formatter.format(person.getPersonality().getBirth()));
            personDTOInfo.setTelephoneNumber(person.getPersonality().getTelephoneNumber());
            personDTOInfo.setCountry(person.getAddress().getCountry());
            personDTOInfo.setCity(person.getAddress().getCity());
            personDTOInfo.setZipCode(person.getAddress().getZipCode());

            for (Role role : person.getRoleStorage())
                personDTOInfo.getRoles().add(role.getRole_id());
        }
        return personDTOInfo;
    }

    public static Privilege toPrivilege(PrivilegeDTO privilegeDTO) {
        return new Privilege(privilegeDTO.getName());
    }

    public static PrivilegeDTOInfo toPrivilegeDTOInfo(Privilege privilege) {
        PrivilegeDTOInfo privilegeDTOInfo = new PrivilegeDTOInfo();
        privilegeDTOInfo.setId(privilege.getPrivilege_id());
        privilegeDTOInfo.setName(privilege.getPrivilege());
        return privilegeDTOInfo;
    }

    public static Role toRole(RoleDTO roleDTO) {
        return new Role(roleDTO.getName());
    }
    public static RoleDTOInfo toRoleDTOInfo(Role role) {
        RoleDTOInfo roleDTOInfo = new RoleDTOInfo();
        if (role != null) {
            roleDTOInfo.setId(role.getRole_id());
            roleDTOInfo.setName(role.getName());
            for (Privilege privilege : role.getPrivilegeStorage()) {
                roleDTOInfo.addPrivilegeDTOInfo(DTOConverter.toPrivilegeDTOInfo(privilege));
            }
        }
        return roleDTOInfo;
    }

    public static CategoryDTOInfo toCategoryDTOInfo(Category category) {
        CategoryDTOInfo categoryDTOInfo = new CategoryDTOInfo();
        if (category != null) {
            categoryDTOInfo.setName(category.getName());
            for (BaseProduct baseProduct : category.getProducts())
                categoryDTOInfo.addBaseProduct(baseProduct);
        }
        return categoryDTOInfo;
    }

    public static BaseProductDTOInfo toBaseProductDTOInfo(BaseProduct baseProduct) {
        BaseProductDTOInfo baseProductDTOInfo = new BaseProductDTOInfo();
        if (baseProduct != null) {
            baseProductDTOInfo.setBaseProductId(baseProduct.getId());
            baseProductDTOInfo.setName(baseProduct.getName());
            baseProductDTOInfo.setBrutto(baseProduct.getBrutto());
        }
        return baseProductDTOInfo;
    }

    public static OrderDetailsDTOInfo toOrderDetailsDTOInfo(AbstractOrderDetails orderDetails) {
        OrderDetailsDTOInfo orderDetailsDTOInfo = new OrderDetailsDTOInfo();
        if (orderDetails != null) {
            orderDetailsDTOInfo.setOrderDetailId(orderDetails.getOrder_id());
            orderDetailsDTOInfo.setDate(formatter.format(orderDetails.getDate()));
            orderDetailsDTOInfo.setClient(DTOConverter.toPersonDTOInfo(orderDetails.getClient()));
            for (BaseProduct baseProduct : orderDetails.getOrder())
                orderDetailsDTOInfo.addBaseProduct(baseProduct);
        }
        return orderDetailsDTOInfo;
    }

}
