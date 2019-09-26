package me.mohammedriazkhan.repository.patient.hibernate;

import me.mohammedriazkhan.domain.patient.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("InDB")
public interface ReportRepositoryHibernate extends CrudRepository<Report, String> {



}
