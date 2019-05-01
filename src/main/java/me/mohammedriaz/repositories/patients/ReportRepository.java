package me.mohammedriaz.repositories.patients;

import me.mohammedriaz.domain.patients.Report;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface ReportRepository extends Repository<Report, Integer> {


    Set<Report> getAll();


}
