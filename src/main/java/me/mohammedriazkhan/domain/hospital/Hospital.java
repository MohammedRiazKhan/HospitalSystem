package me.mohammedriazkhan.domain.hospital;

import java.util.List;
import java.util.Objects;

public class Hospital {

    private List<Department> departments;
    private String hospitalId;
    private String hospitalName;

    public Hospital(){}

    private Hospital(HospitalBuilder builder){

        this.hospitalId = builder.hospitalId;
        this.departments = builder.departments;
        this.hospitalName = builder.hospitalName;

    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public static class HospitalBuilder{

        private List<Department> departments;
        private String hospitalId;
        private String hospitalName;

        public HospitalBuilder(){}

        public HospitalBuilder hospitalId(String hospitalId){
            this.hospitalId = hospitalId;
            return this;
        }

        public HospitalBuilder departments(List<Department> departments){
            this.departments = departments;
            return this;
        }

        public HospitalBuilder hospitalName(String hospitalName){
            this.hospitalName = hospitalName;
            return this;
        }

        public Hospital build(){

            return new Hospital(this);

        }

        public HospitalBuilder copy(Hospital hospital){

            this.hospitalId(hospital.getHospitalId());
            this.hospitalName(hospital.getHospitalName());
            this.departments(hospital.getDepartments());
            return this;

        }

        @Override
        public String toString() {
            return "HospitalBuilder{" +
                    "departments=" + departments +
                    ", hospitalId=" + hospitalId +
                    ", hospitalName='" + hospitalName + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HospitalBuilder that = (HospitalBuilder) o;
            return Objects.equals(departments, that.departments) &&
                    Objects.equals(hospitalId, that.hospitalId) &&
                    Objects.equals(hospitalName, that.hospitalName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(departments, hospitalId, hospitalName);
        }
    }

}
