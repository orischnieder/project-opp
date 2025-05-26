package gal_stienberg_ori_schnieder;

import java.util.Arrays;

import static gal_stienberg_ori_schnieder.CollegeActionStatus.SUCCESS;

public class Committee {
    private String name;
    private Lecturer headOfCommittee;
    private Lecturer[] lecturerInCommittee;
    private int lecturerInCommitteeNum;


    public Committee(String name, Lecturer lecturer) {
        this.name = name;
        this.headOfCommittee =lecturer;
        lecturerInCommittee = new Lecturer[0];
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
    public  CollegeActionStatus addLecturerToCommittee(Lecturer lecturer) {
        if (lecturerInCommitteeNum == lecturerInCommittee.length){
            lecturerInCommittee = (Lecturer[]) Util.resizeArr(lecturerInCommittee);
        }
        lecturerInCommittee[lecturerInCommitteeNum++] = lecturer;
        return SUCCESS;

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

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        // TODO implement
        return super.equals(obj);
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


}

