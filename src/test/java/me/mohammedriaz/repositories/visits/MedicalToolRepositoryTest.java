package me.mohammedriaz.repositories.visits;

import me.mohammedriaz.domain.visits.Medication;
import me.mohammedriaz.factories.visits.MedicationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriaz.repositories.Impl.MedicationRepositoryImpl;

public class MedicalToolRepositoryTest {

    MedicationRepositoryImpl medicationRepository;

    @Before
    public void setUp() throws Exception {

        medicationRepository = MedicationRepositoryImpl.getRepository();

    }

    @Test
    public void create() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationRepository.create(medication);

        Assert.assertNotNull(medicationRepository.getAll());
    }

    @Test
    public void read() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationRepository.create(medication);

        Assert.assertNotNull(medicationRepository.getAll());

        Medication medic = medicationRepository.find(medication.getMedicationId());

        Assert.assertEquals(medic, medication);


    }

    @Test
    public void update() {


        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationRepository.create(medication);

        Assert.assertNotNull(medicationRepository.getAll());

        Medication medication1 = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medication1.setMedicationId(medication.getMedicationId());
        medicationRepository.update(medication1);

        Medication updated = medicationRepository.find(medication1.getMedicationId());

        Assert.assertEquals(medication1, updated);


    }

    @Test
    public void delete() {

        Medication medication = MedicationFactory.getMedication(1, "Heroine", "Not good", 1);
        medicationRepository.create(medication);

        Assert.assertNotNull(medicationRepository.getAll());

        medicationRepository.delete(medication.getMedicationId());

        Medication medic = medicationRepository.find(medication.getMedicationId());

        Assert.assertNull(medic);





    }
}