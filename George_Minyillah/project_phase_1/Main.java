import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Main {




    static String [] admin = {"Dennis.owusu@ashesi.edu.gh"};


    static String[][] User_details = new String [7][7];
    static String[][] courses = new String [2][5];
    static String[][] faculty_members = new String [3][3];
    static  String[][] registered_course = new String[5][5];
    static String[][] assignments = new String[1][6];
    static String[][] submitted_assignments = new String[2][6];
    static String[][] notification_preferences = new String[4][3];

    public static boolean login_required = false;
    public  static boolean pending = true;



    public static void createAccount(String email, String password ) {
//        for(int i = 0; i < User_details.length; i++) {
//            for (int j = 0; j < (User_details[i].length / 2) + 1; j++) {
//                if (User_details[i][j]== null){
//                    User_details[i][j]= email;
//                    Us
//            }
//        }
//            }
        int count = 0;
        for (int g = 0; g < User_details[count].length/2; g++) {
            if (User_details[count][g] == null) {
                User_details[count][0] = email;
                if((g + 1) < User_details.length){
                    User_details[count][1] = password;
                }

            }else{
                count++;

            }
//        for (int i = 0; i < count; i++) {
//            for (int j = 0; j < count; j++) {
//                    if (User_details[count][j] == null){
//                        User_details[count][j] = email;
//                        User_details[count][j+1] = password;
//                    }else{
//                        count++;
//                    }
//
//                    System.out.println("\n\nYour email: " + email + " and your password: " + password + " have been successfully saved");
//                    break;
//                }
//            }
//            count++;
//        }
        }
        System.out.println("\n\nYour email: " + email + " and your password: " + password + " have been successfully saved");
    }

    public static boolean login(String email, String password) {
        String valid_email = null, valid_password = null;
        for (int i = 0; i < User_details.length; i++) {
            for (int j = 0; j < User_details.length; j++) {
                {
                    if (User_details[i][j] == email) {
                        valid_email = User_details[i][j];
                        valid_password = User_details[i][j + 1];
                        break;
                    } else if (User_details[j][i] == email) { //This just slightly increases efficiency
                        valid_email = User_details[i][j];
                        valid_password = User_details[i][j + 1];
                        break;
                    }

                }

            }
        }
        if (email.equals(valid_email)) {
            if (password.equals(valid_password)) {
                System.out.println("Login successful");
                login_required = true;
            } else {
                System.out.println("Incorrect Credentials");
                login_required = false;
            }
            return login_required;
        } else {
            System.out.println("Incorrect Credentials");
            return false;
        }

    }

    public static void updateProfile(String email, String first_name,
                                     String last_name, String year_group,String gpa,
                                     String date_of_birth) {
        if ( login_required == true ){
            for(int i = 0; i < User_details.length; i++) {
                for (int j = 0; j < (User_details[i].length / 2) + 1; j++) {
                    if(User_details[i][j] == email){
                        User_details[i][2] = first_name;
                        User_details[i][3] = last_name;
                        User_details[i][4] = year_group;
                        User_details[i][5] = gpa;
                        User_details[i][6] = date_of_birth;
                    }

                }
            }

        }
    }

    public static void viewProfile(String email){
        if ( login_required == true ){
            for(int i = 0; i < User_details.length; i++) {
                for (int j = 0; j < (User_details[i].length / 2) + 1; j++) {
                    if(User_details[i][j] == email){
                        for (int k = 0; k < User_details[2].length; k++) {
                            if (User_details[i][k]==null) {
                                System.out.println(("NA"));
                            }else {
                                System.out.println(User_details[i][k]);
                            }

                        }

                    }

                }
            }
        }

    }
    public static boolean isAdmin(String email){
        for(int i = 0; i < admin.length; i++){
            if(email == admin[i]){
                System.out.println("This user is an admin");
                return true;
            }else{
                System.out.println("This user is not an admin");
                return false;
            }
        }
        return false;


    }


    public static void makeFaculty(String email){
        if ( login_required == true ){
            for(int i = 0; i < User_details.length; i++) {
                for (int j = 0; j < (User_details[i].length / 2) + 1; j++) {
                    if ( User_details[ i ][ j ] == email ) {
                        for ( int k = 0; k < faculty_members.length; k++ ) {
                            if ( faculty_members[ k ][ 0 ] == null ) {
                                faculty_members[ k ][ 0 ] = email;
                                faculty_members[ k ][ 1 ] = User_details[ i ][ 2 ];
                                faculty_members[ k ][ 2 ] = User_details[ i ][ 3 ];
                            }
                            System.out.println("you have successful made " + email + " a faulty member");
                            break;

                        }

                    }
                }
            }

        }



    }

    public static boolean isFaculty(String email){
        for(int i = 0; i < faculty_members.length; i++) {
            if (faculty_members[i][0] == email) {
                System.out.println(email + " is a faculty member");
                return true;
            }else{
                System.out.println(email + " is not a Faulty member");
            }
        }
        return false;
    }

    public  static void creatCourse(String email, String course_code, String course_name){
        if ( login_required == true ){
            for(int i = 0; i < faculty_members.length; i++){
                if (faculty_members[i][0] == email){
                    for(int j = 0; j < courses[i].length; j++) {
                        for (int k = 0; k < (courses.length / 2) + 1; k++) {
                            if(courses[j][0] == null){
                                courses[j][0] = course_code;
                                courses[j][1] = course_name;
                                courses[j][2] = faculty_members[i][0];
                                courses[j][3] = faculty_members[i][1];
                                courses[j][4] = faculty_members[i][2];


                            }else{
//                            k++;
                                j++;
                            }
                        }
                        break;

                    }
                    System.out.println("You have successfully created a course called "+ course_name+ " with course code " + course_code);


                }else{
                    System.out.println("Email not found. Are you sure you are a faculty member");
                }
                break;
            }

        }

    }

    public static void viewCourses(){
        System.out.println("All course created \nIn the order, course code| course name | email of creator | Firstname of creator | Lastname of Creator");
        System.out.println(Arrays.deepToString(courses).replace("],","\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "));

    }

    public static void registerCourse(String email, String course_code){
        for(int i =0; i < User_details.length; i++){
            if(User_details[i][0] == email){
                for(int j= 0; j < courses[i].length; j++){
                    if(courses[j][0] == course_code){
                        for(int k=0; k< registered_course[j].length; k++){
                            if(registered_course[j][0]== null){
                                registered_course[j][0] = course_code;
                                registered_course[j][1] = courses[i][1];
                                registered_course[j][2] = email;
                                registered_course[j][3] = User_details[i][2];
                                registered_course[j][4]= User_details[i][3];

                            }
                        }
                        System.out.println(email + " has successfully register for the course");
                    }else{
                        System.out.println("Course code not found");
                    }
                    break;
                }
            }else {
                System.out.println("Email not found");
                break;
            }
            break;
        }
    }


    public static void viewCourseByCode(String course_code){
        for(int i =0; i < registered_course.length; i++){
            if(registered_course[i][0] == course_code){
                System.out.println("Course code " +course_code+ "Course name "+ registered_course[i][1]+" " + registered_course[i][2] + " " + registered_course[i][3] + " " + registered_course[i][4] + " has registered for this course ");
                break;
            }else{
                break;
            }
        }

    }

    public static void viewCourseByEmail(String email){
        for(int i =0; i < registered_course.length; i++){
            if(registered_course[i][2] == email){
                System.out.println("Course code " + " " +registered_course[i][0]+ "Course name "+ registered_course[i][1]+" " + registered_course[i][2] + " " + email + " " + registered_course[i][4] + " has registered for this course ");
                break;
            }else{
                break;
            }
        }
    }

    public static void addAssignment(String email, String course_code,String assignment_name,
                                     String description, String due_date, String assignment_type){
        if(login_required == true){
            for(int i =0; i < faculty_members.length; i++){
                if (User_details[i][0] == email){
                    for(int j=0; j < courses.length; j++){
                        if(courses[j][0] == course_code && courses[j][2] == email ){
                            for(int k =0; k < assignments.length; k++){
                                assignments[k][0] = email;
                                assignments[k][1] = course_code;
                                assignments[k][2] = assignment_name;
                                assignments[k][3] = description;
                                assignments[k][4] = due_date;
                                assignments[k][5] = assignment_type;
                                System.out.println( assignment_name + " was successfully added");
                                break;
                            }

                        }

                    }
                }

            }
        }else{
            System.out.println("Login required");
        }
    }

    public static void viewAssignmentByCourse(String course_code){
        for(int i =0; i < assignments.length; i++){
            for(int j =0; j<assignments[i].length;j++){
                if(assignments[i][1] == course_code){
                    System.out.println(assignments[i][j]);
                }
            }
        }
    }

    public static void viewAssignmentByEmail(String email){
        for(int i =0; i < User_details.length; i++){
            if(User_details[i][0] == email){
                System.out.println(Arrays.deepToString(assignments).replace("],","\n").replace(",","\t| ")
                            .replaceAll("[\\[\\]]", " "));
                break;
            }

        }
    }

    public static void submitAssignment(String email, String course_code, String submission_name, String submission){
        for(int i = 0; i < User_details.length; i++){
            if(User_details[i][0] == email){
                        for(int k =0; k < submitted_assignments.length; k++){
                            submitted_assignments[k][0] = email;
                            submitted_assignments[k][1] = course_code;
//                            submitted_assignments[k][2] = assignments[j][2];
                            submitted_assignments[k][2] = submission_name;
                            submitted_assignments[k][3] = submission;

                        }
                        System.out.println("Assignment has been successfully Submitted");
                        break;
                    }
                }
    }

    public static void viewSubmissions(String email, String course_code, String assignment_name){
        for(int i = 0; i< faculty_members.length; i++){
            if(faculty_members[i][0] == email){
                for(int j =0; j < submitted_assignments.length; j++){
                    if ( submitted_assignments[j][1] == course_code ){
                        System.out.println(submitted_assignments[i][3] + " by "+ submitted_assignments[i][0]);
                        break;
                    }
                    else{
                        System.out.println("Details doo not match");
                    }
                }

            }
        }
//        for(int i = 0; i< faculty_members.length)
//        for(int i = 0; i < submitted_assignments.length; i++){
//            for ( int j =0; j < submitted_assignments[i].length; j++ ){
//                if(submitted_assignments[i][0] == email && submitted_assignments[i][1] == course_code && submitted_assignments[i][2] == assignment_name){
//                    System.out.println(submitted_assignments[i][4]);
//                }
//
//            }
//        }
   }
   public static void scoreAssignment(String User_email, String Course_code, String assignment_name,String submitter_email, String score){
        if (login_required == true){
            for ( int i =0; i < faculty_members.length; i++ ){
                if(faculty_members[i][0] == User_email){
                    for(int j =0; j < submitted_assignments.length; j++) {
                        if ( submitted_assignments[ j ][ 1 ] == Course_code ) {
                            for(int k=0; k < submitted_assignments.length; k++){
                                if(submitted_assignments[k][0] == submitter_email){
                                    submitted_assignments[k][4] = score;
                                    System.out.println("Assignment graded");
                                    break;

                                }
                            }

                        }
                    }

                }
            }
        }

   }



    public static void viewAssignmentScore(String email, String course_code, String assignment_name){
        if ( login_required == true ){
            for ( int i =0; i < submitted_assignments.length; i++ ){
                if(submitted_assignments[i][0] == email && submitted_assignments[i][1] == course_code){
                    System.out.println("Your score for this assignment was " + submitted_assignments[i][4]);
                    break;
                }
            }
        }
    }

    public static void viewAssignmentScores(String User_email, String course_code, String assignment_name){
        for ( int i =0; i< faculty_members.length;i++ ){
            if ( faculty_members[i][0] == User_email ){
                for ( int j=0; j< submitted_assignments.length; j++ ){
                    if ( submitted_assignments[i][1] == course_code ){
                        System.out.println(submitted_assignments[i][4]);
                    }
                }
            }
        }
    }

    public static void viewAllAssignmentScore(String email, String course_code){
        if ( login_required == true ){
            for ( int i =0; i < submitted_assignments.length; i++ ){
                if(submitted_assignments[i][0] == email && submitted_assignments[i][1] == course_code){
                    System.out.println("Your score for "+ submitted_assignments[i][2] + " is "+ submitted_assignments[i][4]);
                    break;
                }
            }
        }
    }

    public static void viewAssignmentGrade(String email, String course_code, String assignment_name){
        if ( login_required == true ){
            for ( int i =0; i < submitted_assignments.length; i++ ){
                if(submitted_assignments[i][0] == email && submitted_assignments[i][1] == course_code){
                    Integer grade = Integer.valueOf(submitted_assignments[i][4]);
                    if ( grade <= 100 && grade >=58 ){
                        System.out.println("Your score for "+ submitted_assignments[i][2]+ " "  + submitted_assignments[i][4] + " And you grade is  A+");
                        break;
                    }else if ( grade <=84 && grade >=80){
                        System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  A");
                        break;
                    }else if ( grade<=79 && grade >=75 ){
                        System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  B+");
                        break;
                    }else if ( grade<=74 && grade>=70 ){
                        System.out.println("Your score for " + submitted_assignments[i][2]+ " "  + submitted_assignments[i][4] + " And you grade is  B");
                        break;
                    }else if(grade<=69 && grade >=65){
                        System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  C+");
                        break;
                    }else if ( grade<=64 && grade >=60 ){
                        System.out.println("Your score for "+ submitted_assignments[i][2] + " " + submitted_assignments[i][4] + " And you grade is  C");
                        break;
                    }else if ( grade<=59 && grade>=55 ){
                        System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  D+");
                        break;
                    }else if(grade<=54 && grade >=50){
                        System.out.println("Your score for "+ submitted_assignments[i][2] + " " + submitted_assignments[i][4] + " And you grade is  D");
                        break;
                    }else{
                        System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  E");
                        break;
                    }
                }
            }
        }
    }

    public static void viewAssignmentGrades(String User_email, String course_code, String assignment_name){
        for ( int i =0; i< faculty_members.length;i++ ){
            if ( faculty_members[i][0] == User_email ){
                for ( int j=0; j< submitted_assignments.length; j++ ){
                    if ( submitted_assignments[i][1] == course_code ){
                        Integer grade = Integer.valueOf(submitted_assignments[i][4]);
                        if ( grade <= 100 && grade >=58 ){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " "  + submitted_assignments[i][4] + " And you grade is  A+");
                            break;
                        }else if ( grade <=84 && grade >=80){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  A");
                            break;
                        }else if ( grade<=79 && grade >=75 ){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  B+");
                            break;
                        }else if ( grade<=74 && grade>=70 ){
                            System.out.println("Your score for " + submitted_assignments[i][2]+ " "  + submitted_assignments[i][4] + " And you grade is  B");
                            break;
                        }else if(grade<=69 && grade >=65){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  C+");
                            break;
                        }else if ( grade<=64 && grade >=60 ){
                            System.out.println("Your score for "+ submitted_assignments[i][2] + " " + submitted_assignments[i][4] + " And you grade is  C");
                            break;
                        }else if ( grade<=59 && grade>=55 ){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  D+");
                            break;
                        }else if(grade<=54 && grade >=50){
                            System.out.println("Your score for "+ submitted_assignments[i][2] + " " + submitted_assignments[i][4] + " And you grade is  D");
                            break;
                        }else{
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  E");
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void viewAllAssignmentGrade(String email, String course_code){
        if ( login_required == true ){
            for ( int i =0; i < submitted_assignments.length; i++ ){
                if(submitted_assignments[i][0] == email && submitted_assignments[i][1] == course_code){
                    if ( submitted_assignments[i][1] == course_code ){
                        Integer grade = Integer.valueOf(submitted_assignments[i][4]);
                        if ( grade <= 100 && grade >=58 ){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " "  + submitted_assignments[i][4] + " And you grade is  A+");
                            break;
                        }else if ( grade <=84 && grade >=80){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  A");
                            break;
                        }else if ( grade<=79 && grade >=75 ){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  B+");
                            break;
                        }else if ( grade<=74 && grade>=70 ){
                            System.out.println("Your score for " + submitted_assignments[i][2]+ " "  + submitted_assignments[i][4] + " And you grade is  B");
                            break;
                        }else if(grade<=69 && grade >=65){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  C+");
                            break;
                        }else if ( grade<=64 && grade >=60 ){
                            System.out.println("Your score for "+ submitted_assignments[i][2] + " " + submitted_assignments[i][4] + " And you grade is  C");
                            break;
                        }else if ( grade<=59 && grade>=55 ){
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  D+");
                            break;
                        }else if(grade<=54 && grade >=50){
                            System.out.println("Your score for "+ submitted_assignments[i][2] + " " + submitted_assignments[i][4] + " And you grade is  D");
                            break;
                        }else{
                            System.out.println("Your score for "+ submitted_assignments[i][2]+ " " + submitted_assignments[i][4] + " And you grade is  E");
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void setNotificationPreferences(String email){
        if ( login_required == true ){
            for ( int i=0; i < User_details.length; i++ ){
                if ( User_details[i][0] == email ){
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Would you like to receive notification when an assignment is posted for a course (yes or no)");
                    String post_notification =sc.nextLine();
                    System.out.println("Would you like to receive notification when a score is submitted for your assignment (yes or no)");
                    String score_notification =sc.nextLine();
                    System.out.println("Would you like to receive notification when when you are added to a course (yes or no)");
                    String register_notification =sc.nextLine();
                    for ( int j=0; j < notification_preferences.length; j++ ){
                        for ( int k =0; k < notification_preferences.length; k++ ){
                            notification_preferences[k][0]= post_notification;
                            notification_preferences[k][1] = score_notification;
                            notification_preferences[k][2] = register_notification;
                            break;
                        }
                    }

                }
            }
            System.out.println(Arrays.deepToString(notification_preferences).replace("],","\n").replace(",","\t| ")
                    .replaceAll("[\\[\\]]", " "));

        }
    }




    public static void main(String[] args) {
        createAccount("georgeminyillah@gmail.com", "Minyillah1289$");
        createAccount("george.minyillah@ashesi.edu.gh","Georgemensah0000$£%");
        login("george.minyillah@ashesi.edu.gh","Georgemensah0000$£%");
        updateProfile("georgeminyillah@gmail.com","George", "Minyillah", "2023", "3.85", "10th April 2000");
        updateProfile("george.minyillah@ashesi.edu.gh","Ophelia", "Anyanalimbey", "2023", "4.0", "10th February, 2000");
        viewProfile("george.minyillah@ashesi.edu.gh");
//        viewProfile("georgeminyillah@gmail.com");
        isAdmin("georgeminyillah@gmail.com");
        isAdmin("Dennis.owusu@ashesi.edu.gh");
        makeFaculty("george.minyillah@ashesi.edu.gh");
        isFaculty("george.minyillah@ashesi.edu.gh");
        creatCourse("george.minyillah@ashesi.edu.gh","Math221","Engineering Calculus");
        creatCourse("george.minyillah@ashesi.edu.gh","PHY215","Physics II");
        viewCourses();
        registerCourse("georgeminyillah@gmail.com","Math221");
        viewCourseByCode("Math221");
        viewCourseByEmail("georgeminyillah@gmail.com");
        addAssignment("george.minyillah@ashesi.edu.gh","Math221","Quiz_1","This is your first quiz for the semester",
                "1st march,2021", "Quiz");
        viewAssignmentByCourse("Math221");
        viewAssignmentByEmail("georgeminyillah@gmail.com");
        submitAssignment("georgeminyillah@gmail.com","Math221","George_quiz_1","Final answer.hope i get 100%");
        viewSubmissions("george.minyillah@ashesi.edu.gh","Math221","Quiz_1");
        scoreAssignment("george.minyillah@ashesi.edu.gh","Math221","Quiz_1","georgeminyillah@gmail.com", "90");
        viewAssignmentScore("georgeminyillah@gmail.com","Math221","Quiz_1");
        viewAssignmentScores("george.minyillah@ashesi.edu.gh","Math221","Quiz_1");
        viewAllAssignmentScore("georgeminyillah@gmail.com", "Math221");
        viewAssignmentGrade("georgeminyillah@gmail.com","Math221","Quiz_1");
        viewAssignmentGrades("george.minyillah@ashesi.edu.gh","Math221","Quiz_1");
        viewAllAssignmentGrade("georgeminyillah@gmail.com", "Math221");
        setNotificationPreferences("georgeminyillah@gmail.com");

//        for(int z=0; z < User_details.length; z++){
//            for(int y=0; y< User_details.length; y++){
//                System.out.println("User_details[" + z + "][" + y + "] = "
//                        + User_details[z][y]);
//            }
//
//        }
    }


}
