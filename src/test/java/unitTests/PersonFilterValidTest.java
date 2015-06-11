package unitTests;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.FilterHandlerBuilder;
import DesignPatternsProject.filters.personFilters.*;
import DesignPatternsProject.resources.PersonResource;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 10.06.15.
 */
public class PersonFilterValidTest {
    @Test
    public void AddressCriteria () {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new AddressCriteria(PersonResource.getJavaDeveloperAdamWojcik().getAddress()));
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getJavaDeveloperAdamWojcik());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }



    @Test
    public void FixedTermEmploymentTypeCriteria () {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new FixedTermEmploymentTypeCriteria());
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getJavaDeveloperAdamWojcik());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void NameAndLastNameCriteria() {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new NameAndLastNameCriteria("Adam", "Wojcik"));
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getJavaDeveloperAdamWojcik());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void RegularEmploymenTypeCriteria () {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new RegularEmploymenTypeCriteria());
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void RoleCriteria () {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new RoleCriteria("Java Developer Role"));
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getJavaDeveloperAdamWojcik());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void SalaryBruttoGreaterThanCriteria () {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new SalaryBruttoGreaterThanCriteria(7500));
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getJavaDeveloperAdamWojcik());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void SalaryBruttoLessThanCriteria () {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new SalaryBruttoLessThanCriteria(7500));
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void SalaryNettoGreaterThanCriteria() {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());

        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new SalaryNettoGreaterThanCriteria(5000));
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getJavaDeveloperAdamWojcik());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void SalaryNettoLessThanCriteria () {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(personSet);
        filterManagerBuilder.addCriteria(new SalaryNettoLessThanCriteria(5000));
        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void flow1() {
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(PersonResource.getAllPersonsFromResources());
        filterManagerBuilder.addCriteria(
                new AddressCriteria(PersonResource.getDatabaseDeveloperAdrianKrawiec().getAddress()),
                new RegularEmploymenTypeCriteria(), new NameAndLastNameCriteria("Adrian", "Krawiec"),
                new SalaryBruttoGreaterThanCriteria(6000), new SalaryBruttoLessThanCriteria(8000),
                new SalaryNettoGreaterThanCriteria(4000), new SalaryNettoLessThanCriteria(5000),
                new RoleCriteria("DataBase Developer Role"));
        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

    @Test
    public void flow2() {
        FilterHandlerBuilder filterManagerBuilder = new FilterHandlerBuilder(PersonResource.getAllPersonsFromResources());
        filterManagerBuilder.addCriteria(
                new AddressCriteria(PersonResource.getJavaDeveloperAdamWojcik().getAddress()),
                new FixedTermEmploymentTypeCriteria(), new NameAndLastNameCriteria("Adam", "Wojcik"),
                new RoleCriteria("Java Developer Role"), new SalaryBruttoLessThanCriteria(8100),
                new SalaryBruttoGreaterThanCriteria(7000), new SalaryNettoGreaterThanCriteria(7000),
                new SalaryNettoLessThanCriteria(7500));
        Set<Person> properResult = new HashSet<>();
        properResult.add(PersonResource.getJavaDeveloperAdamWojcik());
        Assert.assertEquals(properResult, filterManagerBuilder.getBuiltResult().doFilter());
    }

}
