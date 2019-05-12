package me.mohammedriazkhan.repositories.Impl;

import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.repositories.visits.MedicalToolRepository;

import java.util.HashSet;
import java.util.Set;

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

    public MedicalTool find(int id) {
        return medicalTools.stream().filter(medicalTool -> medicalTool.getToolId() == id).findAny().orElse(null);
    }

    @Override
    public MedicalTool create(MedicalTool medicalTool) {

        medicalTools.add(medicalTool);

        return medicalTool;
    }

    @Override
    public MedicalTool read(Integer id) {

        MedicalTool medicalTool = find(id);
        if(medicalTool == null){
            return null;
        }
        else {
            return medicalTool;
        }

    }

    @Override
    public MedicalTool update(MedicalTool medicalTool) {

        MedicalTool medicalTool1 = find(medicalTool.getToolId());
        if(medicalTools.contains(medicalTool1)){
            medicalTools.remove(medicalTool1);
            medicalTools.add(medicalTool);
        }

        return medicalTool1;
    }

    @Override
    public void delete(Integer id) {


        MedicalTool medicalTool = find(id);
        medicalTools.remove(medicalTool);

    }

    @Override
    public Set<MedicalTool> getAll() {
        return medicalTools;
    }


}
