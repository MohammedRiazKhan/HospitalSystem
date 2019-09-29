package me.mohammedriazkhan.factory.appointment;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.domain.patient.Meal;
import me.mohammedriazkhan.factory.employee.DoctorFactory;
import me.mohammedriazkhan.factory.patient.InPatientFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFactoryTest {

    @Test
    public void getAppointment() {


        InPatient patient = InPatientFactory.getInPatient("riaz", "khan", "1", "12345" ,23, "Afsd", "1234568", 2, "123");

        Appointment appointment = AppointmentFactory.getAppointment("17-04-2018", patient.getPatientId().toString());
        System.out.println(appointment);

        Assert.assertNotNull(appointment);


    }
}
