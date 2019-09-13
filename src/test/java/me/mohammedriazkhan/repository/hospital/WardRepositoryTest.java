package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.factory.hospital.WardFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.hospital.impl.WardRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WardRepositoryTest {


    @Autowired
    private WardRepositoryImpl wardRepository;


    @Test
    public void create() {

        Ward ward = WardFactory.getWard(null);
        wardRepository.create(ward);

        assertNotNull(wardRepository.getAll());

    }

    @Test
    public void read() {

        Ward ward = WardFactory.getWard(null);
        wardRepository.create(ward);

        assertNotNull(wardRepository.getAll());

        Ward ward1 = wardRepository.read(ward.getWardId());

        assertEquals(ward, ward1);

    }

    @Test
    public void update() {

        Ward ward = WardFactory.getWard( null);
        wardRepository.create(ward);

        assertNotNull(wardRepository.getAll());

        Ward ward1 = WardFactory.getWard( null);
        ward1.setWardId(ward.getWardId());
        wardRepository.update(ward1);

        Ward ward2 = wardRepository.read(ward1.getWardId());

        assertEquals(ward1, ward2);

    }

    @Test
    public void delete() {

        Ward ward = WardFactory.getWard(null);
        wardRepository.create(ward);

        assertNotNull(wardRepository.getAll());

        wardRepository.delete(ward.getWardId());

        Ward ward1 = wardRepository.read(ward.getWardId());

        assertNull(ward1);



    }
}