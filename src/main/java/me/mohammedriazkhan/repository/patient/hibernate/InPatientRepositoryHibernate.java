package me.mohammedriazkhan.repository.patient.hibernate;

import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.domain.patient.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface InPatientRepositoryHibernate extends CrudRepository<InPatient, String> {

}
