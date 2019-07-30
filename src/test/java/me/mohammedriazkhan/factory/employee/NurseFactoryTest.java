package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Nurse;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NurseFactoryTest {

    @Test
    public void getNurse() {

        Nurse nurse = NurseFactory.getNurse(1, null, null, null, null, null, null);
        Assert.assertNotNull(nurse);

    }
}