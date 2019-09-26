package me.mohammedriazkhan.repository.employee.hibernate;

import me.mohammedriazkhan.domain.employee.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface DoctorRepositoryHibernate extends CrudRepository<Doctor, String> {


}
