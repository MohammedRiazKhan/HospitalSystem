package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.domain.visit.Prescription;
import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PrescriptionFactoryTest {

    @Test
    public void buildPrescription() {


        //creating a visit
        Doctor doctor = DoctorFactory.getDoctor( "Mohammed", "Khan", "1234564", "1 May 2501", "Renal Doctor", "Super Man");

        Patient aPatient = InPatientFactory.getInPatient("Mohammed", "Khan", "123135", "3213213213", 23, "1231", "1", 123, "111111");

        Visit visit = VisitFactory.getVisit(new Date().toString(), aPatient.getPatientId().toString(), doctor.getEmployeeId(), "fasd", "fasd");

        Medication medication = MedicationFactory.getMedication("Panado", "Pain Killer", 2);

        Prescription prescription = PrescriptionFactory.buildPrescription(medication.getMedicationId(), visit.getVisitId());
        System.out.println(prescription);
        Assert.assertNotNull(prescription);

    }
}
