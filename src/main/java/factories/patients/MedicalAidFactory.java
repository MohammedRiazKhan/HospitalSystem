package factories.patients;

import domain.patients.MedicalAid;
import utility.IDGenerator;

public class MedicalAidFactory {

    public static MedicalAid getMedicalAid(int accountNo, double balance, String paymentTerms, int medicalAidNo) {
        return (MedicalAid) new MedicalAid.MedicalAidBuilder()
                .accountNo(IDGenerator.genId())
                .build();
    }

}
