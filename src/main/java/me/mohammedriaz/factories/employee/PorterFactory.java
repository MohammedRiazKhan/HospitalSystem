package me.mohammedriaz.factories.employee;

import me.mohammedriaz.domain.employee.Porter;
import me.mohammedriaz.utility.IDGenerator;

public class PorterFactory {

    public static Porter getPorter(int employeeId, String firstName, String lastName, String identityNumber) {
        return (Porter) new Porter.PorterBuilder()
                .employeeId(IDGenerator.genId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .build();
    }



}
