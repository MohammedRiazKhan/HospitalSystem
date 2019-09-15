package me.mohammedriazkhan.domain.hospital;

import java.util.List;
import java.util.Objects;

public class Department {

    private String departmentId;
    private String hospitalId;
    private List<Ward> wards;
    private List<Room> rooms;

    public Department(){

    }


    public Department(DepartmentBuilder builder){
        this.departmentId = builder.departmentId;
        this.hospitalId = builder.hospitalId;
        this.wards = builder.wards;
        this.rooms = builder.rooms;

    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
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

        private String departmentId;
        private String hospitalId;
        private List<Ward> wards;
        private List<Room> rooms;

        public DepartmentBuilder(){

        }

        public DepartmentBuilder departmentId(String departmentId){
            this.departmentId = departmentId;
            return this;
        }

        public DepartmentBuilder hospitalId(String hospitalId){
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DepartmentBuilder that = (DepartmentBuilder) o;

            if (departmentId != that.departmentId) return false;
            if (hospitalId != that.hospitalId) return false;
            if (wards != null ? !wards.equals(that.wards) : that.wards != null) return false;
            return rooms != null ? rooms.equals(that.rooms) : that.rooms == null;

        }

        @Override
        public int hashCode() {
            return Objects.hash(departmentId, hospitalId, wards, rooms);
        }
    }

}
