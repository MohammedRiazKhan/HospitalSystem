package me.mohammedriaz.factories.hospital;

import me.mohammedriaz.domain.hospital.Equipment;
import me.mohammedriaz.utility.IDGenerator;

public class EquipmentFactory {

    public static Equipment getEquipment(int equipmentId, String name, String desc, int quantity) {
        return (Equipment) new Equipment.EquipmentBuilder()
                .equipmentId(IDGenerator.genId())
                .name(name)
                .desc(desc)
                .quantity(quantity)
                .build();
    }

}
