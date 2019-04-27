package services.employees;

import domain.employee.Doctor;
import factories.employee.DoctorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.Impl.DoctorServiceImpl;

public class DoctorServiceImplTest {

    DoctorServiceImpl doctorService;

    @Before
    public void setUp() throws Exception {

        doctorService = new DoctorServiceImpl();

    }

    @Test
    public void create() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorService.create(doc);

        Assert.assertNotNull(doctorService.getAll());

    }

    @Test
    public void read() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorService.create(doc);

        Doctor fromSet = doctorService.read(doc.getEmployeeId());

        Assert.assertEquals(doc, fromSet);

    }

    @Test
    public void update() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorService.create(doc);

        Assert.assertNotNull(doctorService.getAll());

        Doctor doctor = DoctorFactory.getDoctor("Dr", "Dr", "Renal");
        doctor.setEmployeeId(doc.getEmployeeId());

        doctorService.update(doctor);

        //get doc
        Doctor fromSet = doctorService.read(doctor.getEmployeeId());

        Assert.assertEquals(doctor, fromSet);

    }

    @Test
    public void delete() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorService.create(doc);

        Assert.assertNotNull(doctorService.getAll());

        doctorService.delete(doc.getEmployeeId());

        Doctor docTor = doctorService.read(doc.getEmployeeId());

        Assert.assertNull(docTor);

    }
}