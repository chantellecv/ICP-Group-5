import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Assignment_interface{
    void addAssignment();
    void viewAssignmentsByCourse();
    void viewAssignmentsByEmail();
    void submitAssignment();
    void viewSubmissions();
    void scoreAssignment();
    void viewAssignmentScore();
    void viewAssignmentScores();
    void viewAllAssignmentScores();
    void viewAssignmentGrade();
    void viewAssignmentGrades();
    void viewAllAssignmentScores_2();
    void setNotificationPreferences();
}

public class Assignments extends courses implements Assignment_interface {
    Map<String, List<String>> Assignments = new HashMap<String, List<String>>();
    Map<String, List<String>> Submissions = new HashMap<String, List<String>>();
    Map<String, List<String>> Scores = new HashMap<String, List<String>>();
    Map<String, List<String>> notification = new HashMap<String, List<String>>();


    //This function should take a user’s email, a course code, an assignment name, description,
    //due date, and assignment type (whether QUIZ, HOMEWORK, PROJECT, or EXAM) and add
    //the assignment to the course. Login Required.
    @Override
    public void addAssignment(){
        List<String> assignment_details = new ArrayList<String>();
        System.out.println("\nYou are about to create an assignment");
        if(getLoginRequired() == true){
            System.out.println("What is your email (You must be a faculty member to add a course)");
            String email = sc.nextLine();
            for (Map.Entry<String, List<String>> me : course_details.entrySet()) {
                String key = me.getKey();
                List<String> values = me.getValue();
                if(values.get(1).equals(email) && facultymember.contains(email)){
                    System.out.println("What is the email of the user you want to assign the assignment to");
                    String user_email = sc.nextLine();
                    System.out.println("What is the course code");
                    String course_code = sc.nextLine();
                    assignment_details.add(course_code);
                    System.out.println("What is the course name");
                    String course_name = sc.nextLine();
                    assignment_details.add(course_name);
                    System.out.println("What is the assignment name");
                    String assignment_name = sc.nextLine();
                    assignment_details.add(assignment_name);
                    System.out.println("What is the assignment description");
                    String description = sc.nextLine();
                    assignment_details.add(description);
                    System.out.println("What is the assignment due date");
                    String due_date = sc.nextLine();
                    assignment_details.add(due_date);
                    System.out.println("What is the assignment type");
                    String assignment_type = sc.nextLine();
                    assignment_details.add(assignment_type);
                    assignment_details.add(email);
                    Assignments.put(user_email, assignment_details);

                }
            }

        }

    }
    //This function should take a course code and display all the assignments.
    @Override
    public void viewAssignmentsByCourse(){
        System.out.println("\nYou are about to view your assignment by courses");
        System.out.println("Kindly type your course code");
        String course_code = sc.nextLine();
        for (Map.Entry<String, List<String>> me : Assignments.entrySet()) {
            String key = me.getKey();
            List<String> values = me.getValue();
            if(values.get(0).equals(course_code)){
                System.out.println("Assignment name " + values.get(2) + " for " + values.get(1) + " Due on " + values.get(4));
            }
        }

    }

    //This function should take a user’s email and display all a user’s assignments. The function
    //should take an optional Boolean argument called pending. If pending is set to true, it should
    //display only assignments which are not past based on assignment due date.
    @Override
    public void viewAssignmentsByEmail(){
        System.out.println("\nYou are about to view your assignment by email");
        System.out.println("Kindly type your email");
        String email = sc.nextLine();
        for (Map.Entry<String, List<String>> me : Assignments.entrySet()) {
            String key = me.getKey();
            List<String> values = me.getValue();
            if(key.equals(email)){
                System.out.println("Assignment name " + values.get(2) + "for " + values.get(1) + " Due on " + values.get(4));
            }
        }

    }

    //This function should take a user’s email, a course code, an assignment name, and a
    //submission which can be just a string and save the submission. Login Required.
    @Override
    public void submitAssignment(){
        List<String> submission_details = new ArrayList<String>();
        System.out.println("\nYou are about to Submit an Assignment");
        System.out.println("What's your email");
        String email = sc.nextLine();
        submission_details.add(email);
        System.out.println("What is the course code");
        String course_code = sc.nextLine();
        System.out.println("What is the assignment name");
        String assignment_name = sc.nextLine();
        submission_details.add(assignment_name);
        System.out.println("Type your submission here");
        String submission  = sc.nextLine();
        submission_details.add(submission);
        Submissions.put(course_code,submission_details);
        System.out.println(Submissions);
    }


    //This function should take a user’s email, a course code, an assignment name, and display
    //the submissions of every user registered for the course. If a user has no submission for the
    //assignment, display “No Submission”.
    @Override
    public void viewSubmissions(){
        System.out.println("\nYou are about to view submissions for a course");
        if(getLoginRequired() == true){
            System.out.println("What is your email (you must be a faculty member)");
            String email = sc.nextLine();
            System.out.println("What is the course code");
            String course_code = sc.nextLine();
            System.out.println("What is the assignment name");
            String assignment_name = sc.nextLine();
            for (Map.Entry<String, List<String>> me : Submissions.entrySet()) {
                String key = me.getKey();
                List<String> values = me.getValue();
                if(values.get(0).equals(email) && key.equals(course_code)){
                    System.out.println("submisssion " + values.get(2));
                }
            }
        }
    }

    //This function should take a user’s email, a course code, an assignment name, submitter’s
    //email, a score and assign the score (out of 100) to the submitter’s assignment.
    @Override
    public void scoreAssignment(){
        List<String> assignment_score = new ArrayList<String>();
        System.out.println("\nYou are about to score an assignment");
        if(getLoginRequired() == true){
            System.out.println("What is your email (you must be a faculty member)");
            String email = sc.nextLine();
            System.out.println("What is the course code");
            String course_code = sc.nextLine();
            for (Map.Entry<String, List<String>> me : Assignments.entrySet()) {
                String key = me.getKey();
                List<String> values = me.getValue();
                if(values.get(6).equals(email) && facultymember.contains(email) && values.get(0).equals(course_code)){
                    for (Map.Entry<String, List<String>> you : Submissions.entrySet()) {
                        String key_1 = you.getKey();
                        List<String> values_1 = you.getValue();
                        System.out.println("What is the email of the student");
                        String student_email = sc.nextLine();
                        System.out.println("What is the assignment name");
                        String assignment_name = sc.nextLine();
                        System.out.println("What score are you giving for this assignment");
                        String score = sc.nextLine();
                        if (key_1.equals(course_code) && values_1.get(0).equals(student_email) && values_1.get(1).equals(assignment_name)) {
                            assignment_score.add(course_code);
                            assignment_score.add(assignment_name);
                            assignment_score.add(score);
                            Scores.put(student_email, assignment_score);
                            System.out.println(Scores);
                        }
                    }

                }
            }


        }

    }

    //This function should take a user email, a course code, an assignment name and display the
    //user’s score for that assignment.
    @Override
    public void viewAssignmentScore(){
        System.out.println("\nYou are about to view an assignment score");
        if(getLoginRequired() == true){
            System.out.println("What is your email");
            String email = sc.nextLine();
            System.out.println("What is the course code");
            String course_code = sc.nextLine();
            System.out.println("What is the assignment name");
            String assignment_name = sc.nextLine();
            for (Map.Entry<String, List<String>> me : Scores.entrySet()) {
                String key = me.getKey();
                List<String> values = me.getValue();
                if(key.equals(key) && values.get(1).equals(assignment_name) && values.get(0).equals(course_code))
                    System.out.println("Email of student " + key + " you scored  " + values.get(2) + " for " + values.get(1));
            }

        }
    }

        //This function should take a user email, a course code, an assignment name and display the
        //scores for all students registered for the course.
        @Override
    public void viewAssignmentScores(){
        System.out.println("\nYou are about to view the scores an assignment");
        if(getLoginRequired() == true){
            System.out.println("What is your email (you must be a faculty member)");
            String email = sc.nextLine();
            System.out.println("What is the course code");
            String course_code = sc.nextLine();
            System.out.println("What is the assignment name");
            String assignment_name = sc.nextLine();
            for (Map.Entry<String, List<String>> you : Assignments.entrySet()) {
                String key_1 = you.getKey();
                List<String> values_1 = you.getValue();
                if(values_1.get(6).equals(email) && facultymember.contains(email) && values_1.get(0).equals(course_code)){
                    for (Map.Entry<String, List<String>> me : Scores.entrySet()) {
                        String key = me.getKey();
                        List<String> values = me.getValue();
                        if (values.get(0).equals(course_code) && values.get(1).equals(assignment_name)) {
                            System.out.println("Email of student " + key + " score " + values.get(2));
                        }
                    }
                }
            }

        }


    }

// This function should take a user email, a course code, and display all the user’s assignments
//with their scores.
    @Override
    public void viewAllAssignmentScores(){
        System.out.println("\nYou are about to view all your scores for a registered course");
        if(getLoginRequired() == true){
            System.out.println("What is your email");
            String email = sc.nextLine();
            System.out.println("What is the course code");
            String course_code = sc.nextLine();
            for (Map.Entry<String, List<String>> me : Scores.entrySet()) {
                String key = me.getKey();
                List<String> values = me.getValue();
                if(values.get(0).equals(course_code) && key.equals(email)){
                    System.out.println( key + " you scored " + values.get(2) + " for " + values.get(1));

                }
            }
        }

    }


        //This function should take a user email, a course code, an assignment name and display the
        //user’s score as well as letter grade for that assignment.
        @Override
    public void viewAssignmentGrade(){
        System.out.println("\nYou are about to view an assignment's grade");
        if(getLoginRequired() == true){
            System.out.println("What is your email");
            String email = sc.nextLine();
            System.out.println("What is the course code");
            String course_code = sc.nextLine();
            System.out.println("What is the assignment name");
            String assignment_name = sc.nextLine();
            for (Map.Entry<String, List<String>> me : Scores.entrySet()) {
                String key = me.getKey();
                List<String> values = me.getValue();
                if(key.equals(key) && values.get(1).equals(assignment_name) && values.get(0).equals(course_code)){
                    if(Integer.parseInt(values.get(2)) <= 100 && Integer.parseInt(values.get(2)) >=85){
                        System.out.println("Email of student " + key + " you grade is A+  and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 84 && Integer.parseInt(values.get(2)) >=80){
                        System.out.println("Email of student " + key + " you grade is A and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 79 && Integer.parseInt(values.get(2)) >=75){
                        System.out.println("Email of student " + key + " you grade is B+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 74 && Integer.parseInt(values.get(2)) >=70){
                        System.out.println("Email of student " + key + " you grade is B and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 69 && Integer.parseInt(values.get(2)) >=65){
                        System.out.println("Email of student " + key + " you grade is C+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 64 && Integer.parseInt(values.get(2)) >=60){
                        System.out.println("Email of student " + key + " you grade is C and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 59 && Integer.parseInt(values.get(2)) >=55){
                        System.out.println("Email of student " + key + " you grade is D+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 54 && Integer.parseInt(values.get(2)) >=50){
                        System.out.println("Email of student " + key + " you grade is D and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) < 50){
                        System.out.println("Email of student " + key + " you grade is E and your score is " + values.get(2) + " for " + values.get(1));
                    }else{
                        System.out.println("Email of student " + key + " you have not completed this course");
                    }
                }

            }

        }


    }

    //This function should take a user email, a course code, an assignment name and display the
    //scores as well as letter grades for all students registered for the course.
    @Override
    public void viewAssignmentGrades(){
        System.out.println("\nYou are about to view an assignment's grade");
        if(getLoginRequired() == true){
            System.out.println("What is your email (you must be a faculty member)");
            String email = sc.nextLine();
            System.out.println("What is the course code");
            String course_code = sc.nextLine();
            System.out.println("What is the assignment name");
            String assignment_name = sc.nextLine();
            for (Map.Entry<String, List<String>> me : Scores.entrySet()) {
                String key = me.getKey();
                List<String> values = me.getValue();
                if(values.get(0).equals(course_code) && values.get(1).equals(assignment_name)){
                    if(Integer.parseInt(values.get(2)) <= 100 && Integer.parseInt(values.get(2)) >=85){
                        System.out.println("Email of student " + key + " you grade is A+  and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 84 && Integer.parseInt(values.get(2)) >=80){
                        System.out.println("Email of student " + key + " you grade is A and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 79 && Integer.parseInt(values.get(2)) >=75){
                        System.out.println("Email of student " + key + " you grade is B+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 74 && Integer.parseInt(values.get(2)) >=70){
                        System.out.println("Email of student " + key + " you grade is B and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 69 && Integer.parseInt(values.get(2)) >=65){
                        System.out.println("Email of student " + key + " you grade is C+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 64 && Integer.parseInt(values.get(2)) >=60){
                        System.out.println("Email of student " + key + " you grade is C and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 59 && Integer.parseInt(values.get(2)) >=55){
                        System.out.println("Email of student " + key + " you grade is D+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 54 && Integer.parseInt(values.get(2)) >=50){
                        System.out.println("Email of student " + key + " you grade is D and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) < 50){
                        System.out.println("Email of student " + key + " you grade is E and your score is " + values.get(2) + " for " + values.get(1));
                    }else{
                        System.out.println("Email of student " + key + " you have not completed this course");
                    }
                }

            }

        }

    }

    //This function should take a user email, a course code, and display all the user’s assignments
    //with their scores and letter grades.
    @Override
    public void viewAllAssignmentScores_2(){
        System.out.println("\nYou are about to view all your scores for a registered course");
        if(getLoginRequired() == true){
            System.out.println("What is your email");
            String email = sc.nextLine();
            System.out.println("What is the course code");
            String course_code = sc.nextLine();
            for (Map.Entry<String, List<String>> me : Scores.entrySet()) {
                String key = me.getKey();
                List<String> values = me.getValue();
                if(values.get(0).equals(course_code) && key.equals(email)){
                    if(Integer.parseInt(values.get(2)) <= 100 && Integer.parseInt(values.get(2)) >=85){
                        System.out.println("Email of student " + key + " you grade is A+  and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 84 && Integer.parseInt(values.get(2)) >=80){
                        System.out.println("Email of student " + key + " you grade is A and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 79 && Integer.parseInt(values.get(2)) >=75){
                        System.out.println("Email of student " + key + " you grade is B+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 74 && Integer.parseInt(values.get(2)) >=70){
                        System.out.println("Email of student " + key + " you grade is B and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 69 && Integer.parseInt(values.get(2)) >=65){
                        System.out.println("Email of student " + key + " you grade is C+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 64 && Integer.parseInt(values.get(2)) >=60){
                        System.out.println("Email of student " + key + " you grade is C and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 59 && Integer.parseInt(values.get(2)) >=55){
                        System.out.println("Email of student " + key + " you grade is D+ and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) <= 54 && Integer.parseInt(values.get(2)) >=50){
                        System.out.println("Email of student " + key + " you grade is D and your score is " + values.get(2) + " for " + values.get(1));
                    }else if (Integer.parseInt(values.get(2)) < 50){
                        System.out.println("Email of student " + key + " you grade is E and your score is " + values.get(2) + " for " + values.get(1));
                    }else{
                        System.out.println("Email of student " + key + " you have not completed this course");
                    }
                }
            }
        }

    }

    @Override
    //This function should take a user email and set the following notification preferences for that
    //user: whether to email the user when an assignment is posted for a course they are
    //registered for; whether to email the user when a score is submitted for their assignment;
    //whether to email the user when they register for a course.
    public void setNotificationPreferences() {
        // A temprary arraylist that stores the values before adding it to the main Hashmap at the end
        List<String> temporary_notifcation = new ArrayList<String>();
        if(getLoginRequired() == true){
            System.out.println("What is your email");
            String email =sc.nextLine();
            System.out.println("Would you like to receive notification when an assignment is posted for a course (yes or no)");
            String post_notification =sc.nextLine();
            temporary_notifcation.add(post_notification);
            System.out.println("Would you like to receive notification when a score is submitted for your assignment (yes or no)");
            String score_notification =sc.nextLine();
            temporary_notifcation.add(score_notification);
            System.out.println("Would you like to receive notification when when you are added to a course (yes or no)");
            String register_notification =sc.nextLine();
            temporary_notifcation.add(register_notification);

            notification.put(email, temporary_notifcation);
        }
    }

}
