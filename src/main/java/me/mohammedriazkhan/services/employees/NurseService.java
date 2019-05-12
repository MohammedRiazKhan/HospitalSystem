package me.mohammedriazkhan.services.employees;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface NurseService extends Service<Nurse, Integer> {

    Set<Nurse> getAll();

}
