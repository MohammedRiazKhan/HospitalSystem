package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.factory.employee.CleanerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.employee.impl.CleanerRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CleanerRepositoryTest {

    @Autowired
    private CleanerRepositoryImpl cleanerRepository;

    @Test
    public void create() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner("Tabeka", "Mwlaphembu", "000000", "N/A", "Cleaner", "Hair Massage");

        cleanerRepository.create(cleaner);

        assertNotNull(cleanerRepository.getAll());

    }

    @Test
    public void read() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner("Tabeka", "Mwlaphembu", "000000", "N/A", "Cleaner", "Hair Massage");
        cleanerRepository.create(cleaner);

        System.out.println(cleaner.getEmployeeId());

        //get a cleaner
        Cleaner cleaner1 = cleanerRepository.read(cleaner.getEmployeeId());

        System.out.println(cleaner1);

    }

    @Test
    public void update() {

        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner("Tabeka", "Mwlaphembu", "000000", "N/A", "Cleaner", "Hair Massage");
        cleanerRepository.create(cleaner);

        //create a cleaner2
        Cleaner cleaner2 = CleanerFactory.getCleaner("Tabeka", "Mwlaphembu", "000000", "N/A", "Cleaner", "Hair Massage");
        cleaner2.setEmployeeId(cleaner.getEmployeeId());

        cleanerRepository.update(cleaner2);

        //cleaner received
        Cleaner cleaner3 = cleanerRepository.read(cleaner2.getEmployeeId());

        assertEquals(cleaner3, cleaner2);




    }

    @Test
    public void delete() {
        //create a cleaner
        Cleaner cleaner = CleanerFactory.getCleaner("Tabeka", "Mwlaphembu", "000000", "N/A", "Cleaner", "Hair Massage");
        cleanerRepository.create(cleaner);

        assertNotNull(cleanerRepository.getAll());

        //delete
        cleanerRepository.delete(cleaner.getEmployeeId());

        //try to get it
        Cleaner notThere = cleanerRepository.read(cleaner.getEmployeeId());

        assertNull(notThere);




    }
}