package domain.hospital;

import java.util.List;

public class Department {

    private int departmentId;
    private int hospitalId;
    private List<Ward> wards;
    private List<Room> rooms;

    public Department(){

    }


    public Department(DepartmentBuilder builder){

    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public void setWards(List<Ward> wards) {
        this.wards = wards;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static class DepartmentBuilder{

        private int departmentId;
        private int hospitalId;
        private List<Ward> wards;
        private List<Room> rooms;

        public DepartmentBuilder(){

        }

        public DepartmentBuilder departmentId(int departmentId){
            this.departmentId = departmentId;
            return this;
        }

        public DepartmentBuilder hospitalId(int hospitalId){
            this.hospitalId = hospitalId;
            return this;
        }

        public DepartmentBuilder wards(List<Ward> wards){
            this.wards = wards;
            return this;
        }

        public DepartmentBuilder rooms(List<Room> rooms){
            this.rooms = rooms;
            return this;
        }

        public Department build(){

            return new Department(this);

        }

        @Override
        public String toString() {
            return "DepartmentBuilder{" +
                    "departmentId=" + departmentId +
                    ", hospitalId=" + hospitalId +
                    ", wards=" + wards +
                    ", rooms=" + rooms +
                    '}';
        }
    }

}
