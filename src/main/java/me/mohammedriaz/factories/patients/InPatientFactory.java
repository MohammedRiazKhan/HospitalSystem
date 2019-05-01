package me.mohammedriaz.factories.patients;

import me.mohammedriaz.domain.employee.Doctor;
import me.mohammedriaz.domain.patients.InPatient;
import me.mohammedriaz.utility.IDGenerator;

public class InPatientFactory {

    public static InPatient getInPatient(String firstName, String lastName, String telephone, String identityNumber, int age, Doctor doctor) {
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
