package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.helper.IDGenerator;


public class PorterFactory {

    public static Porter getPorter(String firstName, String lastName, String identityNumber) {
        return (Porter) new Porter.PorterBuilder()
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .build();
    }



}
