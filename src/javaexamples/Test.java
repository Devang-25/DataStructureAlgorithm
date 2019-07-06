package javaexamples;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        map.put(null, 10);
        System.out.println(map);
        System.out.println(map.get(null));
    }
}
