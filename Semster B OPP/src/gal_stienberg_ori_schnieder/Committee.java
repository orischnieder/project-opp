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

    public  CollegeActionStatus addLecturerToCommittee(Lecturer lecturer) {
        if (lecturerInCommitteeNum == lecturerInCommittee.length){
            lecturerInCommittee = (Lecturer[]) Util.resizeArr(lecturerInCommittee);
        }
        lecturerInCommittee[lecturerInCommitteeNum++] = lecturer;
        return SUCCESS;

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
    public String toString() {
        return "Committee{" +
                "name='" + name + '\'' +
                ", headOfCommittee=" + headOfCommittee.getName() +
                ", lecturerInCommittee=" + lecturerInCommittee +
                '}';
    }
}

