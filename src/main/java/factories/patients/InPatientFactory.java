package factories.patients;

import domain.employee.Doctor;
import domain.patients.InPatient;
import domain.patients.Meal;
import utility.IDGenerator;

import java.util.List;

public class InPatientFactory {

    public static InPatient getInPatient(String firstName, String lastName, String telephone, String identityNumber, int age, Doctor doctor, List<String> daysStayed, List<Meal> meal) {
        return (InPatient) new InPatient.InPatientBuilder()
                .patientId(IDGenerator.genId())
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .doctor(doctor)
                .identityNumber(identityNumber)
                .telephone(telephone)
                .build();
    }

}
