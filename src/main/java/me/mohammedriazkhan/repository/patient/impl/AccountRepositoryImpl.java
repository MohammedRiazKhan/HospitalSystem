package me.mohammedriazkhan.repository.patient.impl;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.repository.patient.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("AccountInMemory")
public class AccountRepositoryImpl implements AccountRepository {

    private static AccountRepositoryImpl repository = null;
    private Map<Integer, MedicalTool> medicalTools;

    public AccountRepositoryImpl()
    {
        medicalTools = new HashMap<>();
    }

    public static AccountRepositoryImpl getRepository() {
        if(repository == null){
            return new AccountRepositoryImpl();
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
