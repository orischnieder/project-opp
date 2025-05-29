package gal_stienberg_ori_schnieder;
import gal_stienberg_ori_schnieder.exceptions.AlreadyExistException;
import gal_stienberg_ori_schnieder.exceptions.CollegeException;
import gal_stienberg_ori_schnieder.exceptions.NotExistException;

import java.util.Scanner;

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
                "\n 12) Article comparison" +
                "\n 13) Department comparison" +
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
        for (Degree d : Degree.values()) {
            System.out.println("- " + d);
        }
        Degree degree = Degree.valueOf(s.next().toUpperCase());
        s.nextLine();
        System.out.println(" please enter lecturer department / leave blank if does not have");
        String department = s.nextLine();
        try {
            college.addLecturer(name,id,salary,degreeName,degree,department);
        } catch (CollegeException e) {
            System.out.println(e.getMessage());;
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
            college.updateHeadCommitte(committeeName,newHeadName);
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

}
