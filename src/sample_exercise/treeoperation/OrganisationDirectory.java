package sample_exercise.treeoperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rakeshgupta on 3/25/17.
 */
public class OrganisationDirectory {
    public static void main(String[] args) {

        CEO ceo = new CEO();
        ceo.setcId(1);
        ceo.setcName("AAA");
        ceo.setCompany("BBB");

        List<Employee> employeeList = new ArrayList<>();
        List<Manager> managerList = new ArrayList<>();

        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("Satyendra");
        employee.setPost("Senior Engg");

        Employee employee1 = new Employee();
        employee1.setId(101);
        employee1.setName("Ram");
        employee1.setPost("Jr Engg");

        employeeList.add(employee);
        employeeList.add(employee1);

        Manager manager = new Manager();
        manager.setmId(10);
        manager.setmName("John");
        manager.setDeparName("Technical");
        manager.setEmployeeList(employeeList);

        managerList.add(manager);

        ceo.setList(managerList);

        //printCEOData(ceo);
        //printManagers(managerList);
        printEmployees(employeeList);

    }

    public static void printCEOData(CEO ceo){
        System.out.println("\t Id : " + ceo.getcId() + "\t Name : " + ceo.getcName() + "\t Company : " + ceo.getCompany() + "\t" + printManagers(ceo.getList()));
    }

    private static String printManagers(List<Manager> list) {
        for (Manager m : list){
            System.out.println("\t Id : " + m.getmId() + "\t Name : " + m.getmName() + "\t Department :  " + m.getDeparName() + "\t  " + printEmployees(m.getEmployeeList()));
        }
        System.out.println("CEO : ");
        return "";
    }

    private static String printEmployees(List<Employee> employeeList) {
        System.out.println("Employees : ");
        for (Employee e : employeeList){
            printEmployee(e);
        }
        System.out.println("Managers : ");
        return  "";
    }

    private static void printEmployee(Employee e) {
        System.out.println("\t Id : " + e.getId() + "\t Name : " + e.getName() + "\t Post : " + e.getPost());
    }
	}

class Employee {
    int id;
    String name;
    String post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}

class CEO {
    int cId;
    String cName;
    String company;
    List<Manager> list;

    public List<Manager> getList() {
        return list;
    }

    public void setList(List<Manager> list) {
        this.list = list;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

class Manager {
    int mId;
    String mName;
    String  deparName;
    List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDeparName() {
        return deparName;
    }

    public void setDeparName(String deparName) {
        this.deparName = deparName;
    }
}
