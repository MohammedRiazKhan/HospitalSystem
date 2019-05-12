package me.mohammedriazkhan.factories.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.utility.IDGenerator;

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
