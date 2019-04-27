package services.Impl;

import domain.patients.Report;
import repositories.Impl.ReportRepositoryImpl;
import repositories.patients.ReportRepository;
import services.patients.ReportService;

import java.util.Set;

public class ReportServiceImpl implements ReportService {

    private ReportServiceImpl service = null;
    private ReportRepository repository;

    public ReportServiceImpl() {
        repository = ReportRepositoryImpl.getReportRepository();
    }

    public ReportServiceImpl getService(){

        if(service == null){
            return new ReportServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Report> getAll() {
        return repository.getAll();
    }

    @Override
    public Report create(Report report) {
        return repository.create(report);
    }

    @Override
    public Report read(Integer integer) {
        return null;
    }

    @Override
    public Report update(Report report) {
        return repository.update(report);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }
}
