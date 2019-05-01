package me.mohammedriaz.services.patients;

import me.mohammedriaz.domain.patients.Account;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface AccountService extends Service<Account, Integer> {

    Set<Account> getAll();
}
