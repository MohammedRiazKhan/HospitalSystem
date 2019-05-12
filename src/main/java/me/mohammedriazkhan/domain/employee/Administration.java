package me.mohammedriazkhan.domain.employee;

public class Administration extends Employee{

   private String accessLevel;


    public Administration() {

    }

    private Administration(AdminBuilder builder){
       super(builder);
       this.accessLevel = builder.accessLevel;
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
   }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}
