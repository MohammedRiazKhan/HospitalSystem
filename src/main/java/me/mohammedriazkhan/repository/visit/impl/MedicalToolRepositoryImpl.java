package me.mohammedriazkhan.repository.visit.impl;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.repository.visit.MedicalToolRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("MedicalToolInMemory")
public class MedicalToolRepositoryImpl implements MedicalToolRepository{

    private static MedicalToolRepositoryImpl repository = null;
    private Set<MedicalTool> medicalTools;

    public MedicalToolRepositoryImpl()
    {
        medicalTools = new HashSet<>();
    }

    public static MedicalToolRepositoryImpl getRepository() {
        if(repository == null){
            return new MedicalToolRepositoryImpl();
        }
        return repository;
    }


    @Override
    public MedicalTool create(MedicalTool medicalTool) {

       medicalTools.add(medicalTool);
       return medicalTool;
    }

    @Override
    public MedicalTool read(String id) {

       return medicalTools.stream().filter(medicalTool -> medicalTool.getToolId().equals(id)).findAny().orElse(null);

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
    public void delete(String id) {
        MedicalTool inDB = read(id);
        medicalTools.remove(inDB);

    }

    @Override
    public Set<MedicalTool> getAll() {
        return medicalTools;
    }


}
