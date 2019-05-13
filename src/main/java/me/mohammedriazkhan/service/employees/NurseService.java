package me.mohammedriazkhan.service.employees;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface NurseService extends Service<Nurse, Integer> {

    Set<Nurse> getAll();

}
