package gal_stienberg_ori_schnieder;

public class DegreeNotValidException extends CollegeException {
    public DegreeNotValidException() {
        super("you must be a DR/PROF to be head of committee");
    }
}
