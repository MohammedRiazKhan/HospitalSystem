package me.mohammedriazkhan.service.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.repository.hospital.EquipmentRepository;
import me.mohammedriazkhan.repository.hospital.hibernate.EquipmentRepositoryHibernate;
import me.mohammedriazkhan.repository.hospital.impl.EquipmentRepositoryImpl;
import me.mohammedriazkhan.service.hospital.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private static EquipmentServiceImpl equipmentService = null;
    @Autowired
    private EquipmentRepositoryHibernate equipmentRepository;

    public EquipmentServiceImpl(){

    }

    public static EquipmentServiceImpl getEquipmentServiceImpl(){

        if(equipmentService == null){
            return new EquipmentServiceImpl();
        }
        return equipmentService;
    }

    @Override
    public Set<Equipment> getAll() {
        List<Equipment> list = (List<Equipment>) equipmentRepository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment read(String s) {
        return equipmentRepository.findById(s).orElse(null);
    }

    @Override
    public Equipment update(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public void delete(String s) {
        equipmentRepository.deleteById(s);
    }
}
