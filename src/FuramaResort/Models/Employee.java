package FuramaResort.Models;

import org.omg.PortableServer.IdAssignmentPolicy;

public class Employee {
    private String nameEmployee;
    private int ageEmployee;
    private String address;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(int ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee() {
    }

    public Employee(String id, String nameEmployee, int ageEmployee, String address) {
        this.id = id;
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.address = address;
    }

    @Override
    public String toString() {
        return " ID: " +this.getId()+
                " Name: " +this.getNameEmployee()+
                " Age: " +this.getAgeEmployee()+
                " Address: "+ this.getAddress();
    }
}
