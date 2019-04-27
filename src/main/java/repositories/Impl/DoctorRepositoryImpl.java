package repositories.Impl;

import domain.employee.Doctor;
import repositories.employees.DoctorRepository;

import java.util.HashSet;
import java.util.Set;

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

    public Doctor find(int id) {
        return doctors.stream().filter(doctor -> doctor.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public Doctor create(Doctor doctor) {

        doctors.add(doctor);
        return doctor;
    }

    @Override
    public Doctor read(Integer id) {
        Doctor doctor = find(id);

        if(doctor == null){
            return null;
        }
        else {
            return doctor;
        }
    }

    @Override
    public Doctor update(Doctor doctor) {

        Doctor docFound = find(doctor.getEmployeeId());

        if(doctors.contains(docFound)){
            doctors.remove(docFound);
            doctors.add(doctor);
        }

        return docFound;
    }

    @Override
    public void delete(Integer id) {
        Doctor doctor = find(id);
        doctors.remove(doctor);
    }

    @Override
    public Set<Doctor> getAll() {
        return doctors;
    }


}
