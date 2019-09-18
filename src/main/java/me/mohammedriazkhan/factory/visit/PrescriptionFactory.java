package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.Prescription;
import me.mohammedriazkhan.helper.IDGenerator;

public class PrescriptionFactory {


    public static Prescription buildPrescription(String medicationId, String visitId){

        return new Prescription(IDGenerator.generateId(), medicationId, visitId);
    }

}
