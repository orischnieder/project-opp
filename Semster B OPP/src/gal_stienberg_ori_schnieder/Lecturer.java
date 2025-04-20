package gal_stienberg_ori_schnieder;

public class Lecturer {
    enum Degree{
        FIRSTDEGREE , SECONDDEGREE, DOCTOR , PROFESSOR
    }
    private String name;
    private final String id;
    private String degreeName;
    private double salary;
    private Department department;
    private Committee [] committeesPartOf;
    private int committeesPartOfNum;

    public Lecturer( String name,String id, String degreeName, Department department, double salary) {
        this.id = id;
        this.name = name;
        this.degreeName = degreeName;
        this.department = department;
        this.salary = salary;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }
    public String toString() {
        return "Lecturer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", degree='" + degreeName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
