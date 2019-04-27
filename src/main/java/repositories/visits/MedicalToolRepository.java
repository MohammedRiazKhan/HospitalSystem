package repositories.visits;

import domain.visits.MedicalTool;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface MedicalToolRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
