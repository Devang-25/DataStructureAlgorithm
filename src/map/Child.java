package map;

/**
 * Created by rakeshgupta on 7/19/17.
 */
 class Base {
     Base(){
         System.out.println("Base Cpm");
    }
    Base(int a, int j){

    }
}

public  class Child extends Base{
     Child(){
         System.out.println("child");
     }
    {
        System.out.println("angry");
    }

    public static void main(String[] args) {
        Child child = new Child();
        Base b =new Base(30, 34);
    }
}

