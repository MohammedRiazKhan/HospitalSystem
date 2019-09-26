package me.mohammedriazkhan.repository.hospital.hibernate;

import me.mohammedriazkhan.domain.hospital.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface EquipmentRepositoryHibernate extends CrudRepository<Equipment, String> {



}
