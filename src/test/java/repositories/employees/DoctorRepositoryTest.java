package repositories.employees;

import domain.employee.Doctor;
import factories.employee.DoctorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorRepositoryTest {


    DoctorRepository doctorRepository;

    @Before
    public void setUp() throws Exception {

        doctorRepository = DoctorRepository.getDoctorRepository();

    }

    @Test
    public void create() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorRepository.create(doc);

        Assert.assertNotNull(doctorRepository.getAll());

    }

    @Test
    public void read() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorRepository.create(doc);

        Doctor fromSet = doctorRepository.find(doc.getEmployeeId());

        Assert.assertEquals(doc, fromSet);

    }

    @Test
    public void update() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorRepository.create(doc);

        Assert.assertNotNull(doctorRepository.getAll());

        Doctor doctor = DoctorFactory.getDoctor("Dr", "Dr", "Renal");
        doctor.setEmployeeId(doc.getEmployeeId());

        doctorRepository.update(doctor);

        //get doc
        Doctor fromSet = doctorRepository.find(doctor.getEmployeeId());

        Assert.assertEquals(doctor, fromSet);

    }

    @Test
    public void delete() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorRepository.create(doc);

        Assert.assertNotNull(doctorRepository.getAll());

        doctorRepository.delete(doc);

        Doctor docTor = doctorRepository.find(doc.getEmployeeId());

        Assert.assertNull(docTor);

    }
}