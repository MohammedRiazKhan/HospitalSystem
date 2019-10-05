package me.mohammedriazkhan.domain.hospital;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String departmentId;
    private String wards;
    private String rooms;

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

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public static class DepartmentBuilder{

        private String departmentId;
        private String wards;
        private String rooms;

        public DepartmentBuilder(){

        }

        public DepartmentBuilder departmentId(String departmentId){
            this.departmentId = departmentId;
            return this;
        }

        public DepartmentBuilder wards(String wards){
            this.wards = wards;
            return this;
        }

        public DepartmentBuilder rooms(String rooms){
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
