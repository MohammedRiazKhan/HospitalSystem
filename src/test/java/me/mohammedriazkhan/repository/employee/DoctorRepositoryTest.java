package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.employee.impl.DoctorRepositoryImpl;

public class DoctorRepositoryTest {


    DoctorRepositoryImpl doctorRepository;

    @Before
    public void setUp() throws Exception {

        doctorRepository = DoctorRepositoryImpl.getDoctorRepository();

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

        Doctor fromSet = doctorRepository.read(doc.getEmployeeId());

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
        Doctor fromSet = doctorRepository.read(doctor.getEmployeeId());

        Assert.assertEquals(doctor, fromSet);

    }

    @Test
    public void delete() {

        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        doctorRepository.create(doc);

        Assert.assertNotNull(doctorRepository.getAll());

        doctorRepository.delete(doc.getEmployeeId());

        Doctor docTor = doctorRepository.read(doc.getEmployeeId());

        Assert.assertNull(docTor);

    }
}