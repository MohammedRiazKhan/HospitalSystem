package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;


public class EquipmentFactory {

    public static Equipment getEquipment(int equipmentId, String name, String desc, int quantity) {
        return new Equipment.EquipmentBuilder()
                .equipmentId(equipmentId)
                .name(name)
                .desc(desc)
                .quantity(quantity)
                .build();
    }

}
