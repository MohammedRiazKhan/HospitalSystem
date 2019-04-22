package repositories.employees;

import domain.employee.Porter;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class PorterRepository implements Repository<Porter> {

    private static PorterRepository repository = null;
    private Set<Porter> porters;

    public PorterRepository(){
        porters = new HashSet<>();
    }


    public static PorterRepository getRepository() {

        if(repository == null){
            return new PorterRepository();
        }
        return repository;
    }

    @Override
    public Porter find(int id) {
        return porters.stream().filter(porter -> porter.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Porter porter) {

        porters.add(porter);

    }

    @Override
    public Porter read(int id) {
        return find(id);
    }

    @Override
    public void update(Porter porter) {

        Porter porter1 = find(porter.getEmployeeId());

        if(porters.contains(porter1)){
            porters.remove(porter1);
            porters.add(porter);
        }

    }

    @Override
    public void delete(Porter porter) {

        porters.remove(porter);

    }

    @Override
    public Set<Porter> getAll() {
        return porters;
    }



}
