package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.factory.hospital.EquipmentFactory;
import me.mohammedriazkhan.repository.hospital.impl.EquipmentRepositoryImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class EquipmentRepositoryImplTest {

    private EquipmentRepositoryImpl equipmentRepository = EquipmentRepositoryImpl.getEquipmentRepository();

    @Test
    public void getAll() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentRepository.create(equip);
        assertNotNull(equipmentRepository.getAll());

    }

    @Test
    public void create() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentRepository.create(equip);
        assertNotNull(equipmentRepository.getAll());

    }

    @Test
    public void read() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentRepository.create(equip);
        assertNotNull(equipmentRepository.read(equip.getEquipmentId()));

    }

    @Test
    public void update() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentRepository.create(equip);

        Equipment inDB = equipmentRepository.read(equip.getEquipmentId());
        inDB.setDesc("das");

        Equipment updated = equipmentRepository.update(inDB);

        assertEquals(equip.getDesc(), updated.getDesc());

    }

    @Test
    public void delete() {
        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
        equipmentRepository.create(equip);
        assertNotNull(equipmentRepository.getAll());

        equipmentRepository.delete(equip.getEquipmentId());
        Equipment equips = equipmentRepository.read(equip.getEquipmentId());
        assertNull(equips);

    }
}