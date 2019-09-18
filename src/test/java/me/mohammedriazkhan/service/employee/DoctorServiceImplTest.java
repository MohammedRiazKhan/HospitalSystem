package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.employee.impl.DoctorServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceImplTest {

    @Autowired
    private DoctorServiceImpl doctorService;

    @Test
    public void create() {

        Doctor doc = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");
        doctorService.create(doc);

        assertNotNull(doctorService.getAll());

    }

    @Test
    public void read() {

        Doctor doc = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");
        doctorService.create(doc);

        Doctor fromSet = doctorService.read(doc.getEmployeeId());

        assertEquals(doc, fromSet);

    }

    @Test
    public void update() {

        Doctor doc = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");
        doctorService.create(doc);

        assertNotNull(doctorService.getAll());

        Doctor doctor = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");
        doctor.setEmployeeId(doc.getEmployeeId());

        doctorService.update(doctor);

        //get doc
        Doctor fromSet = doctorService.read(doctor.getEmployeeId());

        assertEquals(doctor, fromSet);

    }

    @Test
    public void delete() {

        Doctor doc = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");
        doctorService.create(doc);

        assertNotNull(doctorService.getAll());

        doctorService.delete(doc.getEmployeeId());

        Doctor docTor = doctorService.read(doc.getEmployeeId());

        assertNull(docTor);

    }
}