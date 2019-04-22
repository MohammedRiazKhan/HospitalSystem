package repositories.patients;

import domain.patients.Report;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class ReportRepository implements Repository<Report> {

    private static ReportRepository reportRepository = null;
    private Set<Report> reports;

    public ReportRepository(){
        reports = new HashSet<>();
    }

    public static ReportRepository getReportRepository() {

        if(reportRepository == null){
            return new ReportRepository();
        }
        return reportRepository;
    }

    @Override
    public Report find(int id) {
        return reports.stream().filter(report -> report.getReportId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Report report) {

        reports.add(report);

    }

    @Override
    public Report read(int id) {
        return find(id);
    }

    @Override
    public void update(Report report) {

        Report report1 = find(report.getReportId());
        if(reports.contains(report1)){
            reports.remove(report1);
            reports.add(report);
        }
    }

    @Override
    public void delete(Report report) {

        reports.remove(report);

    }

    @Override
    public Set<Report> getAll() {
        return reports;
    }



}
