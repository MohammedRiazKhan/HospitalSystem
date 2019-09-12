package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import org.junit.Assert;
import org.junit.Test;

import javax.print.Doc;

import static org.junit.Assert.*;

public class DoctorFactoryTest {

    @Test
    public void getDoctor() {

        Doctor doctor = DoctorFactory.getDoctor( "Riaz", "khan", "f");
        Assert.assertNotNull(doctor);
    }
}