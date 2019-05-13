package me.mohammedriazkhan.factory.appointment;

import me.mohammedriazkhan.domain.appoinments.Appointment;
import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.utility.IDGenerator;

public class AppointmentFactory {

    public static Appointment getAppointment(int appointmentId, String bookingDate, Patient patient) {
        return new Appointment.AppointmentBuilder()
                .appointmentId(IDGenerator.genId())
                .bookingDate(bookingDate)
                .patient(patient)
                .build();
    }



}
