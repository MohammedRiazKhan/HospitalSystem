package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.factory.employee.PharmacistFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.employee.impl.PharmacistRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacistRepositoryTest {

    @Autowired
    PharmacistRepositoryImpl pharmacistRepository;


    @Test
    public void create() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        assertNotNull(pharmacistRepository.getAll());

    }

    @Test
    public void read() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        assertNotNull(pharmacistRepository.getAll());

        Pharmacist fromSet = pharmacistRepository.read(pharmacist.getEmployeeId());

        assertEquals(pharmacist, fromSet);



    }

    @Test
    public void update() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        assertNotNull(pharmacistRepository.getAll());

        Pharmacist update = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);
        update.setEmployeeId(pharmacist.getEmployeeId());
        pharmacistRepository.update(update);

        Pharmacist updated = pharmacistRepository.read(update.getEmployeeId());

        assertEquals(update, updated);

    }

    @Test
    public void delete() {

        int[] meds = {1,1,1,1};
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(1, "ads", "Asf", "Asdf", "Asdf", "Asdf", meds);

        pharmacistRepository.create(pharmacist);

        assertNotNull(pharmacistRepository.getAll());

        pharmacistRepository.delete(pharmacist.getEmployeeId());

        Pharmacist notThere = pharmacistRepository.read(pharmacist.getEmployeeId());

        assertNull(notThere);


    }
}