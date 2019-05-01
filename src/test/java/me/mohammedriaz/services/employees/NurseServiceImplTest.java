package me.mohammedriaz.services.employees;

import me.mohammedriaz.domain.employee.Nurse;
import me.mohammedriaz.factories.employee.NurseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriaz.services.Impl.NurseServiceImpl;

public class NurseServiceImplTest {

    NurseServiceImpl nurseService;

    @Before
    public void setUp() throws Exception {

        nurseService = new NurseServiceImpl();

    }

    @Test
    public void create() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");

        nurseService.create(nurse);

        Assert.assertNotNull(nurseService.getAll());

    }

    @Test
    public void read() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");

        nurseService.create(nurse);

        Assert.assertNotNull(nurseService.getAll());

        Nurse fromSet = nurseService.read(nurse.getEmployeeId());

        Assert.assertEquals(nurse, fromSet);

    }

    @Test
    public void update() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");
        nurseService.create(nurse);

        Assert.assertNotNull(nurseService.getAll());

        Nurse nurseJackie = NurseFactory.getNurse(1, "Nurse", "Jackie", "2", "Nurse Duh", "1", "asd");
        nurseJackie.setEmployeeId(nurse.getEmployeeId());
        nurseService.update(nurseJackie);

        Nurse nurseJackieClone = nurseService.read(nurseJackie.getEmployeeId());

        Assert.assertEquals(nurseJackie, nurseJackieClone);

    }

    @Test
    public void delete() {
        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");
        nurseService.create(nurse);

        Assert.assertNotNull(nurseService.getAll());

        nurseService.delete(nurse.getEmployeeId());

        Nurse nurseJackieClone = nurseService.read(nurse.getEmployeeId());

        Assert.assertNull(nurseJackieClone);




    }
}