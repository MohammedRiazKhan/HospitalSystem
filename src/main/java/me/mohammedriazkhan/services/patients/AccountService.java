package me.mohammedriazkhan.services.patients;

import me.mohammedriazkhan.domain.patients.Account;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface AccountService extends Service<Account, Integer> {

    Set<Account> getAll();
}
