package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Doctor;
import org.springframework.stereotype.Repository;
import me.mohammedriazkhan.repository.employee.DoctorRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("InMemory")
public class DoctorRepositoryImpl implements DoctorRepository {

    private static DoctorRepositoryImpl doctorRepository = null;
    private Map<Integer, Doctor> doctors;


    public DoctorRepositoryImpl(){
        doctors = new HashMap<>();
    }


    public static DoctorRepositoryImpl getDoctorRepository() {

        if(doctorRepository == null){
            return new DoctorRepositoryImpl();
        }

        return doctorRepository;
    }

   /* public Doctor find(int id) {
        return doctors.stream().filter(doctor -> doctor.getEmployeeId() == id).findAny().orElse(null);
    }*/

    @Override
    public Doctor create(Doctor doctor) {

        doctors.put(doctor.getEmployeeId(), doctor);
        return doctor;
    }

    @Override
    public Doctor read(Integer id) {
       return doctors.get(id);
    }

    @Override
    public Doctor update(Doctor doctor) {

       doctors.replace(doctor.getEmployeeId(), doctor);
       return doctors.get(doctor.getEmployeeId());
    }

    @Override
    public void delete(Integer id) {
       doctors.remove(id);
    }

    @Override
    public Set<Doctor> getAll() {
        return new HashSet<>(doctors.values());
    }


}
