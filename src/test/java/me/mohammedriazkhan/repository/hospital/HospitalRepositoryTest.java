package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.factory.hospital.HospitalFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.Impl.HospitalRepositoryImpl;

public class HospitalRepositoryTest {


    HospitalRepositoryImpl hospitalRepository;

    @Before
    public void setUp() throws Exception {

        hospitalRepository = HospitalRepositoryImpl.getRepository();

    }

    @Test
    public void create() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalRepository.create(hospital);

        Assert.assertNotNull(hospitalRepository.getAll());

    }

    @Test
    public void read() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalRepository.create(hospital);

        Assert.assertNotNull(hospitalRepository.getAll());

        Hospital fromSet = hospitalRepository.read(hospital.getHospitalId());

        Assert.assertEquals(hospital, fromSet);




    }

    @Test
    public void update() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalRepository.create(hospital);

        Assert.assertNotNull(hospitalRepository.getAll());

        Hospital hospitalUpdate = HospitalFactory.getHospital(null, 1, "Greys fantomy");
        hospitalUpdate.setHospitalId(hospital.getHospitalId());

        hospitalRepository.update(hospitalUpdate);

        Hospital updated = hospitalRepository.find(hospitalUpdate.getHospitalId());

        Assert.assertEquals(hospitalUpdate, updated);


    }

    @Test
    public void delete() {

        Hospital hospital = HospitalFactory.getHospital(null, 1, "Greys Anatomy");

        hospitalRepository.create(hospital);

        Assert.assertNotNull(hospitalRepository.getAll());

        hospitalRepository.delete(hospital.getHospitalId());

        Hospital notThere = hospitalRepository.find(hospital.getHospitalId());

        Assert.assertNull(notThere);



    }
}