package repositories.hospital;

import domain.hospital.Hospital;
import factories.hospital.HospitalFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HospitalRepositoryTest {


    HospitalRepository hospitalRepository;

    @Before
    public void setUp() throws Exception {

        hospitalRepository = HospitalRepository.getRepository();

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

        hospitalRepository.delete(hospital);

        Hospital notThere = hospitalRepository.find(hospital.getHospitalId());

        Assert.assertNull(notThere);



    }
}