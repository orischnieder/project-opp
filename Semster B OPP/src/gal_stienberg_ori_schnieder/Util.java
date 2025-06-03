package gal_stienberg_ori_schnieder;

import gal_stienberg_ori_schnieder.exceptions.AlreadyExistException;
import gal_stienberg_ori_schnieder.exceptions.CollegeException;
import gal_stienberg_ori_schnieder.exceptions.NotExistException;

import java.util.Arrays;

public class Util {
    public static void checkIfExistLecturer(College college, String name) throws AlreadyExistException {
        for (int i = 0; i < college.getNumOfLecturers(); i++) {
            if (college.getLecturerNames()[i].getName().equals(name)){
                throw new AlreadyExistException(name);
            }
        }
    }
    public static void checkIfExistDepartment(College college,String name) throws CollegeException {
        for (int i = 0; i < college.getNumOfDepartments(); i++) {
            if (college.getStudyDepartmentNames()[i].getName().equals(name)){
                throw new AlreadyExistException(name);
            }
        }
        throw new NotExistException(name);
    }
    public static void checkIfExistCommittee(College college, String name) throws AlreadyExistException{
        for (int i = 0; i < college.getNumOfCommittees(); i++) {
            if (college.getCommitteeNames()[i].getName().equals(name)){
                throw new AlreadyExistException(name);
            }
        }
    }
    public static void checkIfExistLecturerCommittee(Committee committee, String name) throws CollegeException{
        for (int i = 0; i < committee.getLecturerInCommitteeNum(); i++) {
            if (committee.getLecturerInCommittee()[i].getName().equals(name)){
                return;
            }
        }
        throw new NotExistException(name);
    }

    public static Object[] resizeArr(Object[] arr){
        return Arrays.copyOf(arr,arr.length == 0 ?2 : arr.length*2);
    }
}

