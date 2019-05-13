package me.mohammedriazkhan.repository.patients;

import me.mohammedriazkhan.domain.patients.Report;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface ReportRepository extends Repository<Report, Integer> {


    Set<Report> getAll();


}
