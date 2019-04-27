package repositories.patients;

import domain.patients.Report;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface ReportRepository extends Repository<Report, Integer> {


    Set<Report> getAll();


}
