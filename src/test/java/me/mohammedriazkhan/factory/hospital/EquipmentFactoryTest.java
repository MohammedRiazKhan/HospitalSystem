package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentFactoryTest {

    @Test
    public void getEquipment() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        System.out.println(equip);
        assertNotNull(equip);

    }
}