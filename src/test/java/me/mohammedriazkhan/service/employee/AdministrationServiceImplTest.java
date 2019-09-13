package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.factory.employee.AdministrationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.employee.impl.AdministrationServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministrationServiceImplTest {

    @Autowired
    private AdministrationServiceImpl administrationService;


    @Test
    public void create() {

        Administration admin = AdministrationFactory.getAdministration( "Jane");
        administrationService.create(admin);

        assertNotNull(administrationService.getAll());

    }

    @Test
    public void read() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration( "Janbe");
        administrationService.create(admin);

        //retrieve the adminStaff
        Administration adminInSet = administrationService.read(admin.getEmployeeId());

        assertEquals(admin, adminInSet);

    }

    @Test
    public void update() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration( "kane");
        administrationService.create(admin);

        //updated version
        Administration adminUpdate = AdministrationFactory.getAdministration( "Khan");
        adminUpdate.setEmployeeId(admin.getEmployeeId());
        administrationService.update(adminUpdate);

        //get the updated version
        Administration updatedVersion = administrationService.read(adminUpdate.getEmployeeId());

        assertEquals(adminUpdate, updatedVersion);

    }

    @Test
    public void delete() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration( "Pane");
        administrationService.create(admin);

        //checks that its not empty
        assertNotNull(administrationService.getAll());

        administrationService.delete(admin.getEmployeeId());

        //check if its deleted
        Administration updatedVersion = administrationService.read(admin.getEmployeeId());

        assertNull(updatedVersion);//will pass if its not there


    }
}