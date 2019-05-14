package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.repository.employee.AdministrationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("AdministrationInMemory")
public class AdministrationRepositoryImpl implements AdministrationRepository {

    private static AdministrationRepositoryImpl administrationRepository = null;
    private Map<Integer, Administration> administrationStaff;


    public AdministrationRepositoryImpl(){
        administrationStaff = new HashMap<>();
    }

    public static AdministrationRepositoryImpl getAdministrationRepository() {

        if(administrationRepository == null){
            return new AdministrationRepositoryImpl();
        }

        return administrationRepository;
    }

   /* public Administration find(int id) {
        return administrationStaff.stream().filter(administration -> administration.getEmployeeId() == id).findAny().orElse(null);
    }*/

    @Override
    public Administration create(Administration administration) {

        administrationStaff.put(administration.getEmployeeId(), administration);

        return administration;
    }

    @Override
    public Administration read(Integer id) {

       return administrationStaff.get(id);

    }

    @Override
    public Administration update(Administration administration) {

       administrationStaff.replace(administration.getEmployeeId(), administration);
       return administrationStaff.get(administration.getEmployeeId());
    }

    @Override
    public void delete(Integer id) {

       administrationStaff.remove(id);
    }

    @Override
    public Set<Administration> getAll() {

        //copies the values in the set to a new collection then places it inside of a HashSet
        return new HashSet<>(administrationStaff.values());

    }


}
