package gal_stienberg_ori_schnieder;


import java.util.Arrays;

import static gal_stienberg_ori_schnieder.CollegeActionStatus.*;

public class College {
    private String name;
    private  Lecturer[] lecturerNames;
    private  Committee[] committeeNames;
    private  Department[] studyDepartmentNames;
    private  int numOfLecturers;
    private  int numOfCommittees;
    private  int numOfStudyDepartments;

    public College(String collegeName) {
        this.name = collegeName;
        lecturerNames = new Lecturer[0];
        committeeNames = new Committee[0];
        studyDepartmentNames = new Department[0];

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
        if (Util.isExist(studyDepartmentNames,numOfStudyDepartments,department)){
            return DEPARTMENTS_EXIST;
        }
        if (numOfStudyDepartments == studyDepartmentNames.length){
            studyDepartmentNames = (Department[]) Util.resizeArr(studyDepartmentNames);
        }
        studyDepartmentNames[numOfStudyDepartments++] = department;
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
        for (int i = 0; i < numOfStudyDepartments; i++) {
            if (studyDepartmentNames[i].getName().equals(name)) {
                return studyDepartmentNames[i];
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

    public CollegeActionStatus checkIfExistLecturer(String name) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturerNames[i].getName().equals(name)){
                return LECTURER_EXIST;
            }
        }
        return SUCCESS;
    }
    public CollegeActionStatus checkIfExistDepartment(String name) {
        for (int i = 0; i < numOfStudyDepartments; i++) {
            if (studyDepartmentNames[i].getName().equals(name)){
                return DEPARTMENTS_EXIST;
            }
        }
        return SUCCESS;
    }
    public CollegeActionStatus checkIfExistCommittee(String name) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committeeNames[i].getName().equals(name)){
                return COMMITTEE_EXIST;
            }
        }
        return SUCCESS;
    }
    public double averageSalryAll() {
        double sum = 0;
        for (int i = 0; i < numOfLecturers; i++) {
            sum += lecturerNames[i].getSalary();
        }
        return sum / numOfLecturers;
    }

//    private Committee findCommitteeByName() {
//    }

    public Committee[] getCommitteeNames() {
        return committeeNames;
    }

    public Lecturer[] getLecturerNames() {
        return lecturerNames;
    }

    public Department[] getStudyDepartmentNames() {
        return studyDepartmentNames;
    }


    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    public int getNumOfCommittees() {
        return numOfCommittees;
    }

    public int getNumOfStudyDepartments() {
        return numOfStudyDepartments;
    }
    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", lecturerNames=" + Arrays.toString(lecturerNames) +
                ", committeeNames=" + Arrays.toString(committeeNames) +
                ", studyDepartmentNames=" + Arrays.toString(studyDepartmentNames) +
                '}';
    }


}
