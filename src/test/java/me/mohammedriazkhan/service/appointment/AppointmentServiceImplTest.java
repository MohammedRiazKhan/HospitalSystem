package me.mohammedriazkhan.service.appointment;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.factory.appointment.AppointmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.appointment.impl.AppointmentServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceImplTest {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @Test
    public void create() {

        Appointment appointment = AppointmentFactory.getAppointment( "asdf", null);
        appointmentService.create(appointment);
//
        assertNotNull(appointmentService.getAll());

    }

    @Test
    public void read() {

        Appointment appointment = AppointmentFactory.getAppointment( "asdf", null);
        appointmentService.create(appointment);

        assertNotNull(appointmentService.getAll());

        Appointment from = appointmentService.read(appointment.getAppointmentId());

        assertEquals(appointment, from);

    }

    @Test
    public void update() {

        Appointment appointment = AppointmentFactory.getAppointment( "asdf", null);
        appointmentService.create(appointment);

        assertNotNull(appointmentService.getAll());

        Appointment appointments = AppointmentFactory.getAppointment("asafsdfdf", null);
        appointments.setAppointmentId(appointment.getAppointmentId());
        appointmentService.update(appointments);

        Appointment updated = appointmentService.read(appointments.getAppointmentId());

        assertEquals(appointments, updated);

    }

    @Test
    public void delete() {

        Appointment appointment = AppointmentFactory.getAppointment( "asdf", null);
        appointmentService.create(appointment);

        assertNotNull(appointmentService.getAll());

        appointmentService.delete(appointment.getAppointmentId());

        Appointment notThereBro = appointmentService.read(appointment.getAppointmentId());

        assertNull(notThereBro);

    }
}