package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.helper.IDGenerator;

import java.util.UUID;


public class InPatientFactory {

    public static InPatient getInPatient(String firstName, String lastName, String telephone, String identityNumber, int age, String accountId, String roomId, int days, String meal) {
        return (InPatient) new InPatient.InPatientBuilder()
                .roomId(roomId)
                .days(days)
                .mealId(meal)
                .firstName(firstName)
                .lastName(lastName)
                .telephone(telephone)
                .identityNumber(identityNumber)
                .age(age)
                .accountId(accountId)
                .patientId(IDGenerator.generateId())
                .build();
    }




}
