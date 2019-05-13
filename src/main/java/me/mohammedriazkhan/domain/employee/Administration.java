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

       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;

           AdminBuilder that = (AdminBuilder) o;

           return accessLevel != null ? accessLevel.equals(that.accessLevel) : that.accessLevel == null;

       }

       @Override
       public int hashCode() {
           return accessLevel != null ? accessLevel.hashCode() : 0;
       }
   }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}
