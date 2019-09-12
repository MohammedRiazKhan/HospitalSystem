package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.MedicalAid;
import me.mohammedriazkhan.helper.IDGenerator;


public class MedicalAidFactory {

    public static MedicalAid getMedicalAid(double balance, String paymentTerms, int medicalAidNo) {
        return (MedicalAid) new MedicalAid.MedicalAidBuilder()
                .accountNo(IDGenerator.generateId())
                .paymentTerms(paymentTerms)
                .build();
    }

}
