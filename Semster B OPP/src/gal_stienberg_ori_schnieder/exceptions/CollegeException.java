package gal_stienberg_ori_schnieder.exceptions;

public class CollegeException extends Exception{
    private static final String PRE_MESSAGE= "Error: ";
    public CollegeException(String message) {
        super(PRE_MESSAGE + message);
    }
}
