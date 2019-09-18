package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface EquipmentRepository extends Repository<Equipment, String> {

    Set<Equipment> getAll();


}
