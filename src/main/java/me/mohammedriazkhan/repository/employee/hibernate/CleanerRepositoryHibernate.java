package me.mohammedriazkhan.repository.employee.hibernate;

import me.mohammedriazkhan.domain.employee.Cleaner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CleanerRepositoryHibernate extends CrudRepository<Cleaner, String> {



}
