package me.mohammedriazkhan.factory;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patients.InPatient;
import me.mohammedriazkhan.domain.patients.Meal;
import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import me.mohammedriazkhan.factory.patients.InPatientFactory;
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

        Doctor doc = DoctorFactory.getDoctor( "Mohammed", "Khan", "Renal");


        List<Meal> m = new ArrayList<>();
        List<String> d = new ArrayList<>();


        InPatient patient = InPatientFactory.getInPatient("riaz", "khan", "1", "12345" ,23, doc);

        Assert.assertNotNull(patient.getPatientId());




    }
}