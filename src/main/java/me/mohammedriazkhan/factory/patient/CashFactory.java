package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Cash;


public class CashFactory {

    public static Cash getCash(int accountNo, double balance, String paymentTerms, double cashAmount) {
        return (Cash) new Cash.CashBuilder()
                .accountNo(accountNo)
                .build();
    }

}
