package gal_stienberg_ori_schnieder;

public enum CollegeActionStatus {
    HEAD_OF_COMMITTEE("can't add because already head of committee"),
    SUCCESS("Success"),
    DEPARTMENTS_EXIST("Department already exist"),
    DEPARTMENTS_NOT_EXIST("Department not exist"),
    LECTURER_EXIST("Lecturer already exist"),
    LECTURER_NOT_EXIST("lecturer not exist"),
    COMMITTEE_EXIST("committee already exist"),
    COMMITTEE_NOT_EXIST("committee not exist"),
    DEGREE_NOT_VALID("you must be a doctor/professor"),
    CAN_NOT_REMOVE("not possible to remove");

    private final String description;

    CollegeActionStatus(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return description;
    }
}
