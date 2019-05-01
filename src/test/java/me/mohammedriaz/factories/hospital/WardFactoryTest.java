package me.mohammedriaz.factories.hospital;

import me.mohammedriaz.domain.hospital.Ward;
import org.junit.Assert;
import org.junit.Test;

public class WardFactoryTest {

    @Test
    public void getWard() {

        Ward ward = WardFactory.getWard(1, "A");

        Assert.assertNotNull("A", ward.getWardCode());

    }
}