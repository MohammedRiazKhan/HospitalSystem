package me.mohammedriazkhan.service.visit.impl;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.repository.visit.MedicalToolRepository;
import me.mohammedriazkhan.repository.visit.impl.MedicalToolRepositoryImpl;
import me.mohammedriazkhan.service.visit.MedicalToolService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class MedicalToolServiceImpl implements MedicalToolService {

    private MedicalToolServiceImpl service = null;
    private MedicalToolRepository repository;

    public MedicalToolServiceImpl() {
        repository = MedicalToolRepositoryImpl.getRepository();
    }

    public MedicalToolServiceImpl getService(){

        if(service == null){
            return new MedicalToolServiceImpl();
        }
        return service;
    }

    @Override
    public Set<MedicalTool> getAll() {
        return null;
    }

    @Override
    public MedicalTool create(MedicalTool medicalTool) {
        return null;
    }

    @Override
    public MedicalTool read(String integer) {
        return null;
    }

    @Override
    public MedicalTool update(MedicalTool medicalTool) {
        return null;
    }

    @Override
    public void delete(String integer) {

    }
}
