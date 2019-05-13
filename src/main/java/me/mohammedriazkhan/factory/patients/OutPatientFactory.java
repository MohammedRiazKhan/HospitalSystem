package me.mohammedriazkhan.factory.patients;

import me.mohammedriazkhan.domain.appoinments.Appointment;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patients.OutPatient;
import me.mohammedriazkhan.utility.IDGenerator;

public class OutPatientFactory {

    public static OutPatient getOutPatient(String firstName, String lastName, String telephone, String identityNumber, int age, Doctor doctor, Appointment appointment) {
        return (OutPatient) new OutPatient.OutPatientBuilder()
                .patientId(IDGenerator.genId())
                .build();
    }

}
