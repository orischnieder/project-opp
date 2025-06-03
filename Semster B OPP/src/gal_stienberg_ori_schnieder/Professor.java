package gal_stienberg_ori_schnieder;

public class Professor extends Doctor{
    private String faculty;
    public Professor(String name, String id, String degreeName, Degree degree, double salary,String[]articles,String faculty) {
        super(name, id, degreeName, degree, salary,articles);
        this.faculty = faculty;
    }

    public Professor(String name, String id, String degreeName, Degree degree, double salary, Department tempDepartment,String[]articles,String faculty) {
        super(name, id, degreeName, degree, salary, tempDepartment,articles);
        this.faculty = faculty;
    }
    // Professor.java
    @Override
    public String toString() {
        String base = super.toString();                  // מ-Doctor – נגמר ב-']'
        StringBuilder sb = new StringBuilder(base.substring(0, base.length() - 1)); // מסיר סוגר אחד

        sb.append(", faculty: \"")
                .append(faculty)
                .append("\"");

        sb.append("]");          // סוגר סופית
        return sb.toString();
    }


}
