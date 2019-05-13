package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.domain.patient.Meal;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import me.mohammedriazkhan.factory.employee.NurseFactory;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
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