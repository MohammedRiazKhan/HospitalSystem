package me.mohammedriazkhan.repository.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.factory.visit.MedicationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.visit.impl.MedicationRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicationRepositoryTest {


    @Autowired
    private MedicationRepositoryImpl medicationRepository;


    @Test
    public void create() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationRepository.create(medication);

        assertNotNull(medicationRepository.getAll());
    }

    @Test
    public void read() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationRepository.create(medication);

        assertNotNull(medicationRepository.getAll());

        Medication medic = medicationRepository.read(medication.getMedicationId());

        assertEquals(medic, medication);


    }

    @Test
    public void update() {


        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationRepository.create(medication);

        assertNotNull(medicationRepository.getAll());

        Medication medication1 = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medication1.setMedicationId(medication.getMedicationId());
        medicationRepository.update(medication1);

        Medication updated = medicationRepository.read(medication1.getMedicationId());

        assertEquals(medication1, updated);


    }

    @Test
    public void delete() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationRepository.create(medication);

        assertNotNull(medicationRepository.getAll());

        medicationRepository.delete(medication.getMedicationId());

        Medication medic = medicationRepository.read(medication.getMedicationId());

        assertNull(medic);





    }
}