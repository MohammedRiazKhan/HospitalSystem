package me.mohammedriaz.factories.patients;

import me.mohammedriaz.domain.patients.Cash;
import me.mohammedriaz.utility.IDGenerator;

public class CashFactory {

    public static Cash getCash(int accountNo, double balance, String paymentTerms, double cashAmount) {
        return (Cash) new Cash.CashBuilder()
                .accountNo(IDGenerator.genId())
                .build();
    }

}
