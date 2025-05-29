package gal_stienberg_ori_schnieder.exceptions;

public class NoDepartmentException extends CollegeException {
    public NoDepartmentException() {
        super(" lecturer created without department");
    }
}
