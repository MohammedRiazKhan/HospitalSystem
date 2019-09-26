package me.mohammedriazkhan.service.visit.impl;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.repository.visit.MedicalToolRepository;
import me.mohammedriazkhan.repository.visit.hibernate.MedicalToolRepositoryHibernate;
import me.mohammedriazkhan.repository.visit.impl.MedicalToolRepositoryImpl;
import me.mohammedriazkhan.service.visit.MedicalToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class MedicalToolServiceImpl implements MedicalToolService {

    private MedicalToolServiceImpl service = null;
    @Autowired
    private MedicalToolRepositoryHibernate repository;

    public MedicalToolServiceImpl() {

    }

    public MedicalToolServiceImpl getService(){

        if(service == null){
            return new MedicalToolServiceImpl();
        }
        return service;
    }

    @Override
    public Set<MedicalTool> getAll() {
        List<MedicalTool> list = (List<MedicalTool>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public MedicalTool create(MedicalTool medicalTool) {
      return repository.save(medicalTool);
    }

    @Override
    public MedicalTool read(String integer) {


        return repository.findById(integer).orElse(null);

    }

    @Override
    public MedicalTool update(MedicalTool medicalTool) {

      return repository.save(medicalTool);

    }

    @Override
    public void delete(String integer) {
      repository.deleteById(integer);


    }
}
