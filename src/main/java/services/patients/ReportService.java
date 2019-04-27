package services.patients;

import domain.appoinments.Appointment;
import domain.patients.Report;
import services.Service;

import java.util.Set;

public interface ReportService extends Service<Report, Integer> {

    Set<Report> getAll();

}
