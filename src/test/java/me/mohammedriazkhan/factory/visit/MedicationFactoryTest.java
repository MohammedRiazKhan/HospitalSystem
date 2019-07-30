package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicationFactoryTest {

    @Test
    public void getMedication() {

        Medication medication = MedicationFactory.getMedication(1, "Panado", "Pain Killer", 2);
        Assert.assertNotNull(medication);

    }
}