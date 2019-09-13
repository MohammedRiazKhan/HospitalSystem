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

    @Override
    public Hospital create(Hospital hospital) {

       hospitals.add(hospital);
       return hospital;
    }

    @Override
    public Hospital read(String id) {
      return hospitals.stream().filter(hospital -> hospital.getHospitalId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Hospital update(Hospital hospital) {

        Hospital inDB = read(hospital.getHospitalId());
        if(inDB != null){
            hospitals.remove(hospital);
            hospitals.add(hospital);
            return hospital;

        }

        return null;
    }

    @Override
    public void delete(String id) {

        Hospital inDB = read(id);
        hospitals.remove(inDB);

    }

    @Override
    public Set<Hospital> getAll() {
        return hospitals;
    }


}
