package gal_stienberg_ori_schnieder.exceptions;

public class NotExistException extends CollegeException {
    public NotExistException(String name) {
        super(name+ " does not exist in the system");
    }
}

