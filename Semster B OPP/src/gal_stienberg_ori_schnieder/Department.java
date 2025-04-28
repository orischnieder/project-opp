package gal_stienberg_ori_schnieder;

import java.util.Arrays;

public class Department {
    private String name;
    private int numOfStudents;
    private Lecturer[] lecturersInDepartment;
    private int lecturersInDepartmentNum;

    public Department(String name, int numOfStudents) {
        this.name = name;
        this.numOfStudents = numOfStudents;
        lecturersInDepartment = new Lecturer[0];
    }
    public void addLecturerToDepartment(Lecturer lecturer) {
        if (lecturersInDepartmentNum == lecturersInDepartment.length) {
            lecturersInDepartment = (Lecturer[]) Util.resizeArr(lecturersInDepartment);
        }
        lecturersInDepartment[lecturersInDepartmentNum++] = lecturer;
    }

    public String getName() {
        return name;
    }
//    public CollegeActionStatus addLecturerToDepartment(Lecturer lecturer){
//
//    }

    @Override
    public String toString() {
        return name;
    }
}
