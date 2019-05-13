package me.mohammedriazkhan.domain.employee;

import java.util.Arrays;

public class Cleaner extends Employee{

    private int[] rooms;

    public Cleaner(){

    }

    public Cleaner(CleanerBuilder builder){
        super(builder);
        this.rooms = builder.rooms;
    }

    public int[] getRooms() {
        return rooms;
    }

    public void setRooms(int[] rooms) {
        this.rooms = rooms;
    }

    public static class CleanerBuilder extends Employee.Builder{

        private int[] rooms;

        public CleanerBuilder(){
            super();
        }

        public CleanerBuilder rooms(int[] rooms){
            this.rooms = rooms;
            return this;
        }

        @Override
        public String toString() {
            return "CleanerBuilder{" +
                    "rooms=" + Arrays.toString(rooms) +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CleanerBuilder that = (CleanerBuilder) o;

            return Arrays.equals(rooms, that.rooms);

        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(rooms);
        }

        @Override
        public Employee build() {
            return new Cleaner(this);
        }
    }

}
