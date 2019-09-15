package me.mohammedriazkhan.domain.appoinment;

import java.util.Objects;

public class Appointment {

    private String appointmentId;
    private String bookingDate;
    private String patientId;

    public Appointment(){}

    public Appointment(AppointmentBuilder builder){

        this.appointmentId = builder.appointmentId;
        this.bookingDate = builder.bookingDate;
        this.patientId = builder.patientId;

    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public static class AppointmentBuilder{

        private String appointmentId;
        private String bookingDate;
        private String patientId;

        public AppointmentBuilder(){

        }

        public AppointmentBuilder appointmentId(String appointmentId){
            this.appointmentId = appointmentId;
            return this;
        }

        public AppointmentBuilder bookingDate(String bookingDate){
            this.bookingDate = bookingDate;
            return this;
        }

        public AppointmentBuilder patientId(String patientId){
            this.patientId = patientId;
            return this;
        }

        public AppointmentBuilder copy(Appointment appointment){
            this.appointmentId = appointment.appointmentId;
            this.bookingDate = appointment.bookingDate;
            this.patientId = appointment.patientId;
            return this;
        }


        public Appointment build(){
            return new Appointment(this);
        }

        @Override
        public String toString() {
            return "AppointmentBuilder{" +
                    "appointmentId='" + appointmentId + '\'' +
                    ", bookingDate='" + bookingDate + '\'' +
                    ", patientId='" + patientId + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AppointmentBuilder that = (AppointmentBuilder) o;
            return Objects.equals(appointmentId, that.appointmentId) &&
                    Objects.equals(bookingDate, that.bookingDate) &&
                    Objects.equals(patientId, that.patientId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(appointmentId, bookingDate, patientId);
        }
    }

}
