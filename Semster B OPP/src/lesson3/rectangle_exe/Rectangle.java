package lesson3.rectangle_exe;

public class Rectangle {
    private int width = 10;
    private int height = 10;
    public Rectangle(int width , int height){
        this.width = width;
        this.height = height;
    }

    public Rectangle() {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return showByChar('*');
    }

    public int getPerimeter() {
        return  2* (width + height);
    }

    public int getArea() {
        return width * height;
    }
    public String showByChar(char ch){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append((ch + " ").repeat(Math.max(0, width)));
            sb.append('\n');
        }
        return sb.toString();
    }
}
