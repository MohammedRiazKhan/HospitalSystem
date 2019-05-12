package me.mohammedriazkhan.factories.patients;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patients.InPatient;
import me.mohammedriazkhan.utility.IDGenerator;

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
