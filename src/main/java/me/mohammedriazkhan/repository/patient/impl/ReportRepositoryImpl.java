package me.mohammedriazkhan.repository.patient.impl;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.repository.patient.ReportRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("ReportInMemory")
public class ReportRepositoryImpl implements ReportRepository {

    private static ReportRepositoryImpl reportRepository = null;
    private Set<Report> reports;

    public ReportRepositoryImpl(){
        reports = new HashSet<>();
    }

    public static ReportRepositoryImpl getReportRepository() {

        if(reportRepository == null){
            return new ReportRepositoryImpl();
        }
        return reportRepository;
    }


    @Override
    public Report create(Report report) {

       reports.add(report);
       return report;
    }

    @Override
    public Report read(String id) {

       return reports.stream().filter(report -> report.getReportId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Report update(Report report) {

        Report inDB = read(report.getReportId());
        if(inDB != null){
            reports.remove(inDB);
            reports.add(report);
            return report;
        }
        return null;
    }

    @Override
    public void delete(String id) {

        Report inDB = read(id);
        reports.remove(inDB);

    }

    @Override
    public Set<Report> getAll() {
        return reports;
    }

}
