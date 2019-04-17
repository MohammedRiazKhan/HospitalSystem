package factories.visits;

import domain.employee.Doctor;
import domain.employee.Nurse;
import domain.patients.Patient;
import domain.visits.MedicalTool;
import domain.visits.Medication;
import domain.visits.Visit;

import java.util.List;

public class VisitFactory {

    public static Visit getVisit(int visitId, String visitDate, Patient patient, Doctor doctor, Nurse nurse, List<Medication> medication, List<MedicalTool> tools) {
        return (Visit) new Visit.VisitBuilder()
                .doctor(doctor)
                .medication(medication)
                .patient(patient)
                .visitDate(visitDate)
                .nurse(nurse)
                .build();
    }




}
