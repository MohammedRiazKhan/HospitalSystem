package me.mohammedriazkhan.domain.hospital;

import java.util.Objects;

public class Ward {

    private String wardId;
    private String wardCode;

    public Ward(){

    }

    public Ward(WardBuilder builder){

        this.wardId = builder.wardId;
        this.wardCode = builder.wardCode;

    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public static class WardBuilder{

        private String wardId;
        private String wardCode;

        public WardBuilder wardId(String wardId){
            this.wardId = wardId;
            return this;
        }

        public WardBuilder wardCode(String wardCode){
            this.wardCode = wardCode;
            return this;
        }

        public Ward build(){
            return new Ward(this);
        }


        @Override
        public String toString() {
            return "WardBuilder{" +
                    "wardId=" + wardId +
                    ", wardCode='" + wardCode + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WardBuilder that = (WardBuilder) o;

            if (wardId != that.wardId) return false;
            return wardCode != null ? wardCode.equals(that.wardCode) : that.wardCode == null;

        }

        @Override
        public int hashCode() {
            return Objects.hash(wardId, wardCode);
        }
    }

}
