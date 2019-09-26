package me.mohammedriazkhan.domain.patient;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;

@Entity
public class OutPatient extends Patient{

    private String appointmentId;

    public OutPatient(){}

    private OutPatient(OutPatientBuilder builder){
        super(builder);
        this.appointmentId = builder.appointmentId;

    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public static class OutPatientBuilder extends Patient.Builder{

        private String appointmentId;

        public OutPatientBuilder(){
            super();
        }

        public OutPatientBuilder appointmentId(String appointmentId){
            this.appointmentId = appointmentId;
            return this;
        }

        @Override
        public Patient build() {
            return new OutPatient(this);
        }

        public OutPatientBuilder copy(OutPatient outPatient){

            this.firstName(outPatient.getFirstName());
            this.patientId(outPatient.getPatientId());
            this.lastName(outPatient.getLastName());
            this.telephone(outPatient.getTelephone());
            this.address(outPatient.getAddress());
            this.identityNumber(outPatient.getIdentityNumber());
            this.age(outPatient.getAge());
            this.accountId(outPatient.getAccountId());
            this.appointmentId(outPatient.getAppointmentId());
            return this;
        }

        @Override
        public String toString() {
            return "OutPatientBuilder{" +
                    "appointmentId='" + appointmentId + '\'' +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            OutPatientBuilder that = (OutPatientBuilder) o;
            return Objects.equals(appointmentId, that.appointmentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), appointmentId);
        }
    }

}
