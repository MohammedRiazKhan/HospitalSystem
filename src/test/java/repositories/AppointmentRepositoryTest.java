package repositories;

import domain.appoinments.Appointment;
import factories.appointment.AppointmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppointmentRepositoryTest {


    AppointmentRepository appointmentRepository;

    @Before
    public void setUp() throws Exception {

        appointmentRepository = AppointmentRepository.getAppointmentRepository();

    }

    @Test
    public void create() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "asdf", null);
        appointmentRepository.create(appointment);

        Assert.assertNotNull(appointmentRepository.getAll());

    }

    @Test
    public void read() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "asdf", null);
        appointmentRepository.create(appointment);

        Assert.assertNotNull(appointmentRepository.getAll());

        Appointment from = appointmentRepository.read(appointment.getAppointmentId());

        Assert.assertEquals(appointment, from);

    }

    @Test
    public void update() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "asdf", null);
        appointmentRepository.create(appointment);

        Assert.assertNotNull(appointmentRepository.getAll());

        Appointment appointments = AppointmentFactory.getAppointment(1, "asafsdfdf", null);
        appointments.setAppointmentId(appointment.getAppointmentId());
        appointmentRepository.update(appointments);

        Appointment updated = appointmentRepository.find(appointments.getAppointmentId());

        Assert.assertEquals(appointments, updated);

    }

    @Test
    public void delete() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "asdf", null);
        appointmentRepository.create(appointment);

        Assert.assertNotNull(appointmentRepository.getAll());

        appointmentRepository.delete(appointment);

        Appointment notThereBro = appointmentRepository.find(appointment.getAppointmentId());

        Assert.assertNull(notThereBro);


    }
}