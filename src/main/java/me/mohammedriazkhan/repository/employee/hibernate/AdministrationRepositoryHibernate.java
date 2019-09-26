package me.mohammedriazkhan.repository.employee.hibernate;

import me.mohammedriazkhan.domain.employee.Administration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface AdministrationRepositoryHibernate extends CrudRepository<Administration, String> {


}
