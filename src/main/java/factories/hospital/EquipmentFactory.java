package factories.hospital;

import domain.hospital.Equipment;

public class EquipmentFactory {

    public static Equipment getEquipment(int equipmentId, String name, String desc, int quantity) {
        return (Equipment) new Equipment.EquipmentBuilder()

                .build();
    }

}
