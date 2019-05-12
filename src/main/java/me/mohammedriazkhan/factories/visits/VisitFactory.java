package me.mohammedriazkhan.factories.visits;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.domain.visits.Medication;
import me.mohammedriazkhan.domain.visits.Visit;

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
