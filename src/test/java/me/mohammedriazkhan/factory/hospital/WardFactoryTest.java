package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import org.junit.Assert;
import org.junit.Test;

public class WardFactoryTest {

    @Test
    public void getWard() {

        Ward ward = WardFactory.getWard( "A");

        Assert.assertNotNull("A", ward.getWardCode());

    }
}