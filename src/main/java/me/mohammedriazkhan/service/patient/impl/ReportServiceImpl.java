package me.mohammedriazkhan.service.patient.impl;

import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.repository.patient.impl.ReportRepositoryImpl;
import me.mohammedriazkhan.repository.patient.ReportRepository;
import me.mohammedriazkhan.service.patient.ReportService;
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
    public Report read(String integer) {
        return null;
    }

    @Override
    public Report update(Report report) {
        return repository.update(report);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
