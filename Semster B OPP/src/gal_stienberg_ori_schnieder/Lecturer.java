package gal_stienberg_ori_schnieder;

enum Degree{
    FIRSTDEGREE , SECONDDEGREE, DOCTOR , PROFESSOR
}

public class Lecturer implements Cloneable{

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
        committeesPartOf = new Committee[0];
    }

    public Lecturer(String name, String id, String degreeName, Degree degree, double salary, Department tempDepartment) {
        this.id = id;
        this.name = name;
        this.degreeName = degreeName;
        this.salary = salary;
        this.degree = degree;
        this.department = tempDepartment;
        committeesPartOf = new Committee[0];
    }
    public void addCommittee(Committee committee) {
        if (committeesPartOfNum == committeesPartOf.length){
            committeesPartOf = (Committee[]) Util.resizeArr(committeesPartOf);
        }
        committeesPartOf[committeesPartOfNum++] = committee;
    }

    public void addDepartment(Department department) {
        this.department = department;
    }

    public void setCommitteeInLecturer(Committee committee) {
        int indexRemove = -1;
        for (int i = 0; i < committeesPartOfNum; i++) {
            if (committeesPartOf[i].equals(committee)){
                indexRemove = i;
                break;
            }
        }
        Committee [] newCommittees = new Committee[committeesPartOfNum-1];
        for (int i = 0, j =0 ; i < committeesPartOfNum; i++) {
            if (i != indexRemove){
                newCommittees[j++] = committeesPartOf[i];
            }
        }
        this.committeesPartOf = newCommittees;
        this.committeesPartOfNum--;
    }

    public Department getDepartment() {
        return department;
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
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Lecturer lecturer){
            return name.equals(lecturer.name);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lecturer Details: [");
        sb.append("\"name: ").append(name != null ? name : "Unnamed").append("\", ");
        sb.append("\"id: ").append(id != null ? id : "No ID").append("\", ");
        sb.append("\"degree name: ").append(degreeName != null ? degreeName : "No Degree Name").append("\", ");
        sb.append("\"degree type: ").append(degree != null ? degree : "No Degree Type").append("\", ");
        sb.append("\"department: ").append(department != null ? department.getName() : "No Department").append("\", ");
        sb.append("\"salary: ").append(salary).append("\", ");

        sb.append("committees: [");
        if (committeesPartOfNum == 0) {
            sb.append("]");
        } else {
            for (int i = 0; i < committeesPartOfNum; i++) {
                if (i > 0) sb.append(", ");
                sb.append("\"").append(committeesPartOf[i].getName()).append("\"");
            }
            sb.append("]");
        }
        sb.append("]");           // סוגר את המערך החיצוני
        return sb.toString();
    }

    @Override
    public Lecturer clone() throws CloneNotSupportedException{
        Lecturer clone = (Lecturer) super.clone();
        clone.department = (department != null) ? department.clone() : null;
        clone.committeesPartOf    = new Committee[0];
        clone.committeesPartOfNum = 0;
        return clone;

    }

}
