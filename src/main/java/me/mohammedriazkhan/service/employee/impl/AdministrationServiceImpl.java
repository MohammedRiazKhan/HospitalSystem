package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.repository.employee.hibernate.AdministrationRepositoryHibernate;
import me.mohammedriazkhan.repository.employee.impl.AdministrationRepositoryImpl;
import me.mohammedriazkhan.repository.employee.AdministrationRepository;
import me.mohammedriazkhan.service.employee.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service("AdministrationServiceImpl")
public class AdministrationServiceImpl implements AdministrationService {

    private AdministrationServiceImpl service = null;
    @Autowired
    private AdministrationRepositoryHibernate repository;

    public AdministrationServiceImpl(){
    }

    public AdministrationServiceImpl getService(){

        if(service == null){
            return new AdministrationServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Administration> getAll() {

        List<Administration> list = (List<Administration>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Administration create(Administration administration) {
        return repository.save(administration);
    }

    @Override
    public Administration read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Administration update(Administration administration) {
        return repository.save(administration);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }



}
