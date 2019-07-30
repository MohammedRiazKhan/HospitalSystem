package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import org.junit.Assert;
import org.junit.Test;

public class CleanerFactoryTest {

    @Test
    public void getCleaner() {


        Cleaner cleaner = CleanerFactory.getCleaner(1);
        Assert.assertNotNull(cleaner);

    }
}