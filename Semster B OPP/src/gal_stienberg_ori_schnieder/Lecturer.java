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

    public double getSalary() {
        return salary;
    }

    public Degree getDegree(){
        return degree;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lecturer Details: [");
        sb.append("\"name: ").append(name).append("\", ");
        sb.append("\"id: ").append(id).append("\", ");
        sb.append("\"degree name: ").append(degreeName).append("\", ");
        sb.append("\"degree type: ").append(degree).append("\", ");
        sb.append("\"department: ").append(department != null ? department.getName() : "No Department").append("\", ");
        sb.append("\"salary: ").append(salary).append("\", ");

        sb.append("committees: [");
        for (int i = 0; i < committeesPartOfNum; i++) {
            sb.append("\"").append(committeesPartOf[i].getName()).append("\"");
            if (i < committeesPartOfNum - 1) {
                sb.append(", ");
            }
        }
        sb.append("]]");

        return sb.toString();
    }

}
