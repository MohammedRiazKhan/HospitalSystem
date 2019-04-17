package factories.patients;

import domain.employee.Doctor;
import domain.patients.Meal;
import domain.patients.Patient;
import factories.employee.DoctorFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PatientFactoryTest {

    @Test
    public void getInPatient() {


        Patient aPatient = null;

        List<Patient> p = new ArrayList<>();

        Doctor doc = DoctorFactory.getDoctor(1, "Mohammed", "Khan", "Renal", p);

        List<Meal> daysStayed = new ArrayList<>();
        List<String> meals = new ArrayList<>();


        aPatient = InPatientFactory.getInPatient(
                "Mohammed",
                "Khan",
                "1234568",
                "0000213546546",
                23,
                doc,
                meals,
                daysStayed
        );


        Assert.assertEquals(aPatient.getDoctor(), doc);

    }
}