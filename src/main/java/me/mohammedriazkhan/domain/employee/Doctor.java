package me.mohammedriazkhan.domain.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.domain.patient.Patient;

import java.util.List;

public class Doctor extends Employee{

    private String specialisation;
    private List<Appointment> appointments;

    public Doctor(){

    }

    protected Doctor(DoctorBuilder builder) {
        super(builder);
        this.appointments = builder.appointments;
        this.specialisation = builder.specialisation;

    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public static class DoctorBuilder extends Employee.Builder{

        private String specialisation;
        private List<Appointment> appointments;

        public DoctorBuilder(){
            super();
        }


        public DoctorBuilder specialisation(String specialisation){
            this.specialisation = specialisation;
            return this;
        }

        public DoctorBuilder appointments(List<Appointment> appointments){
            this.appointments = appointments;
            return this;
        }

        @Override
        public Employee build(){

            return new Doctor(this);

        }

        @Override
        public String toString() {
            return "DoctorBuilder{" +
                    "specialisation='" + specialisation + '\'' +
                    ", appointments=" + appointments +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DoctorBuilder that = (DoctorBuilder) o;

            if (specialisation != null ? !specialisation.equals(that.specialisation) : that.specialisation != null)
                return false;
            return appointments != null ? appointments.equals(that.appointments) : that.appointments == null;

        }

        @Override
        public int hashCode() {
            int result = specialisation != null ? specialisation.hashCode() : 0;
            result = 31 * result + (appointments != null ? appointments.hashCode() : 0);
            return result;
        }
    }
}
