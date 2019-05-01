package me.mohammedriaz.factories.visits;

import me.mohammedriaz.domain.employee.Doctor;
import me.mohammedriaz.domain.employee.Nurse;
import me.mohammedriaz.domain.patients.InPatient;
import me.mohammedriaz.domain.patients.Meal;
import me.mohammedriaz.domain.patients.Patient;
import me.mohammedriaz.domain.visits.MedicalTool;
import me.mohammedriaz.domain.visits.Medication;
import me.mohammedriaz.domain.visits.Visit;
import me.mohammedriaz.factories.employee.DoctorFactory;
import me.mohammedriaz.factories.employee.NurseFactory;
import me.mohammedriaz.factories.patients.InPatientFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VisitFactoryTest {

    @Test
    public void getVisit() {


        String firstName = "Riaz";
        String lastName = "Khan";
        String telephone = "0762828630";
        String identityNumber = "1234564897";
        int age = 23;

        List<Patient> p = new ArrayList<Patient>();

        Doctor doc = DoctorFactory.getDoctor( "Mohammed", "Khan", "Renal");


        List<Meal> m = new ArrayList<>();
        List<String> d = new ArrayList<>();


        List<Medication> medication = new ArrayList<>();

        List<MedicalTool> tools = new ArrayList<>();


        InPatient patient = InPatientFactory.getInPatient("riaz", "khan", "1", "12345" ,23, doc);

        Nurse docN = NurseFactory.getNurse(1, "Mohammed", "Khan", "Renal", "asd", "das", "afds");


        Visit visit = VisitFactory.getVisit(1, "Today", patient, doc, docN, medication, tools);

        Assert.assertNotNull(visit);

    }
}