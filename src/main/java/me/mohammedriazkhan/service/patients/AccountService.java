package me.mohammedriazkhan.service.patients;

import me.mohammedriazkhan.domain.patients.Account;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface AccountService extends Service<Account, Integer> {

    Set<Account> getAll();
}
