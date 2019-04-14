package factories;

import domain.Doctor;

import static utility.IDGenerator.genId;

public class DoctorFactory {

    public static Doctor getDoctor(String firstName) {
        return new Doctor.Builder()
                .doctorId(genId())
                .firstName(firstName)
                .build();
    }
}
