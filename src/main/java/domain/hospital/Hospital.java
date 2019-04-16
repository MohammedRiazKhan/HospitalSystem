package domain.hospital;

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
    }

}
