package factories.patients;

import domain.employee.Doctor;
import domain.patients.Patient;

import static utility.IDGenerator.genId;


public class PatientFactory {

    public static Patient getPatient(String firstName, String lastName, String telephone, String identityNumber, int age, Doctor doctor) {
        return new Patient.Builder().patientId(genId())
                .firstName(firstName)
                .lastName(lastName)
                .telephone(telephone)
                .identityNumber(identityNumber)
                .age(age)
                .doctor(doctor)
                .build();
    }

}
