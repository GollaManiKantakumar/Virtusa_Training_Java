package model;

public class Employee {

    private int empId;
    private String name;
    private String department;
    private String password;

    public Employee(int empId, String name, String department, String password) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.password = password;
    }

    public int getEmpId()        { return empId; }
    public String getName()      { return name; }
    public String getDepartment(){ return department; }
    public String getPassword()  { return password; }

    public void setName(String name)            { this.name = name; }
    public void setDepartment(String department){ this.department = department; }

    @Override
    public String toString() {
        return "ID: " + empId + " | Name: " + name + " | Department: " + department;
    }
}
