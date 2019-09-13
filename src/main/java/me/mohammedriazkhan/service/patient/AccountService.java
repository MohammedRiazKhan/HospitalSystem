package me.mohammedriazkhan.service.patient;

import me.mohammedriazkhan.domain.patient.Account;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface AccountService extends Service<Account, String> {

    Set<Account> getAll();
}
