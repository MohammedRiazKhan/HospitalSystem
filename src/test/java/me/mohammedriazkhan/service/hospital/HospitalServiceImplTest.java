package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
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

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HospitalServiceImplTest {

    @Autowired
    private HospitalServiceImpl hospitalService;

    @Test
    public void a_create() {

        List<Department> departmentList = new ArrayList<>();

        //Hospital
        Hospital hosp = HospitalFactory.getHospital("Greys Anamtomy", "Department 1");

        hospitalService.create(hosp);

        assertNotNull(hospitalService.getAll());

    }

    @Test
    public void b_read() {

        List<Department> departmentList = new ArrayList<>();

        //Hospital
        Hospital hosp = HospitalFactory.getHospital("Greys Anamtomy", "Department 1");
        hosp.setHospitalId("a");

        hospitalService.create(hosp);

        assertNotNull(hospitalService.getAll());

        Hospital fromSet = hospitalService.read("a");

        assertEquals(hosp, fromSet);




    }

    @Test
    public void c_update() {

        List<Department> departmentList = new ArrayList<>();
        Hospital hospital = HospitalFactory.getHospital("Greys Anamtomy", "Department 1");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

        Hospital hospitalUpdate = HospitalFactory.getHospital("Greys Anamtomy", "Department 1");
        hospitalUpdate.setHospitalId(hospital.getHospitalId());

        hospitalService.update(hospitalUpdate);

        Hospital updated = hospitalService.read(hospitalUpdate.getHospitalId());

        assertEquals(hospitalUpdate.getHospitalId(), updated.getHospitalId());


    }

    @Test
    public void d_delete() {

        List<Department> departmentList = new ArrayList<>();

        Hospital hospital = HospitalFactory.getHospital("Greys Anamtomy", "Department 1");

        hospitalService.create(hospital);

        assertNotNull(hospitalService.getAll());

        hospitalService.delete(hospital.getHospitalId());

        Hospital notThere = hospitalService.read(hospital.getHospitalId());

        assertNull(notThere);



    }
}