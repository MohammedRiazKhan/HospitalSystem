package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.factory.employee.PorterFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.Impl.PorterRepositoryImpl;

public class PorterRepositoryTest {


    PorterRepositoryImpl porterRepository;

    @Before
    public void setUp() throws Exception {

        porterRepository = PorterRepositoryImpl.getRepository();
    }

    @Test
    public void create() {

        Porter porter = PorterFactory.getPorter(1, "Dale", "Claassen", "66666");
        porterRepository.create(porter);

        Assert.assertNotNull(porterRepository.getAll());

    }

    @Test
    public void read() {

        Porter porter = PorterFactory.getPorter(1, "Dale", "Claassen", "66666");
        porterRepository.create(porter);

        Assert.assertNotNull(porterRepository.getAll());

        Porter porter1 = porterRepository.read(porter.getEmployeeId());

        Assert.assertEquals(porter, porter1);


    }

    @Test
    public void update() {

        Porter porter = PorterFactory.getPorter(1, "Dale", "Claassen", "66666");
        porterRepository.create(porter);

        Assert.assertNotNull(porterRepository.getAll());

        Porter porter1 = PorterFactory.getPorter(1, "Dale", "Claassen", "6666eqwe6");
        porter1.setEmployeeId(porter.getEmployeeId());
        porterRepository.update(porter1);

        Porter porter2 = porterRepository.read(porter1.getEmployeeId());

        Assert.assertEquals(porter1, porter2);

    }

    @Test
    public void delete() {

        Porter porter = PorterFactory.getPorter(1, "Dale", "Claassen", "66666");
        porterRepository.create(porter);

        Assert.assertNotNull(porterRepository.getAll());

        porterRepository.delete(porter.getEmployeeId());

        Porter notInSet = porterRepository.read(porter.getEmployeeId());

        Assert.assertNull(notInSet);





    }
}