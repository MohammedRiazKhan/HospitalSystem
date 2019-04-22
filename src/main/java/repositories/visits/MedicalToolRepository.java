package repositories.visits;

import domain.visits.MedicalTool;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class MedicalToolRepository implements Repository<MedicalTool> {

    private static MedicalToolRepository repository = null;
    private Set<MedicalTool> medicalTools;

    public MedicalToolRepository()
    {
        medicalTools = new HashSet<>();
    }

    public static MedicalToolRepository getRepository() {
        if(repository == null){
            return new MedicalToolRepository();
        }
        return repository;
    }

    @Override
    public MedicalTool find(int id) {
        return medicalTools.stream().filter(medicalTool -> medicalTool.getToolId() == id).findAny().orElse(null);
    }

    @Override
    public void create(MedicalTool medicalTool) {

        medicalTools.add(medicalTool);

    }

    @Override
    public MedicalTool read(int id) {
        return find(id);
    }

    @Override
    public void update(MedicalTool medicalTool) {

        MedicalTool medicalTool1 = find(medicalTool.getToolId());
        if(medicalTools.contains(medicalTool1)){
            medicalTools.remove(medicalTool1);
            medicalTools.add(medicalTool);
        }

    }

    @Override
    public void delete(MedicalTool medicalTool) {

        medicalTools.remove(medicalTool);

    }

    @Override
    public Set<MedicalTool> getAll() {
        return medicalTools;
    }



}
