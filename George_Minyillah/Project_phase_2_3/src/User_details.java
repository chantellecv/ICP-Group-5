import java.util.*;
import java.util.Scanner;
import java.util.InputMismatchException;

// creating an interface for the class User_details
interface details_of_users{
    void createAccount();
    boolean login();
    void updateProfile() throws Exception;
    void  viewProfile();
    boolean isAdmin();
    void makeFaculty();
    boolean isFaculty();
    boolean setLoginRequired(boolean value);
    boolean getLoginRequired();

}


public class User_details implements details_of_users {
    Map<String, String> Userdetails = new HashMap<String, String>();
    Map<String, List<String>> profile = new HashMap<String,List<String>>();
    HashSet<String> admin = new HashSet<String>();
    HashSet<String> facultymember = new HashSet<String>();
    Scanner sc = new Scanner(System.in);
    private boolean login_required;


    @Override
    //This function should take the email and password of a user and save it.
    // it asks for the user email and password and then stores it in the Userdeatils hashmap
    public void createAccount() {
        System.out.println("You are about to create an account");
        System.out.println("Enter your email");
        String email = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        Userdetails.put(email, password);
        System.out.println("Account creation successful");
    }

    @Override
    // set the value of login required to true when invoked
    public boolean setLoginRequired(boolean value) {
        this.login_required = true;
        return true;
    }

    @Override
    // gets the value of login required since it is a private global variable and cannot be access by other class
            //encapsulation
    public boolean getLoginRequired() {
        return this.login_required;

    }



    @Override
    public boolean login() {
        // returns True if the user exists
        // and sets the value of login_required to true
        System.out.println("\nLet's get you logged in.");

        System.out.println("Enter your email address:");
        String email = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        if (Userdetails.containsKey(email) && Userdetails.get(email).equals(password)) {
            System.out.println("Logged in successfully. Welcome, " + email );
            setLoginRequired(true);
            return true;
        }
        else {
            System.out.println("Your account doesn't exist.");
            createAccount();
            login_required = false;
            return false;
        }
    }

    @Override
    //This function should take the email of a user and their first name, last name, year group,
    //current GPA, and date of birth, and update their details accordingly.
    // and saves them in the user_profile hashmap
    public void updateProfile() throws Exception {
        if(getLoginRequired() == true){
            List<String> temporary_profile = new ArrayList<String>();
            System.out.println("\nYou are about to edit your details");
            System.out.println("Enter your email address:");
            String email = sc.nextLine();
            System.out.println("Enter your firstname:");
            String firstname = sc.nextLine();
            temporary_profile.add(firstname);
            System.out.println("Enter your lastname:");
            String lastname = sc.nextLine();
            temporary_profile.add(lastname);
            System.out.println("Enter your your year group:");
            String year_group = sc.nextLine();
            temporary_profile.add(year_group);
            System.out.println("Enter your current GPA:");
            String current_GPA = sc.nextLine();
            temporary_profile.add(current_GPA);
            System.out.println("Enter your date of Birth:");
            String dob = sc.nextLine();
            temporary_profile.add(dob);
            profile.put(email,temporary_profile);


        }else {
            login();
        }




    }

    @Override
    // this loops through the profiles hashmap and print's out the user details if only the exist in the database
    public void viewProfile() {
        if(getLoginRequired() == true){
            System.out.println("\nYou are about to view you profile");
            System.out.println("What is your email");
            String email = sc.nextLine();
            if(profile.containsKey(email)){
                System.out.println(profile);
            }else{
                System.out.println("NA");
            }
        }else {
            System.out.println("login required");
            login();
        }

    }

    @Override
    //This function should take the email of a user and return true if user is admin; false
    //otherwise. There should exist a top-level array containing the emails of users who are
    //admins.
            // loops through the isadmin hashset
    public boolean isAdmin() {
        admin.add("dennis.owusu@ashesi.edu.gh");
        admin.add("daniel.nettey@ashesi.edu.gh");
        System.out.println("\nKindly input the email you would like too check if he/she is an admin");
        String email = sc.nextLine();
        if(admin.contains(email)){
            System.out.println("This user is an admin");
            return  true;
        }else{
            System.out.println("This user is not an admin");
            return false;
        }
    }

    @Override
    //This function should take the email of a user and assign the user the role of faculty.
    // user must exist in the database first
    public void makeFaculty() {
        if(getLoginRequired() == true){
            System.out.println("\nWhat is the email of the person you would like to make a faculty member");
            String email = sc.nextLine();
            if(Userdetails.containsKey(email)){
                facultymember.add(email);
            }else{
                System.out.println("User not found");
            }
        }else{
            System.out.println("Login in required");
            login();
        }

    }

    @Override
    //This function should take the email of a user and return true if the user is a faculty member;
    //false otherwise.
    public boolean isFaculty() {
        System.out.println("\nKindly enter the email of the user you would like to check if he/she is a faculty member" +
                " or not");
        String email = sc.nextLine();
        if(facultymember.contains(email)){
            System.out.println("The user is a faculty member");
            return true;
        }else {
            System.out.println("The user is not a faculty member");
            return false;

        }
    }

}
