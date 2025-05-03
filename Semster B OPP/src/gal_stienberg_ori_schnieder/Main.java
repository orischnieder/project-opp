package gal_stienberg_ori_schnieder;
import java.util.Arrays;
import java.util.Scanner;

import static gal_stienberg_ori_schnieder.CollegeActionStatus.*;
import static gal_stienberg_ori_schnieder.Degree.*;

/*names: gal stienberg & ori schnieder
* id gal:318915139
* id ori: 322699554*/
public class Main {

    private static Scanner s;
    public static void main(String[]args){
        s = new Scanner(System.in);

        chooseOption();
        
        s.close();
    }

    public static void chooseOption() {
        int userChoose;
        System.out.println("hello please enter your college name:");
        String collegeName = s.next();
        College college = new College(collegeName);
        do {
            printMenu();
            userChoose = s.nextInt();
            switch (userChoose) {
                case 0 -> System.out.println("bye bye and thank you");
                case 1 ->addLecturer(college);
                case 2 ->addCommittee(college);
                case 3 ->addCommitteeLecturer(college);
                case 4 ->updateHeadOfCommittee(college);
                case 5 ->removeLecturerCommittee(college);
                case 6 ->addStudyDepartment(college);
                case 7 ->averageSalaryCollege(college);
                case 8 ->averageSalaryDepartment(college);
                case 9 ->detailsLecturer(college);
                case 10 ->detailsCommittee(college);
                default -> System.out.println("invalid option please choose again");
            }

        } while(userChoose != 0);

    }

    private static void printMenu() {
        System.out.println("Menu: " +
                "\n==========: " +
                "\n  0) Exit " +
                "\n  1) Add a new lecturer " +
                "\n  2) Add a new committee" +
                "\n  3) Add a lecturer to a committee" +
                "\n  4) Update the head of a committee" +
                "\n  5) Remove a lecturer from a committee" +
                "\n  6) Add a new department" +
                "\n  7) Display the average salary of the lecturers in college " +
                "\n  8) Display the average salary of the lecturers in a specific department" +
                "\n  9) Display the full details of the lecturers" +
                "\n 10) Display the full details of all the committees" );

    }



    public static void addLecturer(College college) {
//        CollegeActionStatus check;
//        String name;
//        s.nextLine();
//        do {
//
//            System.out.println(" please enter lecturer name");
//            name = s.nextLine();
//            check = Util.checkIfExistLecturer(college,name);
//            if (check != SUCCESS){
//                System.out.println(check);
//            }
//        } while (check != SUCCESS);
//        System.out.println(" please enter lecturer id");
//        String id = s.nextLine();
//        System.out.println(" please enter lecturer salary");
//        double salary = s.nextDouble();
//        s.nextLine();
//        System.out.println(" please enter lecturer degree name");
//        String degreeName = s.nextLine();
//        System.out.println("Please enter lecturer degree (choose from):");
//        for (Degree d : Degree.values()) {
//            System.out.println("- " + d);
//        }
//        Degree degree = Degree.valueOf(s.next().toUpperCase());
//        s.nextLine();
//        System.out.println(" please enter lecturer department / leave blank if does not have");
//        String department = s.nextLine();
//        System.out.println(college.addLecturer(name,id,salary,degreeName,degree,department));
        System.out.println(college.addLecturer("gal", "318915139", 10000 , "kaki" , DOCTOR,"math"));
        System.out.println(college.addLecturer("sami", "287663228", 7000 , "pipi" , FIRSTDEGREE,"pizi"));
        System.out.println(college.addLecturer("ori", "167188188", 5500 , "shilshul" , FIRSTDEGREE,"sport"));
        System.out.println(college.addLecturer("dor", "344553139", 12000 , "samim" , PROFESSOR,"math"));

    }

    private static void addCommittee(College college) {
        CollegeActionStatus checkName;
        String name;
        s.nextLine();
        do {

            System.out.println(" please enter the committee name");
            name = s.nextLine();
            checkName = Util.checkIfExistCommittee(college, name);
            if (checkName != SUCCESS){
                System.out.println(checkName);
            }
        } while (checkName != SUCCESS);
        boolean checkHead = false;
        do {
            System.out.println("please enter the name of the head of the committee:");
            String headOfCommittee = s.nextLine();
            CollegeActionStatus check = college.addCommitteeCollege(name, headOfCommittee);
            System.out.println(check);
            if (check == DEGREE_NOT_VALID) {

                System.out.println("do you wish to enter another name? yes/no?");
                String userChoose = s.nextLine();
                if (userChoose.equals("yes")) {
                    checkHead = true;
                } else {
                    break;
                }
            }
            else {
                checkHead = false;
            }
        }while (checkHead);
    }

    private static void addCommitteeLecturer(College college) {
        s.nextLine();
        System.out.println(" please enter committee to add a lecturer:");
        String nameCommittee = s.nextLine();
        System.out.println("please enter the name of the lecturer you want to add to the Committee:");
        String lecturerToAdd = s.nextLine();
        CollegeActionStatus check = college.addLecturerToCommittee(nameCommittee,lecturerToAdd);
        System.out.println(check);
    }

    private static void updateHeadOfCommittee(College college) {
        s.nextLine();
        System.out.println("Please enter the name of the committee:");
        String committeeName = s.nextLine();
        System.out.println("Please enter the name of the new head of the committee:");
        String newHeadName = s.nextLine();
        CollegeActionStatus check = college.updateHeadCommitte(committeeName,newHeadName);
        System.out.println(check);
    }

    private static void removeLecturerCommittee(College college) {
        s.nextLine();
        System.out.println("Please enter the name of the committee:");
        String committeeName = s.nextLine();
        System.out.println("Please enter the name of the lecturer to remove:");
        String lecturerName = s.nextLine();
        CollegeActionStatus check = college.removeLecturer(committeeName,lecturerName);
        System.out.println(check);
    }

    private static void addStudyDepartment(College college) {
//        CollegeActionStatus check;
//        String name;
//        s.nextLine();
//        do {
//
//            System.out.println(" please enter department name");
//            name = s.nextLine();
//            check = Util.checkIfExistDepartment(college,name);
//            if (check != SUCCESS){
//                System.out.println(check);
//            }
//        } while (check != SUCCESS);
//        System.out.println(" please enter the number of students in the department:");
//        int numOfStudents = s.nextInt();
//        System.out.println(college.addDepartment(name,numOfStudents));
        System.out.println(college.addDepartment("math",120));
        System.out.println(college.addDepartment("pizi",80));
        System.out.println(college.addDepartment("sport",200));
    }

    private static void averageSalaryCollege(College college) {
        System.out.println("The average salary of all the lecturers in the college is: "+ college.averageSalryAll());
    }

    private static void averageSalaryDepartment(College college) {
        s.nextLine();
        System.out.println("please choose a department please: ");
        for (int i = 0; i < college.getNumOfDepartments(); i++) {
            System.out.println(college.getStudyDepartmentNames()[i]);
        }
        String name = s.nextLine();
        if (Util.checkIfExistDepartment(college,name) == DEPARTMENTS_EXIST) {
            System.out.println("The average salary of the lecturers in department " + name + " is: " + college.averageSalaryDepartment(name));
        }else {
            System.out.println(DEPARTMENTS_NOT_EXIST);
        }
    }

    private static void detailsLecturer(College college) {
        for (int i = 0; i < college.getNumOfLecturers(); i++) {
            System.out.println(college.getLecturerNames()[i]);
        }
    }

    private static void detailsCommittee(College college) {
        for (int i = 0; i < college.getNumOfCommittees(); i++) {
            System.out.println(college.getCommitteeNames()[i]);
        }

    }

}
