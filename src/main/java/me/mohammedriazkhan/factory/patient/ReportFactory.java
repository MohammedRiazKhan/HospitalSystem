package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.patient.Report;

public class ReportFactory {

    public static Report getReport(int reportId, String title, String description, String dateRange, Patient patient) {
        return (Report) new Report.ReportBuilder()

                .build();
    }

}
