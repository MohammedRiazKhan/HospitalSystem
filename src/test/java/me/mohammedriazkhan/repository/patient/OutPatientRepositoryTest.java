package me.mohammedriazkhan.repository.patient;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.Impl.PatientRepositoryImpl;

public class OutPatientRepositoryTest {


    PatientRepositoryImpl patientRepository;

    @Before
    public void setUp() throws Exception {
        patientRepository = PatientRepositoryImpl.getRepository();
    }


    @Test
    public void create() {

        //doctor instance to pass into patient creation
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");

        //patient
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);

        //create a patient
        patientRepository.create(patient);

        //checks if the repos set is not null
        Assert.assertNotNull(patientRepository.getAll());

    }

    @Test
    public void read() {

        //creating a patient
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);
        patientRepository.create(patient);

        //getting a patient from the set
        Patient patientFromSet = patientRepository.find(patient.getPatientId());

        Assert.assertEquals(patient, patientFromSet);


    }

    @Test
    public void update() {

        //creating a patient
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);
        patientRepository.create(patient);

        //creating a new patient to update
        Patient patientNew = InPatientFactory.getInPatient("Mohammed", "Khan", "0762828630", "1111111111", 23, doc);
        patientNew.setPatientId(patient.getPatientId());

        //updating the value
        patientRepository.update(patientNew);

        //patient once updated (pulled from set)
        Patient updatedPatientFromSet = patientRepository.find(patient.getPatientId());

        Assert.assertEquals(patientNew, updatedPatientFromSet);

        System.out.println(patientNew.toString());
        System.out.println(updatedPatientFromSet.toString());

    }

    @Test
    public void delete() {

        //creating a patient
        Doctor doc = DoctorFactory.getDoctor("Dr", "Doctor", "Renal");
        Patient patient = InPatientFactory.getInPatient("Riaz", "Khan", "0762828630", "1111111111", 23, doc);
        patientRepository.create(patient);

        //checks if set has a value
        Assert.assertNotNull(patientRepository.getAll());

        //deleting the patient
        patientRepository.delete(patient.getPatientId());

        //checking if object is in set
        Patient patientInSet = patientRepository.find(patient.getPatientId());

        //if null it will pass
        Assert.assertNull(patientInSet);


    }



}