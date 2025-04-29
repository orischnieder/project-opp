package gal_stienberg_ori_schnieder;
import java.util.Objects;
import java.util.Scanner;

import static gal_stienberg_ori_schnieder.CollegeActionStatus.DEGREE_NOT_VALID;

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
                case 3 ->addCommitteeLecturer();
                case 4 ->updateHeadOfCommittee();
                case 5 ->removeLecturerCommittee();
                case 6 ->addStudyDepartment(college);
                case 7 ->averageSalaryCollege();
                case 8 ->averageSalaryDepartment();
                case 9 ->detailsLecturer(college);
                case 10 ->detailsCommittee();
                default -> System.out.println("invalid option please choose again");
            }

        } while(userChoose != 0);

    }

    private static void detailsCommittee() {
    }

    private static void detailsLecturer(College college) {
        Lecturer [] lecturers = college.getLecturerNames();
        for (int i = 0; i < college.getNumOfLecturers(); i++) {
            System.out.println(lecturers[i]);
        }
    }

    private static void averageSalaryDepartment() {
    }

    private static void averageSalaryCollege() {
    }

    private static void removeLecturerCommittee() {
    }

    private static void updateHeadOfCommittee() {
    }

    private static void addCommitteeLecturer() {
    }

    private static void printLecturer() {
    }

    public static void addLecturer(College college) {
        // בדיקה של השם. בדיקה שך התואר.בדיקה של המחלקה
        CollegeActionStatus check;
        String name;
        s.nextLine();
        do {

            System.out.println(" please enter lecturer name");
            name = s.nextLine();
            check = college.checkIfExist(name);
            if (check != CollegeActionStatus.SUCCESS){
                System.out.println(check);
            }
        } while (check != CollegeActionStatus.SUCCESS);
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
        System.out.println(" please enter lecturer department");
        String department = s.nextLine();
        System.out.println(college.addLecturer(name,id,salary,degreeName,degree,department));

    }

    private static void addCommittee(College college) {
        s.nextLine();
        System.out.println(" please enter committee name:");
        String name = s.nextLine();
        //בדיקה האם קיים
        boolean check = false;
        do {
            System.out.println("please enter the name of the head of the committee:");
            String headOfCommittee = s.nextLine();
            System.out.println(college.addCommittee(name, headOfCommittee));

            if (college.addCommittee(name, headOfCommittee) == DEGREE_NOT_VALID) {
                System.out.println("do you wish to enter another name? yes/no?");
                String userChoose = s.nextLine();
                if (Objects.equals(userChoose, "yes")) {
                    check = true;
                } else {
                    break;
                }
            }
            else {
                check = false;
            }
        }while (check);
    }


    private static void addStudyDepartment(College college) {
        s.nextLine();
        System.out.println(" please enter study department name:");
        String name = s.nextLine();
        System.out.println(" please enter the number of students in the department:");
        int numOfStudents = s.nextInt();
        System.out.println(college.addDepartment(name,numOfStudents));
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
}
