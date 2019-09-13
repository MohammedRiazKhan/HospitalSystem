package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.factory.employee.NurseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.employee.impl.NurseServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NurseServiceImplTest {

    @Autowired
    private NurseServiceImpl nurseService;


    @Test
    public void create() {

        Nurse nurse = NurseFactory.getNurse("Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");

        nurseService.create(nurse);

        assertNotNull(nurseService.getAll());

    }

    @Test
    public void read() {

        Nurse nurse = NurseFactory.getNurse("Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");

        nurseService.create(nurse);

        assertNotNull(nurseService.getAll());

        Nurse fromSet = nurseService.read(nurse.getEmployeeId());

        assertEquals(nurse, fromSet);

    }

    @Test
    public void update() {

        Nurse nurse = NurseFactory.getNurse("Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");
        nurseService.create(nurse);

        assertNotNull(nurseService.getAll());

        Nurse nurseJackie = NurseFactory.getNurse( "Nurse", "Jackie", "2", "Nurse Duh", "1", "asd");
        nurseJackie.setEmployeeId(nurse.getEmployeeId());
        nurseService.update(nurseJackie);

        Nurse nurseJackieClone = nurseService.read(nurseJackie.getEmployeeId());

        assertEquals(nurseJackie, nurseJackieClone);

    }

    @Test
    public void delete() {
        Nurse nurse = NurseFactory.getNurse("Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");
        nurseService.create(nurse);

        assertNotNull(nurseService.getAll());

        nurseService.delete(nurse.getEmployeeId());

        Nurse nurseJackieClone = nurseService.read(nurse.getEmployeeId());

        assertNull(nurseJackieClone);




    }
}