package me.mohammedriazkhan.repository.hospital.hibernate;

import me.mohammedriazkhan.domain.hospital.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface HospitalRepositoryHibernate extends CrudRepository<Hospital, String> {

}
