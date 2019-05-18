package me.mohammedriazkhan.service.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.factory.visit.MedicationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.visit.impl.MedicationServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicationServiceImplTest {


    @Autowired
    MedicationServiceImpl medicationService;


    @Test
    public void create() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationService.create(medication);

        assertNotNull(medicationService.getAll());
    }

    @Test
    public void read() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationService.create(medication);

        assertNotNull(medicationService.getAll());

        Medication medic = medicationService.read(medication.getMedicationId());

        assertEquals(medic, medication);


    }

    @Test
    public void update() {


        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationService.create(medication);

        assertNotNull(medicationService.getAll());

        Medication medication1 = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medication1.setMedicationId(medication.getMedicationId());
        medicationService.update(medication1);

        Medication updated = medicationService.read(medication1.getMedicationId());

        assertEquals(medication1, updated);


    }

    @Test
    public void delete() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationService.create(medication);

        assertNotNull(medicationService.getAll());

        medicationService.delete(medication.getMedicationId());

        Medication medic = medicationService.read(medication.getMedicationId());

        assertNull(medic);





    }
}