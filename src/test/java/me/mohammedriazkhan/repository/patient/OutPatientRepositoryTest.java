package me.mohammedriazkhan.repository.patient;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.patient.impl.PatientRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutPatientRepositoryTest {

    @Autowired
    private PatientRepositoryImpl patientRepository;

    @Test
    public void create() {

        Doctor doctor = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");

        Patient aPatient = InPatientFactory.getInPatient("Mohammed", "Khan", "123135", "3213213213", 23, "1231", "1", 123, "111111");


        //create a patient
        patientRepository.create(aPatient);

        //checks if the repos set is not null
        assertNotNull(patientRepository.getAll());

    }

    @Test
    public void read() {

        Doctor doctor = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");

        Patient aPatient = InPatientFactory.getInPatient("Mohammed", "Khan", "123135", "3213213213", 23, "1231", "1", 123, "111111");


        patientRepository.create(aPatient);

        //getting a patient from the set
        Patient patientFromSet = patientRepository.read(aPatient.getPatientId());

        assertEquals(aPatient, patientFromSet);


    }

    @Test
    public void update() {

        Doctor doctor = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");

        Patient aPatient = InPatientFactory.getInPatient("Mohammed", "Khan", "123135", "3213213213", 23, "1231", "1", 123, "111111");


        patientRepository.create(aPatient);

        //creating a new patient to update
        Patient patientNew = InPatientFactory.getInPatient("Mohammed", "Khan", "123135", "3213213213", 23, "1231", "1", 123, "111111");
        patientNew.setPatientId(aPatient.getPatientId());

        //updating the value
        patientRepository.update(patientNew);

        //patient once updated (pulled from set)
        Patient updatedPatientFromSet = patientRepository.read(aPatient.getPatientId());

        assertEquals(patientNew, updatedPatientFromSet);

        System.out.println(patientNew.toString());
        System.out.println(updatedPatientFromSet.toString());

    }

    @Test
    public void delete() {

        Doctor doctor = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");

        Patient aPatient = InPatientFactory.getInPatient("Mohammed", "Khan", "123135", "3213213213", 23, "1231", "1", 123, "111111");


        patientRepository.create(aPatient);

        //checks if set has a value
        assertNotNull(patientRepository.getAll());

        //deleting the patient
        patientRepository.delete(aPatient.getPatientId());

        //checking if object is in set
        Patient patientInSet = patientRepository.read(aPatient.getPatientId());

        //if null it will pass
        assertNull(patientInSet);


    }



}