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
    }

}
