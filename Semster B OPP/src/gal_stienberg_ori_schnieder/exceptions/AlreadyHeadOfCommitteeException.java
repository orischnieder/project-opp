package gal_stienberg_ori_schnieder.exceptions;

public class AlreadyHeadOfCommitteeException extends CollegeException {
    public AlreadyHeadOfCommitteeException(String name) {
        super(name + " is the head of committee");
    }
}

