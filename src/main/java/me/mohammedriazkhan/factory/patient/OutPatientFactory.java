package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.patient.OutPatient;
import me.mohammedriazkhan.utility.IDGenerator;

public class OutPatientFactory {

    public static OutPatient getOutPatient(String firstName, String lastName, String telephone, String identityNumber, int age, Doctor doctor, Appointment appointment) {
        return (OutPatient) new OutPatient.OutPatientBuilder()
                .patientId(IDGenerator.genId())
                .build();
    }

}
