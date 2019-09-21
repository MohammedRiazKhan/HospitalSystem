package me.mohammedriazkhan.repository.patient;

import me.mohammedriazkhan.domain.patient.Report;

import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface ReportRepository extends Repository<Report, String> {

   Set<Report> getAll();


}
