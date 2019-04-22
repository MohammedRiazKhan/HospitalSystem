package repositories.employees;

import domain.employee.Nurse;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class NurseRepository implements Repository<Nurse> {

    private static NurseRepository repository = null;
    private Set<Nurse> nurses;

    public NurseRepository(){
        nurses = new HashSet<>();
    }

    public static NurseRepository getRepository() {

        if(repository == null){
            return new NurseRepository();
        }

        return repository;
    }

    @Override
    public Nurse find(int id) {
        return nurses.stream().filter(nurse -> nurse.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Nurse nurse) {

        nurses.add(nurse);

    }

    @Override
    public Nurse read(int id) {
        return find(id);
    }

    @Override
    public void update(Nurse nurse) {

        Nurse nurse1 = find(nurse.getEmployeeId());

        if(nurses.contains(nurse1)){
            nurses.remove(nurse1);
            nurses.add(nurse);
        }

    }

    @Override
    public void delete(Nurse nurse) {

        nurses.remove(nurse);

    }

    @Override
    public Set<Nurse> getAll() {
        return nurses;
    }



}
