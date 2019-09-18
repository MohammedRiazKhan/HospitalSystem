package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Cash;
import me.mohammedriazkhan.helper.IDGenerator;

public class CashFactory {

    public static Cash getCash(double cashAmount, String paymentDatre) {
        return (Cash) new Cash.CashBuilder()
                .cashAmount(cashAmount)
                .paymentDate(paymentDatre)
                .accountId(IDGenerator.generateId())
                .build();

    }

}
