package gal_stienberg_ori_schnieder;
import java.util.Scanner;

public class Main {
    private static String[] lecturerNames;
    private static String[] committeeNames;
    private static String[] studyDepartmentNames;
    private static int numOfLecturers;
    private static int numOfCommittees;
    private static int numOfStudyDepartments;
    private static Scanner s;
    public static void main(String[]args){
        s = new Scanner(System.in);
        chooseOption();
        
        s.close();
    }

    private static void chooseOption() {
        int userChoose;
        lecturerNames = new String[0];
        committeeNames = new String[0];
        studyDepartmentNames = new String[0];
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
    private static String[] copy(String[] arr, int size, int numOfArr) {
        String [] temp = new String[size];
        for (int i = 0; i < numOfArr; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    private static void addLecturer() {
        s.nextLine();
        System.out.println(" please enter lecturer name" );
        String name = s.nextLine();
        if (isExist(name,numOfLecturers,lecturerNames)){
            System.out.println(name +" is already registered in the system");
            return;
        }
        if (numOfLecturers == lecturerNames.length){
            // לבנות פונקציה במקום הקופי אוף
            lecturerNames = copy(lecturerNames, numOfLecturers == 0 ? 2: numOfLecturers * 2, numOfLecturers);
        }
        lecturerNames[numOfLecturers ++] = name;

    }

    private static void addCommittee() {
        s.nextLine();
        System.out.println(" please enter committee name:" );
        String name = s.nextLine();
        if (isExist(name,numOfCommittees,committeeNames)){
            System.out.println(name +" is already registered in the system. try another name:");
            return;
        }
        if (numOfCommittees == committeeNames.length){
            committeeNames = copy(committeeNames,numOfCommittees == 0 ? 2: numOfCommittees * 2,numOfCommittees);
        }
        committeeNames[numOfCommittees ++] = name;
    }

    private static void addStudyDepartment() {
        s.nextLine();
        System.out.println(" please enter study department name:" );
        String name = s.nextLine();
        if (isExist(name,numOfStudyDepartments,studyDepartmentNames)){
            System.out.println(name +" is already registered in the system. try another name:");
            return;
        }
        if (numOfStudyDepartments == studyDepartmentNames.length){
            studyDepartmentNames = copy(studyDepartmentNames,numOfStudyDepartments == 0 ? 2: numOfStudyDepartments * 2,numOfStudyDepartments);
        }
        studyDepartmentNames[numOfStudyDepartments ++] = name;
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

    private static boolean isExist(String name, int numOfArr, String [] arr) {
        for (int i = 0; i < numOfArr; i++) {
            if (arr[i].equals(name)){
                return true;
            }
        }
        return false;
    }

    private static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("==========: ");
        System.out.println("0) Exit ");
        System.out.println("1) add a lecturer ");
        System.out.println("2) add a committee ");
        System.out.println("3) add a study department ");
        System.out.println("4) not available yet ");
        System.out.println("5) not available yet ");
        System.out.println("6) not available yet ");
        System.out.println("7) details of the lecturers ");
        System.out.println("8) details of the committee ");
    }
}
