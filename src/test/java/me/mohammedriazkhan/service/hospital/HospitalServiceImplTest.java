package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.factory.hospital.HospitalFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.Impl.HospitalServiceImpl;

public class HospitalServiceImplTest {


    HospitalServiceImpl hospitalService;

    @Before
    public void setUp() throws Exception {

        hospitalService = new HospitalServiceImpl();

    }

    @Test
    public void create() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalService.create(hospital);

        Assert.assertNotNull(hospitalService.getAll());

    }

    @Test
    public void read() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalService.create(hospital);

        Assert.assertNotNull(hospitalService.getAll());

        Hospital fromSet = hospitalService.read(hospital.getHospitalId());

        Assert.assertEquals(hospital, fromSet);




    }

    @Test
    public void update() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalService.create(hospital);

        Assert.assertNotNull(hospitalService.getAll());

        Hospital hospitalUpdate = HospitalFactory.getHospital(null, 1, "Greys fantomy");
        hospitalUpdate.setHospitalId(hospital.getHospitalId());

        hospitalService.update(hospitalUpdate);

        Hospital updated = hospitalService.read(hospitalUpdate.getHospitalId());

        Assert.assertEquals(hospitalUpdate, updated);


    }

    @Test
    public void delete() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalService.create(hospital);

        Assert.assertNotNull(hospitalService.getAll());

        hospitalService.delete(hospital.getHospitalId());

        Hospital notThere = hospitalService.read(hospital.getHospitalId());

        Assert.assertNull(notThere);



    }
}