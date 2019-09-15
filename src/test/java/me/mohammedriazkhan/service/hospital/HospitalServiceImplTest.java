package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.factory.hospital.HospitalFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import me.mohammedriazkhan.service.hospital.impl.HospitalServiceImpl;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HospitalServiceImplTest {

    @Autowired
    private HospitalServiceImpl hospitalService;

    @Test
    public void a_create() {

        Hospital hospital = HospitalFactory.getHospital(null, "h", "Greys Anatomy");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

    }

    @Test
    public void b_read() {

        Hospital hospital = HospitalFactory.getHospital(null, "h", "Greys Anatomy");
        hospital.setHospitalId("a");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

        Hospital fromSet = hospitalService.read("a");

        assertEquals(hospital, fromSet);




    }

    @Test
    public void c_update() {

        Hospital hospital = HospitalFactory.getHospital(null, "h", "Greys Anatomy");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

        Hospital hospitalUpdate = HospitalFactory.getHospital(null, "h", "Greys fantomy");
        hospitalUpdate.setHospitalId(hospital.getHospitalId());

        hospitalService.update(hospitalUpdate);

        Hospital updated = hospitalService.read(hospitalUpdate.getHospitalId());

        assertEquals(hospitalUpdate.getHospitalId(), updated.getHospitalId());


    }

    @Test
    public void d_delete() {

        Hospital hospital = HospitalFactory.getHospital(null, "h", "Greys Anatomy");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

        hospitalService.delete(hospital.getHospitalId());

        Hospital notThere = hospitalService.read(hospital.getHospitalId());

        assertNotNull(notThere);



    }
}