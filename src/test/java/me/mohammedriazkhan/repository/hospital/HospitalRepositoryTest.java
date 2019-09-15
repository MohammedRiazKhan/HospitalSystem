package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.factory.hospital.HospitalFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.hospital.impl.HospitalRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalRepositoryTest {

    @Autowired
    private HospitalRepositoryImpl hospitalRepository;

    @Test
    public void create() {

        Hospital hospital = HospitalFactory.getHospital(null, "da", "Greys Anatomy");

        hospitalRepository.create(hospital);

        assertNotNull(hospitalRepository.getAll());

    }

    @Test
    public void read() {

        Hospital hospital = HospitalFactory.getHospital(null, "ASDf", "Greys Anatomy");

        hospitalRepository.create(hospital);

        assertNotNull(hospitalRepository.getAll());

        Hospital fromSet = hospitalRepository.read(hospital.getHospitalId());

        assertEquals(hospital.getHospitalId(), fromSet.getHospitalId());


    }

    @Test
    public void update() {

        Hospital hospital = HospitalFactory.getHospital(null, "ASDf", "Greys Anatomy");

        hospitalRepository.create(hospital);

        assertNotNull(hospitalRepository.getAll());

        Hospital hospitalUpdate = HospitalFactory.getHospital(null, "ASdf", "Greys fantomy");
        hospitalUpdate.setHospitalId(hospital.getHospitalId());

        hospitalRepository.update(hospitalUpdate);

        Hospital updated = hospitalRepository.read(hospitalUpdate.getHospitalId());

        assertEquals(hospitalUpdate, updated);

    }

    @Test
    public void delete() {

        Hospital hospital = HospitalFactory.getHospital(null, UUID.randomUUID().toString(), "Greys Anatomy");

        hospitalRepository.create(hospital);

        assertNotNull(hospitalRepository.getAll());

        hospitalRepository.delete(hospital.getHospitalId());

        Hospital notThere = hospitalRepository.read(hospital.getHospitalId());

        assertNull(notThere);



    }
}