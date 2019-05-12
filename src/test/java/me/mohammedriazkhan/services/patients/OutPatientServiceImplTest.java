package me.mohammedriazkhan.services.patients;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.factories.employee.DoctorFactory;
import me.mohammedriazkhan.factories.patients.InPatientFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.services.Impl.InPatientServiceImpl;

public class OutPatientServiceImplTest {


    InPatientServiceImpl patientService;

    @Before
    public void setUp() throws Exception {
        patientService = new InPatientServiceImpl();
    }


    @Test
    public void create() {

        //doctor instance to pass into patient creation
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");

        //patient
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);

        //create a patient
        patientService.create(patient);

        //checks if the repos set is not null
        Assert.assertNotNull(patientService.getAll());

    }

    @Test
    public void read() {

        //creating a patient
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);
        patientService.create(patient);

        //getting a patient from the set
        Patient patientFromSet = patientService.read(patient.getPatientId());

        Assert.assertEquals(patient, patientFromSet);


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

        Assert.assertEquals(patientNew, updatedPatientFromSet);

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
        Assert.assertNotNull(patientService.getAll());

        //deleting the patient
        patientService.delete(patient.getPatientId());

        //checking if object is in set
        Patient patientInSet = patientService.read(patient.getPatientId());

        //if null it will pass
        Assert.assertNull(patientInSet);


    }
}