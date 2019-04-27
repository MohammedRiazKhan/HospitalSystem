package repositories.visits;

import domain.visits.Visit;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface VisitRepository extends Repository<Visit, Integer> {


    Set<Visit> getAll();


}
