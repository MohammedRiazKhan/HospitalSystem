package me.mohammedriazkhan.repository.patient.impl;

import me.mohammedriazkhan.domain.patient.Account;
import me.mohammedriazkhan.repository.patient.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("AccountInMemory")
public class AccountRepositoryImpl implements AccountRepository {

    private static AccountRepositoryImpl repository = null;
    private Set<Account> accounts;

    public AccountRepositoryImpl()
    {
        accounts = new HashSet<>();
    }

    public static AccountRepositoryImpl getRepository() {
        if(repository == null){
            return new AccountRepositoryImpl();
        }
        return repository;
    }


    @Override
    public Set<Account> getAll() {
        return accounts;
    }

    @Override
    public Account create(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account read(String s) {
        return accounts.stream().filter(account -> account.getAccountNo().equals(s)).findAny().orElse(null);
    }

    @Override
    public Account update(Account account) {

        Account inDB = read(account.getAccountNo());
        if(inDB != null){
            accounts.remove(inDB);
            accounts.add(account);
            return account;
        }

        return null;
    }

    @Override
    public void delete(String s) {

        Account inDB = read(s);
        accounts.remove(inDB);

    }
}
