package lesson3.objects_refernce;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car [] cars = new Car[3];
        cars[0] = new Car("skoda", 2022);
        cars[1] = new Car("opel", 2024);
        cars[2] = new Car("audi", 2025);
        cars = copy(cars, cars.length+1);
        cars[3] = new Car("toyota", 2020);
        System.out.println(str(cars));
        Car firstCar = new Car(cars[0]);
        System.out.println("first car" + firstCar);
        firstCar.setModel("skoda fabia");
        System.out.println("first car after change:" + firstCar);
        System.out.println(str(cars));
    }

    private static String str(Object[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length-1){
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    private static Car[] copy(Car[] cars, int size) {
        Car [] temp = new Car[size];
        for (int i = 0; i < cars.length; i++) {
            temp[i] = cars[i];
        }
        return temp;
    }

}
class Car{
    private String model;
    private int year;

    public Car(String model, int year) {
        setModel(model);
        setYear(year);
    }

    public Car(Car other) {
        this.year = other.year;
        this.model = other.model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "(" + model + "," + year + ")";
    }
}