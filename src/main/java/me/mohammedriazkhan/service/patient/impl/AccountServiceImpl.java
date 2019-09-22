package me.mohammedriazkhan.service.patient.impl;

import me.mohammedriazkhan.domain.patient.Account;
import me.mohammedriazkhan.repository.patient.impl.AccountRepositoryImpl;
import me.mohammedriazkhan.repository.patient.AccountRepository;
import me.mohammedriazkhan.service.patient.AccountService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountServiceImpl service = null;
    private AccountRepository repository;

    public AccountServiceImpl() {
        repository = AccountRepositoryImpl.getRepository();
    }

    public AccountServiceImpl getService(){

        if(service == null){
            return new AccountServiceImpl();
        }
        return service;
    }


    @Override
    public Set<Account> getAll() {
        return repository.getAll();
    }

    @Override
    public Account create(Account account) {
        return repository.create(account);
    }

    @Override
    public Account read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Account update(Account account) {
        return repository.update(account);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }
}
