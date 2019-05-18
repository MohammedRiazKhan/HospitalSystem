package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.factory.hospital.HospitalFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.hospital.impl.HospitalServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalServiceImplTest {


    @Autowired
    private HospitalServiceImpl hospitalService;

    @Test
    public void create() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

    }

    @Test
    public void read() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

        Hospital fromSet = hospitalService.read(hospital.getHospitalId());

        assertEquals(hospital, fromSet);




    }

    @Test
    public void update() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

        Hospital hospitalUpdate = HospitalFactory.getHospital(null, 1, "Greys fantomy");
        hospitalUpdate.setHospitalId(hospital.getHospitalId());

        hospitalService.update(hospitalUpdate);

        Hospital updated = hospitalService.read(hospitalUpdate.getHospitalId());

        assertEquals(hospitalUpdate, updated);


    }

    @Test
    public void delete() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

        hospitalService.delete(hospital.getHospitalId());

        Hospital notThere = hospitalService.read(hospital.getHospitalId());

        assertNull(notThere);



    }
}