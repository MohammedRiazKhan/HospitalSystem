package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.repository.employee.AdministrationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AdministrationRepositoryImpl implements AdministrationRepository {

    private static AdministrationRepositoryImpl administrationRepository = null;
    private Set<Administration> administrationStaff;

    public AdministrationRepositoryImpl(){
        administrationStaff = new HashSet<>();
    }

    public static AdministrationRepositoryImpl getAdministrationRepository() {

        if(administrationRepository == null){
            return new AdministrationRepositoryImpl();
        }

        return administrationRepository;
    }

   /* public Administration find(int id) {
        return
    }*/

    @Override
    public Administration create(Administration administration) {

       administrationStaff.add(administration);
       return administration;
    }

    @Override
    public Administration read(String id) {

       return administrationStaff.stream().filter(administration -> administration.getEmployeeId().equals(id)).findAny().orElse(null);

    }

    @Override
    public Administration update(Administration administration) {

        Administration inDB = read(administration.getEmployeeId());
        if(inDB != null){
            administrationStaff.remove(inDB);
            administrationStaff.add(administration);
            return administration;
        }

        return null;
    }

    @Override
    public void delete(String id) {
        Administration inDB = read(id);

        administrationStaff.remove(inDB);

    }

    @Override
    public Set<Administration> getAll() {

        return administrationStaff;

    }


}
