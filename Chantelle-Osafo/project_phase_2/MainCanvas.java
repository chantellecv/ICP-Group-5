public class MainCanvas extends CanvasPerson{
    public static void main(String[] args) {
        CanvasPerson person = new CanvasPerson();
        person.createAccount();
        // System.out.println(person.login());
        person.updateProfile();
        person.viewProfile();
        // System.out.println(person.isAdmin());
        // person.isFaculty();
        person.viewCourses();
        // person.registerCourse();
        // person.viewCourseByCode();
        // person.viewCoursesByEmail();
        // person.viewAssignmentsByEmail();
        // person.submitAssignment();
        // person.viewSubmissions();
        // person.scoreAssignment();
        // person.viewAssignmentScore();
        // person.viewAssignmentScores();
        // person.viewAllAssignmentScores();
        // person.viewAssignmentGrade();
    }
}