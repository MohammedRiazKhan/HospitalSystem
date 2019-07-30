package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalToolFactoryTest {

    @Test
    public void getMedicalTool() {

        MedicalTool medicalTool = MedicalToolFactory.getMedicalTool(1, "fas", "fasd");
        Assert.assertNotNull(medicalTool);

    }
}