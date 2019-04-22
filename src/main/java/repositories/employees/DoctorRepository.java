package repositories.employees;

import domain.employee.Doctor;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepository implements Repository<Doctor> {

    private static DoctorRepository doctorRepository = null;
    private Set<Doctor> doctors;


    public DoctorRepository(){
        doctors = new HashSet<>();
    }


    public static DoctorRepository getDoctorRepository() {

        if(doctorRepository == null){
            return new DoctorRepository();
        }

        return doctorRepository;
    }

    @Override
    public Doctor find(int id) {
        return doctors.stream().filter(doctor -> doctor.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Doctor doctor) {

        doctors.add(doctor);
    }

    @Override
    public Doctor read(int id) {
        return find(id);
    }

    @Override
    public void update(Doctor doctor) {

        Doctor docFound = find(doctor.getEmployeeId());

        if(doctors.contains(docFound)){
            doctors.remove(docFound);
            doctors.add(doctor);
        }

    }

    @Override
    public void delete(Doctor doctor) {

        doctors.remove(doctor);

    }

    @Override
    public Set<Doctor> getAll() {
        return doctors;
    }


}
