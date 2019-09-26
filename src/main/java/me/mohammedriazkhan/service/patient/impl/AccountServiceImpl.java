package me.mohammedriazkhan.service.patient.impl;

import me.mohammedriazkhan.domain.patient.Account;
import me.mohammedriazkhan.repository.patient.hibernate.AccountRepositoryHibernate;
import me.mohammedriazkhan.repository.patient.impl.AccountRepositoryImpl;
import me.mohammedriazkhan.repository.patient.AccountRepository;
import me.mohammedriazkhan.service.patient.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountServiceImpl service = null;
    @Autowired
    private AccountRepositoryHibernate repository;

    public AccountServiceImpl() {

    }

    public AccountServiceImpl getService(){

        if(service == null){
            return new AccountServiceImpl();
        }
        return service;
    }


    @Override
    public Set<Account> getAll() {
        List<Account> list = (List<Account>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Account create(Account account) {
        return repository.save(account);
    }

    @Override
    public Account read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Account update(Account account) {
        return repository.save(account);
    }

    @Override
    public void delete(String integer) {
        repository.deleteById(integer);
    }
}
