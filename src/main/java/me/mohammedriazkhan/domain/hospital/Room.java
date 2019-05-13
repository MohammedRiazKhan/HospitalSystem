package me.mohammedriazkhan.domain.hospital;

import java.util.List;

public class Room {

    private int roomId;
    private List<Equipment> equipment;

    public Room(){

    }

    private Room(RoomBuilder builder){
        this.roomId = builder.roomId;
        this.equipment = builder.equipment;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public static class RoomBuilder{

        private int roomId;
        private List<Equipment> equipment;

        public RoomBuilder roomId(int roomId){
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

            if (roomId != that.roomId) return false;
            return equipment != null ? equipment.equals(that.equipment) : that.equipment == null;

        }

        @Override
        public int hashCode() {
            int result = roomId;
            result = 31 * result + (equipment != null ? equipment.hashCode() : 0);
            return result;
        }
    }


}
