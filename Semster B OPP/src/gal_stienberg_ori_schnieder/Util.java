package gal_stienberg_ori_schnieder;

import java.util.Arrays;

import static gal_stienberg_ori_schnieder.CollegeActionStatus.*;
import static gal_stienberg_ori_schnieder.CollegeActionStatus.SUCCESS;

public class Util {
    public static CollegeActionStatus checkIfExistLecturer(College college, String name) {
        for (int i = 0; i < college.getNumOfLecturers(); i++) {
            if (college.getLecturerNames()[i].getName().equals(name)){
                return LECTURER_EXIST;
            }
        }
        return SUCCESS;
    }
    public static CollegeActionStatus checkIfExistDepartment(College college,String name) {
        for (int i = 0; i < college.getNumOfDepartments(); i++) {
            if (college.getStudyDepartmentNames()[i].getName().equals(name)){
                return DEPARTMENTS_EXIST;
            }
        }
        return SUCCESS;
    }
    public static CollegeActionStatus checkIfExistCommittee(College college, String name) {
        for (int i = 0; i < college.getNumOfCommittees(); i++) {
            if (college.getCommitteeNames()[i].getName().equals(name)){
                return COMMITTEE_EXIST;
            }
        }
        return SUCCESS;
    }
//    public static boolean isExist(Object[] arr, int numOfItems, Object item) {
//        for (int i = 0; i < numOfItems; i++) {
//            if (arr[i].equals(item)){
//                return true;
//            }
//        }
//        return false;
//    }


    public static Object[] resizeArr(Object[] arr){
        return Arrays.copyOf(arr,arr.length == 0 ?2 : arr.length*2);
    }
}
