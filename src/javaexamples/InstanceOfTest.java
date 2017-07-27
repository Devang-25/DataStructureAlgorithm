package javaexamples;

/**
 * Created by rakeshgupta on 7/27/17.
 */
public class InstanceOfTest {
    public static void main(String[] args) {

        String s = "PawanM";
        if (s instanceof String){
            System.out.println("Yes! It's instance of");
        }else {
            System.out.println("No it's not instance of");
        }
    }
}
