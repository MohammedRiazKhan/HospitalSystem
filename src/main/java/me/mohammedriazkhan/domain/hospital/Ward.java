package me.mohammedriazkhan.domain.hospital;

import java.util.Objects;

public class Ward {

    private String wardId;
    private String wardSize;

    public Ward(){}

    public Ward(WardBuilder builder){

        this.wardId = builder.wardId;
        this.wardSize = builder.wardSize;

    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public String getWardSize() {
        return wardSize;
    }

    public void setWardSize(String wardSize) {
        this.wardSize = wardSize;
    }

    public static class WardBuilder{

        private String wardId;
        private String wardSize;

        public WardBuilder wardId(String wardId){
            this.wardId = wardId;
            return this;
        }

        public WardBuilder wardSize(String wardSize){
            this.wardSize = wardSize;
            return this;
        }

        public WardBuilder copy(Ward ward){
            this.wardId(ward.getWardId());
            this.wardSize(ward.getWardSize());
            return this;
        }

        public Ward build(){
            return new Ward(this);
        }


        @Override
        public String toString() {
            return "WardBuilder{" +
                    "wardId=" + wardId +
                    ", wardSize='" + wardSize + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WardBuilder that = (WardBuilder) o;
            return Objects.equals(wardId, that.wardId) &&
                    Objects.equals(wardSize, that.wardSize);
        }

        @Override
        public int hashCode() {
            return Objects.hash(wardId, wardSize);
        }
    }

}
