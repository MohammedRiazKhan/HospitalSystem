package me.mohammedriaz.factories.employee;

import me.mohammedriaz.domain.employee.Administration;
import me.mohammedriaz.utility.IDGenerator;

public class AdministrationFactory {

    public static Administration getAdministration() {
        return (Administration) new Administration.AdminBuilder()
                .accessLevel("1")
                .employeeId(IDGenerator.genId())
                .build();
    }




}
