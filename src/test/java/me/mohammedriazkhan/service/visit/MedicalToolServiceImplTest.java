package me.mohammedriazkhan.service.visit;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.factory.visit.MedicalToolFactory;
import me.mohammedriazkhan.service.visit.impl.MedicalToolServiceImpl;
import me.mohammedriazkhan.service.visit.impl.MedicationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalToolServiceImplTest {

    @Autowired
    private MedicalToolServiceImpl medicationService;


    @Test
    public void create() {

        MedicalTool medicalTool = MedicalToolFactory.getMedicalTool( "fas", "fasd");
        medicationService.create(medicalTool);

        assertNotNull(medicationService.getAll());
    }

    @Test
    public void read() {

        MedicalTool medicalTool = MedicalToolFactory.getMedicalTool( "fas", "fasd");
        medicationService.create(medicalTool);
        System.out.println(medicalTool.getToolId());

        assertNotNull(medicationService.getAll());

        MedicalTool medic = medicationService.read(medicalTool.getToolId());

        assertNotNull(medic);


    }

    @Test
    public void update() {


        MedicalTool medicalTool = MedicalToolFactory.getMedicalTool("fas", "fasd");
        medicationService.create(medicalTool);


        assertNotNull(medicationService.getAll());
        MedicalTool medication1 = MedicalToolFactory.getMedicalTool("fas", "fasd");
        medication1.setToolId(medicalTool.getToolId());
        medicationService.update(medication1);

        MedicalTool updated = medicationService.read(medicalTool.getToolId());

        assertEquals(medication1, updated);


    }

    @Test
    public void delete() {

        MedicalTool medicalTool = MedicalToolFactory.getMedicalTool( "fas", "fasd");
        medicationService.create(medicalTool);

        assertNotNull(medicationService.getAll());

        medicationService.delete(medicalTool.getToolId());

        MedicalTool medic = medicationService.read(medicalTool.getToolId());

        assertNull(medic);



    }


}