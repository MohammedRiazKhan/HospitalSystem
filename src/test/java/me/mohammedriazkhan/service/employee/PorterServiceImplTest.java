package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.factory.employee.PorterFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.employee.impl.PorterServiceImpl;

public class PorterServiceImplTest {
    PorterServiceImpl porterService;

    @Before
    public void setUp() throws Exception {

        porterService =new PorterServiceImpl();
    }

    @Test
    public void create() {

        Porter porter = PorterFactory.getPorter(1, "Dale", "Claassen", "66666");
        porterService.create(porter);

        Assert.assertNotNull(porterService.getAll());

    }

    @Test
    public void read() {

        Porter porter = PorterFactory.getPorter(1, "Dale", "Claassen", "66666");
        porterService.create(porter);

        Assert.assertNotNull(porterService.getAll());

        Porter porter1 = porterService.read(porter.getEmployeeId());

        Assert.assertEquals(porter, porter1);


    }

    @Test
    public void update() {

        Porter porter = PorterFactory.getPorter(1, "Dale", "Claassen", "66666");
        porterService.create(porter);

        Assert.assertNotNull(porterService.getAll());

        Porter porter1 = PorterFactory.getPorter(1, "Dale", "Claassen", "6666eqwe6");
        porter1.setEmployeeId(porter.getEmployeeId());
        porterService.update(porter1);

        Porter porter2 = porterService.read(porter1.getEmployeeId());

        Assert.assertEquals(porter1, porter2);

    }

    @Test
    public void delete() {

        Porter porter = PorterFactory.getPorter(1, "Dale", "Claassen", "66666");
        porterService.create(porter);

        Assert.assertNotNull(porterService.getAll());

        porterService.delete(porter.getEmployeeId());

        Porter notInSet = porterService.read(porter.getEmployeeId());

        Assert.assertNull(notInSet);





    }
}