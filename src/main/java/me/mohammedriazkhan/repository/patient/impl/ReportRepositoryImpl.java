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
    private Map<Integer, Report> reports;

    public ReportRepositoryImpl(){
        reports = new HashMap<>();
    }

    public static ReportRepositoryImpl getReportRepository() {

        if(reportRepository == null){
            return new ReportRepositoryImpl();
        }
        return reportRepository;
    }


    @Override
    public Report create(Report report) {

       reports.put(report.getReportId(), report);

        return report;
    }

    @Override
    public Report read(Integer id) {

       return reports.get(id);
    }

    @Override
    public Report update(Report report) {

       reports.replace(report.getReportId(), report);
       return reports.get(report.getReportId());
    }

    @Override
    public void delete(Integer id) {

        reports.remove(id);

    }

    @Override
    public Set<Report> getAll() {
        return new HashSet<>(reports.values());
    }

}
