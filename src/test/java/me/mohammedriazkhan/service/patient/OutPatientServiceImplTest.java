package me.mohammedriazkhan.service.patient;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.patient.impl.InPatientServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutPatientServiceImplTest {


    @Autowired
    InPatientServiceImpl patientService;


    @Test
    public void create() {

        //doctor instance to pass into patient creation
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");

        //patient
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);

        //create a patient
        patientService.create(patient);

        //checks if the repos set is not null
        assertNotNull(patientService.getAll());

    }

    @Test
    public void read() {

        //creating a patient
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);
        patientService.create(patient);

        //getting a patient from the set
        Patient patientFromSet = patientService.read(patient.getPatientId());

        assertEquals(patient, patientFromSet);


    }

    @Test
    public void update() {

        //creating a patient
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);
        patientService.create(patient);

        //creating a new patient to update
        Patient patientNew = InPatientFactory.getInPatient("Mohammed", "Khan", "0762828630", "1111111111", 23, doc);
        patientNew.setPatientId(patient.getPatientId());

        //updating the value
        patientService.update(patientNew);

        //patient once updated (pulled from set)
        Patient updatedPatientFromSet = patientService.read(patient.getPatientId());

        assertEquals(patientNew, updatedPatientFromSet);

        System.out.println(patientNew.toString());
        System.out.println(updatedPatientFromSet.toString());

    }

    @Test
    public void delete() {

        //creating a patient
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);
        patientService.create(patient);

        //checks if set has a value
        assertNotNull(patientService.getAll());

        //deleting the patient
        patientService.delete(patient.getPatientId());

        //checking if object is in set
        Patient patientInSet = patientService.read(patient.getPatientId());

        //if null it will pass
        assertNull(patientInSet);


    }
}