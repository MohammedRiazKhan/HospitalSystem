package me.mohammedriazkhan.factory.patients;

import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.domain.patients.Report;

public class ReportFactory {

    public static Report getReport(int reportId, String title, String description, String dateRange, Patient patient) {
        return (Report) new Report.ReportBuilder()

                .build();
    }

}
