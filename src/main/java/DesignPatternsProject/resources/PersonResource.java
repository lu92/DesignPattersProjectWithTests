package DesignPatternsProject.resources;


import DesignPatternsProject.builders.PersonBuilder;
import DesignPatternsProject.entities.actors.Manager;
import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.actors.Student;
import DesignPatternsProject.entities.actors.Worker;
import DesignPatternsProject.entities.personalData.EmploymentContractType;
import DesignPatternsProject.entities.personalData.Salary;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 13.05.15.
 */
public class PersonResource {


    public static Person getJavaDeveloperKamilMilosz() {
        PersonBuilder personBuilder = new PersonBuilder("Kamil_Milosz", "Kamil_Milosz", "kamil_Milosz@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 1", "30-330 Warsaw");
        personBuilder.setPersonality("Kamil", "Milosz", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getJAVADeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 7005));
        return personBuilder.getBuildResult();
    }

    public static Person getManagerJanKowalski() {
        PersonBuilder personBuilder = new PersonBuilder("Jan_Kowal", "Jan_Kowalski", "jan.kowalski@gmail.com", Manager.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 2", "30-330 Warsaw");
        personBuilder.setPersonality("Jan", "Kowalski", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getManagerRole(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 110000));
        return personBuilder.getBuildResult();
    }

    public static Person getManagerJanKowalskiAdmin() {
        PersonBuilder personBuilder = new PersonBuilder("admin", "admin", "jan.kowalski@gmail.com", Manager.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 2", "30-330 Warsaw");
        personBuilder.setPersonality("Jan", "Kowalski", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getManagerRole(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 110000));
        return personBuilder.getBuildResult();
    }
    public static Person getJavaDeveloperWojciechSeliga() {
        PersonBuilder personBuilder = new PersonBuilder("Wojciech_Seliga", "Wojciech_Seliga", "wojciech_seliga@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 3", "30-330 Warsaw");
        personBuilder.setPersonality("Wojciech", "Seliga", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getJAVADeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 7001));
        return personBuilder.getBuildResult();
    }

    public static Person getJavaDeveloperPiotrNawalka() {
        PersonBuilder personBuilder = new PersonBuilder("Piotr_Nawalka", "Piotr_Nawalka", "piotr_nawalka@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 4", "30-330 Warsaw");
        personBuilder.setPersonality("Piotr", "Nawalka", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getJAVADeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 7001));
        return personBuilder.getBuildResult();
    }

    public static Person getJavaDeveloperAdamWojcik() {
        PersonBuilder personBuilder = new PersonBuilder("Adam_Wojcik", "Adam_Wojcik", "adam.wojcik@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 5", "30-330 Warsaw");
        personBuilder.setPersonality("Adam", "Wojcik", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getJAVADeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.FIXED_TERM_EMPLOYMENT, 8000));
        return personBuilder.getBuildResult();
    }
    public static Person getDatabaseDeveloperAdrianKrawiec() {
        PersonBuilder personBuilder = new PersonBuilder("Adrian_Krawiec", "Adrian_Krawiec", "adrian.krawiec@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 8", "30-330 Warsaw");
        personBuilder.setPersonality("Adrian", "Krawiec", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getDataBaseDeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 7000));
        return personBuilder.getBuildResult();
    }

    public static Person getDatabaseDeveloperAdrianCiecholewski() {
        PersonBuilder personBuilder = new PersonBuilder("Adrian_Ciecholewski", "Adrian_Ciecholewski", "adrian.ciecholewski@gmail.com", Student.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 6", "30-330 Warsaw");
        personBuilder.setPersonality("Adrian", "Ciecholewski", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getDataBaseDeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 5700));
        return personBuilder.getBuildResult();
    }

    public static Person getDatabaseDeveloperLukaszDebinski() {
        PersonBuilder personBuilder = new PersonBuilder("Lukasz_Debinski", "Lukasz_Debinski", "lukasz.debinski@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 7",  "30-330 Warsaw");
        personBuilder.setPersonality("Lukasz", "Debinski", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getDataBaseDeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 8500));
        return personBuilder.getBuildResult();
    }


    public static Person getWebDeveloperMateuszStepala() {
        PersonBuilder personBuilder = new PersonBuilder("Mateusz_Stepaka", "Mateusz_Stepala", "mateusz.stepala@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 9", "30-330 Warsaw");
        personBuilder.setPersonality("Mateusz", "Stepala", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getWebDeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 7700));
        return personBuilder.getBuildResult();
    }

    public static Person getWebDeveloperDominikNocon() {
        PersonBuilder personBuilder = new PersonBuilder("Dominik_Nocon", "Dominik_Nocon", "dominik.nocon@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 10", "30-330 Warsaw");
        personBuilder.setPersonality("Dominik", "Nocon", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getWebDeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.FIXED_TERM_EMPLOYMENT, 6000));
        return personBuilder.getBuildResult();
    }

    public static Person getWebDeveloperPrzemekRoman() {
        PersonBuilder personBuilder = new PersonBuilder("Przemek_Roman", "Przemek_Roman", "przemek.roman@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 11", "30-330 Warsaw");
        personBuilder.setPersonality("Przemyslaw", "Roman", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getWebDeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.FIXED_TERM_EMPLOYMENT, 5500));
        return personBuilder.getBuildResult();
    }

    public static Person getUXDesignerMonikaStokrotka() {
        PersonBuilder personBuilder = new PersonBuilder("Monika_Stokrotka", "Monika_Stokrotka", "monika.Stokrotka@gmail.com", Worker.class);
        personBuilder.setAddress("Poland", "Warsaw", "street 12", "30-330 Warsaw");
        personBuilder.setPersonality("Monika", "Stokrotka", "20/04/1970", "123456789");
        personBuilder.addRoles(
                RoleResource.getJAVADeveloper(),
                RoleResource.getWebDeveloper(),
                RoleResource.getWorkerRole());
        personBuilder.setSalary(new Salary(EmploymentContractType.FIXED_TERM_EMPLOYMENT, 9000));
        return personBuilder.getBuildResult();
    }


    public static Set<Person> getAllPersonsFromResources() {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianCiecholewski());
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getDatabaseDeveloperLukaszDebinski());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        personSet.add(PersonResource.getJavaDeveloperKamilMilosz());
        personSet.add(PersonResource.getJavaDeveloperPiotrNawalka());
        personSet.add(PersonResource.getJavaDeveloperWojciechSeliga());
        personSet.add(PersonResource.getManagerJanKowalski());
        personSet.add(PersonResource.getUXDesignerMonikaStokrotka());
        personSet.add(PersonResource.getWebDeveloperDominikNocon());
        personSet.add(PersonResource.getWebDeveloperMateuszStepala());
        personSet.add(PersonResource.getWebDeveloperPrzemekRoman());
        personSet.add(PersonResource.getManagerJanKowalskiAdmin());
        return personSet;
    }

    public static long getNumberOfPersons() {
        return getAllPersonsFromResources().size();
    }

}
