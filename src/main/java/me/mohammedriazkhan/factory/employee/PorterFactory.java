package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Porter;


public class PorterFactory {

    public static Porter getPorter(int employeeId, String firstName, String lastName, String identityNumber) {
        return (Porter) new Porter.PorterBuilder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .build();
    }



}
