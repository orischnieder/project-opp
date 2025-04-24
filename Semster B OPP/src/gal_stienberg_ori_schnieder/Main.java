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

    private  void chooseOption() {
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
                case 3 ->addStudyDepartment(college);
                case 4 -> System.out.println("this option is not available yet please select another one");
                case 5 -> System.out.println("this option is not available yet please select another one");
                case 6 -> System.out.println("this option is not available yet please select another one");
                case 7 ->printLecturer();
                case 8 ->printCommittee();
                default -> System.out.println("invalid option please choose again");
            }

        } while(userChoose != 0);

    }

    public void addLecturer(College college) {
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

        college.addLecturer(lecturer);
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
        college.addDepartment(department);
    }




    private static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("==========: ");
        System.out.println(" 0) Exit ");
        System.out.println(" 1) add a lecturer ");
        System.out.println(" 2) add a committee ");
        System.out.println(" 3) add a study department ");
        System.out.println(" 4) not available yet ");
        System.out.println(" 5) not available yet ");
        System.out.println(" 6) not available yet ");
        System.out.println(" 7) details of specific department ");
        System.out.println(" 8) average salary of lecturers");
        System.out.println(" 9) details of the lecturers ");
        System.out.println("10) details of the committee ");
    }
}
