package me.mohammedriazkhan.repository.patient.hibernate;

import me.mohammedriazkhan.domain.patient.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface AccountRepositoryHibernate extends CrudRepository<Account, String> {


}
