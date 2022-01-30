import java.util.*;

public class Phase1 {

    // global data stores
    public static HashMap<String, String> userAccounts = new HashMap <String, String>();
    public static HashSet <String> activeSession = new HashSet <String>();
    public static HashMap<String, List<String>> userProfile = new HashMap<String, List<String>>();
    public static HashSet <String> adminUsers = new HashSet <String>();
    public static HashSet <String> facultyMembers = new HashSet <String>();

    public static void main(String[] args) {
        System.out.println("Welcome to Kenneth's Canvas - Phase 1.");

        Scanner input = new Scanner(System.in);
        createAccount();

        if (login() == true) {
            System.out.println("Yes! You're logged in.");
        } else {
            System.out.println("Login failed.");
        }

        // Update Profile Function
        int firstloop = 0;
        while (firstloop < 3) {
            System.out.println("Do you want to update your profile? (y/n)");
            String answer = input.next();
            if (answer.equals("y")) {
                firstloop = 7;
                updateProfile();
            } else if (answer.equals("n")) {
                firstloop = 7;
                System.out.println("Sure thing.");
            } else {
                System.out.println("Your input should be 'y' or 'n'.");
            }
        }

        // View Profile function
        int loop = 0;
        while (loop < 3) {
            System.out.println("Do you want to view your profile? (y/n)");
            String answer = input.next();
            if (answer.equals("y")) {
                loop = 7;
                viewProfile();
            } else if (answer.equals("n")) {
                loop = 7;
                System.out.println("Understandable. Have a nice day.");
            } else {
                System.out.println("Your input should be 'y' or 'n'.");
            }
        }


        //isAdmin();
        //makeFaculty();
        //isFaculty();
    }

    public static void createAccount() {
        // saves user's email and password
        System.out.println("Create your account.");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your desired email address below:");
        String email = input.nextLine();
        System.out.println("Set a secure password:");
        String password = input.nextLine();

        userAccounts.put(email, password);
        System.out.println("Your account has been created.");
    }

    public static boolean login() {
        // returns True if the user exists
        System.out.println("Let's get you logged in.");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your email address:");
        String email = input.nextLine();
        System.out.println("Enter your password:");
        String password = input.nextLine();

        if (userAccounts.containsKey(email) && userAccounts.get(email).equals(password)) {
            //System.out.println("Logged in successfully. Welcome, " + email);
            activeSession.add(email);
            return true;
        }
        else {
            //System.out.println("Your account doesn't exist.");
            return false;
        }
    }

    public static void updateProfile() {
        // first & last name, year group, Current GPA, date of birth
        Scanner input = new Scanner(System.in);

        // creating the profile list
        List<String> profile = new ArrayList<String>();

        // updating the profile list
        System.out.println("What's your first name?");
        String fname = input.nextLine();
        profile.add(fname);

        System.out.println("How about your last name?");
        String lname  = input.nextLine();
        profile.add(lname);

        System.out.println("Your year group?");
        String ygroup = input.nextLine();
        profile.add(ygroup);

        System.out.println("Almost done. Your current GPA?");
        String cgpa = input.nextLine();
        profile.add(cgpa);

        System.out.println("Last question. When were you born?");
        String bday = input.nextLine();
        profile.add(bday);

        // email collection
        System.out.println("Okay, THIS is the last question. Now what's your email?");
        String email = input.nextLine();

        userProfile.put(email, profile);
        System.out.println("Your profile has been updated.");
    }

    public static void viewProfile() {
        System.out.println("So you want to view your profile.");
        Scanner input = new Scanner(System.in);
        System.out.println("What's your sign-up email?");
        String email = input.nextLine();

        if (userProfile.containsKey(email)) {
            System.out.println(userProfile);
        }
        else {
            System.out.println("NA");
        }
    }

    public static boolean isAdmin() {
        System.out.println("Let's check if you're an admin.");
        Scanner input = new Scanner(System.in);
        System.out.println("Give me your email address. NOW!");
        String email = input.nextLine();

        // test with 'admin@admin.com'
        adminUsers.add("admin@admin.com");

        if (adminUsers.contains(email)) {
            System.out.println("You're an admin!");
            return true;
        } else {
            System.out.println("You're not an admin.");
            return false;
        }
    }

    public static void makeFaculty() {
        System.out.println("So you want to be faculty.");
        Scanner input = new Scanner(System.in);
        System.out.println("Well whatchu waitin' for?? Your email, type it down.");
        String email = input.nextLine();

        facultyMembers.add(email);
        System.out.println("All done. We're proud of you!");
    }

    public static boolean isFaculty() {
        System.out.println("Let's check if you're faculty.");
        Scanner input = new Scanner(System.in);
        System.out.println("Your email address, please.");
        String email = input.nextLine();

        if (facultyMembers.contains(email)) {
            System.out.println("You're faculty!");
            return true;
        } else {
            System.out.println("You're.. unemployed?");
            return false;
        }
    }

}