import java.util.Scanner;
public class Main {
    



    static String [] admin = {"Dennis.owusu@ashesi.edu.gh"};


    static String[][] User_details = new String [7][7];
    static String[][] faculty_members = new String [2][2];




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
                if(g +1 < User_details.length){
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

    public static void updateProfile(String email, String first_name,
                                     String last_name, String year_group,String gpa,
                                     String date_of_birth) {

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
        for(int i = 0; i < User_details.length; i++) {
            for (int j = 0; j < (User_details[i].length / 2) + 1; j++) {
                if (User_details[i][j] == email) {
                    for(int k=0; k < faculty_members.length; k++){
                        if(faculty_members[k][0]==null){
                            User_details[i][0] = faculty_members[k][0];
                            User_details[i][1] = faculty_members[k][1];

                        }
                    }


                }
            }
        }
        System.out.println("you have successful made " + email + " a faulty member");



    }

    public static boolean isFaculty(String email){
        for(int i = 0; i < faculty_members.length; i++) {
                if (faculty_members[i][0] == email) {
                    System.out.println(email + "is a faculty member");
                    return true;
                }else{
                    System.out.println(email + " is not a Faulty member");
                }
            }
        return false;
    }
    public static void main(String[] args) {
//        createAccount("georgeminyillah@gmail.com", "Minyillah1289$");
//        createAccount("george.minyillah@ashesi.edu.gh","Georgemensah0000$£%");
//        updateProfile("georgeminyillah@gmail.com","George", "Minyillah", "2023", "3.85", "10th April 2000");
//        viewProfile("georgeminyillah@gmail.com");
//        viewProfile("george.minyillah@ashesi.edu.gh");
//        isAdmin("georgeminyillah@gmail.com");
//        isAdmin("Dennis.owusu@ashesi.edu.gh");
        makeFaculty("george.minyillah@ashesi.edu.gh");
        isFaculty("george.minyillah@ashesi.edu.gh");
//        for(int z=0; z < User_details.length; z++){
//            for(int y=0; y< User_details.length; y++){
//                System.out.println("User_details[" + z + "][" + y + "] = "
//                        + User_details[z][y]);
//            }
//
//        }
    }


}