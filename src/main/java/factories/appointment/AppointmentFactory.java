package factories.appointment;

import domain.appoinments.Appointment;
import domain.patients.Patient;
import utility.IDGenerator;

public class AppointmentFactory {

    public static Appointment getAppointment(int appointmentId, String bookingDate, Patient patient) {
        return new Appointment.AppointmentBuilder()
                .appointmentId(IDGenerator.genId())
                .bookingDate(bookingDate)
                .patient(patient)
                .build();
    }



}
