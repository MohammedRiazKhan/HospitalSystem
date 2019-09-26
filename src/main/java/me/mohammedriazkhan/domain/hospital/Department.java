package me.mohammedriazkhan.domain.hospital;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Department {

    @Id
    private String departmentId;
    private List<Ward> wards;
    private List<Room> rooms;

    public Department(){}


    public Department(DepartmentBuilder builder){
        this.departmentId = builder.departmentId;
        this.wards = builder.wards;
        this.rooms = builder.rooms;

    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
        private List<Ward> wards;
        private List<Room> rooms;

        public DepartmentBuilder(){

        }

        public DepartmentBuilder departmentId(String departmentId){
            this.departmentId = departmentId;
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

        public DepartmentBuilder copy(Department department){
            this.departmentId(department.getDepartmentId());
            this.wards(department.getWards());
            this.rooms(department.getRooms());
            return this;
        }

        public Department build(){

            return new Department(this);

        }

        @Override
        public String toString() {
            return "DepartmentBuilder{" +
                    "departmentId='" + departmentId + '\'' +
                    ", wards=" + wards +
                    ", rooms=" + rooms +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DepartmentBuilder that = (DepartmentBuilder) o;
            return Objects.equals(departmentId, that.departmentId) &&
                    Objects.equals(wards, that.wards) &&
                    Objects.equals(rooms, that.rooms);
        }

        @Override
        public int hashCode() {
            return Objects.hash(departmentId, wards, rooms);
        }
    }

}
