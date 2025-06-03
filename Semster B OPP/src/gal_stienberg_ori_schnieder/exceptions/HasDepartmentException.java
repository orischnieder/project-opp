package gal_stienberg_ori_schnieder.exceptions;

public class HasDepartmentException extends CollegeException {
    public HasDepartmentException() {
        super(" already has a department");
    }
}
