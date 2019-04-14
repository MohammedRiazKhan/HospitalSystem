package utility;

public class IDGenerator {

    public static int genId(){

        //generates a unique number -- could use UUID but i'd have to convert it to
        //string
        return (int) (Math.random() * 10);

    }

}
