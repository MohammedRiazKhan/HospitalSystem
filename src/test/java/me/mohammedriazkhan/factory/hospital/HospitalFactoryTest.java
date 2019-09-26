package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Hospital;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HospitalFactoryTest {

    @Test
    public void getHospital() {

        //Hospital
        Hospital hosp = HospitalFactory.getHospital("Greys Anamtomy", "List");
        System.out.println(hosp);

        Assert.assertNotNull(hosp);

    }
}