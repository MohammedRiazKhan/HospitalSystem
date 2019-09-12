package me.mohammedriazkhan.factory.appointment;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.helper.IDGenerator;


public class AppointmentFactory {

    public static Appointment getAppointment(String bookingDate, String patientId) {
        return new Appointment.AppointmentBuilder()
                .appointmentId(IDGenerator.generateId())
                .bookingDate(bookingDate)
                .patientId(patientId)
                .build();
    }



}
