package me.mohammedriazkhan.domain.appoinments;

import me.mohammedriazkhan.domain.patients.Patient;

public class Appointment {

    private int appointmentId;
    private String bookingDate;
    private Patient patient;

    public Appointment(){

    }

    public Appointment(AppointmentBuilder builder){

        this.appointmentId = builder.appointmentId;
        this.bookingDate = builder.bookingDate;
        this.patient = builder.patient;

    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public static class AppointmentBuilder{

        private int appointmentId;
        private String bookingDate;
        private Patient patient;

        public AppointmentBuilder(){

        }

        public AppointmentBuilder appointmentId(int appointmentId){
            this.appointmentId = appointmentId;
            return this;
        }

        public AppointmentBuilder bookingDate(String bookingDate){
            this.bookingDate = bookingDate;
            return this;
        }

        public AppointmentBuilder patient(Patient patient){
            this.patient = patient;
            return this;
        }

        public Appointment build(){
            return new Appointment(this);
        }

        @Override
        public String toString() {
            return "AppointmentBuilder{" +
                    "appointmentId=" + appointmentId +
                    ", bookingDate='" + bookingDate + '\'' +
                    ", patient=" + patient +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AppointmentBuilder that = (AppointmentBuilder) o;

            if (appointmentId != that.appointmentId) return false;
            if (bookingDate != null ? !bookingDate.equals(that.bookingDate) : that.bookingDate != null) return false;
            return patient != null ? patient.equals(that.patient) : that.patient == null;

        }

        @Override
        public int hashCode() {
            int result = appointmentId;
            result = 31 * result + (bookingDate != null ? bookingDate.hashCode() : 0);
            result = 31 * result + (patient != null ? patient.hashCode() : 0);
            return result;
        }
    }

}
