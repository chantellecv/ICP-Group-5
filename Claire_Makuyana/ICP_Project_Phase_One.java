import java.util.Scanner;

public class ICP_Project_Phase_One {


    static String [] emails = {"claire.makuyana@ashesi.edu.gh","george.bush@ashesi.edu.gh","sylvie.lombi@ashesi.edu.gh","luis.mazondi@ashesi.edu.gh","lorraine.makuyana@ashesi.edu.gh"};

    static String [] passwords = {"Book6501","ChaseAsher1507","Chair3412","Luis23445","Guest1234"};



    static String [] administration = {"mateko.collins@ashesi.edu.gh","george.collins@ashesi.edu.gh","brian.greens@ashesi.edu.gh","mills.greens@ashesi.edu.gh","mitchelle.mashingaidze@ashesi.edu.gh"};

    static String [][] admin_profiles = new String [10][7];

    static String[][] profiles = new String [10][7];

    //static String[][] admin_profiles = new String [10][7];


    public static void createAccount(){
        String email;
        String pass;

        for (int i=0;i<5;i++)
        {
            for(int j=0;j<1;)
            {
                email= emails[i];
                profiles[i][j] = email;

                pass = passwords[i];
                j=j+1;

                profiles[i][j] = pass;

                System.out.println("\n\nYour email: "+ email + " and your password: "+ pass + " have been successfully saved");
            }
        }
    }

    public static boolean login(String email, String pass) {

        // fix the true email false password issue later

        int size = profiles.length;
        int logic = 0;
        int compare =0;
        for (int i = 0; i < size; i++) {
            int j = 0;
            String email_iteration = profiles[i][j];
            j = j + 1;
            String pass_iteration = profiles[i][j];


            if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                logic = 1;
                break;
            } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                compare=1;
                break;
            }

        }
        if (logic == 1) {

            System.out.println("\n\nThe user " + email + " exists");
            return true;
        } else if (compare==1) {
            System.out.println("\n\nThe user " + email + " does not exist from the student database because provided details are false ");
            return false;

        } else {
            System.out.println("\n\nThe user " + email + " does not exist from the student database");
            return false;
        }

    }

    public static void updateProfile(String email, String pass, String first_name,
                                     String last_name, String year_group,String gpa,
                                     String dob) {
        login(email, pass);
        int size = profiles.length;
        int i;
        for (i = 0; i < size; i++) {
            int j = 0;
            String email_iteration = profiles[i][j];
            j = j + 1;
            String pass_iteration = profiles[i][j];

            if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                j = j + 1;
                profiles[i][j] = first_name;
                j = j + 1;
                profiles[i][j] = last_name ;
                j = j + 1;
                profiles[i][j] = year_group;
                j = j + 1;
                profiles[i][j] = gpa;
                j = j + 1;
                profiles[i][j] = dob;

            }
        }
    }




    public static void viewProfile(String email,String pass){

        login(email,pass);
        int size = profiles.length;
        int i;
        for (i = 0; i < size; i++) {
            int j = 0;
            String email_iteration = profiles[i][j];
            j = j + 1;
            String pass_iteration = profiles[i][j];


            if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                break;
            }

        }

        for (int k = 0; k < profiles[i].length; k++) {
            String item = profiles[i][k];
            int first_count = k+1;
            if (item==null) {
                profiles[i][k]= "NA";
                System.out.println("\n\nThe profile details of element "+ first_count + " of the profile is: " + item);
                profiles[i][k]=null;
            }else {
                System.out.println("\n\nThe profile details of element " + first_count + " of the profile is: " + item);
            }

        }

    }
    public static boolean isAdmin(String email){

        int size = administration.length;
        int logic = 0;
        for (int i = 0; i < size; i++) {

            String email_iteration = administration[i];



            if (email.equals(email_iteration)) {
                logic = 1;
                break;
            }

        }
        if (logic == 1) {

            System.out.println("\n\nThe user " + email + " exists as an admin from the database");
            return true;
        } else {
            System.out.println("\n\nThe user " + email + " does not exist from the database as an admin");
            return false;
        }
    }

    public static void create_faculty_Account(){
        String email;

        for (int i=0;i<administration.length;i++)
        {
            email= administration[i];
            admin_profiles[i][0] = email;


            System.out.println("\n\nYour email: "+ email + " has been successfully saved");
        }
    }

    public static void makeFaculty(String email,String pass){
        int logic =0;

        if (login(email,pass)==false) {
            if (isAdmin(email)==false) {

                Scanner string_input = new Scanner(System.in);
                System.out.println("\nDo you want to be a faculty member.Use Y/N: \n");
                String response = string_input.next();
                if (response.equals("Y")) {


                    Scanner int_input = new Scanner(System.in);
                    System.out.println("\nIf your above response was y, enter the administration code to proceed the registration process: \n");
                    int code = string_input.nextInt();

                    if (code == 200322022) {
                        int size = admin_profiles.length;
                        int i;
                        for (i = 0; i < size; i++) {

                            String admin_iteration_email = admin_profiles[i][0];
                            String admin_iteration_pass = admin_profiles[i][1];
                            if ((admin_iteration_email == null) && (admin_iteration_pass == null)) {
                                logic = 1;
                                break;
                            }
                        }
                        if (logic == 1) {
                            admin_profiles[i][0] = email;
                            admin_profiles[i][1] = pass;
                            System.out.println("\nThe registration process was successful");
                        }
                    }else {
                        System.out.println("\nThe administration code is incorrect, try again to proceed to the registration process");
                    }

                }
            }
        }

    }
    public static void student_array_elements(){
        for (int i = 0; i < profiles.length; i++) {

            for (int j = 0; j < 7; j++) {

                // Print array element present at index i
                System.out.print(profiles[i][j] + " ");
            }
        }
    }

    public static void admin_array_elements(){
        for (int i = 0; i < administration.length; i++) {

                // Print array element present at index i
                System.out.print("\n"+administration[i] + " \n");
        }

    }

    public static void admin_profiles_array_elements(){
        for (int i = 0; i < admin_profiles.length; i++) {

            for (int j = 0; j < admin_profiles[i].length; j++) {

                // Print array element present at index i
                System.out.print(admin_profiles[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        createAccount();
        create_faculty_Account();
        //login("claire.makuyana@ashesi.edu.gh", "7845623");
        //login("lorraine.makuyana@ashesi.edu.gh", "Guest1234");
        //updateProfile("lorraine.makuyana@ashesi.edu.gh","Guest1234","Lorraine","Makuyana","2022", "3.7","1998");
        //check the profiles array to ensure that all the elements are added to the array
        //updateProfile("asher.chakupa@ashesi.edu.gh","asher3412","Asher","Chakupa","2024","3.9","2000");
        //viewProfile("george.bush@ashesi.edu.gh","ChaseAsher1507");
        //viewProfile("lorraine.makuyana@ashesi.edu.gh", "Guest1234");
        //isAdmin("claire.makuyana@ashesi.edu.gh");
        //isAdmin("mateko.collins@ashesi.edu.gh");
        //makeFaculty("mateko.collins@ashesi.edu.gh","george12345");
        makeFaculty("lorrain.makuyana@ashesi.edu.gh","Guest1234");
        //makeFaculty("adams.family@ashesi.edu.gh","pass1234");

        student_array_elements();
        admin_array_elements();
        admin_profiles_array_elements();
    }


}

