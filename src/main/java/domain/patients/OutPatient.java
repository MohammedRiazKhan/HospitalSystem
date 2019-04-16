package domain.patients;

import domain.appoinments.Appointment;

import java.util.List;

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
    }

}
