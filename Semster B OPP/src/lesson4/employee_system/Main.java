package lesson4.employee_system;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Keren", "R&D"),
                new Employee("Ido", "Engineering"),
                new Employee("Yuval", "IT"),
                new Employee("M", "HR")
        };
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}




