package repositories.employees;

import domain.employee.Administration;
import factories.employee.AdministrationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdministrationRepositoryTest {

    AdministrationRepository administrationRepository;

    @Before
    public void setUp() throws Exception {

        administrationRepository = AdministrationRepository.getAdministrationRepository();

    }

    @Test
    public void create() {

        Administration admin = AdministrationFactory.getAdministration();
        administrationRepository.create(admin);

        Assert.assertNotNull(administrationRepository.getAll());

    }

    @Test
    public void read() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration();
        administrationRepository.create(admin);

        //retrieve the adminStaff
        Administration adminInSet = administrationRepository.find(admin.getEmployeeId());

        Assert.assertEquals(admin, adminInSet);

    }

    @Test
    public void update() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration();
        administrationRepository.create(admin);

        //updated version
        Administration adminUpdate = AdministrationFactory.getAdministration();
        adminUpdate.setEmployeeId(admin.getEmployeeId());
        administrationRepository.update(adminUpdate);

        //get the updated version
        Administration updatedVersion = administrationRepository.find(adminUpdate.getEmployeeId());

        Assert.assertEquals(adminUpdate, updatedVersion);

    }

    @Test
    public void delete() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration();
        administrationRepository.create(admin);

        //checks that its not empty
        Assert.assertNotNull(administrationRepository.getAll());

        administrationRepository.delete(admin);

        //check if its deleted
        Administration updatedVersion = administrationRepository.find(admin.getEmployeeId());

        Assert.assertNull(updatedVersion);//will pass if its not there


    }
}