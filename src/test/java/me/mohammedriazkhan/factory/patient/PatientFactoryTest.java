package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.Meal;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PatientFactoryTest {

    @Test
    public void getInPatient() {


        Patient aPatient = null;

        List<Patient> p = new ArrayList<>();

        Doctor doc = DoctorFactory.getDoctor("Dr", "Mohammed", "Renal");

        List<Meal> daysStayed = new ArrayList<>();
        List<String> meals = new ArrayList<>();


        aPatient = InPatientFactory.getInPatient(
                "Mohammed",
                "Khan",
                "1234568",
                "0000213546546",
                23,
                doc
        );


        Assert.assertEquals(aPatient.getDoctorId(), doc.getEmployeeId());

    }
}