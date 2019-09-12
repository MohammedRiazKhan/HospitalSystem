package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.patient.Report;
import me.mohammedriazkhan.helper.IDGenerator;

public class ReportFactory {

    public static Report getReport(String title, String description, String dateRange, String patient) {
        return new Report.ReportBuilder()
                .reportId(IDGenerator.generateId())
                .title(title)
                .description(description)
                .dateRange(dateRange)
                .patient(patient)
                .build();
    }

}
