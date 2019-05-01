package me.mohammedriaz.factories.employee;

import me.mohammedriaz.domain.employee.Cleaner;
import me.mohammedriaz.utility.IDGenerator;

public class CleanerFactory {

    public static Cleaner getCleaner() {
        return (Cleaner) new Cleaner.CleanerBuilder()
                .employeeId(IDGenerator.genId())
                .jobTitle("Cleaner")
                .build();
    }



}
