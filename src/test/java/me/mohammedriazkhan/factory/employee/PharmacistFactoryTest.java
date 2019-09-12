package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PharmacistFactoryTest {

    @Test
    public void getPharmacist() {

        Pharmacist pharmacist = PharmacistFactory.getPharmacist( null, null, null, null, null, null);
        Assert.assertNotNull(pharmacist);

    }
}