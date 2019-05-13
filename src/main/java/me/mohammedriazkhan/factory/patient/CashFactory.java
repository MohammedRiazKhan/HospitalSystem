package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Cash;
import me.mohammedriazkhan.utility.IDGenerator;

public class CashFactory {

    public static Cash getCash(int accountNo, double balance, String paymentTerms, double cashAmount) {
        return (Cash) new Cash.CashBuilder()
                .accountNo(IDGenerator.genId())
                .build();
    }

}
