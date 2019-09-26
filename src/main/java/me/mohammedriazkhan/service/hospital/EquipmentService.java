package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Equipment;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface EquipmentService extends Service<Equipment, String> {

    Set<Equipment> getAll();
}
