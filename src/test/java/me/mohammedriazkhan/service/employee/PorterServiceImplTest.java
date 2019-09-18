package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.factory.employee.PorterFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.employee.impl.PorterServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PorterServiceImplTest {

    @Autowired
    private PorterServiceImpl porterService;

    @Test
    public void create() {

        Porter porter = PorterFactory.getPorter("Mohammed Riaz", "Khan", "1234564", "1 May 2501", "Renal Doctor", "SuperKey");
        porterService.create(porter);

        assertNotNull(porterService.getAll());

    }

    @Test
    public void read() {

        Porter porter = PorterFactory.getPorter("Mohammed Riaz", "Khan", "1234564", "1 May 2501", "Renal Doctor", "SuperKey");
        porterService.create(porter);

       assertNotNull(porterService.getAll());

        Porter porter1 = porterService.read(porter.getEmployeeId());

        assertEquals(porter, porter1);


    }

    @Test
    public void update() {

        Porter porter = PorterFactory.getPorter("Mohammed Riaz", "Khan", "1234564", "1 May 2501", "Renal Doctor", "SuperKey");
        porterService.create(porter);

        assertNotNull(porterService.getAll());

        Porter porter1 = PorterFactory.getPorter("Mohammed Riaz", "Khan", "1234564", "1 May 2501", "Renal Doctor", "SuperKey");
        porter1.setEmployeeId(porter.getEmployeeId());
        porterService.update(porter1);

        Porter porter2 = porterService.read(porter1.getEmployeeId());

        assertEquals(porter1, porter2);

    }

    @Test
    public void delete() {

        Porter porter = PorterFactory.getPorter("Mohammed Riaz", "Khan", "1234564", "1 May 2501", "Renal Doctor", "SuperKey");
        porterService.create(porter);

        assertNotNull(porterService.getAll());

        porterService.delete(porter.getEmployeeId());

        Porter notInSet = porterService.read(porter.getEmployeeId());

        assertNull(notInSet);





    }
}