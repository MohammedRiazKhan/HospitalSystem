package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.factory.employee.CleanerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.Impl.CleanerRepositoryImpl;

public class CleanerRepositoryTest {


    CleanerRepositoryImpl cleanerRepository;

    @Before
    public void setUp() throws Exception {

        cleanerRepository = CleanerRepositoryImpl.getCleanerRepository();

    }

    @Test
    public void create() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner();

        cleanerRepository.create(cleaner);

        Assert.assertNotNull(cleanerRepository.getAll());

    }

    @Test
    public void read() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner();
        cleanerRepository.create(cleaner);

        System.out.println(cleaner.getEmployeeId());

        //get a cleaner
        Cleaner cleaner1 = cleanerRepository.read(cleaner.getEmployeeId());

        System.out.println(cleaner1);

    }

    @Test
    public void update() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner();
        cleanerRepository.create(cleaner);

        //create a cleaner2
        Cleaner cleaner2 = CleanerFactory.getCleaner();
        cleaner2.setEmployeeId(cleaner.getEmployeeId());

        cleanerRepository.update(cleaner2);

        //cleaner received
        Cleaner cleaner3 = cleanerRepository.find(cleaner2.getEmployeeId());

        Assert.assertEquals(cleaner3, cleaner2);




    }

    @Test
    public void delete() {
        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner();
        cleanerRepository.create(cleaner);

        Assert.assertNotNull(cleanerRepository.getAll());

        //delete
        cleanerRepository.delete(cleaner.getEmployeeId());

        //try to get it
        Cleaner notThere = cleanerRepository.find(cleaner.getEmployeeId());

        Assert.assertNull(notThere);




    }
}