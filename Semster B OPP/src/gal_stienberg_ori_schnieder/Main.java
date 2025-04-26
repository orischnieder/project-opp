package gal_stienberg_ori_schnieder;
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
                case 2 ->addCommittee();
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
        for (Lecturer lec:lecturers){
            System.out.println(lec);
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
        s.nextLine();
        System.out.println(" please enter lecturer name" );
        String name = s.nextLine();
        System.out.println(" please enter lecturer id" );
        String id = s.nextLine();
        System.out.println(" please enter lecturer salary" );
        double salary = s.nextDouble();
        s.nextLine();
        System.out.println(" please enter lecturer degree name" );
        String degreeName = s.nextLine();
        System.out.println("Please enter lecturer degree (choose from):");
        for (Degree d : Degree.values()) {
            System.out.println("- " + d);
        }
        Degree degree = Degree.valueOf(s.next());
        System.out.println(" please enter lecturer department" );
        String department = s.nextLine();
        Department tempDepartment = college.findDepartmentByName(department);
        Lecturer lecturer;
        if (tempDepartment == null){
            lecturer = new Lecturer(name,id,degreeName,degree,salary);
        }
        else {
            lecturer = new Lecturer(name,id,degreeName,degree,salary,tempDepartment);
        }

        System.out.println(college.addLecturer(lecturer));
    }

    private static void addCommittee() {
        s.nextLine();
        System.out.println(" please enter committee name:");
        String name = s.nextLine();

    }

    private static void addStudyDepartment(College college) {
        s.nextLine();
        System.out.println(" please enter study department name:");
        String name = s.nextLine();
        System.out.println(" please enter the number of students in the department:");
        int numOfStudents = s.nextInt();
        Department department = new Department(name,numOfStudents);
        System.out.println(college.addDepartment(department));
    }

    private static void printMenu() {
        System.out.println("Menu: " +
                        "\n==========: " +
                        "\n 0) Exit " +
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
