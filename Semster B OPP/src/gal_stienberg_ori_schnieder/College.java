package gal_stienberg_ori_schnieder;

import lesson5.Utils;

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
    public Department findDepartmentByName(String name) {
        for (int i = 0; i < numOfStudyDepartments; i++) {
            if (studyDepartmentNames[i].getName().equals(name)) {
                return studyDepartmentNames[i];
            }
        }
        return null;
    }
    public CollegeActionStatus addLecturer(Lecturer lecturer) {
        if (Utils.isExist(lecturerNames,numOfLecturers,lecturer)){
            return LECTURER_EXIST;
        }
        if (numOfLecturers == lecturerNames.length){
            lecturerNames = (Lecturer[]) Utils.resizeArr(lecturerNames);
        }
        lecturerNames[numOfLecturers++] = lecturer;
        return SUCCESS;
    }
    public CollegeActionStatus addDepartment(Department department) {
        if (Utils.isExist(studyDepartmentNames,numOfStudyDepartments,department)){
            return DEPARTMENTS_EXIST;
        }
        if (numOfStudyDepartments == studyDepartmentNames.length){
            studyDepartmentNames = (Department[]) Utils.resizeArr(studyDepartmentNames);
        }
        studyDepartmentNames[numOfStudyDepartments++] = department;
        return SUCCESS;
    }

    public CollegeActionStatus addCommittee(Committee committee) {
        if (Utils.isExist(committeeNames,numOfCommittees,committee)){
            return COMMITTEE_EXIST;
        }
        if (numOfCommittees == committeeNames.length){
            committeeNames = (Committee[]) Utils.resizeArr(committeeNames);
        }
        committeeNames[numOfCommittees++] = committee;
        return SUCCESS;
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
