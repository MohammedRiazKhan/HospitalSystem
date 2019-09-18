package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Nurse;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NurseFactoryTest {

    @Test
    public void getNurse() {

        Nurse nurse = NurseFactory.getNurse( "Nursey", "Khan", "1234564", "1 May 2501", "Renal Nurse", "Super Nurse");
        System.out.println(nurse);
        Assert.assertNotNull(nurse);

    }
}