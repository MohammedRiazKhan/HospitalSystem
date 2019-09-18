package me.mohammedriazkhan.domain.patient;

import java.util.Objects;

public class Report {

    private String reportId;
    private String title;
    private String description;
    private String dateRange;
    private String patientId;

    public Report(){}

    private Report(ReportBuilder builder){
        this.reportId = builder.reportId;
        this.title = builder.title;
        this.description = builder.description;
        this.dateRange = builder.dateRange;
        this.patientId = builder.patientId;

    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public static class ReportBuilder{
        private String reportId;
        private String title;
        private String description;
        private String dateRange;
        private String patientId;

        public ReportBuilder reportId(String reportId){
            this.reportId = reportId;
            return this;
        }

        public ReportBuilder title(String title){
            this.title = title;
            return this;
        }

        public ReportBuilder description(String description){
            this.description = description;
            return this;
        }

        public ReportBuilder dateRange(String dateRange){
            this.dateRange = dateRange;
            return this;
        }

        public ReportBuilder patient(String patientId){
            this.patientId = patientId;
            return this;
        }

        public Report build(){

            return new Report(this);

        }

        public ReportBuilder copy(Report report){

            this.reportId(report.getReportId());
            this.patient(report.getPatientId());
            this.title(report.getTitle());
            this.description(report.getDescription());
            this.dateRange(report.getDateRange());
            return this;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReportBuilder that = (ReportBuilder) o;
            return Objects.equals(reportId, that.reportId) &&
                    Objects.equals(title, that.title) &&
                    Objects.equals(description, that.description) &&
                    Objects.equals(dateRange, that.dateRange) &&
                    Objects.equals(patientId, that.patientId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(reportId, title, description, dateRange, patientId);
        }

        @Override
        public String toString() {
            return "ReportBuilder{" +
                    "reportId='" + reportId + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", dateRange='" + dateRange + '\'' +
                    ", patientId='" + patientId + '\'' +
                    '}';
        }
    }

}
