package factories.visits;

import domain.employee.Doctor;
import domain.employee.Nurse;
import domain.patients.InPatient;
import domain.patients.Meal;
import domain.patients.Patient;
import domain.visits.MedicalTool;
import domain.visits.Medication;
import domain.visits.Visit;
import factories.employee.DoctorFactory;
import factories.employee.NurseFactory;
import factories.patients.InPatientFactory;
import factories.patients.PatientFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VisitFactoryTest {

    @Test
    public void getVisit() {


        String firstName = "Riaz";
        String lastName = "Khan";
        String telephone = "0762828630";
        String identityNumber = "1234564897";
        int age = 23;

        List<Patient> p = new ArrayList<Patient>();

        Doctor doc = DoctorFactory.getDoctor(1, "Mohammed", "Khan", "Renal", p);


        List<Meal> m = new ArrayList<>();
        List<String> d = new ArrayList<>();


        List<Medication> medication = new ArrayList<>();

        List<MedicalTool> tools = new ArrayList<>();


        InPatient patient = InPatientFactory.getInPatient("riaz", "khan", "1", "12345" ,23, doc, d, m);

        Nurse docN = NurseFactory.getNurse(1, "Mohammed", "Khan", "Renal", "asd", "das", "afds");


        Visit visit = VisitFactory.getVisit(1, "Today", patient, doc, docN, medication, tools);

        Assert.assertNotNull(visit);

    }
}