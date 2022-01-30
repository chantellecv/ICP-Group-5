import java.util.Scanner;
public class Main {


//    static String [] emails = {};
//
//    static String [] passwords = {};



    static String [] administration = {};

    static String [][] admin_profiles = new String [10][7];

    static String[][] User_details = new String [7][7];


    //static String[][] admin_profiles = new String [10][7];


    public static void createAccount(String email, String password ) {
        int count = 0;
        for (int g = 0; g < User_details.length; g++) {
            if (User_details[count][g] == null) {
                User_details[count][g] = email;
                if(g +1 < User_details.length){
                    User_details[count][g + 1] = password;
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
        count++;
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
                    } else if (User_details[j][i] == email) { //This just slightly increases efficiency
                        valid_email = User_details[i][j];
                        valid_password = User_details[i][j + 1];
                    }

                }

                System.out.println("User not found");
            }
        }
        if (email.equals(valid_email)) {
            if (password.equals(valid_password)) {
                System.out.println("Login successful");
                return true;
            } else {
                System.out.println("Incorrect Credentials");
                return false;
            }
        } else {
            System.out.println("Incorrect Credentials");
            return false;
        }

    }

    public static void updateProfile(String first_name,
                                     String last_name, String year_group,String gpa,
                                     String date_of_birth) {
        for (int a = 0; a < User_details.length; a++) {
            int b = 1;
            b = b + 1;
            User_details[a][b] = first_name;
            b = b + 1;
            User_details[a][b] = last_name ;
            b = b + 1;
            User_details[a][b] = year_group;
            b = b + 1;
            User_details[a][b] = gpa;
            b = b + 1;
            User_details[a][b] = date_of_birth;

        }
    }




    public static void viewProfile(String email){

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
    public static boolean isAdmin(String email){
        System.out.println("This user is an admin");
        return true;
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

    public static void makeFaculty(String email){
        System.out.println("who will you like to make a faulty member");

    }
    public static void main(String[] args) {
        createAccount("georgeminyillah@gmail.com", "Minyillah1289$");
        updateProfile("first_name", "last_name", "year_group", "gpa", "date_of_birth");
        viewProfile("georgeminyillah@gmail.com");

//        for(int z=0; z < User_details.length; z++){
//            for(int y=0; y< User_details.length; y++){
//                System.out.println("User_details[" + z + "][" + y + "] = "
//                        + User_details[z][y]);
//            }
//
//        }
    }


}