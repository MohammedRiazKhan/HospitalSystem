package me.mohammedriaz.services.patients;

import me.mohammedriaz.domain.patients.Report;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface ReportService extends Service<Report, Integer> {

    Set<Report> getAll();

}
