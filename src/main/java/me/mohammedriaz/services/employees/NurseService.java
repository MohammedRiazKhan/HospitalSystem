package me.mohammedriaz.services.employees;

import me.mohammedriaz.domain.employee.Nurse;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface NurseService extends Service<Nurse, Integer> {

    Set<Nurse> getAll();

}
