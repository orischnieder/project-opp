package lesson3.exe3;

public class Adult {
    private String name;
    private int height;
    private String professional;
    public Adult(String name, int height, String professional) {
        setName(name);
        setHeight(height);
        setProfessional(professional);
    }

    public Adult(String name, int height) {
        setName(name);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name!= null && !name.isEmpty()){
            this.name = name;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "Adult{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", professional='" + professional + '\'' +
                '}';
    }
}
