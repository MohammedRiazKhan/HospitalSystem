package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.helper.IDGenerator;


public class CleanerFactory {

    public static Cleaner getCleaner() {
        return (Cleaner) new Cleaner.CleanerBuilder()
                .employeeId(IDGenerator.generateId())
                .jobTitle("Cleaner")
                .build();
    }



}
