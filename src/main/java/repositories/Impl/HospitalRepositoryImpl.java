package repositories.Impl;

import domain.hospital.Hospital;
import repositories.hospital.HospitalRepository;

import java.util.HashSet;
import java.util.Set;

public class HospitalRepositoryImpl implements HospitalRepository {

    private static HospitalRepositoryImpl repository = null;
    private Set<Hospital> hospitals;

    public HospitalRepositoryImpl(){
        hospitals = new HashSet<>();
    }

    public static HospitalRepositoryImpl getRepository() {

        if(repository == null){
            return new HospitalRepositoryImpl();
        }
        return repository;

    }

    public Hospital find(int id) {
        return hospitals.stream().filter(hospital -> hospital.getHospitalId() == id).findAny().orElse(null);
    }

    @Override
    public Hospital create(Hospital hospital) {

        hospitals.add(hospital);

        return hospital;
    }

    @Override
    public Hospital read(Integer id) {
        Hospital hospital = find(id);
        if(hospital == null){
            return  null;
        }
        else {
            return hospital;
        }
    }

    @Override
    public Hospital update(Hospital hospital) {


        Hospital hospital1 = find(hospital.getHospitalId());
        if(hospitals.contains(hospital1)){
            hospitals.remove(hospital1);
            hospitals.add(hospital);
        }
        return hospital1;
    }

    @Override
    public void delete(Integer id) {

        Hospital hospital = find(id);
        hospitals.remove(hospital);

    }

    @Override
    public Set<Hospital> getAll() {
        return hospitals;
    }


}
