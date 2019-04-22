package repositories.employees;

import domain.employee.Pharmacist;
import factories.employee.PharmacistFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PharmacistRepositoryTest {


    PharmacistRepository pharmacistRepository;

    @Before
    public void setUp() throws Exception {

        pharmacistRepository = PharmacistRepository.getRepository();

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

        Pharmacist updated = pharmacistRepository.find(update.getEmployeeId());

        Assert.assertEquals(update, updated);

    }

    @Test
    public void delete() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        Assert.assertNotNull(pharmacistRepository.getAll());

        pharmacistRepository.delete(pharmacist);

        Pharmacist notThere = pharmacistRepository.find(pharmacist.getEmployeeId());

        Assert.assertNull(notThere);


    }
}