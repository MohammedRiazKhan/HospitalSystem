package me.mohammedriazkhan.service.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.repository.hospital.HospitalRepository;
import me.mohammedriazkhan.repository.hospital.hibernate.HospitalRepositoryHibernate;
import me.mohammedriazkhan.repository.hospital.impl.HospitalRepositoryImpl;
import me.mohammedriazkhan.service.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class HospitalServiceImpl implements HospitalService {

    private HospitalServiceImpl service = null;
    @Autowired
    private HospitalRepositoryHibernate repository;

    public HospitalServiceImpl() {

    }

    public HospitalServiceImpl getService(){

        if(service == null){
            return new HospitalServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Hospital> getAll() {
        List<Hospital> list = (List<Hospital>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Hospital create(Hospital hospital) {
        return repository.save(hospital);
    }

    @Override
    public Hospital read(String integer) {
       return repository.findById(integer).orElse(null);
    }

    @Override
    public Hospital update(Hospital hospital) {
        return repository.save(hospital);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }
}
