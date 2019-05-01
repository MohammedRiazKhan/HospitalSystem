package me.mohammedriaz.factories.patients;

import me.mohammedriaz.domain.patients.Patient;
import me.mohammedriaz.domain.patients.Report;

public class ReportFactory {

    public static Report getReport(int reportId, String title, String description, String dateRange, Patient patient) {
        return (Report) new Report.ReportBuilder()

                .build();
    }

}
