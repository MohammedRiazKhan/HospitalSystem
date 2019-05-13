package me.mohammedriazkhan.domain.hospital;

public class Equipment {

    private int equipmentId;
    private String name;
    private String desc;
    private int quantity;


    public Equipment(){

    }

    public Equipment(EquipmentBuilder builder){

        this.equipmentId = builder.equipmentId;
        this.name = builder.name;
        this.desc = builder.desc;
        this.quantity = builder.quantity;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EquipmentBuilder that = (EquipmentBuilder) o;

            if (equipmentId != that.equipmentId) return false;
            if (quantity != that.quantity) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            return desc != null ? desc.equals(that.desc) : that.desc == null;

        }

        @Override
        public int hashCode() {
            int result = equipmentId;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (desc != null ? desc.hashCode() : 0);
            result = 31 * result + quantity;
            return result;
        }
    }


}
