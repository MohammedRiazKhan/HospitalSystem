package me.mohammedriazkhan.domain.hospital;

import java.util.Objects;

public class Equipment {

    private String equipmentId;
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

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static class EquipmentBuilder{

        private String equipmentId;
        private String name;
        private String desc;
        private int quantity;

        public EquipmentBuilder equipmentId(String equipmentId){
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
            return Objects.hash(equipmentId, name, desc, quantity);
        }
    }


}
