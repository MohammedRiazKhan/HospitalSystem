package repositories.employees;

import domain.employee.Administration;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class AdministrationRepository implements Repository<Administration> {

    private static AdministrationRepository administrationRepository = null;
    private Set<Administration> administrationStaff;


    public AdministrationRepository(){
        administrationStaff = new HashSet<>();
    }

    public static AdministrationRepository getAdministrationRepository() {

        if(administrationRepository == null){
            return new AdministrationRepository();
        }

        return administrationRepository;
    }

    @Override
    public Administration find(int id) {
        return administrationStaff.stream().filter(administration -> administration.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Administration administration) {

        administrationStaff.add(administration);

    }

    @Override
    public Administration read(int id) {
        return find(id);
    }

    @Override
    public void update(Administration administration) {

        Administration administration1 = find(administration.getEmployeeId());

        if(administrationStaff.contains(administration1)){
            administrationStaff.remove(administration1);
            administrationStaff.add(administration);
        }

    }

    @Override
    public void delete(Administration administration) {

        administrationStaff.remove(administration);


    }

    @Override
    public Set<Administration> getAll() {
        return administrationStaff;
    }


}
