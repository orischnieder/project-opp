package gal_stienberg_ori_schnieder;

import static gal_stienberg_ori_schnieder.CollegeActionStatus.SUCCESS;

enum Degree{
    FIRSTDEGREE , SECONDDEGREE, DOCTOR , PROFESSOR
}

public class Lecturer {

    private String [] Articles;
    private int numOfArticles;
    private String faculty;
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
    public int getNumOfArticles() {
        return numOfArticles;
    }
    public String[] getArticles() {
        return Articles;
    }

    public void setArticles(String[] articles) {
        Articles = articles;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
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
        // TODO implement
        return super.equals(obj);
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
