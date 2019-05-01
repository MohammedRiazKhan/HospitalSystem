package me.mohammedriaz.factories.patients;

import me.mohammedriaz.domain.appoinments.Appointment;
import me.mohammedriaz.domain.employee.Doctor;
import me.mohammedriaz.domain.patients.OutPatient;
import me.mohammedriaz.utility.IDGenerator;

public class OutPatientFactory {

    public static OutPatient getOutPatient(String firstName, String lastName, String telephone, String identityNumber, int age, Doctor doctor, Appointment appointment) {
        return (OutPatient) new OutPatient.OutPatientBuilder()
                .patientId(IDGenerator.genId())
                .build();
    }

}
