package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.helper.IDGenerator;

import java.util.List;

public class VisitFactory {

    public static Visit getVisit( String visitDate, String patient, String doctorId, String nurse, List<Medication> medication, List<MedicalTool> tools) {
        return (Visit) new Visit.VisitBuilder()
                .visitId(IDGenerator.generateId())
                .doctorId(doctorId)
                .medication(medication)
                .patientId(patient)
                .visitDate(visitDate)
                .nurseId(nurse)
                .build();
    }




}
