package gal_stienberg_ori_schnieder;

public class AlreadyExistException extends CollegeException{
    public AlreadyExistException(String name) {
        super(name+ " already exist in the system");
    }
}
