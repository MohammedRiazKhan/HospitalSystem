package domain.patients;

public class Report {

    private int reportId;
    private String title;
    private String description;
    private String dateRange;
    private Patient patient;

    public Report(){

    }

    private Report(ReportBuilder builder){
        this.reportId = builder.reportId;
        this.title = builder.title;
        this.description = builder.description;
        this.dateRange = builder.dateRange;
        this.patient = builder.patient;

    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public static class ReportBuilder{
        private int reportId;
        private String title;
        private String description;
        private String dateRange;
        private Patient patient;

        public ReportBuilder reportId(int reportId){
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

        public ReportBuilder patient(Patient patient){
            this.patient = patient;
            return this;
        }

        public Report build(){

            return new Report(this);

        }

        @Override
        public String toString() {
            return "ReportBuilder{" +
                    "reportId=" + reportId +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", dateRange='" + dateRange + '\'' +
                    ", patient=" + patient +
                    '}';
        }
    }

}
