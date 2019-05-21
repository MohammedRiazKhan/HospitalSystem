package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;


public class CleanerFactory {

    public static Cleaner getCleaner(int id) {
        return (Cleaner) new Cleaner.CleanerBuilder()
                .employeeId(id)
                .jobTitle("Cleaner")
                .build();
    }



}
