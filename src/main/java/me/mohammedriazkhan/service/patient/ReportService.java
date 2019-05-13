package me.mohammedriazkhan.service.patient;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface ReportService extends Service<Report, Integer> {

    Set<Report> getAll();

}
