package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.OutPatient;
import me.mohammedriazkhan.helper.IDGenerator;


public class OutPatientFactory {

    public static OutPatient getOutPatient(String firstName, String lastName, String telephone, String identityNumber, int age, String accountId, String appointmentId) {
        return (OutPatient) new OutPatient.OutPatientBuilder()
                .appointmentId(appointmentId)
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
