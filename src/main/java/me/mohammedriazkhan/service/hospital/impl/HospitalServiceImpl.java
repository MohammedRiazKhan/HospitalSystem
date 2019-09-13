package me.mohammedriazkhan.service.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.repository.hospital.HospitalRepository;
import me.mohammedriazkhan.repository.hospital.impl.HospitalRepositoryImpl;
import me.mohammedriazkhan.service.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class HospitalServiceImpl implements HospitalService {

    private HospitalServiceImpl service = null;
    private HospitalRepository repository;

    public HospitalServiceImpl() {
        repository = HospitalRepositoryImpl.getRepository();
    }

    public HospitalServiceImpl getService(){

        if(service == null){
            return new HospitalServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Hospital> getAll() {
        return repository.getAll();
    }

    @Override
    public Hospital create(Hospital hospital) {
        return repository.create(hospital);
    }

    @Override
    public Hospital read(String integer) {
       return repository.read(integer);
    }

    @Override
    public Hospital update(Hospital hospital) {
        return repository.update(hospital);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
