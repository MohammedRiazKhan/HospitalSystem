package repositories.patients;

import domain.visits.MedicalTool;
import repositories.Repository;
import repositories.visits.MedicalToolRepository;

import java.util.HashSet;
import java.util.Set;

public interface AccountRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
