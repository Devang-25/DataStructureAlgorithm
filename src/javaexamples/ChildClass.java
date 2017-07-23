package javaexamples;

/**
 * Created by rakeshgupta on 7/23/17.
 */

class BaseClass {
    public  String name = "Super Class Name ..AAAA";
    public int id;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public BaseClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public BaseClass(String name) {
        this("Constructor with Double Parameter", 1);
    }


    public BaseClass() {
        this("By Manually");
    }
}

public class ChildClass extends BaseClass {

    public  String name = "Child Class Name..BBBBB";
    public int id;
    public String mobile;

    public ChildClass() {
    }

    public static void main(String[] args) {
        ChildClass childClass =new ChildClass();
        childClass.getData();


    }

    private void getData() {
        System.out.println(super.name);
        System.out.println(super.id);
    }
}