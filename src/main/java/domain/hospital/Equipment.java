package domain.hospital;

public class Equipment {

    private int equipmentId;
    private String name;
    private String desc;
    private int quantity;

    public Equipment(){

    }

    public Equipment(EquipmentBuilder builder){

    }



    public static class EquipmentBuilder{

        private int equipmentId;
        private String name;
        private String desc;
        private int quantity;

        public EquipmentBuilder equipmentId(int equipmentId){
            this.equipmentId = equipmentId;
            return this;
        }

        public EquipmentBuilder name(String name){
            this.name = name;
            return this;
        }

        public EquipmentBuilder desc(String desc){
            this.desc = desc;
            return this;
        }

        public EquipmentBuilder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Equipment build(){
            return new Equipment(this);
        }

        @Override
        public String toString() {
            return "EquipmentBuilder{" +
                    "equipmentId=" + equipmentId +
                    ", name='" + name + '\'' +
                    ", desc='" + desc + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }


}
