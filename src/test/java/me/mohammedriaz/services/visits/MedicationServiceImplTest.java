package me.mohammedriaz.services.visits;

import me.mohammedriaz.domain.visits.Medication;
import me.mohammedriaz.factories.visits.MedicationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriaz.services.Impl.MedicationServiceImpl;

public class MedicationServiceImplTest {


    MedicationServiceImpl medicationService;

    @Before
    public void setUp() throws Exception {

        medicationService = new MedicationServiceImpl();

    }

    @Test
    public void create() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationService.create(medication);

        Assert.assertNotNull(medicationService.getAll());
    }

    @Test
    public void read() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationService.create(medication);

        Assert.assertNotNull(medicationService.getAll());

        Medication medic = medicationService.read(medication.getMedicationId());

        Assert.assertEquals(medic, medication);


    }

    @Test
    public void update() {


        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationService.create(medication);

        Assert.assertNotNull(medicationService.getAll());

        Medication medication1 = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medication1.setMedicationId(medication.getMedicationId());
        medicationService.update(medication1);

        Medication updated = medicationService.read(medication1.getMedicationId());

        Assert.assertEquals(medication1, updated);


    }

    @Test
    public void delete() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationService.create(medication);

        Assert.assertNotNull(medicationService.getAll());

        medicationService.delete(medication.getMedicationId());

        Medication medic = medicationService.read(medication.getMedicationId());

        Assert.assertNull(medic);





    }
}