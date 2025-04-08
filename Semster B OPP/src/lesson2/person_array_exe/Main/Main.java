package lesson2.person_array_exe.Main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        p1.setName("ori");
        p1.setHeight(175);
        p1.setWeight(77.7f);
        System.out.println(p1);
        p2.setName("do");
        p2.setHeight(155);
        p2.setWeight(47.7f);
        System.out.println(p2);
        p3.setName("yo");
        p3.setHeight(185);
        p3.setWeight(76.7f);
        System.out.println(p3);
        Person [] persons  = {p1,p2,p3};
        System.out.println(Arrays.toString(persons));
        Person[] personsByWeight = sortByWeight(persons);
        System.out.println(Arrays.toString(personsByWeight));
    }

    private static Person[] sortByWeight(Person[] persons) {
        Person[] personsByWeight = Arrays.copyOf(persons,persons.length);
        bubbleSort(personsByWeight);
        return personsByWeight;
    }
    private static Person[] sortByHeight(Person[] persons) {
        Person[] personsByWeight = Arrays.copyOf(persons,persons.length);
        bubbleSort(personsByWeight);
        return personsByWeight;
    }

    private static void bubbleSort(Person[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].getWeight() > arr[j + 1].getWeight()) {

                    // swap temp and arr[i]
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
