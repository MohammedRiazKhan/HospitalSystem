package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.factory.employee.PharmacistFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.Impl.PharmacistRepositoryImpl;

public class PharmacistRepositoryTest {


    PharmacistRepositoryImpl pharmacistRepository;

    @Before
    public void setUp() throws Exception {

        pharmacistRepository = PharmacistRepositoryImpl.getRepository();

    }

    @Test
    public void create() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        Assert.assertNotNull(pharmacistRepository.getAll());

    }

    @Test
    public void read() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        Assert.assertNotNull(pharmacistRepository.getAll());

        Pharmacist fromSet = pharmacistRepository.find(pharmacist.getEmployeeId());

        Assert.assertEquals(pharmacist, fromSet);



    }

    @Test
    public void update() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        Assert.assertNotNull(pharmacistRepository.getAll());

        Pharmacist update = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);
        update.setEmployeeId(pharmacist.getEmployeeId());
        pharmacistRepository.update(update);

        Pharmacist updated = pharmacistRepository.read(update.getEmployeeId());

        Assert.assertEquals(update, updated);

    }

    @Test
    public void delete() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        Assert.assertNotNull(pharmacistRepository.getAll());

        pharmacistRepository.delete(pharmacist.getEmployeeId());

        Pharmacist notThere = pharmacistRepository.read(pharmacist.getEmployeeId());

        Assert.assertNull(notThere);


    }
}