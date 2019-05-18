package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.factory.employee.CleanerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.employee.impl.CleanerServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CleanerServiceImplTest {

    @Autowired
    private CleanerServiceImpl cleanerService;


    @Test
    public void create() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner(1);

        cleanerService.create(cleaner);

        assertNotNull(cleanerService.getAll());

    }

    @Test
    public void read() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner(1);
        cleanerService.create(cleaner);

        System.out.println(cleaner.getEmployeeId());

        //get a cleaner
        Cleaner cleaner1 = cleanerService.read(cleaner.getEmployeeId());

        System.out.println(cleaner1);

    }

    @Test
    public void update() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner(1);
        cleanerService.create(cleaner);

        //create a cleaner2
        Cleaner cleaner2 = CleanerFactory.getCleaner(1);
        cleaner2.setEmployeeId(cleaner.getEmployeeId());

        cleanerService.update(cleaner2);

        //cleaner received
        Cleaner cleaner3 = cleanerService.read(cleaner2.getEmployeeId());

        assertEquals(cleaner3, cleaner2);




    }

    @Test
    public void delete() {
        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner(1);
        cleanerService.create(cleaner);

        assertNotNull(cleanerService.getAll());

        //delete
        cleanerService.delete(cleaner.getEmployeeId());

        //try to get it
        Cleaner notThere = cleanerService.read(cleaner.getEmployeeId());

        assertNull(notThere);




    }
}