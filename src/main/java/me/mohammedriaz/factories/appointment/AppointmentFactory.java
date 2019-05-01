package me.mohammedriaz.factories.appointment;

import me.mohammedriaz.domain.appoinments.Appointment;
import me.mohammedriaz.domain.patients.Patient;
import me.mohammedriaz.utility.IDGenerator;

public class AppointmentFactory {

    public static Appointment getAppointment(int appointmentId, String bookingDate, Patient patient) {
        return new Appointment.AppointmentBuilder()
                .appointmentId(IDGenerator.genId())
                .bookingDate(bookingDate)
                .patient(patient)
                .build();
    }



}
