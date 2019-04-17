package factories.employee;

import domain.employee.Cleaner;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerFactoryTest {

    @Test
    public void getCleaner() {

        Cleaner cleaner = CleanerFactory.getCleaner();

        Assert.assertNotNull(cleaner);

    }
}