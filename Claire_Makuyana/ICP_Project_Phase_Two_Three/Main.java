package ICP_Project_Phase_Two_Three;

interface req_One {

    boolean login(String email, String pass);

}


interface req_Three {

    boolean login(String email, String pass);

    boolean isAdmin(String email);

    void makeFaculty(String email,String pass,String name);

    boolean isFaculty(String email);

}

interface profile extends req_One{
    void updateProfile(String email, String pass, String first_name,
                              String last_name, String year_group,String gpa,
                              String dob);

    void viewProfile(String email,String pass);
}

interface course extends req_Three{
    void createCourse( String email, String pass,String code,
                              String course_name);

    void viewCourses();

    void registerCourse(String first_name, String last_name,String email,String pass,String course_code);

    void viewCourseByCode(String course_code);

    void viewCoursesByEmail(String first_name,String last_name,String email);
}

interface assignment extends req_Three{

    void addAssignment(String email,String pass,String course_code,
                              String assignment_number,String description,
                              String due_date, String assignment_name);

    void viewAssignmentsByCourse(String course_code);

    void viewAssignmentsByEmail(String email,String first_name,String last_name);

    void submitAssignment(String first_name,String last_name,String email,String pass,
                                 String course_code,String assignment_name,String assignment_number,String submission);

    void viewSubmissions(String email,String pass,String course_code,String assignment_name);
}

interface assignmentScore extends assignment{
    void scoreAssignment( String faculty_email,String faculty_pass,String course_code,
                                 String assignment_name,String assignment_number, String student_email,
                                 String first_name, String last_name, String score);

    void viewAssignmentScore(String email, String pass,String first_name,String last_name, String course_code,String assignment_name,String assignment_number);

    //void viewAssignmentScores(String email,String pass,String course_code,String assignment_number,String assignment_type);

    //void viewALLAssignmentScores(String email,String pass,String first_name,String last_name,String course_code);

}

interface assignmentGrade extends assignmentScore{

    void viewAssignmentGrade(String email,String pass,String course_code,String assignment_type,String assignment_number);

    void ViewAssignmentGrades(String email,String pass,String course_code,String assignment_number,String assignment_type);

    void viewAllAssignmentGrades(String first_name,String last_name,String email,String pass,String course_code);

}


interface main extends req_One{

    void setNotificationPreferences(String email,String pass);
}

