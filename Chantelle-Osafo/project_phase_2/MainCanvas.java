public class MainCanvas extends CanvasPerson{
    public static void main(String[] args) {

        CanvasPerson person = new CanvasPerson();
        person.createAccount();
        System.out.println(person.login());
        person.updateProfile();
        person.viewProfile();
        System.out.println(person.isAdmin());
        person.isFaculty();
        person.viewCourses();

        Student stud = new Student();
        stud.updateProfile();
        stud.viewCourseByCode();
        stud.viewCoursesByEmail();
        stud.submitAssignment();
        stud.viewAssignmentsByCourse();
        stud.viewAssignmentsByEmail();

        Faculty fac = new Faculty();
        fac.createCourse();
        fac.viewSubmissions();
        fac.scoreAssignment();
        fac.addAssignment();
        fac.registerCourse();

        Assignment assign = new Assignment();
        assign.viewAssignmentScore();
        assign.viewAssignmentScores();
        assign.viewAllAssignmentScores();
        assign.viewAssignmentGrade();
        assign.viewAssignmentGrades();
        assign.viewAllAssignmentGrades();

        Admin admins = new Admin();
        admins.makeFaculty();

        
    }
}