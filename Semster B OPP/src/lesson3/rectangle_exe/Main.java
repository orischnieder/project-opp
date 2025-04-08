package lesson3.rectangle_exe;


public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
        System.out.println("perimeter:" + r1.getPerimeter());
        System.out.println("area:" + r1.getArea());
        System.out.println(r1.showByChar('$'));
        Rectangle r2 = new Rectangle(5,7);
        
    }
}
