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
    private Map<Integer, MedicalTool> medicalTools;

    public MedicalToolRepositoryImpl()
    {
        medicalTools = new HashMap<>();
    }

    public static MedicalToolRepositoryImpl getRepository() {
        if(repository == null){
            return new MedicalToolRepositoryImpl();
        }
        return repository;
    }


    @Override
    public MedicalTool create(MedicalTool medicalTool) {

       medicalTools.put(medicalTool.getToolId(), medicalTool);

        return medicalTool;
    }

    @Override
    public MedicalTool read(Integer id) {

       return medicalTools.get(id);

    }

    @Override
    public MedicalTool update(MedicalTool medicalTool) {

       medicalTools.replace(medicalTool.getToolId(), medicalTool);
       return medicalTools.get(medicalTool.getToolId());
    }

    @Override
    public void delete(Integer id) {

        medicalTools.remove(id);

    }

    @Override
    public Set<MedicalTool> getAll() {
        return new HashSet<>(medicalTools.values());
    }


}
