package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.factory.hospital.WardFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.hospital.impl.WardServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WardServiceImplTest {

    @Autowired
    WardServiceImpl wardService;


    @Test
    public void create() {

        Ward ward = WardFactory.getWard(1, null);
        wardService.create(ward);

        assertNotNull(wardService.getAll());

    }

    @Test
    public void read() {

        Ward ward = WardFactory.getWard(1, null);
        wardService.create(ward);

        assertNotNull(wardService.getAll());

        Ward ward1 = wardService.read(ward.getWardId());

        assertEquals(ward, ward1);

    }

    @Test
    public void update() {

        Ward ward = WardFactory.getWard(1, null);
        wardService.create(ward);

        assertNotNull(wardService.getAll());

        Ward ward1 = WardFactory.getWard(1, null);
        ward1.setWardId(ward.getWardId());
        wardService.update(ward1);

        Ward ward2 = wardService.read(ward1.getWardId());

        assertEquals(ward1, ward2);

    }

    @Test
    public void delete() {

        Ward ward = WardFactory.getWard(1, null);
        wardService.create(ward);

        assertNotNull(wardService.getAll());

        wardService.delete(ward.getWardId());

        Ward ward1 = wardService.read(ward.getWardId());

        assertNull(ward1);



    }
}