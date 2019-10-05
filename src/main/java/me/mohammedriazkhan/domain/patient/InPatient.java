package me.mohammedriazkhan.domain.patient;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class InPatient extends Patient{

    private String roomId;
    private int days;
    private String mealId;

    public InPatient(){}

    private InPatient(InPatientBuilder builder){
        super(builder);
        this.roomId = builder.roomId;
        this.days = builder.days;
        this.mealId = builder.mealId;

    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public static class InPatientBuilder extends Patient.Builder{

        private String roomId;
        private int days;
        private String mealId;

        public InPatientBuilder(){
            super();
        }

        public InPatientBuilder roomId(String roomId){
            this.roomId = roomId;
            return this;
        }


        public InPatientBuilder days(int days){
            this.days = days;
            return this;
        }

        public InPatientBuilder mealId(String mealId){
            this.mealId = mealId;
            return this;
        }

        @Override
        public Patient build() {
            return new InPatient(this);
        }

        public InPatientBuilder copy(InPatient inPatient){

            this.patientId(inPatient.getPatientId());
            this.firstName(inPatient.getFirstName());
            this.lastName(inPatient.getLastName());
            this.telephone(inPatient.getTelephone());
            this.address(inPatient.getAddress());
            this.identityNumber(inPatient.getIdentityNumber());
            this.age(inPatient.getAge());
            this.accountId(inPatient.getAccountId());
            return this;
        }

        @Override
        public String toString() {
            return "InPatientBuilder{" +
                    "roomId='" + roomId + '\'' +
                    ", days=" + days +
                    ", mealId='" + mealId + '\'' +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            InPatientBuilder that = (InPatientBuilder) o;
            return days == that.days &&
                    Objects.equals(roomId, that.roomId) &&
                    Objects.equals(mealId, that.mealId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), roomId, days, mealId);
        }
    }




}
