package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.repository.employee.NurseRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("NurseInMemory")
public class NurseRepositoryImpl implements NurseRepository {

    private static NurseRepositoryImpl repository = null;
    private HashSet<Nurse> nurses;

    public NurseRepositoryImpl(){
        nurses = new HashSet<>();
    }

    public static NurseRepositoryImpl getRepository() {

        if(repository == null){
            return new NurseRepositoryImpl();
        }

        return repository;
    }

    @Override
    public Nurse create(Nurse nurse) {

       nurses.add(nurse);
       return nurse;
    }

    @Override
    public Nurse read(String id) {

     return nurses.stream().filter(nurse -> nurse.getEmployeeId().equals(id)).findAny().orElse(null);

    }

    @Override
    public Nurse update(Nurse nurse) {

        Nurse inDB = read(nurse.getEmployeeId());

        if(inDB != null){
            nurses.remove(inDB);
            nurses.add(nurse);
            return nurse;
        }

        return null;
    }

    @Override
    public void delete(String id) {

        Nurse inDB = read(id);
        nurses.remove(inDB);
    }

    @Override
    public Set<Nurse> getAll() {
        return nurses;
    }

}
