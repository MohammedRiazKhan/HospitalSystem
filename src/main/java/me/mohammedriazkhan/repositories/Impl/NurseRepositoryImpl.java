package me.mohammedriazkhan.repositories.Impl;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.repositories.employees.NurseRepository;

import java.util.HashSet;
import java.util.Set;

public class NurseRepositoryImpl implements NurseRepository {

    private static NurseRepositoryImpl repository = null;
    private Set<Nurse> nurses;

    public NurseRepositoryImpl(){
        nurses = new HashSet<>();
    }

    public static NurseRepositoryImpl getRepository() {

        if(repository == null){
            return new NurseRepositoryImpl();
        }

        return repository;
    }

    public Nurse find(int id) {
        return nurses.stream().filter(nurse -> nurse.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public Nurse create(Nurse nurse) {

        nurses.add(nurse);

        return nurse;
    }

    @Override
    public Nurse read(Integer id) {

       Nurse nurse = find(id);

       if(nurse == null){
           return null;
       }
       else{
           return nurse;
       }

    }

    @Override
    public Nurse update(Nurse nurse) {

        Nurse nurse1 = find(nurse.getEmployeeId());

        if(nurses.contains(nurse1)){
            nurses.remove(nurse1);
            nurses.add(nurse);
        }

        return nurse1;
    }

    @Override
    public void delete(Integer id) {


        Nurse nurse = find(id);
        nurses.remove(nurse);

    }

    @Override
    public Set<Nurse> getAll() {
        return nurses;
    }

}
