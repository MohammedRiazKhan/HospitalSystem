package factories;

import domain.Doctor;
import domain.Patient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientFactoryTest {


    @Test
    public void getPatient() {

        String firstName = "Riaz";
        String lastName = "Khan";
        String telephone = "0762828630";
        String identityNumber = "1234564897";
        int age = 23;
        Doctor doc = DoctorFactory.getDoctor("Mohammed");

        Patient patient = PatientFactory.getPatient(firstName, lastName, telephone, identityNumber, age, doc);

        Assert.assertNotNull(patient.getPatientId());

    }
}