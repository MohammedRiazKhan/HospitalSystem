package me.mohammedriazkhan.repository.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.repository.hospital.EquipmentRepository;

import java.util.HashSet;
import java.util.Set;

public class EquipmentRepositoryImpl implements EquipmentRepository {

    private static EquipmentRepositoryImpl equipmentRepository = null;
    private Set<Equipment> equipments;

    public EquipmentRepositoryImpl(){
        equipments = new HashSet<>();
    }

    public static EquipmentRepositoryImpl getEquipmentRepository(){
        if(equipmentRepository == null){
            return new EquipmentRepositoryImpl();
        }
        return equipmentRepository;
    }

    @Override
    public Set<Equipment> getAll() {
        return equipments;
    }

    @Override
    public Equipment create(Equipment equipment) {
        equipments.add(equipment);
        return equipment;
    }

    @Override
    public Equipment read(String s) {
        return equipments.stream().filter(equipment -> equipment.getEquipmentId().equals(s)).findAny().orElse(null);
    }

    @Override
    public Equipment update(Equipment equipment) {

        Equipment inDB = read(equipment.getEquipmentId());
        if(inDB != null){
            equipments.remove(inDB);
            equipments.add(equipment);
            return equipment;
        }

        return null;
    }

    @Override
    public void delete(String s) {

        Equipment inDB = read(s);

        equipments.remove(inDB);
    }
}
