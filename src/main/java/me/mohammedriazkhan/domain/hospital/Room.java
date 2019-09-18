package me.mohammedriazkhan.domain.hospital;

import java.util.List;
import java.util.Objects;

public class Room {

    private String roomId;
    private List<Equipment> equipment;

    public Room(){}

    private Room(RoomBuilder builder){
        this.roomId = builder.roomId;
        this.equipment = builder.equipment;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public static class RoomBuilder{

        private String roomId;
        private List<Equipment> equipment;

        public RoomBuilder roomId(String roomId){
            this.roomId = roomId;
            return this;
        }

        public RoomBuilder equipment(List<Equipment> equipment){
            this.equipment = equipment;
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
                    Objects.equals(equipment, that.equipment);
        }

        @Override
        public int hashCode() {
            return Objects.hash(roomId, equipment);
        }
    }


}
