package factories;

import domain.employee.Doctor;
import domain.patients.Patient;
import factories.employee.DoctorFactory;
import factories.patients.PatientFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PatientFactoryTest {


    @Test
    public void getPatient() {

        String firstName = "Riaz";
        String lastName = "Khan";
        String telephone = "0762828630";
        String identityNumber = "1234564897";
        int age = 23;

        List<Patient> p = new ArrayList<Patient>();

        Doctor doc = DoctorFactory.getDoctor(1, "Mohammed", "Khan", "Renal", p);

        Patient patient = PatientFactory.getPatient(firstName, lastName, telephone, identityNumber, age, doc);

        Assert.assertNotNull(patient.getPatientId());




    }
}