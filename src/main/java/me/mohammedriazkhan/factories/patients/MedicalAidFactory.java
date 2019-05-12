package me.mohammedriazkhan.factories.patients;

import me.mohammedriazkhan.domain.patients.MedicalAid;
import me.mohammedriazkhan.utility.IDGenerator;

public class MedicalAidFactory {

    public static MedicalAid getMedicalAid(int accountNo, double balance, String paymentTerms, int medicalAidNo) {
        return (MedicalAid) new MedicalAid.MedicalAidBuilder()
                .accountNo(IDGenerator.genId())
                .build();
    }

}
