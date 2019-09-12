package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Cash;
import me.mohammedriazkhan.helper.IDGenerator;


public class CashFactory {

    public static Cash getCash(double balance, String paymentTerms, double cashAmount) {
        return (Cash) new Cash.CashBuilder()
                .accountNo(IDGenerator.generateId())
                .balance(balance)
                .paymentTerms(paymentTerms)
                .build();
    }

}
