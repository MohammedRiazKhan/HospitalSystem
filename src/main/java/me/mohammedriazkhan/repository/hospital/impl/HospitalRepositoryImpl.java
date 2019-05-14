package me.mohammedriazkhan.repository.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.repository.hospital.HospitalRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("HospitalInMemory")
public class HospitalRepositoryImpl implements HospitalRepository {

    private static HospitalRepositoryImpl repository = null;
    private Map<Integer, Hospital> hospitals;

    public HospitalRepositoryImpl(){
        hospitals = new HashMap<>();
    }

    public static HospitalRepositoryImpl getRepository() {

        if(repository == null){
            return new HospitalRepositoryImpl();
        }
        return repository;

    }

    /*public Hospital find(int id) {
        return hospitals.stream().filter(hospital -> hospital.getHospitalId() == id).findAny().orElse(null);
    }*/

    @Override
    public Hospital create(Hospital hospital) {

       hospitals.put(hospital.getHospitalId(), hospital);
       return hospital;
    }

    @Override
    public Hospital read(Integer id) {
      return hospitals.get(id);
    }

    @Override
    public Hospital update(Hospital hospital) {

        hospitals.replace(hospital.getHospitalId(), hospital);
        return hospitals.get(hospital.getHospitalId());
    }

    @Override
    public void delete(Integer id) {

       hospitals.remove(id);

    }

    @Override
    public Set<Hospital> getAll() {
        return new HashSet<>(hospitals.values());
    }


}
