package me.mohammedriazkhan.services.patients;

import me.mohammedriazkhan.domain.patients.Report;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface ReportService extends Service<Report, Integer> {

    Set<Report> getAll();

}
