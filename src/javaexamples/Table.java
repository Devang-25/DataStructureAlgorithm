package javaexamples;

/**
 * Created by rakeshgupta on 7/24/17.
 */
public class Table {

    String woodNames="JackFruit";
    String color;
    int size;

    public Table(String woodNames, String color, int size) {
       this.woodNames = woodNames;
        this.color = color;
        this.size = size;
    }

    public Table() {
    }

    public String getWoodNames() {
        return woodNames;
    }

    public void setWoodNames(String woodNames) {
        // Checking security....
        System.out.println("Setting WoodName with security and check inside box memory");
        this.woodNames = woodNames;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        // Breaking old Table with old size
        // Making new Table with size s
        size = s;
    }

    public void breakTable(int s){
       // Breaking Table with size s
        System.out.println("Breaking table with size : " + s);
    }

    public void createTable( String woodName){
       // Making Table
       woodNames = woodName;
    }

    public static void main(String[] args) {

        Table table = new Table();
        table.getData();
    }

    private void getData() {
        String woodNames = "Apple";
        System.out.println(woodNames);
        System.out.println(this.woodNames);
    }
}
