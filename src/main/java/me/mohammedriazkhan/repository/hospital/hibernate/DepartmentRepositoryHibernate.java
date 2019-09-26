package me.mohammedriazkhan.repository.hospital.hibernate;


import me.mohammedriazkhan.domain.hospital.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface DepartmentRepositoryHibernate extends CrudRepository<Department, String> {



}
