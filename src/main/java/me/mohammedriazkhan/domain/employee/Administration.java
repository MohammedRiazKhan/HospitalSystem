package me.mohammedriazkhan.domain.employee;

import java.util.Objects;

public class Administration extends Employee{

    private String accessLevel;

    public Administration() {

    }

    private Administration(AdminBuilder builder){
       super(builder);
       this.accessLevel = builder.accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

   public static class AdminBuilder extends Employee.Builder{

       private String accessLevel;

       public AdminBuilder(){
           super();
       }

       public AdminBuilder accessLevel(String accessLevel){
           this.accessLevel = accessLevel;
           return this;
       }

       @Override
       public Employee build(){

           return new Administration(this);
       }

       @Override
       public String toString() {
           return "AdminBuilder{" +
                   "accessLevel='" + accessLevel + '\'' +
                   "} " + super.toString();
       }

       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;
           AdminBuilder that = (AdminBuilder) o;
           return Objects.equals(accessLevel, that.accessLevel);
       }

       @Override
       public int hashCode() {
           return Objects.hash(accessLevel);
       }
   }


}
