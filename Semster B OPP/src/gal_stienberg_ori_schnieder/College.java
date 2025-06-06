package gal_stienberg_ori_schnieder;


import gal_stienberg_ori_schnieder.exceptions.*;

import static gal_stienberg_ori_schnieder.Degree.*;

public class College {
    private String name;
    private  Lecturer[] lecturerNames;
    private  Committee[] committeeNames;
    private  Department[] departmentsNames;
    private  int numOfLecturers;
    private  int numOfCommittees;
    private  int numOfDepartments;

    public College(String collegeName) {
        this.name = collegeName;
        lecturerNames = new Lecturer[0];
        committeeNames = new Committee[0];
        departmentsNames = new Department[0];

    }

    public void addLecturer(String name, String id, double salary, String degreeName, Degree degree, String department,String[]articles,String faculty) throws CollegeException {
        Lecturer lecturer;
        Department tempDepartment = findDepartmentByName(department);
        if (tempDepartment == null){
            if (degree == DOCTOR){
                lecturer = new Doctor(name,id,degreeName,degree,salary,articles);
            }
            else if (degree == PROFESSOR){
                lecturer = new Professor(name,id,degreeName,degree,salary,articles,faculty);
            }
            else {
                lecturer = new Lecturer(name,id,degreeName,degree,salary);
            }
        }
        else {
            if (degree == DOCTOR){
                lecturer = new Doctor(name,id,degreeName,degree,salary,tempDepartment,articles);
            }
            else if (degree == PROFESSOR){
                lecturer = new Professor(name,id,degreeName,degree,salary,tempDepartment,articles,faculty);
            }
            else {
                lecturer = new Lecturer(name,id,degreeName,degree,salary,tempDepartment);
            }
            tempDepartment.addLecturerToDepartment(lecturer);
        }
        if (numOfLecturers == lecturerNames.length){
            lecturerNames = (Lecturer[]) Util.resizeArr(lecturerNames);
        }
        lecturerNames[numOfLecturers++] = lecturer;
        if (tempDepartment == null){
            throw new NoDepartmentException();
        }
    }

    public void addDepartment(String name,int numOfStudents) {
        Department department = new Department(name,numOfStudents);
        if (numOfDepartments == departmentsNames.length){
            departmentsNames = (Department[]) Util.resizeArr(departmentsNames);
        }
        departmentsNames[numOfDepartments++] = department;
    }

    public void addCommitteeCollege(String name,String headOfCommittee) throws CollegeException{
        Lecturer lecturer = findLecturerByName(headOfCommittee);
        if (lecturer == null){
            throw new NotExistException(headOfCommittee);
        } else if (lecturer.getDegree() == FIRSTDEGREE || lecturer.getDegree() == Degree.SECONDDEGREE) {
            throw new DegreeNotValidException();
        }
        Committee committee = new Committee(name,lecturer);
        if (numOfCommittees == committeeNames.length){
            committeeNames = (Committee[]) Util.resizeArr(committeeNames);
        }
        committeeNames[numOfCommittees++] = committee;
    }

    public void addLecturerToCommittee(String nameCommittee,String nameLecturer) throws CollegeException{
        Committee committee = findCommitteeByName(nameCommittee);
        Lecturer lecturer = findLecturerByName(nameLecturer);
        if (committee == null) {
            throw new NotExistException(nameCommittee);
        }
        if (lecturer == null){
            throw new NotExistException(nameLecturer);
        }
        if (lecturer.equals(committee.getHeadOfCommittee())){
            throw new AlreadyHeadOfCommitteeException(nameLecturer);
        }
        lecturer.addCommittee(committee);
        committee.addLecturerToCommittee(lecturer);
    }

    public Department findDepartmentByName(String name) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departmentsNames[i].getName().equals(name)) {
                return departmentsNames[i];
            }
        }
        return null;
    }

    Lecturer findLecturerByName(String name) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturerNames[i].getName().equals(name)) {
                return lecturerNames[i];
            }
        }
        return null;
    }

    public Committee findCommitteeByName(String name) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committeeNames[i].getName().equals(name)) {
                return committeeNames[i];
            }
        }
        return null;
    }

    public double averageSalaryDepartment(String name) {
        double sum = 0;
        Department temp = findDepartmentByName(name);
        Lecturer lecturer;
        for (int i = 0; i < temp.getLecturersInDepartmentNum(); i++) {
            lecturer = temp.getLecturersInDepartment()[i];
            sum += lecturer.getSalary();
        }
        return sum / temp.getLecturersInDepartmentNum();
    }

    public double averageSalaryAll() {
        double sum = 0;
        for (int i = 0; i < numOfLecturers; i++) {
            sum += lecturerNames[i].getSalary();
        }
        return sum / numOfLecturers;
    }


    public void removeLecturer(String committeeName, String lecturerName) throws CollegeException{
        Committee committee = findCommitteeByName(committeeName);
        Lecturer lecturer = findLecturerByName(lecturerName);
        if (committee == null) {
            throw new NotExistException(committeeName);
        }
        if (lecturer == null) {
            throw new NotExistException(lecturerName);
        }
        if (committee.getHeadOfCommittee().equals(lecturer)){
            throw new AlreadyHeadOfCommitteeException(lecturerName);
        }
        try {
            Util.checkIfExistLecturerCommittee(committee,lecturerName);
        }catch (NotExistException e){
            throw new NotExistException(lecturerName);
        }
        int indexRemove = -1;
        int size = committee.getLecturerInCommitteeNum();
        Lecturer [] lecturers = committee.getLecturerInCommittee();
        for (int i = 0; i < size; i++) {
            if (lecturers[i].equals(lecturer)){
                indexRemove = i;
                break;
            }
        }
        Lecturer [] newLecturers = new Lecturer[size-1];
        for (int i = 0, j =0 ; i < size; i++) {
            if (i != indexRemove){
                newLecturers[j++] = lecturers[i];
            }
        }
        lecturer.setCommitteeInLecturer(committee);
        committee.setLecturerInCommittee(newLecturers);
        committee.decreaseNumOfLecturers();

    }

    public void updateHeadCommittee(String committeeName, String newHeadName) throws CollegeException{
        Committee committee = findCommitteeByName(committeeName);
        Lecturer lecturer = findLecturerByName(newHeadName);
        if (committee == null) {
            throw new NotExistException(committeeName);
        }
        if (lecturer == null) {
            throw new NotExistException(newHeadName);
        }

        if (lecturer.getDegree() == FIRSTDEGREE || lecturer.getDegree() == Degree.SECONDDEGREE) {
            throw new DegreeNotValidException();
        }
        committee.setHeadOfCommittee(lecturer);
    }

    public void addLecturerDepartment(String departmentName, String lecturerName) throws CollegeException{
        Lecturer lecturer = findLecturerByName(lecturerName);
        Department department = findDepartmentByName(departmentName);
        if (department == null) {
            throw new NotExistException(departmentName);
        }
        if (lecturer == null){
            throw new NotExistException(lecturerName);
        }
        if (lecturer.getDepartment() != null){
            throw new HasDepartmentException();
        }
        lecturer.addDepartment(department);

    }
    public void copyCommittee(String committeeName) throws CollegeException, CloneNotSupportedException {
        Committee committee = findCommitteeByName(committeeName);
        if (committee == null) {
            throw new NotExistException(committeeName);
        }
        Committee newCommittee = committee.clone();
        newCommittee.setName("new"+newCommittee.getName());
        if (numOfCommittees == committeeNames.length){
            committeeNames = (Committee[]) Util.resizeArr(committeeNames);
        }
        committeeNames[numOfCommittees++] = newCommittee;
    }



    public int compareCommitteeByLecturer(String committee1, String committee2) throws CollegeException{
        Committee c1 = findCommitteeByName(committee1);
        Committee c2 = findCommitteeByName(committee2);
        if (c1 == null){
            throw new NotExistException(committee1);
        }
        if (c2 == null){
            throw new NotExistException(committee2);
        }
        CompareByNumOfLecturer cmp = new CompareByNumOfLecturer();
        return cmp.compare(c1,c2);

    }

    public int compareCommitteeByArticles(String committee1, String committee2) throws CollegeException{
        Committee c1 = findCommitteeByName(committee1);
        Committee c2 = findCommitteeByName(committee2);
        if (c1 == null){
            throw new NotExistException(committee1);
        }
        if (c2 == null){
            throw new NotExistException(committee2);
        }
        CompareByNumOfArticles cmp = new CompareByNumOfArticles();
        return cmp.compare(c1,c2);
    }

    public int compareDocProf(String l1, String l2) throws CollegeException{
        Lecturer lecturer1 = findLecturerByName(l1);
        Lecturer lecturer2 = findLecturerByName(l2);
        if (lecturer1 == null){
            throw new NotExistException(l1);
        }
        if (lecturer2 == null){
            throw new NotExistException(l2);
        }
        CompareDocProf cmp = new CompareDocProf();
        if (lecturer1 instanceof Doctor doctor1 && lecturer2 instanceof Doctor doctor2){
            return cmp.compare(doctor1,doctor2);
        }
        else {
            throw new DegreeNotValidException();
        }
    }
    public Committee[] getCommitteeNames() {
        return committeeNames;
    }


    public Lecturer[] getLecturerNames() {
        return lecturerNames;
    }

    public Department[] getStudyDepartmentNames() {
        return departmentsNames;
    }

    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    public int getNumOfCommittees() {
        return numOfCommittees;
    }

    public int getNumOfDepartments() {
        return numOfDepartments;
    }
}
