package lesson2.CarExe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        Scanner s = new Scanner(System.in);
        System.out.println("enter car number:");
        String carNumber = s.next();
        c.setCarNumber(carNumber);
        System.out.println(c);

        s.close();
    }
}
