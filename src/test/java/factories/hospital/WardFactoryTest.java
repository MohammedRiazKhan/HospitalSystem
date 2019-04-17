package factories.hospital;

import domain.hospital.Ward;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WardFactoryTest {

    @Test
    public void getWard() {

        Ward ward = WardFactory.getWard(1, "A");

        Assert.assertNotNull("A", ward.getWardCode());

    }
}