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

    public static Visit getVisit(String visitDate, String patientId, String doctorId) {
        return  new Visit(IDGenerator.generateId(), visitDate, patientId, doctorId);
    }




}
