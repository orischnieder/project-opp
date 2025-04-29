package gal_stienberg_ori_schnieder;
enum Degree{
    FIRSTDEGREE , SECONDDEGREE, DOCTOR , PROFESSOR
}

public class Lecturer {

    private String name;
    private String id;
    private String degreeName;
    private double salary;
    private Degree degree;
    private Department department;
    private Committee [] committeesPartOf;
    private int committeesPartOfNum;


    public Lecturer(String name,String id, String degreeName,Degree degree, double salary) {
        this.id = id;
        this.name = name;
        this.degreeName = degreeName;
        this.salary = salary;
        this.degree = degree;
    }

    public Lecturer(String name, String id, String degreeName, Degree degree, double salary, Department tempDepartment) {
        this.id = id;
        this.name = name;
        this.degreeName = degreeName;
        this.salary = salary;
        this.degree = degree;
        this.department = tempDepartment;
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
    public Degree getDegree(){
        return degree;
    }
    public Department getDepartment() {
        return department;
    }
    public String toString() {
        return "Lecturer[" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", degree='" + degreeName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ']';
    }
}
