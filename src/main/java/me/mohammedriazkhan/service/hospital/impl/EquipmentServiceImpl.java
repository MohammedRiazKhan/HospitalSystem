package me.mohammedriazkhan.service.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.repository.hospital.EquipmentRepository;
import me.mohammedriazkhan.repository.hospital.impl.EquipmentRepositoryImpl;
import me.mohammedriazkhan.service.hospital.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private static EquipmentServiceImpl equipmentService = null;
    private EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(){
        equipmentRepository = EquipmentRepositoryImpl.getEquipmentRepository();
    }

    public static EquipmentServiceImpl getEquipmentServiceImpl(){

        if(equipmentService == null){
            return new EquipmentServiceImpl();
        }
        return equipmentService;
    }

    @Override
    public Set<Equipment> getAll() {
        return equipmentRepository.getAll();
    }

    @Override
    public Equipment create(Equipment equipment) {
        return equipmentRepository.create(equipment);
    }

    @Override
    public Equipment read(String s) {
        return equipmentRepository.read(s);
    }

    @Override
    public Equipment update(Equipment equipment) {
        return equipmentRepository.update(equipment);
    }

    @Override
    public void delete(String s) {
        equipmentRepository.delete(s);
    }
}
