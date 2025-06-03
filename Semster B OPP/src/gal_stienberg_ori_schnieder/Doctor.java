package gal_stienberg_ori_schnieder;

import java.util.Comparator;
class CompareDocProf implements Comparator<Doctor> {
    @Override
    public int compare(Doctor o1, Doctor o2) {
        return Integer.compare(o1.getNumOfArticles(),o2.getNumOfArticles());
    }
}

public class Doctor extends Lecturer{
    private String[] articles;
    private int numOfArticles;

    public int getNumOfArticles() {
        return numOfArticles;
    }

    public Doctor(String name, String id, String degreeName, Degree degree, double salary, String[]articles) {
        super(name, id, degreeName, degree, salary);
        this.articles = articles;
        this.numOfArticles = articles.length;
    }
    public Doctor(String name, String id, String degreeName, Degree degree, double salary, Department tempDepartment,String[]articles) {
        super(name, id, degreeName, degree, salary, tempDepartment);
        this.articles = articles;
        this.numOfArticles = articles.length;
    }
    // Doctor.java
    @Override
    public String toString() {
        String base = super.toString();                  // נגמר ב-']'
        StringBuilder sb = new StringBuilder(base.substring(0, base.length() - 1)); // מסיר סוגר אחד

        sb.append(", articles: [");
        if (articles == null || articles.length == 0) {
            sb.append("]");
        } else {
            for (int i = 0; i < articles.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append("\"").append(articles[i]).append("\"");
            }
            sb.append("]");
        }
        sb.append("]");          // סוגר את המערך החיצוני מחדש
        return sb.toString();
    }



}
