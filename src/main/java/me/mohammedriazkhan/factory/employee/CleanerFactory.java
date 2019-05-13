package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.utility.IDGenerator;

public class CleanerFactory {

    public static Cleaner getCleaner() {
        return (Cleaner) new Cleaner.CleanerBuilder()
                .employeeId(IDGenerator.genId())
                .jobTitle("Cleaner")
                .build();
    }



}
