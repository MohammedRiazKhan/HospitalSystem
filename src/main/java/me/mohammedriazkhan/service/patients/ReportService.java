package me.mohammedriazkhan.service.patients;

import me.mohammedriazkhan.domain.patients.Report;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface ReportService extends Service<Report, Integer> {

    Set<Report> getAll();

}
