package factories.appointment;

import domain.appoinments.Appointment;
import domain.patients.Patient;

public class AppointmentFactory {

    public static Appointment getAppointment(int appointmentId, String bookingDate, Patient patient) {
        return new Appointment.AppointmentBuilder()

                .build();
    }

}
