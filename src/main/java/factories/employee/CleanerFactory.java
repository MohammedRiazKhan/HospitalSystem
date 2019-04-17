package factories.employee;

import domain.employee.Cleaner;
import utility.IDGenerator;

public class CleanerFactory {

    public static Cleaner getCleaner() {
        return (Cleaner) new Cleaner.CleanerBuilder()
                .employeeId(IDGenerator.genId())
                .build();
    }



}
