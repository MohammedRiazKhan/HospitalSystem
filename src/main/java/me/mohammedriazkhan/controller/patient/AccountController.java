package me.mohammedriazkhan.controller.patient;

import me.mohammedriazkhan.domain.patient.Account;
import me.mohammedriazkhan.service.Impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/new")
    public Account create(@RequestBody Account account){

        return accountService.create(account);
    }

    @GetMapping(path = "/find/{id}")
    public Account findById(@PathVariable int id){

        Account account = accountService.read(id);
        return account;
    }

    @PutMapping("/update")
    public void update(@RequestBody Account account){

        accountService.update(account);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id){
        accountService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Account> getAll(){
        return accountService.getAll();
    }


}
