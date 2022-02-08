import java.util.*;

public class PhaseOne{

    public static String email;
    public static String password;
    public static String name;
    String courseCode;
    String courseName;
    int score = 0;
    Scanner sc = new Scanner(System.in);

    ArrayList<String> assignment = new ArrayList<>();
    ArrayList<String> emailList = new ArrayList<String>();
    ArrayList<String> adminList = new ArrayList<String>();
    ArrayList<String> facultyList = new ArrayList<String>();
    ArrayList<String> passwordList = new ArrayList<String>();
    ArrayList<String> firstName = new ArrayList<String>();
    ArrayList<String> lastName = new ArrayList<String>();
    ArrayList<Integer> yearGroup = new ArrayList<Integer>();
    ArrayList<Float> currentGPA = new ArrayList<Float>();
    ArrayList<String> dateOfBirth = new ArrayList<String>();
    ArrayList<String> courseCodes = new ArrayList<String>();
    ArrayList<String> courseNames = new ArrayList<String>();
    ArrayList<String> creatorNames = new ArrayList<String>();
    ArrayList<String> creatorEmails = new ArrayList<String>();
    ArrayList<String> courseMemberNames = new ArrayList<>();
    ArrayList<String> courseMemberEmails = new ArrayList<>();
    ArrayList<String> assignmentSubmissions = new ArrayList<String>();
    ArrayList<String> submitterEmails = new ArrayList<String>();


    ArrayList<ArrayList<String>> assignments = new ArrayList<>();
    ArrayList<ArrayList<String>> courseSubmissions = new ArrayList<>();
    ArrayList<ArrayList<String>> completeCourseMembersNames = new ArrayList<>();
    ArrayList<ArrayList<String>> completeCourseMembersEmails = new ArrayList<>();

    ArrayList<ArrayList<ArrayList<String>>> courseAssignments = new ArrayList<>();



    public void createAccount(){

        System.out.print("Hello. Please enter your email address to create an account: ");  
        email = sc.nextLine();
        System.out.print("Please enter a password: ");
        password = sc.nextLine();

        emailList.add(email);
        adminList.add(email);
        passwordList.add(password);
        System.out.println("You have successfully created your account.");

    }
    

    public boolean login(){   

        System.out.print("Welcome to the login page. Please enter your email address: \n");  
        email = sc.nextLine();
        System.out.print("Please enter your password: \n");
        password = sc.nextLine();
        
        if (emailList.indexOf(email) == passwordList.indexOf(password) && emailList.indexOf(email) != -1 ){
            return true;
        }
        return false;
    }


    public void updateProfile(){
        System.out.println("Update Profile");
        if (login() == true){

            System.out.println("Please enter your email: ");

            System.out.println("Please enter your first name: ");
            firstName.add(sc.next());

            System.out.println("Please enter your last name: ");
            lastName.add(sc.next());

            System.out.println("Please enter your year group: ");
            yearGroup.add(sc.nextInt());

            System.out.println("Please enter your current GPA: ");
            currentGPA.add(sc.nextFloat());

            System.out.println("Please enter your date of birth: ");
            sc.nextLine();   
            dateOfBirth.add(sc.nextLine());  
        }
        else{
            System.out.println("User does not exist. Please try again");
        }
    }

    public void viewProfile(){

        System.out.println("View Profile");
        if (login() == true){
            System.out.println("Please enter your email: ");
            email = sc.nextLine();
            int index = emailList.indexOf(email);
            try{
                System.out.println("Your first name is: " + firstName.get(index));
                System.out.println("Your last name is: " + lastName.get(index));
                System.out.println("Your GPA is: " + currentGPA.get(index));
                System.out.println("Your year group is: " + yearGroup.get(index));
                System.out.println("Your date of birth is: " + dateOfBirth.get(index));
            } catch (Exception e) {
                System.out.println("Your first name is: NA");
                System.out.println("Your last name is: NA");
                System.out.println("Your GPA is: NA");
                System.out.println("Your year group is: NA");
                System.out.println("Your date of birth is: NA");
            }
        }
    }

    public boolean isAdmin(){
        boolean result;
        System.out.println("Please enter an email address.");
        email = sc.nextLine();
        result = adminList.contains(email)? true: false;
        return result;
    }

    public void makeFaculty(){
        if (login()==true && isAdmin()==true){
            System.out.println("Please enter the email address of the person to be made faculty.");
            email = sc.nextLine();
            facultyList.add(email);
            System.out.println("You have successfully made " + email + " a faculty member.");
        }else{
            System.out.println("You do not have the permission to do this.");
        }
    }

    public boolean isFaculty(){
        System.out.println("Please enter the email address to be checked being faculty: ");
        email = sc.nextLine();
        if (facultyList.contains(email)){
            return true;
        }
        return false;
    }

    public void createCourse(){

        if (login()==true && isFaculty()==true){
            System.out.println("Please enter your email: ");
            creatorEmails.add(sc.nextLine());

            System.out.println("Please enter your name: ");
            creatorNames.add(sc.nextLine());

            System.out.println("Please enter the course code: ");
            courseCode = sc.nextLine();
            courseCodes.add(courseCode);

            System.out.println("Please enter the course name: ");
            courseName = sc.nextLine();
            courseNames.add(courseName);

            System.out.println("You have successfully created the course " + courseCode + ": " + courseName);
        }
    }

    public void viewCourses(){
        for (int i = 0; i < courseCodes.size(); i++){
            System.out.println(i+1 + ". " + courseCodes.get(i) + ": " + courseNames.get(i) + ". Created by " + creatorNames.get(i) + ": " + creatorEmails.get(i));
        }
    }

    public void registerCourse(){
        if (login() == true){
            System.out.println("Welcome to the course registration page.\nPlease enter your name:");
            name = sc.nextLine();

            System.out.println("Please enter your email address:");
            email = sc.nextLine();

            System.out.println("Please enter the code of the course you would like to register for:");
            courseCode = sc.nextLine();

            if (courseCodes.contains(courseCode)){
                int index = courseCodes.indexOf(courseCode);
                courseMemberNames.add(name);
                courseMemberEmails.add(email);
                completeCourseMembersNames.add(index, courseMemberNames);
                completeCourseMembersEmails.add(index, courseMemberEmails);
            }else{
                System.out.println("This course does not exist.");
            }
            System.out.println("You have successfully registered for this course.");
        }
    }

    public void viewCourseByCode(){
        System.out.println("Please enter a course code to view its details:");
        int index = courseCodes.indexOf(sc.nextLine());
        if (index != -1){
            System.out.println("This is course " + courseCodes.get(index) + ": " + courseNames.get(index));
            for (int i = 0; i < completeCourseMembersNames.get(index).size(); i++){
                System.out.println("Students taking this course include:\n" + completeCourseMembersNames.get(index).get(i) + ": " + completeCourseMembersEmails.get(index).get(i));
            }
        }
    }

    public void viewCoursesByEmail(){
        System.out.println("Please enter an email to view its courses:");
        email = sc.nextLine();
        String print = "";

        for (int i = 0; i<completeCourseMembersEmails.size(); i++){
            if (completeCourseMembersEmails.get(i).contains(email)){
                print = courseCodes.get(i) + ": " + courseNames.get(i);
                System.out.println(print);
            }
        }
        if (print == ""){
            System.out.println("This email has not registered for any course.");
        }
    }

    public void addAssignment(){
        if (isFaculty() == true && creatorEmails.contains(email)){
            System.out.println("Please enter your email:");
            assignment.add(sc.nextLine());

            System.out.println("Please enter a course code:");
            courseCode = sc.nextLine();
            assignment.add(courseCode);
            int index = courseCodes.indexOf(courseCode);

            System.out.println("Please enter an assignment name:");
            assignment.add(sc.nextLine());

            System.out.println("Please enter an assignment description:");
            assignment.add(sc.nextLine());

            System.out.println("Please enter a due date:");
            assignment.add(sc.nextLine());

            System.out.println("Please enter the assignment type:");
            assignment.add(sc.nextLine());
            assignments.add(assignment);
            courseAssignments.add(index, assignments);
            System.out.println("You have successfully added this assignment.");
        }else{
            System.out.println("You do not have the permission to do this.");
        }
        
    }

    public void viewAssignmentsByCourse(){
        System.out.println("Please enter a course code to view its assignments:");
        int index = courseCodes.indexOf(sc.nextLine());
        if (index != -1){
            System.out.println(courseAssignments.get(index).toString());
        }else{
            System.out.println("This course does not exist."); 
        }
    }

    public void viewAssignmentsByEmail(){
        System.out.println("Please enter an email to view assignments:");
        for (int i = 0; i < courseAssignments.size(); i++){
            for (int j = 0; j < assignments.size(); j++){
                if (courseAssignments.get(i).get(j).contains(sc.nextLine())){
                    System.out.println(courseAssignments.get(i).get(j).toString());
                }
            }
        }
    }

    public void submitAssignment(){
        if (login() == true){
            System.out.println("Please enter your email to submit your assignment:");
            email = sc.nextLine();
            submitterEmails.add(email);

            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            System.out.println("Please post your submission:");
            assignmentSubmissions.add(sc.nextLine());

            // int index = courseCodes.indexOf(courseCode);
            
            int ind = 0;
            for (int j = 0; j < courseAssignments.size(); j++){
                if (assignment.contains(assignmentName)){
                    ind = assignments.indexOf(assignment);
                }
            }
            courseSubmissions.add(ind, assignmentSubmissions);
        }
    }

    public void viewSubmissions(){
        if (login() == true && isFaculty()==true && creatorEmails.contains(email)){
            System.out.println("Please enter an email address:");
            email = sc.nextLine();

            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();
            int index = courseCodes.indexOf(courseCode);

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            if (index != -1){
                for (int i = 0; i < completeCourseMembersNames.get(index).size(); i++){
                    String user = completeCourseMembersNames.get(index).get(i);

                    for (int j = 0; j < courseAssignments.size(); j++){
                        for (int k = 0; k < assignmentSubmissions.size(); k++){
                            if (courseAssignments.get(i).get(k).contains(user) && courseAssignments.get(i).get(k).contains(assignmentName)){
                                int ind = courseAssignments.get(i).indexOf(courseAssignments.get(i).get(k));
                                System.out.println(courseSubmissions.get(i).get(ind));
                            }
                        }
                    }
                }
            }
        }
    } 

    public void scoreAssignment(){
        if (login() == true && isFaculty()==true && creatorEmails.contains(email)){
            System.out.println("Please enter an email address:");
            email = sc.nextLine();

            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            System.out.println("Please enter the a score:");
            score = sc.nextInt();

            ArrayList<Integer> scores = new ArrayList<>();

            if (courseCodes.contains(courseCode) && submitterEmails.contains(email)){
                for (int i = 0; i < courseAssignments.size(); i++){
                    int index = courseAssignments.get(i).indexOf(assignmentName);
                    scores.add(index, score);
                }
            }



        }
    }

    public static void main(String[] args) {
        PhaseOne person = new PhaseOne();
        person.createAccount();
        System.out.println(person.login());
        // person.updateProfile();
        // person.viewProfile()
        // System.out.println(person.isAdmin());
        person.makeFaculty();
        // person.isFaculty();
        person.createCourse();
        person.viewCourses();
        person.registerCourse();
        person.viewCourseByCode();
        person.viewCoursesByEmail();
        person.addAssignment();
        person.viewAssignmentsByCourse();
        person.viewAssignmentsByEmail();
        person.submitAssignment();
        person.viewSubmissions();
     }
}