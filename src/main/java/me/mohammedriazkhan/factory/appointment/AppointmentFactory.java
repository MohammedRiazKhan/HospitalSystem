package me.mohammedriazkhan.factory.appointment;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.patient.Patient;


public class AppointmentFactory {

    public static Appointment getAppointment(int appointmentId, String bookingDate, Patient patient) {
        return new Appointment.AppointmentBuilder()
                .appointmentId(appointmentId)
                .bookingDate(bookingDate)
                .patient(patient)
                .build();
    }



}
