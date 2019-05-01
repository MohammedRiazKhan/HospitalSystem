package me.mohammedriaz.factories.visits;

import me.mohammedriaz.domain.employee.Doctor;
import me.mohammedriaz.domain.employee.Nurse;
import me.mohammedriaz.domain.patients.Patient;
import me.mohammedriaz.domain.visits.MedicalTool;
import me.mohammedriaz.domain.visits.Medication;
import me.mohammedriaz.domain.visits.Visit;

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
