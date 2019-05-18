package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.factory.employee.NurseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.employee.impl.NurseRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NurseRepositoryTest {

    @Autowired
    NurseRepositoryImpl nurseRepository;

    @Test
    public void create() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");

        nurseRepository.create(nurse);

        assertNotNull(nurseRepository.getAll());

    }

    @Test
    public void read() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");

        nurseRepository.create(nurse);

        assertNotNull(nurseRepository.getAll());

        Nurse fromSet = nurseRepository.read(nurse.getEmployeeId());

        assertEquals(nurse, fromSet);

    }

    @Test
    public void update() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");
        nurseRepository.create(nurse);

        assertNotNull(nurseRepository.getAll());

        Nurse nurseJackie = NurseFactory.getNurse(1, "Nurse", "Jackie", "2", "Nurse Duh", "1", "asd");
        nurseJackie.setEmployeeId(nurse.getEmployeeId());
        nurseRepository.update(nurseJackie);

        Nurse nurseJackieClone = nurseRepository.read(nurseJackie.getEmployeeId());

        assertEquals(nurseJackie, nurseJackieClone);

    }

    @Test
    public void delete() {
        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");
        nurseRepository.create(nurse);

        assertNotNull(nurseRepository.getAll());

        nurseRepository.delete(nurse.getEmployeeId());

        Nurse nurseJackieClone = nurseRepository.read(nurse.getEmployeeId());

        assertNull(nurseJackieClone);




    }
}