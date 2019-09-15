package me.mohammedriazkhan.service.visit.impl;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.repository.visit.MedicalToolRepository;
import me.mohammedriazkhan.repository.visit.impl.MedicalToolRepositoryImpl;
import me.mohammedriazkhan.service.visit.MedicalToolService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class MedicalToolServiceImpl implements MedicalToolService {

    private MedicalToolServiceImpl service = null;
    private MedicalToolRepository repository;
    private Set<MedicalTool> medicalTools;

    public MedicalToolServiceImpl() {
        repository = MedicalToolRepositoryImpl.getRepository();
        medicalTools = new HashSet<>();
    }

    public MedicalToolServiceImpl getService(){

        if(service == null){
            return new MedicalToolServiceImpl();
        }
        return service;
    }

    @Override
    public Set<MedicalTool> getAll() {
        return medicalTools;
    }

    @Override
    public MedicalTool create(MedicalTool medicalTool) {
        medicalTools.add(medicalTool);
        return medicalTool;
    }

    @Override
    public MedicalTool read(String integer) {


        return medicalTools.stream().filter(medicalTool -> medicalTool.getToolId().equals(integer)).findAny().orElse(null);

    }

    @Override
    public MedicalTool update(MedicalTool medicalTool) {

        MedicalTool inDB = read(medicalTool.getToolId());
        if(inDB != null){
            medicalTools.remove(inDB);
            medicalTools.add(medicalTool);
            return medicalTool;
        }
        return null;

    }

    @Override
    public void delete(String integer) {
        MedicalTool inDB = read(integer);
        medicalTools.remove(inDB);


    }
}
