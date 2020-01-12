package javaexamples;

import java.sql.Timestamp;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        //Timestamp timestamp = new Timestamp(new Date().setDate(10)//);
        System.out.println(timestamp);
    }
}

