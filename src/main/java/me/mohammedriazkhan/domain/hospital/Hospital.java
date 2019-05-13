package me.mohammedriazkhan.domain.hospital;

import java.util.List;

public class Hospital {

    private List<Department> departments;
    private int hospitalId;
    private String hospitalName;


    public Hospital(){

    }

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

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
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
        private int hospitalId;
        private String hospitalName;

        public HospitalBuilder(){

        }

        public HospitalBuilder hospitalId(int hospitalId){
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

            if (hospitalId != that.hospitalId) return false;
            if (departments != null ? !departments.equals(that.departments) : that.departments != null) return false;
            return hospitalName != null ? hospitalName.equals(that.hospitalName) : that.hospitalName == null;

        }

        @Override
        public int hashCode() {
            int result = departments != null ? departments.hashCode() : 0;
            result = 31 * result + hospitalId;
            result = 31 * result + (hospitalName != null ? hospitalName.hashCode() : 0);
            return result;
        }
    }

}
