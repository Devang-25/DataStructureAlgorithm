package string;

import java.text.SimpleDateFormat;

/**
 * Created by rakeshgupta on 2/5/17.
 */
public class LaterDate {
    public static void main(String[] args) {

          final long HOUR = 3600*24*365*2*1000;
        java.util.Date a = new java.util.Date();

//        java.util.Date b = new java.util.Date();
//        b.setTime(HOUR);
//        System.out.println(b);

        long l = System.currentTimeMillis()+HOUR;
    //    System.out.println(l+HOUR);

        java.util.Date d = new java.util.Date(l);
        System.out.println(d);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD'T'HH:MM:SS");
       System.out.println(simpleDateFormat.format(d));
    }
}
