package me.mohammedriazkhan.factories.employee;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.utility.IDGenerator;

public class AdministrationFactory {

    public static Administration getAdministration() {
        return (Administration) new Administration.AdminBuilder()
                .accessLevel("1")
                .employeeId(IDGenerator.genId())
                .build();
    }




}
