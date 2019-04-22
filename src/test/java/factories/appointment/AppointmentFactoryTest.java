package factories.appointment;

import domain.appoinments.Appointment;
import domain.employee.Doctor;
import domain.patients.InPatient;
import domain.patients.Meal;
import domain.patients.Patient;
import factories.employee.DoctorFactory;
import factories.patients.InPatientFactory;
import factories.patients.PatientFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppointmentFactoryTest {

    @Test
    public void getAppointment() {


        ArrayList list = new ArrayList();

        Doctor doc = DoctorFactory.getDoctor("Moh", "Khan", "Renal");


        List<Meal> m = new ArrayList<>();
        List<String> d = new ArrayList<>();

        InPatient patient = InPatientFactory.getInPatient("riaz", "khan", "1", "12345" ,23, doc);

        Appointment appointment = AppointmentFactory.getAppointment
                (1, "17-04-2018", patient);

        Assert.assertNotNull(appointment.getAppointmentId());


    }
}