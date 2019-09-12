package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.employee.impl.DoctorRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorRepositoryTest {

    @Autowired
    private DoctorRepositoryImpl doctorRepository;

    @Test
    public void create() {

        Doctor doc = DoctorFactory.getDoctor(1, "Dr", "Doctor", "Renal");
        doctorRepository.create(doc);

        assertNotNull(doctorRepository.getAll());

    }

    @Test
    public void read() {

        Doctor doc = DoctorFactory.getDoctor(1, "Dr", "Doctor", "Renal");
        doctorRepository.create(doc);

        Doctor fromSet = doctorRepository.read(doc.getEmployeeId());

        assertEquals(doc, fromSet);

    }

    @Test
    public void update() {


        Doctor doctor = DoctorFactory.getDoctor(1,"riaz", "khan", "alles");
        doctorRepository.create(doctor);

        Doctor updatedDoctor = DoctorFactory.getDoctor(1, "Not riaz", "khan", "alles");

        doctorRepository.update(updatedDoctor);

        Assert.assertNotEquals(doctor.getFirstName(), updatedDoctor.getFirstName());


    }

    @Test
    public void delete() {

        Doctor doc = DoctorFactory.getDoctor(1, "Dr", "Doctor", "Renal");
        doctorRepository.create(doc);

        assertNotNull(doctorRepository.getAll());

        doctorRepository.delete(doc.getEmployeeId());

        Doctor docTor = doctorRepository.read(doc.getEmployeeId());

        assertNull(docTor);

    }
}