package services.patients;

import domain.appoinments.Appointment;
import domain.patients.Account;
import services.Service;

import java.util.Set;

public interface AccountService extends Service<Account, Integer> {

    Set<Account> getAll();
}
