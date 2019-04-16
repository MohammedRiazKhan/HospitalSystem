package factories.patients;

import domain.appoinments.Appointment;
import domain.employee.Doctor;
import domain.patients.OutPatient;
import utility.IDGenerator;

public class OutPatientFactory {

    public static OutPatient getOutPatient(String firstName, String lastName, String telephone, String identityNumber, int age, Doctor doctor, Appointment appointment) {
        return (OutPatient) new OutPatient.OutPatientBuilder()
                .patientId(IDGenerator.genId())
                .build();
    }

}
