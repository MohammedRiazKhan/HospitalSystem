package me.mohammedriazkhan.services.Impl;

import me.mohammedriazkhan.domain.patients.Account;
import me.mohammedriazkhan.repositories.Impl.AccountRepositoryImpl;
import me.mohammedriazkhan.repositories.patients.AccountRepository;
import me.mohammedriazkhan.services.patients.AccountService;
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
        return null;
    }

    @Override
    public Account create(Account account) {
        return null;
    }

    @Override
    public Account read(Integer integer) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
