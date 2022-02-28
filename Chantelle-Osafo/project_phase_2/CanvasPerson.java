import java.util.*;

public class CanvasPerson implements CanvasPersonInterface{

    static String email;
    static String password;
    Scanner sc = new Scanner(System.in);


    private String fName;
    private String lName;P
    private String dOB;

    ArrayList<String> emailList = new ArrayList<String>();
    ArrayList<String> adminList = new ArrayList<String>();
    ArrayList<String> passwordList = new ArrayList<String>();
    ArrayList<String> firstName = new ArrayList<String>();
    ArrayList<String> lastName = new ArrayList<String>();
    ArrayList<Integer> yearGroup = new ArrayList<Integer>();
    ArrayList<Float> currentGPA = new ArrayList<Float>();
    ArrayList<String> dateOfBirth = new ArrayList<String>();
    ArrayList<String> facultyList = new ArrayList<String>();
    ArrayList<String> courseCodes = new ArrayList<String>();
    ArrayList<String> courseNames = new ArrayList<String>();


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
            sc.nextLine();

            System.out.println("Please enter your first name: ");
            firstName.add(sc.nextLine());

            System.out.println("Please enter your last name: ");
            lastName.add(sc.nextLine());

            System.out.println("Please enter your year group / role: ");
            yearGroup.add(sc.nextInt());

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


    public boolean isFaculty(){
        System.out.println("Please enter the email address to be checked being faculty: ");
        email = sc.nextLine();
        if (facultyList.contains(email)){
            return true;
        }
        return false;
    }

    public void viewCourses(){
        for (int i = 0; i < courseCodes.size(); i++){
            try {
                System.out.println(i+1 + ". " + courseCodes.get(i) + ": " + courseNames.get(i) + ". Created by " + creatorNames.get(i) + ": " + creatorEmails.get(i));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("This item does not exist. Please try a different input.");
            }
            
        }
    }

    public void setNotificationPreferences(){
        boolean response1, response2, response3;
        System.out.println("Would you like to receive an email when an assignment is posted?");
        response1 = sc.nextBoolean();
        System.out.println("Would you like to receive an email when an assignment is graded?");
        response2 = sc.nextBoolean();
        System.out.println("Would you like to receive an email after successfully registering for a course?");
        response3 = sc.nextBoolean();

        if (response1 == true) {
            System.out.println("You will receive emails for new assignments");
        } else {
            System.out.println("You will not receive emails for new assignments");
        }
        if (response2 == true) {
            System.out.println("You will receive emails for grades posted");
        } else {
            System.out.println("You will not receive emails for grades posted");
        }
        if (response3 == true) {
            System.out.println("You will receive emails for successful course registerations");
        } else {
            System.out.println("You will receive not emails for successful course registerations");
        }
    }

    public void setFirstName(String userFirstName) {
        this.fName = userFirstName;
    }

    public void setLastName(String userLastName) {
        this.lName = userLastName;
    }

    public void setDateOfBirth(String userDateOfBirth) {
        this.dOB = userDateOfBirth;
    }

    public String getFirstName() {
        return this.fName;
    }

    public String getLastName() {
        return this.lName;
    }

    public String getDateOfBirth() {
        return this.dOB;
    }



}