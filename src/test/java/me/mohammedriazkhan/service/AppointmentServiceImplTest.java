package me.mohammedriazkhan.service;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.factory.appointment.AppointmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.Impl.AppointmentServiceImpl;

public class AppointmentServiceImplTest {

    AppointmentServiceImpl appointmentService;

    @Before
    public void setUp() throws Exception {

        appointmentService = new AppointmentServiceImpl();

    }

    @Test
    public void create() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "asdf", null);
        appointmentService.create(appointment);

        Assert.assertNotNull(appointmentService.getAll());

    }

    @Test
    public void read() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "asdf", null);
        appointmentService.create(appointment);

        Assert.assertNotNull(appointmentService.getAll());

        Appointment from = appointmentService.read(appointment.getAppointmentId());

        Assert.assertEquals(appointment, from);

    }

    @Test
    public void update() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "asdf", null);
        appointmentService.create(appointment);

        Assert.assertNotNull(appointmentService.getAll());

        Appointment appointments = AppointmentFactory.getAppointment(1, "asafsdfdf", null);
        appointments.setAppointmentId(appointment.getAppointmentId());
        appointmentService.update(appointments);

        Appointment updated = appointmentService.read(appointments.getAppointmentId());

        Assert.assertEquals(appointments, updated);

    }

    @Test
    public void delete() {

        Appointment appointment = AppointmentFactory.getAppointment(1, "asdf", null);
        appointmentService.create(appointment);

        Assert.assertNotNull(appointmentService.getAll());

        appointmentService.delete(appointment.getAppointmentId());

        Appointment notThereBro = appointmentService.read(appointment.getAppointmentId());

        Assert.assertNull(notThereBro);

    }
}