package repositories.hospital;

import domain.hospital.Ward;
import factories.hospital.WardFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.Impl.WardRepositoryImpl;

import static org.junit.Assert.*;

public class WardRepositoryTest {


    WardRepositoryImpl wardRepository;

    @Before
    public void setUp() throws Exception {

        wardRepository = WardRepositoryImpl.getWards();
    }

    @Test
    public void create() {

        Ward ward = WardFactory.getWard(1, null);
        wardRepository.create(ward);

        Assert.assertNotNull(wardRepository.getAll());

    }

    @Test
    public void read() {

        Ward ward = WardFactory.getWard(1, null);
        wardRepository.create(ward);

        Assert.assertNotNull(wardRepository.getAll());

        Ward ward1 = wardRepository.find(ward.getWardId());

        Assert.assertEquals(ward, ward1);

    }

    @Test
    public void update() {

        Ward ward = WardFactory.getWard(1, null);
        wardRepository.create(ward);

        Assert.assertNotNull(wardRepository.getAll());

        Ward ward1 = WardFactory.getWard(1, null);
        ward1.setWardId(ward.getWardId());
        wardRepository.update(ward1);

        Ward ward2 = wardRepository.find(ward1.getWardId());

        Assert.assertEquals(ward1, ward2);

    }

    @Test
    public void delete() {

        Ward ward = WardFactory.getWard(1, null);
        wardRepository.create(ward);

        Assert.assertNotNull(wardRepository.getAll());

        wardRepository.delete(ward.getWardId());

        Ward ward1 = wardRepository.find(ward.getWardId());

        Assert.assertNull(ward1);



    }
}