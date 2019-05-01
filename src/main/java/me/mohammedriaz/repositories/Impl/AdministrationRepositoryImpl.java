package me.mohammedriaz.repositories.Impl;

import me.mohammedriaz.domain.employee.Administration;
import me.mohammedriaz.repositories.employees.AdministrationRepository;

import java.util.HashSet;
import java.util.Set;

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

    public Administration find(int id) {
        return administrationStaff.stream().filter(administration -> administration.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public Administration create(Administration administration) {

        administrationStaff.add(administration);

        return administration;
    }

    @Override
    public Administration read(Integer id) {

        Administration administration = find(id);

        if(administration == null){
            return null;
        }
        else {
            return administration;
        }

    }

    @Override
    public Administration update(Administration administration) {

        Administration administration1 = find(administration.getEmployeeId());

        if(administrationStaff.contains(administration1)){
            administrationStaff.remove(administration1);
            administrationStaff.add(administration);
        }

        return administration1;
    }

    @Override
    public void delete(Integer id) {

        Administration administration = find(id);
        administrationStaff.remove(administration);
    }

    @Override
    public Set<Administration> getAll() {
        return administrationStaff;
    }


}
