package repositories.visits;

import domain.visits.Visit;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class VisitRepository implements Repository<Visit> {

    private static VisitRepository repository = null;
    private Set<Visit> visits;

    public VisitRepository(){
        visits = new HashSet<>();
    }

    public static VisitRepository getRepository() {

        if(repository == null){
            return new VisitRepository();
        }
        return repository;
    }

    @Override
    public Visit find(int id) {
        return visits.stream().filter(visit -> visit.getVisitId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Visit visit) {

        visits.add(visit);

    }

    @Override
    public Visit read(int id) {
        return find(id);
    }

    @Override
    public void update(Visit visit) {

        Visit visit1 = find(visit.getVisitId());
        if(visits.contains(visit1)){
            visits.remove(visit1);
            visits.add(visit);
        }

    }

    @Override
    public void delete(Visit visit) {

        visits.remove(visit);
    }

    @Override
    public Set<Visit> getAll() {
        return visits;
    }



}
