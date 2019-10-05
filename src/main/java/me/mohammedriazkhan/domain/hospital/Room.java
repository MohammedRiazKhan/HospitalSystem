package me.mohammedriazkhan.domain.hospital;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Room {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String roomId;
    private String equipmentId;

    public Room(){}

    private Room(RoomBuilder builder){
        this.roomId = builder.roomId;
        this.equipmentId = builder.equipmentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getEquipment() {
        return equipmentId;
    }

    public void setEquipment(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public static class RoomBuilder{

        private String roomId;
        private String equipmentId;

        public RoomBuilder roomId(String roomId){
            this.roomId = roomId;
            return this;
        }

        public RoomBuilder equipment(String equipmentId){
            this.equipmentId = equipmentId;
            return this;
        }


        public Room build(){
            return new Room(this);
        }

        public RoomBuilder copy(Room room){

            this.roomId(room.getRoomId());
            this.equipment(room.getEquipment());
            return this;
        }

        @Override
        public String toString() {
            return "RoomBuilder{" +
                    "roomId=" + roomId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RoomBuilder that = (RoomBuilder) o;
            return Objects.equals(roomId, that.roomId) &&
                    Objects.equals(equipmentId, that.equipmentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(roomId, equipmentId);
        }
    }


}
