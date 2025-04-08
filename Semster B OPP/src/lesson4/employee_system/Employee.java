package lesson4.employee_system;

import java.net.IDN;

import static lesson4.employee_system.Util.rjust;

public class Employee {
    private static int ID = 1000;
    private String id;
    private String name;
    private String department;
    public Employee(String name, String department) {
        setDepartment(department);
        setName(name);
        setId();
    }

    private void setId() {
        ID ++;
        String start = name.length()<= 2 ?
                rjust(name,2,'_'):
                name.substring(0,2).toUpperCase();
        String middle = department.length()<= 3 ?
                rjust(department,3,'_'):
                department.substring(department.length() -3).toLowerCase();
        id = start + middle + ID;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
