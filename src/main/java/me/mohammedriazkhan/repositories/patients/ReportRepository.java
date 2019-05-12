package me.mohammedriazkhan.repositories.patients;

import me.mohammedriazkhan.domain.patients.Report;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface ReportRepository extends Repository<Report, Integer> {


    Set<Report> getAll();


}
