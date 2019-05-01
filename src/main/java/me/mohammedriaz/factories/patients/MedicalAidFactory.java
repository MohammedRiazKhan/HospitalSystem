package me.mohammedriaz.factories.patients;

import me.mohammedriaz.domain.patients.MedicalAid;
import me.mohammedriaz.utility.IDGenerator;

public class MedicalAidFactory {

    public static MedicalAid getMedicalAid(int accountNo, double balance, String paymentTerms, int medicalAidNo) {
        return (MedicalAid) new MedicalAid.MedicalAidBuilder()
                .accountNo(IDGenerator.genId())
                .build();
    }

}
