package domain.hospital;

public class Ward {

    private int wardId;
    private String wardCode;

    public Ward(){

    }

    public Ward(WardBuilder builder){

        this.wardId = builder.wardId;
        this.wardCode = builder.wardCode;

    }

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public static class WardBuilder{

        private int wardId;
        private String wardCode;

        public WardBuilder wardId(int wardId){
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
    }

}
