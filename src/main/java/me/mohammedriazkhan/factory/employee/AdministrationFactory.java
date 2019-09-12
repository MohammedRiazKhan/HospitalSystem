package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.helper.IDGenerator;


public class AdministrationFactory {

    public static Administration getAdministration(String access) {
        return (Administration) new Administration.AdminBuilder()
                .accessLevel(access)
                .employeeId(IDGenerator.generateId())
                .build();
    }




}
