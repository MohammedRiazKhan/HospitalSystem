package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.InPatient;


public class InPatientFactory {

    public static InPatient getInPatient(String firstName, String lastName, String telephone, String identityNumber, int age, Doctor doctor) {
        return (InPatient) new InPatient.InPatientBuilder()
                .patientId(1)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .doctor(doctor)
                .identityNumber(identityNumber)
                .telephone(telephone)
                .build();
    }




}
