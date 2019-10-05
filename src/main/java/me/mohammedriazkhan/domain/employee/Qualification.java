package me.mohammedriazkhan.domain.employee;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Qualification {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String qualificationId;
    private String qualificationName;
    private String instituteName;
    private int duration;

    public Qualification(){}

    public Qualification(QualificationBuilder builder){

        this.qualificationId = builder.qualificationId;
        this.qualificationName = builder.qualificationName;
        this.instituteName = builder.instituteName;
        this.duration = builder.duration;

    }

    public String getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static class QualificationBuilder {

        private String qualificationId;
        private String qualificationName;
        private String instituteName;
        private int duration;

        public QualificationBuilder(){

        }

        public QualificationBuilder qualificationId(String qualificationId){
            this.qualificationId = qualificationId;
            return this;
        }
        public QualificationBuilder qualificationName(String qualificationName){
            this.qualificationName = qualificationName;
            return this;
        }

        public QualificationBuilder instituteName(String instituteName){
            this.instituteName = instituteName;
            return this;
        }

        public QualificationBuilder duration(int duration){
            this.duration = duration;
            return this;
        }

        public QualificationBuilder copy(Qualification qualification){
            this.qualificationId(qualification.getQualificationId());
            this.qualificationName(qualification.getQualificationName());
            this.instituteName(qualification.getInstituteName());
            this.duration(qualification.duration);
            return this;

        }


        public Qualification build(){
            return new Qualification(this);
        }


        @Override
        public String toString() {
            return "QualificationBuilder{" +
                    "qualificationId=" + qualificationId +
                    ", qualificationName='" + qualificationName + '\'' +
                    ", instituteName='" + instituteName + '\'' +
                    ", duration='" + duration + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            QualificationBuilder that = (QualificationBuilder) o;
            return Objects.equals(qualificationId, that.qualificationId) &&
                    Objects.equals(qualificationName, that.qualificationName) &&
                    Objects.equals(instituteName, that.instituteName) &&
                    Objects.equals(duration, that.duration);
        }

        @Override
        public int hashCode() {
            return Objects.hash(qualificationId, qualificationName, instituteName, duration);
        }
    }

}
