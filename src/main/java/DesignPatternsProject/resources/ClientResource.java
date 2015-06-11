package DesignPatternsProject.resources;

import DesignPatternsProject.builders.PersonBuilder;
import DesignPatternsProject.entities.actors.Client;

/**
 * Created by lucjan on 05.06.15.
 */
public class ClientResource {

    public static Client getAnnaNowak() {
        PersonBuilder personBuilder = new PersonBuilder("Anna_Nowak", "Anna_Nowak", "anna.nowak@gmail.com", Client.class);
        personBuilder.setAddress("Poland", "Warsaw", "Mikołaja Kopernika 2/6", "30-330 Warsaw");
        personBuilder.setPersonality("Anna", "Nowak", "20/04/1970", "123456789");
        personBuilder.addRoles(RoleResource.getClientRole());
        return (Client) personBuilder.getBuildResult();
    }

    public static Client getPiotrKraus() {
        PersonBuilder personBuilder = new PersonBuilder("Piotr_Kraus", "Piotr_Kraus", "piotr.kraus@gmail.com", Client.class);
        personBuilder.setAddress("Poland", "Warsaw", "Adama Mickiewicza 23/4", "30-330 Warsaw");
        personBuilder.setPersonality("Piotr", "Kraus", "20/04/1970", "123456789");
        personBuilder.addRoles(RoleResource.getClientRole());
        return (Client) personBuilder.getBuildResult();
    }
}
