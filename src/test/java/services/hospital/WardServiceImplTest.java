package services.hospital;

import domain.hospital.Ward;
import factories.hospital.WardFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.Impl.WardServiceImpl;

public class WardServiceImplTest {

    WardServiceImpl wardService;

    @Before
    public void setUp() throws Exception {

        wardService = new WardServiceImpl();
    }

    @Test
    public void create() {

        Ward ward = WardFactory.getWard(1, null);
        wardService.create(ward);

        Assert.assertNotNull(wardService.getAll());

    }

    @Test
    public void read() {

        Ward ward = WardFactory.getWard(1, null);
        wardService.create(ward);

        Assert.assertNotNull(wardService.getAll());

        Ward ward1 = wardService.read(ward.getWardId());

        Assert.assertEquals(ward, ward1);

    }

    @Test
    public void update() {

        Ward ward = WardFactory.getWard(1, null);
        wardService.create(ward);

        Assert.assertNotNull(wardService.getAll());

        Ward ward1 = WardFactory.getWard(1, null);
        ward1.setWardId(ward.getWardId());
        wardService.update(ward1);

        Ward ward2 = wardService.read(ward1.getWardId());

        Assert.assertEquals(ward1, ward2);

    }

    @Test
    public void delete() {

        Ward ward = WardFactory.getWard(1, null);
        wardService.create(ward);

        Assert.assertNotNull(wardService.getAll());

        wardService.delete(ward.getWardId());

        Ward ward1 = wardService.read(ward.getWardId());

        Assert.assertNull(ward1);



    }
}