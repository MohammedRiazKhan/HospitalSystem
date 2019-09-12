package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.helper.IDGenerator;


public class EquipmentFactory {

    public static Equipment getEquipment(String name, String desc, int quantity) {
        return new Equipment.EquipmentBuilder()
                .equipmentId(IDGenerator.generateId())
                .name(name)
                .desc(desc)
                .quantity(quantity)
                .build();
    }

}
