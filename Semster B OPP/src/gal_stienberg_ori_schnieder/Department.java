package gal_stienberg_ori_schnieder;

import java.util.Arrays;

public class Department implements Cloneable{
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

    public int getLecturersInDepartmentNum() {
        return lecturersInDepartmentNum;
    }


    public Lecturer[] getLecturersInDepartment() {
        return lecturersInDepartment;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Department department){
            return name.equals(department.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Department clone() throws CloneNotSupportedException {
        return (Department) super.clone();
    }
}
