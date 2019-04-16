package factories.patients;

import domain.patients.Cash;
import utility.IDGenerator;

public class CashFactory {

    public static Cash getCash(int accountNo, double balance, String paymentTerms, double cashAmount) {
        return (Cash) new Cash.CashBuilder()
                .accountNo(IDGenerator.genId())
                .build();
    }

}
