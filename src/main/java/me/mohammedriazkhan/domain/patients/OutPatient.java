package me.mohammedriazkhan.domain.patients;

import me.mohammedriazkhan.domain.appoinments.Appointment;

public class OutPatient extends Patient{

    private Appointment appointment;

    public OutPatient(){

    }

    private OutPatient(OutPatientBuilder builder){
        super(builder);
        this.appointment = builder.appointment;

    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public static class OutPatientBuilder extends Patient.Builder{

        private Appointment appointment;

        public OutPatientBuilder(){
            super();
        }

        public OutPatientBuilder appointment(Appointment appointment){
            this.appointment = appointment;
            return this;
        }



        @Override
        public Patient build() {
            return new OutPatient(this);
        }

        @Override
        public String toString() {
            return "OutPatientBuilder{" +
                    "appointment=" + appointment +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            OutPatientBuilder that = (OutPatientBuilder) o;

            return appointment != null ? appointment.equals(that.appointment) : that.appointment == null;

        }

        @Override
        public int hashCode() {
            return appointment != null ? appointment.hashCode() : 0;
        }
    }

}
