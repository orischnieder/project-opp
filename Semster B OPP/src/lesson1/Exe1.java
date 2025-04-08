
package lesson1;

import java.util.Scanner;
import java.util.Arrays;

public class Exe1 {
    public Exe1() {
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        q7(s);
        q8();
        s.close();

    }



    private static void q6(Scanner s) {
        System.out.println("Enter number: ");
        int num = s.nextInt();
        int res = factorial(num);
        System.out.println(num + "!=" + res);
    }

    private static int factorial(int num) {
        int res = 1;

        for(int i = 2; i <= num; ++i) {
            res *= i;
        }

        return res;
    }

    private static void q7(Scanner s) {
        printMenu();

        int userChoose;
        do {
            userChoose = s.nextInt();
            switch (userChoose) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3();
                    break;
                case 4:
                    exitProgram();
                    return;
                default:
                    System.out.println("Invalid option..");
            }

            printMenu();
        } while(userChoose > 0 && userChoose < 4);

    }

    private static void option1() {
        System.out.println("User choose option 1...");
    }

    private static void option2() {
        System.out.println("User choose option 2...");
    }

    private static void option3() {
        System.out.println("User choose option 3...");
    }

    private static void exitProgram() {
        System.out.println("Bye....");
    }

    private static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("==========: ");
        System.out.println("1) option 1 ");
        System.out.println("2) option 2 ");
        System.out.println("3) option 3 ");
        System.out.println("4) Exit ");
        System.out.println("Please, choose one option...");
    }
    private static void q8() {
        int [] arr = {-3,5,-2,1,-7,8,9,3};
        System.out.println(Arrays.toString(arr));
        getMinToStrat(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void getMinToStrat(int [] arr) {
        int save;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[0]){
                
            }
        }
    }
}
