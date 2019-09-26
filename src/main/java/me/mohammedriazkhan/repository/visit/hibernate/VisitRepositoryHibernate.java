package me.mohammedriazkhan.repository.visit.hibernate;

import me.mohammedriazkhan.domain.visit.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface VisitRepositoryHibernate extends CrudRepository<Visit, String> {



}
