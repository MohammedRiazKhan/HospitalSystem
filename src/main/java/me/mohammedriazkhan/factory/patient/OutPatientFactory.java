package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.OutPatient;
import me.mohammedriazkhan.helper.IDGenerator;


public class OutPatientFactory {

    public static OutPatient getOutPatient(String firstName, String lastName, String telephone, String identityNumber, int age, String doctor, Appointment appointment) {
        return (OutPatient) new OutPatient.OutPatientBuilder()
                .patientId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .doctor(doctor)
                .identityNumber(identityNumber)
                .telephone(telephone)
                .build();
    }

}
