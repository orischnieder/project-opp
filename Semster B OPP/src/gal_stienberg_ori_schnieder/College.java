package gal_stienberg_ori_schnieder;


import java.util.Arrays;

import static gal_stienberg_ori_schnieder.CollegeActionStatus.*;

public class College {
    private String name;
    private  Lecturer[] lecturerNames;
    private  Committee[] committeeNames;
    private  Department[] departmentsNames;
    private  int numOfLecturers;
    private  int numOfCommittees;
    private  int numOfDepartments;

    public College(String collegeName) {
        this.name = collegeName;
        lecturerNames = new Lecturer[0];
        committeeNames = new Committee[0];
        departmentsNames = new Department[0];

    }

    public CollegeActionStatus addLecturer(String name, String id, double salary, String degreeName, Degree degree, String department) {
        Lecturer lecturer;
        Department tempDepartment = findDepartmentByName(department);
        if (tempDepartment == null){
            lecturer = new Lecturer(name,id,degreeName,degree,salary);
        }
        else {
            lecturer = new Lecturer(name,id,degreeName,degree,salary,tempDepartment);
            tempDepartment.addLecturerToDepartment(lecturer);
        }
        if (numOfLecturers == lecturerNames.length){
            lecturerNames = (Lecturer[]) Util.resizeArr(lecturerNames);
        }
        lecturerNames[numOfLecturers++] = lecturer;
        return SUCCESS;
    }

    public CollegeActionStatus addDepartment(String name,int numOfStudents) {
        Department department = new Department(name,numOfStudents);
        if (numOfDepartments == departmentsNames.length){
            departmentsNames = (Department[]) Util.resizeArr(departmentsNames);
        }
        departmentsNames[numOfDepartments++] = department;
        return SUCCESS;
    }

    public CollegeActionStatus addCommittee(String name,String headOfCommittee) {
        Lecturer lecturer = findLecturerByName(headOfCommittee);
        if (lecturer == null){
            return LECTURER_NOT_EXIST;
        } else if (lecturer.getDegree() == Degree.FIRSTDEGREE || lecturer.getDegree() == Degree.SECONDDEGREE) {
            return DEGREE_NOT_VALID;
        }
        Committee committee = new Committee(name,lecturer);
        if (numOfCommittees == committeeNames.length){
            committeeNames = (Committee[]) Util.resizeArr(committeeNames);
        }
        committeeNames[numOfCommittees++] = committee;
        return SUCCESS;
    }



    public Department findDepartmentByName(String name) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departmentsNames[i].getName().equals(name)) {
                return departmentsNames[i];
            }
        }
        return null;
    }

    private Lecturer findLecturerByName(String name) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturerNames[i].getName().equals(name)) {
                return lecturerNames[i];
            }
        }
        return null;
    }



    public double averageSalryAll() {
        double sum = 0;
        for (int i = 0; i < numOfLecturers; i++) {
            sum += lecturerNames[i].getSalary();
        }
        return sum / numOfLecturers;
    }

    public Committee[] getCommitteeNames() {
        return committeeNames;
    }

    public Lecturer[] getLecturerNames() {
        return lecturerNames;
    }

    public Department[] getStudyDepartmentNames() {
        return departmentsNames;
    }


    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    public int getNumOfCommittees() {
        return numOfCommittees;
    }

    public int getNumOfDepartments() {
        return numOfDepartments;
    }
    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", lecturerNames=" + Arrays.toString(lecturerNames) +
                ", committeeNames=" + Arrays.toString(committeeNames) +
                ", studyDepartmentNames=" + Arrays.toString(departmentsNames) +
                '}';
    }


    public Double averageSalaryDepartment(String name) {
        double sum = 0;
        Department temp = findDepartmentByName(name);
        Lecturer lecturer;
        for (int i = 0; i < temp.getLecturersInDepartmentNum(); i++) {
            lecturer = temp.getLecturersInDepartment()[i];
            sum += lecturer.getSalary();
        }
        return sum / temp.getLecturersInDepartmentNum();
    }

    public Committee findCommitteeByName(String name) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committeeNames[i].getName().equals(name)) {
                return committeeNames[i];
            }
        }
        return null;
    }

    public CollegeActionStatus addLecturerToCommittee(String name, Committee committee) {
        Lecturer lecturer = findLecturerByName(name);
        return committee.addLecturerToCommittee(lecturer);
    }
}
