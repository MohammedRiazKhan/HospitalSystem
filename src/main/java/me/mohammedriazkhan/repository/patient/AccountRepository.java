package me.mohammedriazkhan.repository.patient;

import me.mohammedriazkhan.domain.patient.Account;
import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface AccountRepository extends Repository<Account, String> {


    Set<Account> getAll();

}
