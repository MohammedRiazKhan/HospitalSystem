package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.repository.employee.impl.AdministrationRepositoryImpl;
import me.mohammedriazkhan.repository.employee.AdministrationRepository;
import me.mohammedriazkhan.service.employee.AdministrationService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("AdministrationServiceImpl")
public class AdministrationServiceImpl implements AdministrationService {

    private AdministrationServiceImpl service = null;
    private AdministrationRepository repository;

    public AdministrationServiceImpl() {
        repository = AdministrationRepositoryImpl.getAdministrationRepository();
    }

    public AdministrationServiceImpl getService(){

        if(service == null){
            return new AdministrationServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Administration> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Administration create(Administration administration) {
        return repository.create(administration);
    }

    @Override
    public Administration read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Administration update(Administration administration) {
        return repository.update(administration);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }



}
