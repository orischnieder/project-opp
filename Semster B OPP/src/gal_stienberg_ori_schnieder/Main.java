package gal_stienberg_ori_schnieder;
import gal_stienberg_ori_schnieder.exceptions.AlreadyExistException;
import gal_stienberg_ori_schnieder.exceptions.CollegeException;
import gal_stienberg_ori_schnieder.exceptions.NoDepartmentException;
import gal_stienberg_ori_schnieder.exceptions.NotExistException;

import java.util.Scanner;

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
                case 11 ->addLecturerToDepartment(college);
                case 12 ->committeeCompare(college);
                case 13 ->profDocCompare(college);
                case 14 ->copyCommittee(college);
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
                "\n 10) Display the full details of all the committees" +
                "\n 11) Add department to lecturer" +
                "\n 12) Committee comparison" +
                "\n 13) Prof/Doc comparison" +
                "\n 14) Copy committee") ;
    }

    public static void addLecturer(College college) {
        boolean check;
        String name;
        s.nextLine();
        do {
            check = false;
            System.out.println(" please enter lecturer name");
            name = s.nextLine();
            try {
                Util.checkIfExistLecturer(college,name);
            } catch (AlreadyExistException e) {
                check = true;
                System.out.println(e.getMessage());
            }
        } while (check);
        System.out.println(" please enter lecturer id");
        String id = s.nextLine();
        System.out.println(" please enter lecturer salary");
        double salary = s.nextDouble();
        s.nextLine();
        System.out.println(" please enter lecturer degree name");
        String degreeName = s.nextLine();
        System.out.println("Please enter lecturer degree (choose from):");
        for (Degree d : values()) {
            System.out.println("- " + d);
        }
        Degree degree = null;
        boolean userInput;
        do {
            userInput = false;
            try {
                degree = valueOf(s.next().toUpperCase());

            }catch (IllegalArgumentException e){
                System.out.println("Invalid degree type please enter again:");
                userInput = true;
            }
        }while (userInput);
        s.nextLine();
        System.out.println(" please enter lecturer department / leave blank if does not have");
        String department = s.nextLine();
        String faculty = null;
        String[] articles = new String[0];
        if (degree == DOCTOR || degree == PROFESSOR) {
            System.out.println("please enter the number of your published article");
            int numOfArticles = s.nextInt();
            s.nextLine();
            articles = new String[numOfArticles];
            for (int i = 0; i < numOfArticles ; i++) {
                System.out.println("enter article " + (i+1)+ ": ");
                articles[i] = s.nextLine();
            }
            if (degree == PROFESSOR){
                System.out.println("please enter the name of the faculty your degree's from: ");
                faculty = s.nextLine();
            }
        }
        try {
            college.addLecturer(name,id,salary,degreeName,degree,department,articles,faculty);
        } catch (CollegeException e) {
            System.out.println(e.getMessage());
        }



    }

    private static void addCommittee(College college) {
        boolean check;
        String name;
        s.nextLine();
        do {
            check = false;
            System.out.println(" please enter committee name");
            name = s.nextLine();
            try {
                Util.checkIfExistCommittee(college,name);
            } catch (AlreadyExistException e) {
                check = true;
                System.out.println(e.getMessage());
            }
        } while (check);
        boolean checkHead;
        do {
            checkHead = false;
            System.out.println("please enter the name of the head of the committee:");
            String headOfCommittee = s.nextLine();
            try {
                college.addCommitteeCollege(name, headOfCommittee);
            } catch (CollegeException e) {
                checkHead = true;
                System.out.println(e.getMessage());;
            }
        }while (checkHead);
    }

    private static void addCommitteeLecturer(College college) {
        s.nextLine();
        System.out.println(" please enter committee to add a lecturer:");
        String nameCommittee = s.nextLine();
        System.out.println("please enter the name of the lecturer you want to add to the Committee:");
        String lecturerToAdd = s.nextLine();
        try {
            college.addLecturerToCommittee(nameCommittee,lecturerToAdd);
        } catch (CollegeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateHeadOfCommittee(College college) {
        s.nextLine();
        System.out.println("Please enter the name of the committee:");
        String committeeName = s.nextLine();
        System.out.println("Please enter the name of the new head of the committee:");
        String newHeadName = s.nextLine();
        try {
            college.updateHeadCommittee(committeeName,newHeadName);
        } catch (CollegeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeLecturerCommittee(College college) {
        s.nextLine();
        System.out.println("Please enter the name of the committee:");
        String committeeName = s.nextLine();
        System.out.println("Please enter the name of the lecturer to remove:");
        String lecturerName = s.nextLine();
        try {
            college.removeLecturer(committeeName,lecturerName);
        } catch (CollegeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addStudyDepartment(College college) {
        boolean check;
        String name;
        s.nextLine();
        do {
            check = false;
            System.out.println(" please enter department name");
            name = s.nextLine();
            try {
                Util.checkIfExistDepartment(college,name);
            } catch (CollegeException e) {
                if (e instanceof AlreadyExistException a) {
                    check = true;
                    System.out.println(e.getMessage());
                }
            }
        } while (check);
        System.out.println(" please enter the number of students in the department:");
        int numOfStudents = s.nextInt();
        college.addDepartment(name,numOfStudents);

    }

    private static void averageSalaryCollege(College college) {
        System.out.println("The average salary of all the lecturers in the college is: "+ college.averageSalaryAll());
    }

    private static void averageSalaryDepartment(College college) {
        s.nextLine();
        System.out.println("please choose a department please: ");
        for (int i = 0; i < college.getNumOfDepartments(); i++) {
            System.out.println(college.getStudyDepartmentNames()[i]);
        }
        String name = s.nextLine();
        try {
            Util.checkIfExistDepartment(college,name);
        }catch (CollegeException e) {
            if (e instanceof NotExistException a){
                System.out.println(a.getMessage());
            }
            else{
                System.out.println("The average salary of the lecturers in department " + name + " is: "
                        + college.averageSalaryDepartment(name));
            }
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

    private static void addLecturerToDepartment(College college) {
        s.nextLine();
        System.out.println("Enter the department:");
        String departmentName = s.nextLine();
        System.out.println("Enter the lecturer:");
        String lecturerName = s.nextLine();
        try {
            college.addLecturerDepartment(departmentName,lecturerName);
        } catch (CollegeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void copyCommittee(College college) {
        s.nextLine();
        System.out.println("Please enter a committee to copy:");
        String committeeName = s.nextLine();
        try {
            college.copyCommittee(committeeName);
        } catch (CollegeException | CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void committeeCompare(College college) {
        s.nextLine();
        System.out.println("Please enter a committee");
        String committee1 = s.nextLine();
        System.out.println("Please enter another committee");
        String committee2 = s.nextLine();
        System.out.println("Choose which comparison you want:" +
                " press 1) number of lecturer in committee , or press 2) number of articles");
        int answer = s.nextInt();
        int res = 0;
        if (answer == 1){
            try {
                res = college.compareCommitteeByLecturer(committee1,committee2);
                if (res < 0 ){
                    System.out.println("committee " +committee1 + " is less then "+committee2);
                }
                else if (res > 0 ){
                    System.out.println("committee " +committee1 + " is more then "+committee2);
                }else {
                    System.out.println("committee " +committee1 + " is same as "+committee2);
                }
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }
        }
        if (answer == 2){
            try {
                res = college.compareCommitteeByArticles(committee1,committee2);
                if (res < 0 ){
                    System.out.println("committee " +committee1 + " is less then "+committee2);
                }
                else if (res > 0 ){
                    System.out.println("committee " +committee1 + " is more then "+committee2);
                }else {
                    System.out.println("committee " +committee1 + " is same as "+committee2);
                }
            } catch (CollegeException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private static void profDocCompare(College college) {
        s.nextLine();
        System.out.println("Please enter the name of Doc/Prof: ");
        String l1 = s.nextLine();
        System.out.println("Please enter another name of Doc/Prof: ");
        String l2 = s.nextLine();
        int res = 0;
        try {
            res = college.compareDocProf(l1,l2);
            if (res < 0 ){
                System.out.println(l1 + " has less articles then "+ l2);
            }
            else if (res > 0 ){
                System.out.println(l1 + " has more articles then "+ l2);
            }else {
                System.out.println(l1 + " has the same number of articles as "+ l2);
            }
        } catch (CollegeException e) {
            System.out.println(e.getMessage());
        }
    }
}
