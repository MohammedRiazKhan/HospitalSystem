package repositories.Impl;

import domain.visits.MedicalTool;
import repositories.patients.AccountRepository;

import java.util.HashSet;
import java.util.Set;

public class AccountRepositoryImpl implements AccountRepository {

    private static AccountRepositoryImpl repository = null;
    private Set<MedicalTool> medicalTools;



    public AccountRepositoryImpl()
    {
        medicalTools = new HashSet<>();
    }

    public static AccountRepositoryImpl getRepository() {
        if(repository == null){
            return new AccountRepositoryImpl();
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
