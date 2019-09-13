package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Doctor;
import org.springframework.stereotype.Repository;
import me.mohammedriazkhan.repository.employee.DoctorRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("DoctorInMemory")
public class DoctorRepositoryImpl implements DoctorRepository {

    private static DoctorRepositoryImpl doctorRepository = null;
    private Set<Doctor> doctors;


    public DoctorRepositoryImpl(){
        doctors = new HashSet<>();
    }


    public static DoctorRepositoryImpl getDoctorRepository() {

        if(doctorRepository == null){
            return new DoctorRepositoryImpl();
        }

        return doctorRepository;
    }

    @Override
    public Doctor create(Doctor doctor) {

       doctors.add(doctor);
       return doctor;
    }

    @Override
    public Doctor read(String id) {
       return doctors.stream().filter(doctor -> doctor.getEmployeeId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Doctor update(Doctor doctor) {

        Doctor inDB = read(doctor.getEmployeeId());

        if(inDB != null){
            doctors.remove(inDB);
            doctors.add(doctor);
            return doctor;
        }

        return null;
    }

    @Override
    public void delete(String id) {
        Doctor inDB = read(id);
        doctors.remove(inDB);
    }

    @Override
    public Set<Doctor> getAll() {
        return doctors;
    }


}
