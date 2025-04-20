package gal_stienberg_ori_schnieder;
import java.util.Scanner;
/*names: gal stienberg & ori schnieder
* id gal:318915139
* id ori: 322699554*/
public class Main {
    private static Lecturer[] lecturerNames;
    private static Committee[] committeeNames;
    private static Department[] studyDepartmentNames;
    private static int numOfLecturers;
    private static int numOfCommittees;
    private static int numOfStudyDepartments;
    private static   Scanner s;
    public static void main(String[]args){
        s = new Scanner(System.in);
        chooseOption();
        
        s.close();
    }

    private static void chooseOption() {
        int userChoose;
        lecturerNames = new Lecturer[0];
        committeeNames = new Committee[0];
        studyDepartmentNames = new Department[0];
        System.out.println("hello please enter your college name:");
        String college = s.next();
        do {
            printMenu();
            userChoose = s.nextInt();
            switch (userChoose) {
                case 0 -> System.out.println("bye bye and thank you");
                case 1 ->addLecturer();
                case 2 ->addCommittee();
                case 3 ->addStudyDepartment();
                case 4 -> System.out.println("this option is not available yet please select another one");
                case 5 -> System.out.println("this option is not available yet please select another one");
                case 6 -> System.out.println("this option is not available yet please select another one");
                case 7 ->printLecturer();
                case 8 ->printCommittee();
                default -> System.out.println("invalid option please choose again");
            }

        } while(userChoose != 0);

    }

    private static void addLecturer() {
        s.nextLine();
        System.out.println(" please enter lecturer name" );
        String name = s.nextLine();
        while (Util.isExist(name,numOfLecturers,lecturerNames)) {
            System.out.println(name + " is already registered in the system, please try another name:");
            name = s.nextLine();
        }
        System.out.println(" please enter lecturer id" );
        String id = s.nextLine();
        while (!Util.isValidId(id)) {
            System.out.println(id + " id is not valid please enter again:");
            id = s.nextLine();
        }
        System.out.println(" please enter lecturer salary" );
        double salary = s.nextDouble();
        s.nextLine();
        System.out.println(" please enter lecturer degree name" );
        String degreeName = s.nextLine();
        System.out.println(" please enter lecturer department" );
        String department = s.nextLine();
        while (!Util.isExist(department,numOfStudyDepartments,studyDepartmentNames)) {
            System.out.println(department + " the department you entered does not exist try again:");
            department = s.nextLine();
        }

        Lecturer.Degree [] degrees = Lecturer.Degree.values();
        System.out.println("please choose one option:");
        for (Lecturer.Degree deg:degrees){
            System.out.print(deg.name()+",");
        }
        if (numOfLecturers == lecturerNames.length){
            lecturerNames = Util.copy(lecturerNames, numOfLecturers == 0 ? 2: numOfLecturers * 2, numOfLecturers);
        }
        lecturerNames[numOfLecturers] = new Lecturer(name,id,degreeName,department,salary);
        Department.addLecturerToDepartment(lecturerNames[numOfLecturers]);
        numOfLecturers ++;
    }

    private static void addCommittee() {
        s.nextLine();
        System.out.println(" please enter committee name:" );
        String name = s.nextLine();
        if (Util.isExist(name,numOfCommittees,committeeNames)){
            System.out.println(name +" is already registered in the system. try another name:");
            return;
        }
        if (numOfCommittees == committeeNames.length){
            committeeNames = Util.copy(committeeNames,numOfCommittees == 0 ? 2: numOfCommittees * 2,numOfCommittees);
        }
        committeeNames[numOfCommittees ++] = new Committee(name, headOfCommittee,);
    }

    private static void addStudyDepartment() {
        s.nextLine();
        System.out.println(" please enter study department name:" );
        String name = s.nextLine();
        while (Util.isExist(name,numOfStudyDepartments,studyDepartmentNames)) {
            System.out.println(name + " is already registered in the system, please try another department:");
            name = s.nextLine();
        }
        System.out.println("please enter the number of students in the department:");
        int numOfStudents = s.nextInt();

        if (numOfStudyDepartments == studyDepartmentNames.length){
            studyDepartmentNames = Util.copy(studyDepartmentNames,numOfStudyDepartments == 0 ? 2: numOfStudyDepartments * 2,numOfStudyDepartments);
        }
        studyDepartmentNames[numOfStudyDepartments ++] = new Department(name,numOfStudents);
    }

    private static void printLecturer() {
        System.out.print("[");
        for (int i = 0; i < numOfLecturers; i++) {
            if (i == numOfLecturers -1){
                System.out.print(lecturerNames[i]);
            }
            else {
                System.out.print(lecturerNames[i]+ " ,");
            }

        }
        System.out.println("]");
    }

    private static void printCommittee() {
        System.out.print("[");
        for (int i = 0; i < numOfCommittees; i++) {
            if (i == numOfCommittees -1){
                System.out.print(committeeNames[i]);
            }
            else {
                System.out.print(committeeNames[i]+ " ,");
            }

        }
        System.out.println("]");
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
