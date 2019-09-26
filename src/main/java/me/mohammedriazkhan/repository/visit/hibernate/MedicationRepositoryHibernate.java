package me.mohammedriazkhan.repository.visit.hibernate;

import me.mohammedriazkhan.domain.visit.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface MedicationRepositoryHibernate extends CrudRepository<Medication, String> {

}

