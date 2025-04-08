package lesson2.person_array_exe.Main;

public class Person {
    private String name;
    private int height;
    private float weight;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "("+name+ "," + height + "," + weight    +")";
    }
}
