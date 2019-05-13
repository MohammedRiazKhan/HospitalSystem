package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.MedicalAid;
import me.mohammedriazkhan.utility.IDGenerator;

public class MedicalAidFactory {

    public static MedicalAid getMedicalAid(int accountNo, double balance, String paymentTerms, int medicalAidNo) {
        return (MedicalAid) new MedicalAid.MedicalAidBuilder()
                .accountNo(IDGenerator.genId())
                .build();
    }

}
