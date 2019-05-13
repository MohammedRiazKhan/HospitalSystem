package me.mohammedriazkhan.service.employees;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.factory.employee.CleanerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.Impl.CleanerServiceImpl;

public class CleanerServiceImplTest {

    CleanerServiceImpl cleanerService;

    @Before
    public void setUp() throws Exception {

        cleanerService = new CleanerServiceImpl();

    }

    @Test
    public void create() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner();

        cleanerService.create(cleaner);

        Assert.assertNotNull(cleanerService.getAll());

    }

    @Test
    public void read() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner();
        cleanerService.create(cleaner);

        System.out.println(cleaner.getEmployeeId());

        //get a cleaner
        Cleaner cleaner1 = cleanerService.read(cleaner.getEmployeeId());

        System.out.println(cleaner1);

    }

    @Test
    public void update() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner();
        cleanerService.create(cleaner);

        //create a cleaner2
        Cleaner cleaner2 = CleanerFactory.getCleaner();
        cleaner2.setEmployeeId(cleaner.getEmployeeId());

        cleanerService.update(cleaner2);

        //cleaner received
        Cleaner cleaner3 = cleanerService.read(cleaner2.getEmployeeId());

        Assert.assertEquals(cleaner3, cleaner2);




    }

    @Test
    public void delete() {
        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner();
        cleanerService.create(cleaner);

        Assert.assertNotNull(cleanerService.getAll());

        //delete
        cleanerService.delete(cleaner.getEmployeeId());

        //try to get it
        Cleaner notThere = cleanerService.read(cleaner.getEmployeeId());

        Assert.assertNull(notThere);




    }
}