package me.mohammedriaz.services.Impl;

import me.mohammedriaz.domain.patients.Report;
import me.mohammedriaz.repositories.Impl.ReportRepositoryImpl;
import me.mohammedriaz.repositories.patients.ReportRepository;
import me.mohammedriaz.services.patients.ReportService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
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
