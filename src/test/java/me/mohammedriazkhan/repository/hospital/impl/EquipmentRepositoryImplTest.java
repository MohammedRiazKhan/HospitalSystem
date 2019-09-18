package me.mohammedriazkhan.repository.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.factory.hospital.EquipmentFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentRepositoryImplTest {

    @Test
    public void getAll() {

        Equipment equip = EquipmentFactory.getEquipment("Hammer", "Used to hammer things in", 1);
    }

    @Test
    public void create() {
    }

    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}