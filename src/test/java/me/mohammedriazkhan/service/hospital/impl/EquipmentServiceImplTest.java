package me.mohammedriazkhan.service.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.factory.hospital.EquipmentFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentServiceImplTest {

    private EquipmentServiceImpl equipmentService = EquipmentServiceImpl.getEquipmentServiceImpl();

    @Test
    public void getAll() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentService.create(equip);
        assertNotNull(equipmentService.getAll());

    }

    @Test
    public void create() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentService.create(equip);
        assertNotNull(equipmentService.getAll());

    }

    @Test
    public void read() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentService.create(equip);
        assertNotNull(equipmentService.read(equip.getEquipmentId()));

    }

    @Test
    public void update() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentService.create(equip);

        Equipment inDB = equipmentService.read(equip.getEquipmentId());
        inDB.setDesc("das");

        Equipment updated = equipmentService.update(inDB);

        assertEquals(equip.getDesc(), updated.getDesc());

    }

    @Test
    public void delete() {
        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentService.create(equip);
        assertNotNull(equipmentService.getAll());

        equipmentService.delete(equip.getEquipmentId());
        Equipment equips = equipmentService.read(equip.getEquipmentId());
        assertNull(equips);

    }
}