package gal_stienberg_ori_schnieder;

import java.util.Comparator;

class CompareByNumOfLecturer implements Comparator<Committee>{

    @Override
    public int compare(Committee o1, Committee o2) {
        return Integer.compare(o1.getLecturerInCommitteeNum(), o2.getLecturerInCommitteeNum());
    }
}
class CompareByNumOfArticles implements Comparator<Committee>{

    @Override
    public int compare(Committee o1, Committee o2) {
        return Integer.compare(o1.getNumOfArticles(), o2.getNumOfArticles());
    }
}
public class Committee implements Cloneable{
    private String name;
    private Lecturer headOfCommittee;
    private Lecturer[] lecturerInCommittee;
    private int lecturerInCommitteeNum;


    public Committee(String name, Lecturer lecturer) {
        this.name = name;
        this.headOfCommittee =lecturer;
        lecturerInCommittee = new Lecturer[0];
    }
    public int getNumOfArticles(){
        int sum = 0;
        for (int i = 0; i < lecturerInCommitteeNum; i++) {
            if (lecturerInCommittee[i] instanceof Professor professor){
                sum += professor.getNumOfArticles();
            }
            if (lecturerInCommittee[i] instanceof Doctor doctor)
                sum += doctor.getNumOfArticles();
        }
        return sum;
    }
    public void setHeadOfCommittee(Lecturer newHead) {
        this.headOfCommittee = newHead;
    }

    public void setLecturerInCommittee(Lecturer[] lecturerInCommittee) {
        this.lecturerInCommittee = lecturerInCommittee;
    }

    public Lecturer getHeadOfCommittee() {
        return headOfCommittee;
    }
    public  void addLecturerToCommittee(Lecturer lecturer) {
        if (lecturerInCommitteeNum == lecturerInCommittee.length){
            lecturerInCommittee = (Lecturer[]) Util.resizeArr(lecturerInCommittee);
        }
        lecturerInCommittee[lecturerInCommitteeNum++] = lecturer;
    }
    public void decreaseNumOfLecturers() {
        lecturerInCommitteeNum--;
    }
    public int getLecturerInCommitteeNum() {
        return lecturerInCommitteeNum;
    }

    public Lecturer[] getLecturerInCommittee() {
        return lecturerInCommittee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Committee committee){
            return name.equals(committee.name);
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee:").append(name).append("\n");
        sb.append("Head of committee: ").append(headOfCommittee.getName()).append("\n");
        sb.append("Lecturers in committee: ");
        sb.append("[");
        for (int i = 0; i < lecturerInCommitteeNum; i++) {
            Lecturer lecturer = lecturerInCommittee[i];
            sb.append(lecturer.getName()).append(",");
        }
        sb.append("]");

        return sb.toString();
    }
    @Override
    public Committee clone() throws CloneNotSupportedException{
        Committee clone = (Committee) super.clone();
        clone.headOfCommittee = headOfCommittee.clone();
        clone.headOfCommittee.addCommittee(clone);
        clone.lecturerInCommittee = new Lecturer[lecturerInCommittee.length];
        for (int i = 0; i < lecturerInCommitteeNum; i++) {
            Lecturer lClone = lecturerInCommittee[i].clone();
            lClone.addCommittee(clone);
            clone.lecturerInCommittee[i] = lClone;
        }
        clone.lecturerInCommitteeNum = lecturerInCommitteeNum;
        return clone;
    }

}

