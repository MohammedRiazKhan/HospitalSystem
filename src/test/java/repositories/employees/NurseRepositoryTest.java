package repositories.employees;

import domain.employee.Nurse;
import factories.employee.NurseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.Impl.NurseRepositoryImpl;

import static org.junit.Assert.*;

public class NurseRepositoryTest {


    NurseRepositoryImpl nurseRepository;

    @Before
    public void setUp() throws Exception {

        nurseRepository = NurseRepositoryImpl.getRepository();

    }

    @Test
    public void create() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");

        nurseRepository.create(nurse);

        Assert.assertNotNull(nurseRepository.getAll());

    }

    @Test
    public void read() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");

        nurseRepository.create(nurse);

        Assert.assertNotNull(nurseRepository.getAll());

        Nurse fromSet = nurseRepository.read(nurse.getEmployeeId());

        Assert.assertEquals(nurse, fromSet);

    }

    @Test
    public void update() {

        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");
        nurseRepository.create(nurse);

        Assert.assertNotNull(nurseRepository.getAll());

        Nurse nurseJackie = NurseFactory.getNurse(1, "Nurse", "Jackie", "2", "Nurse Duh", "1", "asd");
        nurseJackie.setEmployeeId(nurse.getEmployeeId());
        nurseRepository.update(nurseJackie);

        Nurse nurseJackieClone = nurseRepository.find(nurseJackie.getEmployeeId());

        Assert.assertEquals(nurseJackie, nurseJackieClone);

    }

    @Test
    public void delete() {
        Nurse nurse = NurseFactory.getNurse(1, "Nurse", "Nurse", "2", "Nurse Duh", "1", "asd");
        nurseRepository.create(nurse);

        Assert.assertNotNull(nurseRepository.getAll());

        nurseRepository.delete(nurse.getEmployeeId());

        Nurse nurseJackieClone = nurseRepository.find(nurse.getEmployeeId());

        Assert.assertNull(nurseJackieClone);




    }
}