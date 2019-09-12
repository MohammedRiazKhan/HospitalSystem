package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Qualification;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QualificationFactoryTest {

    @Test
    public void getQualification() {


        Qualification qualification = QualificationFactory.getQualification("IT", "CPUT", "3");
        Assert.assertNotNull(qualification);

    }
}