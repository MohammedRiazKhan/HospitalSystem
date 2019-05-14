package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.repository.employee.NurseRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("InMemory")
public class NurseRepositoryImpl implements NurseRepository {

    private static NurseRepositoryImpl repository = null;
    private Map<Integer, Nurse> nurses;

    public NurseRepositoryImpl(){
        nurses = new HashMap<>();
    }

    public static NurseRepositoryImpl getRepository() {

        if(repository == null){
            return new NurseRepositoryImpl();
        }

        return repository;
    }

    /*public Nurse find(int id) {
        return nurses.stream().filter(nurse -> nurse.getEmployeeId() == id).findAny().orElse(null);
    }*/

    @Override
    public Nurse create(Nurse nurse) {

       nurses.put(nurse.getEmployeeId(), nurse);
       return nurse;
    }

    @Override
    public Nurse read(Integer id) {

     return nurses.get(id);

    }

    @Override
    public Nurse update(Nurse nurse) {

      nurses.replace(nurse.getEmployeeId(), nurse);
      return nurses.get(nurse.getEmployeeId());
    }

    @Override
    public void delete(Integer id) {

        nurses.remove(id);

    }

    @Override
    public Set<Nurse> getAll() {
        return new HashSet<>(nurses.values());
    }

}
