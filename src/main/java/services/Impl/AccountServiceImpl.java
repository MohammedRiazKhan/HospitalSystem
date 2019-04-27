package services.Impl;

import domain.patients.Account;
import repositories.Impl.AccountRepositoryImpl;
import repositories.patients.AccountRepository;
import services.patients.AccountService;

import java.util.Set;

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
