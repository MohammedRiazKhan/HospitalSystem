package repositories.hospital;

import domain.hospital.Hospital;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class HospitalRepository implements Repository<Hospital> {

    private static HospitalRepository repository = null;
    private Set<Hospital> hospitals;

    public HospitalRepository(){
        hospitals = new HashSet<>();
    }

    public static HospitalRepository getRepository() {

        if(repository == null){
            return new HospitalRepository();
        }
        return repository;

    }

    @Override
    public Hospital find(int id) {
        return hospitals.stream().filter(hospital -> hospital.getHospitalId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Hospital hospital) {

        hospitals.add(hospital);

    }

    @Override
    public Hospital read(int id) {
        return find(id);
    }

    @Override
    public void update(Hospital hospital) {


        Hospital hospital1 = find(hospital.getHospitalId());
        if(hospitals.contains(hospital1)){
            hospitals.remove(hospital1);
            hospitals.add(hospital);
        }
    }

    @Override
    public void delete(Hospital hospital) {

        hospitals.remove(hospital);

    }

    @Override
    public Set<Hospital> getAll() {
        return hospitals;
    }



}
