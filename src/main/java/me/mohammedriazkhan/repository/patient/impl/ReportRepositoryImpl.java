package me.mohammedriazkhan.repository.patient.impl;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.repository.patient.ReportRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
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

    public Report find(int id) {
        return reports.stream().filter(report -> report.getReportId() == id).findAny().orElse(null);
    }

    @Override
    public Report create(Report report) {

        reports.add(report);

        return report;
    }

    @Override
    public Report read(Integer id) {

        Report report1 = find(id);


        if(report1 == null){
            return null;
        }
        else {
            return report1;
        }
    }

    @Override
    public Report update(Report report) {

        Report report1 = find(report.getReportId());
        if(reports.contains(report1)){
            reports.remove(report1);
            reports.add(report);
        }
        return report1;
    }

    @Override
    public void delete(Integer id) {

        Report report1 = find(id);
        reports.remove(report1);

    }

    @Override
    public Set<Report> getAll() {
        return reports;
    }

}
