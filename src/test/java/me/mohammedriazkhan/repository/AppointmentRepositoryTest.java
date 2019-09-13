package me.mohammedriazkhan.repository;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.factory.appointment.AppointmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.appointment.impl.AppointmentRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentRepositoryTest {


    @Autowired
    private AppointmentRepositoryImpl appointmentRepository;

    @Test
    public void create() {

        Appointment appointment = AppointmentFactory.getAppointment("asdf", null);
        appointmentRepository.create(appointment);

        assertNotNull(appointmentRepository.getAll());

    }

    @Test
    public void read() {

        Appointment appointment = AppointmentFactory.getAppointment("asdf", null);
        appointmentRepository.create(appointment);

        assertNotNull(appointmentRepository.getAll());

        Appointment from = appointmentRepository.read(appointment.getAppointmentId());

        assertEquals(appointment, from);

    }

    @Test
    public void update() {

        Appointment appointment = AppointmentFactory.getAppointment( "asdf", null);
        appointmentRepository.create(appointment);

        assertNotNull(appointmentRepository.getAll());

        Appointment appointments = AppointmentFactory.getAppointment( "asafsdfdf", null);
        appointments.setAppointmentId(appointment.getAppointmentId());
        appointmentRepository.update(appointments);

        Appointment updated = appointmentRepository.read(appointments.getAppointmentId());

        assertEquals(appointments, updated);

    }

    @Test
    public void delete() {

        Appointment appointment = AppointmentFactory.getAppointment( "asdf", null);
        appointmentRepository.create(appointment);

       assertNotNull(appointmentRepository.getAll());

        appointmentRepository.delete(appointment.getAppointmentId());

        Appointment notThereBro = appointmentRepository.read(appointment.getAppointmentId());

        assertNull(notThereBro);

    }
}