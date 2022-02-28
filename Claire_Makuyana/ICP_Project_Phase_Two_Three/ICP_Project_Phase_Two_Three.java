package ICP_Project_Phase_Two_Three;

import java.util.Objects;
import java.util.Scanner;

class ICP_Project_Phase_Two_Three {

    static String[] emails = {"claire.makuyana@ashesi.edu.gh", "george.bush@ashesi.edu.gh", "sylvie.lombi@ashesi.edu.gh", "luis.mazondi@ashesi.edu.gh", "lorraine.makuyana@ashesi.edu.gh"};

    static String[] passwords = {"Book6501", "ChaseAsher1507", "Chair3412", "Luis23445", "Guest1234"};

    static String[][] profiles = new String[5][7];

    public void createAccount() {
        //Change part of the code such that a user can input their email and password and add it to the email and password arrays
        String email;
        String pass;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; ) {
                email = emails[i];
                profiles[i][j] = email;

                pass = passwords[i];
                j = j + 1;

                profiles[i][j] = pass;

                System.out.println("\n\nYour email: " + email + " and your password: " + pass + " have been successfully saved");
            }
        }
    }


    public static class Req_One {


        public boolean login(String email, String pass) {


            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\nThe user " + email + " exists from the student database");
                return true;
            } else if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;

            } else {
                System.out.println("\nThe user " + email + " does not exist from the student database.");
                return false;
            }

        }

    }

    public static class Req_Two{

        private String[] administration = {"mateko.collins@ashesi.edu.gh", "george.collins@ashesi.edu.gh", "brian.greens@ashesi.edu.gh", "mills.greens@ashesi.edu.gh", "mitchelle.mashingaidze@ashesi.edu.gh"};



        public boolean login(String email, String pass) {

            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\nThe user " + email + " exists in the student database.");
                return true;
            } else if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;

            } else {
                System.out.println("\nThe user " + email + " does not exist from the student database.\nThey might be an administration member.");
                return false;
            }

        }


        public boolean isAdmin(String email) {

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


    }

    public static class Req_Three{

        private String[][] faculty_profiles = new String[3][7];

        public boolean login(String email, String pass) {
            // to attain polymorphism, the login method is being implemented differently in each class

            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\nThe user " + email + " exists from the student database.");
                return true;
            } else if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;

            } else {
                System.out.println("\nThe user " + email + " does not exist from the student database.\n They might be a faculty member.");
                return false;
            }

        }


        public boolean isFaculty(String email) {
            int size = faculty_profiles.length;
            int logic = 0;
            for (int i = 0; i < size; i++) {

                String email_iteration = faculty_profiles[i][0];

                if (email.equals(email_iteration)) {
                    logic = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\n\nThe user " + email + " exists as a faculty member from the database");
                return true;
            } else {
                System.out.println("\n\nThe user " + email + " does not exist from the database as a faculty member");
                return false;
            }

        }
    }

    public static class Profile implements profile {

        public boolean login(String email, String pass) {


            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }

            if (logic == 1) {

                System.out.println("\nThe user " + email + " exists from the student database.");
                return true;
            } else if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;

            }else {
                System.out.println("\nThe user " + email + " does not exist from the student database.");
                return false;
            }

        }

        public void updateProfile(String email, String pass, String first_name,
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

        public void viewProfile(String email,String pass){

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
                    System.out.println("\n\nThe profile details of element "+ first_count + " of the profile is: " + profiles[i][k]);
                    profiles[i][k]=null;
                }else {
                    System.out.println("\n\nThe profile details of element " + first_count + " of the profile is: " + item);
                }

            }

        }

    }



    public static class Course implements course{
        private String[] administration = {"mateko.collins@ashesi.edu.gh", "george.collins@ashesi.edu.gh", "brian.greens@ashesi.edu.gh", "mills.greens@ashesi.edu.gh", "mitchelle.mashingaidze@ashesi.edu.gh"};

        private String [] course_codes_names ={"Multivariable Calculus","Leadership III","Data Structures"};

        private String[] course_names = {"Eng 112", "Eng 221", "112"};

        private String[][] faculty_profiles = new String[3][7];

        private String[] course_creators = new String[3];

        private String[][] students_courses = new String[3][5];

        public boolean login(String email, String pass) {

            // to attain polymorphism, the login method is being implemented differently in each class that inherits interface req_Three

            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }

            if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;
            }else if (logic == 1) {

                System.out.println("\nThe user " + email + " exists from the student database.");
                return true;


            }else {
                System.out.println("\nThe user " + email + " does not exist from the student database.\nThey might be a faculty member.");
                return false;
            }

        }

        public boolean isAdmin(String email) {

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

        public void makeFaculty(String email,String pass,String name){
            int logic =0;

            if (!login(email, pass)) {//(login(email,pass)==false)
                if (!isAdmin(email)) {//(isAdmin(email)==false)

                    Scanner string_input = new Scanner(System.in);
                    System.out.println("\nDo you want to be a faculty member.Use Y/N: \n");
                    String response = string_input.next();
                    if (response.equals("Y")) {


                        Scanner int_input = new Scanner(System.in);
                        System.out.println("\nIf your above response was y, enter the administration code to proceed the registration process: \n");
                        int code = int_input.nextInt();

                        if (code == 200322022) {
                            int size = faculty_profiles.length;
                            int i;
                            for (i = 0; i < size; i++) {

                                String admin_iteration_email = faculty_profiles[i][0];
                                String admin_iteration_name = faculty_profiles[i][1];
                                if ((admin_iteration_email == null) && (admin_iteration_name == null)) {
                                    logic = 1;
                                    break;
                                }
                            }
                            if (logic == 1) {
                                faculty_profiles[i][0] = email;
                                faculty_profiles[i][1] = name;
                                System.out.println("\nThe registration process was successful");
                            }
                        }else {
                            System.out.println("\nThe administration code is incorrect, try again to proceed to the registration process");
                        }

                    }
                }
            }

        }

        public boolean isFaculty(String email) {
            int size = faculty_profiles.length;
            int logic = 0;
            for (int i = 0; i < size; i++) {

                String email_iteration = faculty_profiles[i][0];

                if (email.equals(email_iteration)) {
                    logic = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\n\nThe user " + email + " exists as a faculty member from the database");
                return true;
            } else {
                System.out.println("\n\nThe user " + email + " does not exist from the database as a faculty member");
                return false;
            }

        }

        public void createCourse( String email, String pass,String code,
                                  String course_name){
            int logic=0;
            if(!login(email, pass)){
                if(isFaculty(email)) {
                    for (int i = 0; i < faculty_profiles.length; i++) {
                        String faculty_iteration = faculty_profiles[i][0];

                        if (Objects.equals(faculty_iteration,email)) {
                            int j;
                            for(j=0;j< faculty_profiles[i].length;j++) {
                                String intext_faculty_iteration = faculty_profiles[i][j];
                                if (intext_faculty_iteration == null) {
                                    logic =1;
                                    break;
                                }
                            }
                            if(logic==1){
                                String item = course_name + "-" + code;
                                faculty_profiles[i][j] =item;
                                course_creators[i]=email;
                                System.out.println("\nCongratulations " + email + " you have successfully created the " + course_name + " course with a course code of " +code + "\n");
                            }
                        }

                    }

                } else{
                    System.out.println("You cannot create a course because your details are not in the faculty database");
                }
            }else{
                System.out.println("You cannot create a course because you are a student");
            }
        }
        public void viewCourses(){
            for (int i = 0; i < faculty_profiles.length; i++) {

                for (int j = 0; j < faculty_profiles[i].length; j++) {

                    // Print array element present at index i
                    System.out.print(faculty_profiles[i][j] + ", ");
                }
            }
        }

        public void registerCourse(String first_name, String last_name,String email,String pass,String course_code){
            int logic=0;
            if(login(email, pass)){

                for(int i=0; i < course_names.length; i++){

                    String code_iteration=course_names[i];

                    if(code_iteration.equals(course_code)){

                        int j;
                        for (j = 0; j < students_courses[i].length; j++) {
                            String students_courses_iteration = students_courses[i][j];
                            if(students_courses_iteration == null){

                                logic = 1;
                                break;
                            }
                        }
                        if(logic==1){
                            String item = first_name+" - "+last_name+" - "+email;
                            students_courses[i][j]=item;
                            System.out.println("Congratulations "+ email + " you have been successfully added to the course "+ course_code + " \n");
                        }
                    }
                }
            } else {
                System.out.println("Unauthorized registration because you are not a student");
            }

        }

        public void viewCourseByCode(String course_code){
            int null_counter=0;
            int logic=0;
            int i;
            for (i = 0; i < students_courses.length; i++){

                String course_code_iteration = course_names[i];
                if(Objects.equals(course_code_iteration, course_code)) {
                    logic = 1;


                    for (int j = 0; j < students_courses[i].length; j++) {

                        if(students_courses[i][j]!=null) {

                            // Print array element present at index j
                            int count=j+1;
                            System.out.print("\nStudent number " + count + " in the " + course_code + " class is " + students_courses[i][j] + "\n ");
                        }else{
                            null_counter = null_counter +1;
                        }
                    }
                }
            }
            if (logic==0){
                System.out.println("The course code you entered does not exist in our database");
            }else if(null_counter==10){
                System.out.println("The course "+ course_code +" does not have students yet");
            }

        }

        public void viewCoursesByEmail(String first_name,String last_name,String email){
            //modify the function to take email only

            int logic=0;
            int count=0;
            int i;
            for (i = 0; i < students_courses.length; i++){

                for(int j=0; j< students_courses[i].length;j++){

                    String item = first_name+" - "+last_name+" - "+email;


                    if(Objects.equals(students_courses[i][j], item)){

                        logic=1;
                        String course = course_codes_names[i];
                        count = count+1;
                        System.out.print("\n"+email+"'s course number " + count + " is: "+ course +" with a course code of "+ course_names[i] +"\n");


                    }
                }

            }
            if(logic==0){
                System.out.println("\nThe user "+ email+" is not registered in any courses yet\n");
            }
        }
    }


    public static class Assignment implements assignment{

        private String[] administration = {"mateko.collins@ashesi.edu.gh", "george.collins@ashesi.edu.gh", "brian.greens@ashesi.edu.gh", "mills.greens@ashesi.edu.gh", "mitchelle.mashingaidze@ashesi.edu.gh"};

        private String[] course_names = {"Eng 112", "Eng 221", "112"};

        private String[] course_creators = new String[3];

        private String[][] faculty_profiles = new String[3][7];

        private String[][] students_courses = new String[3][5];

        private String[][] students_courses_assignments_MC = new String [4][3];

        private String[][] students_courses_assignments_leadership = new String [4][3];

        private String[][] students_courses_assignments_DS = new String [4][3];

        private String[][] students_submitted_assignments_MC = new String [20][4];

        private String[][] students_submitted_assignments_leadership = new String [20][4];

        private String[][] students_submitted_assignments_DS = new String [20][4];

        public boolean login(String email, String pass) {

            // to attain polymorphism, the login method is being implemented differently in each class that inherits interface req_Three

            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }
           if (logic == 1) {

                System.out.println("\nThe user " + email + " exists from the student database.");
                return true;
            } else if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;

            } else {
                System.out.println("\nThe user " + email + " does not exist from the student database.\nThey might be a faculty member.");
                return false;
            }


        }

        public boolean isAdmin(String email) {

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

        public void makeFaculty(String email,String pass,String name){
            int logic =0;

            if (!login(email, pass)) {//(login(email,pass)==false)
                if (!isAdmin(email)) {//(isAdmin(email)==false)

                    Scanner string_input = new Scanner(System.in);
                    System.out.println("\nDo you want to be a faculty member.Use Y/N: \n");
                    String response = string_input.next();
                    if (response.equals("Y")) {


                        Scanner int_input = new Scanner(System.in);
                        System.out.println("\nIf your above response was y, enter the administration code to proceed the registration process: \n");
                        int code = int_input.nextInt();

                        if (code == 200322022) {
                            int size = faculty_profiles.length;
                            int i;
                            for (i = 0; i < size; i++) {

                                String admin_iteration_email = faculty_profiles[i][0];
                                String admin_iteration_name = faculty_profiles[i][1];
                                if ((admin_iteration_email == null) && (admin_iteration_name == null)) {
                                    logic = 1;
                                    break;
                                }
                            }
                            if (logic == 1) {
                                faculty_profiles[i][0] = email;
                                faculty_profiles[i][1] = name;
                                System.out.println("\nThe registration process was successful");
                            }
                        }else {
                            System.out.println("\nThe administration code is incorrect, try again to proceed to the registration process");
                        }

                    }
                }
            }

        }



        public boolean isFaculty(String email) {
            int size = faculty_profiles.length;
            int logic = 0;
            for (int i = 0; i < size; i++) {

                String email_iteration = faculty_profiles[i][0];

                if (email.equals(email_iteration)) {
                    logic = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\n\nThe user " + email + " exists as a faculty member from the database");
                return true;
            } else {
                System.out.println("\n\nThe user " + email + " does not exist from the database as a faculty member");
                return false;
            }

        }

        public void addAssignment(String email,String pass,String course_code,
                                  String assignment_number,String description,
                                  String due_date, String assignment_name){

            int logic=0;
            if(!login(email, pass)){
                if(isFaculty(email)) {

                    for (int i = 0; i < course_names.length; i++) {


                        String course_creator_iteration = course_creators[i];
                        if (course_code.equals("Eng 112") && course_creator_iteration.equals(email)) {//checking if the email and course code details provided are correct or not

                            for (int j = 0; j < students_courses_assignments_MC[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };


                                students_courses_assignments_MC[index][j] = assignment_number;
                                logic = 1;

                            }
                        }else if(course_code.equals("Eng 221") && course_creator_iteration.equals(email)) {

                            for (int j = 0; j < students_courses_assignments_leadership[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };

                                students_courses_assignments_leadership[index][j] = assignment_number;
                                logic = 1;

                            }
                        }else if (course_code.equals("112") && course_creator_iteration.equals(email)) {

                            for (int j = 0; j < students_courses_assignments_DS[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };

                                students_courses_assignments_leadership[index][j] = assignment_number;
                                logic = 1;

                            }

                        }
                        if (logic == 1) {

                            System.out.println("\nCongratulations " + email + " you have successfully added " + assignment_number + " that is due on " + due_date + "\n. The assignment description is " + description + " \n.");
                        }
                    }
                } else {
                    System.out.println("\nYou cannot add an assignment to the course database because you are not a faculty member\n");
                }
            } else {
                System.out.println("\nYou cannot add an assignment to the course database because you are a student\n");
            }
        }

        public void viewAssignmentsByCourse(String course_code) {

            int null_counter = 0;
            int code = 0;

            if (Objects.equals("Eng 112", course_code)) {

                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;


                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;


                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }


            } else if (Objects.equals("Eng 221", course_code)) {

                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }

            } else if (Objects.equals("112", course_code)) {
                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }


            }

            if (code==0){
                System.out.println("The course code you entered does not exist in our database");
            }else if(null_counter==3){
                System.out.println("The course "+ course_code +" does not have any assignments posted yet");
            }

        }

        public void viewAssignmentsByEmail(String email,String first_name,String last_name){
            //let's keep pending optional for now till we figure out how to implement it
            //modify the function to take email only

            int logic=0;
            int index=0;
            int i;
            for (i = 0; i < students_courses.length; i++) {
                for (int j = 0; j < students_courses[i].length; j++) {

                    String item = first_name + " - " + last_name + " - " + email;
                    if (Objects.equals(students_courses[i][j], item)) {
                        index = i;
                        logic = 1;
                    }
                }
            }
            for(int k=0;k<4;k++) {

                if (index == 0) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i
                        System.out.print("\n" + email + "'s assignment for Multivariable Calculus is: " + students_courses_assignments_MC[k][m] + " \n");
                    }
                } else if (index == 1) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i

                        System.out.print("\n" + email + "'s assignment for Leadership III is: " + students_courses_assignments_leadership[k][m] + " \n");
                    }


                } else if (index == 2) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i

                        System.out.print("\n" + email + "'s assignment for Data Structures is: " + students_courses_assignments_DS[k][m] + " \n");
                    }
                }
            }
            if(logic==0){
                System.out.println("\nThe user "+ email+" is not registered in any courses yet\n");
            }
        }

        public void submitAssignment(String first_name,String last_name,String email,String pass,
                                     String course_code,String assignment_name,String assignment_number,String submission){
            int interior_logic=0;

            if(login(email,pass)){
                for(int i=0;i<course_names.length;i++){
                    label:
                    for (int j = 0; j < students_courses[i].length; j++) {
                        String students_iteration = students_courses[i][j];
                        String student = first_name + " - " + last_name + " - " + email;

                        if (Objects.equals(students_iteration, student)) {

                            //to ensure that the index of the registered student links with his/ her submitted assignments
                            switch (course_code) {
                                case "Eng 112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }

                                }
                                case "Eng 221" -> {

                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;

                                    }
                                }
                                case "112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;

                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }
                                }
                                default -> System.out.println("\nIncorrect course code details provided\n");
                            }
                        }
                    }

                }
            }
            if(interior_logic==0){
                System.out.println("\nThe assignment name provided is incorrect because it is not found in the assignments' database\n");

            } else{
                System.out.println("\n"+email+" you cannot submit an assignment because you are not a student\n");
            }
        }

        public void viewSubmissions(String email,String pass,String course_code,String assignment_name){

            int logic=0;
            int counter;
            if(!login(email,pass)&&isFaculty(email)) {
                if(course_code.equals("Eng 112") && email.equals("laura.price@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                } else if(course_code.equals("Eng 221") && email.equals("jude.law@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                } else if(course_code.equals("112") && email.equals("adams.family@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                }
            }
            if(logic==0){
                System.out.println("\nIncorrect course code or course creator\n");

            }


        }

    }

    public static class Assignment_Score implements assignmentScore {
        private String[] administration = {"mateko.collins@ashesi.edu.gh", "george.collins@ashesi.edu.gh", "brian.greens@ashesi.edu.gh", "mills.greens@ashesi.edu.gh", "mitchelle.mashingaidze@ashesi.edu.gh"};

        private String[] course_names = {"Eng 112", "Eng 221", "112"};

        private String[][] faculty_profiles = new String[3][7];

        private String[][] students_courses = new String[3][5];

        private String[] course_creators = new String[3];

        private String[][] students_courses_assignments_MC = new String [4][3];

        private String[][] students_courses_assignments_leadership = new String [4][3];

        private String[][] students_courses_assignments_DS = new String [4][3];

        private String[][] students_submitted_assignments_MC = new String [20][4];

        private String[][] students_submitted_assignments_leadership = new String [20][4];

        private String[][] students_submitted_assignments_DS = new String [20][4];

        private String[][] students_submitted_assignments_scores_MC = new String [20][4];

        private String[][] students_submitted_assignments_scores_leadership = new String [20][4];

        private String[][] students_submitted_assignments_scores_DS = new String [20][4];

        public boolean login(String email, String pass) {

            // to attain polymorphism, the login method is being implemented differently in each class that inherits interface req_Three

            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }
            if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;
            }else if (logic == 1) {

                System.out.println("\nThe user " + email + " exists from the student database.");
                return true;


            }else {
                System.out.println("\nThe user " + email + " does not exist from the student database.\nThey might be a faculty member.");
                return false;
            }

        }


        public boolean isAdmin(String email) {

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

        public void makeFaculty(String email,String pass,String name){
            int logic =0;

            if (!login(email, pass)) {//(login(email,pass)==false)
                if (!isAdmin(email)) {//(isAdmin(email)==false)

                    Scanner string_input = new Scanner(System.in);
                    System.out.println("\nDo you want to be a faculty member.Use Y/N: \n");
                    String response = string_input.next();
                    if (response.equals("Y")) {


                        Scanner int_input = new Scanner(System.in);
                        System.out.println("\nIf your above response was y, enter the administration code to proceed the registration process: \n");
                        int code = int_input.nextInt();

                        if (code == 200322022) {
                            int size = faculty_profiles.length;
                            int i;
                            for (i = 0; i < size; i++) {

                                String admin_iteration_email = faculty_profiles[i][0];
                                String admin_iteration_name = faculty_profiles[i][1];
                                if ((admin_iteration_email == null) && (admin_iteration_name == null)) {
                                    logic = 1;
                                    break;
                                }
                            }
                            if (logic == 1) {
                                faculty_profiles[i][0] = email;
                                faculty_profiles[i][1] = name;
                                System.out.println("\nThe registration process was successful");
                            }
                        }else {
                            System.out.println("\nThe administration code is incorrect, try again to proceed to the registration process");
                        }

                    }
                }
            }

        }

        public boolean isFaculty(String email) {
            int size = faculty_profiles.length;
            int logic = 0;
            for (int i = 0; i < size; i++) {

                String email_iteration = faculty_profiles[i][0];

                if (email.equals(email_iteration)) {
                    logic = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\n\nThe user " + email + " exists as a faculty member from the database");
                return true;
            } else {
                System.out.println("\n\nThe user " + email + " does not exist from the database as a faculty member");
                return false;
            }

        }

        public void addAssignment(String email,String pass,String course_code,
                                  String assignment_number,String description,
                                  String due_date, String assignment_name){

            int logic=0;
            if(!login(email, pass)){
                if(isFaculty(email)) {

                    for (int i = 0; i < course_names.length; i++) {


                        String course_creator_iteration = course_creators[i];
                        if (course_code.equals("Eng 112") && course_creator_iteration.equals(email)) {//checking if the email and course code details provided are correct or not

                            for (int j = 0; j < students_courses_assignments_MC[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };


                                students_courses_assignments_MC[index][j] = assignment_number;
                                logic = 1;

                            }
                        }else if(course_code.equals("Eng 221") && course_creator_iteration.equals(email)) {

                            for (int j = 0; j < students_courses_assignments_leadership[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };

                                students_courses_assignments_leadership[index][j] = assignment_number;
                                logic = 1;

                            }
                        }else if (course_code.equals("112") && course_creator_iteration.equals(email)) {

                            for (int j = 0; j < students_courses_assignments_DS[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };

                                students_courses_assignments_leadership[index][j] = assignment_number;
                                logic = 1;

                            }

                        }
                        if (logic == 1) {

                            System.out.println("\nCongratulations " + email + " you have successfully added " + assignment_number + " that is due on " + due_date + "\n. The assignment description is " + description + " \n.");
                        }
                    }
                } else {
                    System.out.println("\nYou cannot add an assignment to the course database because you are not a faculty member\n");
                }
            } else {
                System.out.println("\nYou cannot add an assignment to the course database because you are a student\n");
            }
        }

        public void viewAssignmentsByCourse(String course_code) {

            int null_counter = 0;
            int code = 0;

            if (Objects.equals("Eng 112", course_code)) {

                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;


                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;


                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }


            } else if (Objects.equals("Eng 221", course_code)) {

                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }

            } else if (Objects.equals("112", course_code)) {
                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }


            }

            if (code==0){
                System.out.println("The course code you entered does not exist in our database");
            }else if(null_counter==3){
                System.out.println("The course "+ course_code +" does not have any assignments posted yet");
            }

        }

        public void viewAssignmentsByEmail(String email,String first_name,String last_name){
            //let's keep pending optional for now till we figure out how to implement it
            //modify the function to take email only

            int logic=0;
            int index=0;
            int i;
            for (i = 0; i < students_courses.length; i++) {
                for (int j = 0; j < students_courses[i].length; j++) {

                    String item = first_name + " - " + last_name + " - " + email;
                    if (Objects.equals(students_courses[i][j], item)) {
                        index = i;
                        logic = 1;
                    }
                }
            }
            for(int k=0;k<4;k++) {

                if (index == 0) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i
                        System.out.print("\n" + email + "'s assignment for Multivariable Calculus is: " + students_courses_assignments_MC[k][m] + " \n");
                    }
                } else if (index == 1) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i

                        System.out.print("\n" + email + "'s assignment for Leadership III is: " + students_courses_assignments_leadership[k][m] + " \n");
                    }


                } else if (index == 2) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i

                        System.out.print("\n" + email + "'s assignment for Data Structures is: " + students_courses_assignments_DS[k][m] + " \n");
                    }
                }
            }
            if(logic==0){
                System.out.println("\nThe user "+ email+" is not registered in any courses yet\n");
            }
        }

        public void submitAssignment(String first_name,String last_name,String email,String pass,
                                     String course_code,String assignment_name,String assignment_number,String submission){
            int interior_logic=0;

            if(login(email,pass)){
                for(int i=0;i<course_names.length;i++){
                    label:
                    for (int j = 0; j < students_courses[i].length; j++) {
                        String students_iteration = students_courses[i][j];
                        String student = first_name + " - " + last_name + " - " + email;

                        if (Objects.equals(students_iteration, student)) {

                            //to ensure that the index of the registered student links with his/ her submitted assignments
                            switch (course_code) {
                                case "Eng 112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }

                                }
                                case "Eng 221" -> {

                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;

                                    }
                                }
                                case "112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;

                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }
                                }
                                default -> System.out.println("\nIncorrect course code details provided\n");
                            }
                        }
                    }

                }
            }
            if(interior_logic==0){
                System.out.println("\nThe assignment name provided is incorrect because it is not found in the assignments' database\n");

            } else{
                System.out.println("\n"+email+" you cannot submit an assignment because you are not a student\n");
            }
        }

        public void viewSubmissions(String email,String pass,String course_code,String assignment_name){

            int logic=0;
            int counter;
            if(!login(email,pass)&&isFaculty(email)) {
                if(course_code.equals("Eng 112") && email.equals("laura.price@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                } else if(course_code.equals("Eng 221") && email.equals("jude.law@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                } else if(course_code.equals("112") && email.equals("adams.family@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                }
            }
            if(logic==0){
                System.out.println("\nIncorrect course code or course creator\n");

            }


        }

        public void scoreAssignment( String faculty_email,String faculty_pass,String course_code,
                                     String assignment_name,String assignment_number, String student_email,
                                     String first_name, String last_name, String score){

            if(!login(faculty_email,faculty_pass)==isFaculty(faculty_email)){

                for(int i=0;i<course_names.length;i++){
                    label:
                    for (int j = 0; j < students_courses[i].length; j++) {
                        String students_iteration = students_courses[i][j];
                        String student = first_name + " - " + last_name + " - " + student_email;

                        if (Objects.equals(students_iteration, student)) {
                            //to ensure that the index of the registered student links with his/ her submitted assignments
                            switch (course_code) {
                                case "Eng 112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_scores_MC[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_scores_MC[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored homework: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_scores_MC[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored project: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_scores_MC[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored exam: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                    }

                                }
                                case "Eng 221" -> {

                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_scores_leadership[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_scores_leadership[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored homework: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_scores_leadership[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored project: " + assignment_number +  ":"+ score + "\n");

                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_scores_leadership[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;

                                    }
                                }
                                case "112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;

                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_scores_DS[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_scores_DS[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_scores_DS[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_scores_DS[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                    }
                                }
                                default -> System.out.println("\nIncorrect course code details provided\n");
                            }
                        }else{
                            System.out.println("\nThe student does not exist in the student database\n");
                        }
                    }

                }

            }

        }
        public void viewAssignmentScore(String email, String pass,String first_name,String last_name, String course_code,String assignment_name,String assignment_number) {

            int interior_logic=0;

            if(login(email,pass)){
                for(int i=0;i<course_names.length;i++){
                    label:
                    for (int j = 0; j < students_courses[i].length; j++) {
                        String students_iteration = students_courses[i][j];
                        String student = first_name + " - " + last_name + " - " + email;

                        if (Objects.equals(students_iteration, student)) {

                            //to ensure that the index of the registered student links with his/ her submitted assignments
                            switch (course_code) {
                                case "Eng 112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    String score;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            score=students_submitted_assignments_scores_MC[index][k];
                                            System.out.println("\nHello "+ email + " your score for Quiz: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            score =students_submitted_assignments_scores_MC[index][k];
                                            System.out.println("\nHello "+ email + " your score for Homework: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            score =students_submitted_assignments_scores_MC[index][k];
                                            System.out.println("\nHello "+ email + " your score for Project: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            score =students_submitted_assignments_scores_MC[index][k];
                                            System.out.println("\nHello "+ email + " your score for Quiz: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }

                                }
                                case "Eng 221" -> {

                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    String score;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            score =students_submitted_assignments_scores_leadership[index][k];
                                            System.out.println("\nHello "+ email + " your score for Quiz: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            score =students_submitted_assignments_scores_leadership[index][k];
                                            System.out.println("\nHello "+ email + " your score for Homework: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            score =students_submitted_assignments_scores_leadership[index][k];
                                            System.out.println("\nHello "+ email + " your score for Project: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            score =students_submitted_assignments_scores_leadership[index][k];
                                            System.out.println("\nHello "+ email + " your score for Exam: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;

                                    }
                                }
                                case "112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    String score;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            score =students_submitted_assignments_scores_DS[index][k];
                                            System.out.println("\nHello "+ email + " your score for Quiz: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            score =students_submitted_assignments_scores_DS[index][k];
                                            System.out.println("\nHello "+ email + " your score for Homework: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            score =students_submitted_assignments_scores_DS[index][k];
                                            System.out.println("\nHello "+ email + " your score for Project: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            score =students_submitted_assignments_scores_DS[index][k];
                                            System.out.println("\nHello "+ email + " your score for Exam: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }
                                }
                                default -> System.out.println("\nIncorrect course code details provided\n");
                            }
                        }
                    }

                }
            }
            if(interior_logic==0){
                System.out.println("\nThe assignment name provided is incorrect because it is not found in the assignments' database\n");

            } else{
                System.out.println("\n"+email+" you cannot view an assignment score because you are not a student\n");
            }
        }

    }

    /**
    public static void viewAssignmentScores(String email,String pass,String course_code,String assignment_number,String assignment_type){
        int logic = 0;
        int login_code=0;
        int code = 0;
        if (!login(email, pass)==isFaculty(email)) {
            login_code=1;
            System.out.println("one");
            for (int i = 0; i < students_courses_assignments.length; i++) {
                if (Objects.equals(course_names[i], course_code)&& Objects.equals(course_creators[i], email)) {//course creator
                    System.out.println("two");
                    code = 1;

                    for (int j = 0; j < students_submitted_assignments[i].length; j++) {

                        int index = 0;
                        if (assignment_type.equals("Quiz")) {
                            index = j*4;
                        } else if (assignment_type.equals("Homework")) {
                            index = (j*4)+1;
                        } else if (assignment_type.equals("Project")) {
                            index = (j*4)+2;
                        } else if (assignment_type.equals("Exam")) {
                            index = (j*4)+3;
                        }

                        if (Integer.parseInt(assignment_number)<=5) {
                            System.out.println("three");
                            logic = 1;

                            int position =Integer.parseInt(assignment_number)-1;
                            String score = students_actual_scores[index][position];
                            System.out.println("\nThe scoring details for " + email + " are: " + score + " \n");
                            break;
                        }


                    }
                }

            }
        }
        if(code==0){

            System.out.println("\nIncorrect code entered\n");
        }else if(logic==0){
            System.out.println("\nIncorrect assignment name\n");
        }else if(login_code==0){
            System.out.println("\nCannot view student scores because you are not a student\n");
        }
    }

    public static void viewALLAssignmentScores(String email,String pass,String first_name,String last_name,String course_code){

        int logic=0;
        if(login(email,pass)){
            for(int i=0;i< students_submitted_assignments_scores.length;i++) {
                String code=course_names[i];
                if (course_code.equals(code)){
                    logic=1;
                    for(int j=0;j< students_submitted_assignments[i].length;j++){
                        String item = students_courses[i][j];
                        String student = first_name + " - " + last_name + " - " + email;
                        if(student.equals(item)) {
                            for (int k = 0; k < students_submitted_assignments[i][j].length; k++) {
                                String index =null;
                                if(k==0){
                                    index ="Quiz";
                                }else if(k==1){
                                    index="Homework";
                                }else if(k==2){
                                    index="Project";
                                }else if(k==3){
                                    index="Exam";
                                }
                                System.out.println("\nAssignment scoring details for "+ index + "" + students_courses_assignments[i][j][k] +" for "+ course_code +" are "+students_submitted_assignments_scores[i][j][k]+"\n");

                            }
                        }
                    }
                }
            }
        if(logic==0){
            System.out.println("\nIncorrect course code entered\n");
        }
        }else{
            System.out.println("\nUnauthorized access because you are not a student\n");
        }
    }



    public static class Assignment_Grade implements assignmentGrade{

        private String[] administration = {"mateko.collins@ashesi.edu.gh", "george.collins@ashesi.edu.gh", "brian.greens@ashesi.edu.gh", "mills.greens@ashesi.edu.gh", "mitchelle.mashingaidze@ashesi.edu.gh"};

        private String[] course_names = {"Eng 112", "Eng 221", "112"};

        private String[][] faculty_profiles = new String[3][7];

        private String[][] students_courses = new String[3][5];

        private String[] course_creators = new String[3];

        private String[][] students_courses_assignments_MC = new String [4][3];

        private String[][] students_courses_assignments_leadership = new String [4][3];

        private String[][] students_courses_assignments_DS = new String [4][3];

        private String[][] students_submitted_assignments_MC = new String [20][4];

        private String[][] students_submitted_assignments_leadership = new String [20][4];

        private String[][] students_submitted_assignments_DS = new String [20][4];

        private String[][] students_submitted_assignments_scores_MC = new String [20][4];

        private String[][] students_submitted_assignments_scores_leadership = new String [20][4];

        private String[][] students_submitted_assignments_scores_DS = new String [20][4];

        public boolean login(String email, String pass) {

            // to attain polymorphism, the login method is being implemented differently in each class that inherits interface req_Three

            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }
            if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;
            }else if (logic == 1) {

                System.out.println("\nThe user " + email + " exists from the student database.");
                return true;


            }else {
                System.out.println("\nThe user " + email + " does not exist from the student database.\nThey might be a faculty member.");
                return false;
            }

        }


        public boolean isAdmin(String email) {

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

        public void makeFaculty(String email,String pass,String name){
            int logic =0;

            if (!login(email, pass)) {//(login(email,pass)==false)
                if (!isAdmin(email)) {//(isAdmin(email)==false)

                    Scanner string_input = new Scanner(System.in);
                    System.out.println("\nDo you want to be a faculty member.Use Y/N: \n");
                    String response = string_input.next();
                    if (response.equals("Y")) {


                        Scanner int_input = new Scanner(System.in);
                        System.out.println("\nIf your above response was y, enter the administration code to proceed the registration process: \n");
                        int code = int_input.nextInt();

                        if (code == 200322022) {
                            int size = faculty_profiles.length;
                            int i;
                            for (i = 0; i < size; i++) {

                                String admin_iteration_email = faculty_profiles[i][0];
                                String admin_iteration_name = faculty_profiles[i][1];
                                if ((admin_iteration_email == null) && (admin_iteration_name == null)) {
                                    logic = 1;
                                    break;
                                }
                            }
                            if (logic == 1) {
                                faculty_profiles[i][0] = email;
                                faculty_profiles[i][1] = name;
                                System.out.println("\nThe registration process was successful");
                            }
                        }else {
                            System.out.println("\nThe administration code is incorrect, try again to proceed to the registration process");
                        }

                    }
                }
            }

        }

        public boolean isFaculty(String email) {
            int size = faculty_profiles.length;
            int logic = 0;
            for (int i = 0; i < size; i++) {

                String email_iteration = faculty_profiles[i][0];

                if (email.equals(email_iteration)) {
                    logic = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\n\nThe user " + email + " exists as a faculty member from the database");
                return true;
            } else {
                System.out.println("\n\nThe user " + email + " does not exist from the database as a faculty member");
                return false;
            }

        }

        public void addAssignment(String email,String pass,String course_code,
                                  String assignment_number,String description,
                                  String due_date, String assignment_name){

            int logic=0;
            if(!login(email, pass)){
                if(isFaculty(email)) {

                    for (int i = 0; i < course_names.length; i++) {


                        String course_creator_iteration = course_creators[i];
                        if (course_code.equals("Eng 112") && course_creator_iteration.equals(email)) {//checking if the email and course code details provided are correct or not

                            for (int j = 0; j < students_courses_assignments_MC[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };


                                students_courses_assignments_MC[index][j] = assignment_number;
                                logic = 1;

                            }
                        }else if(course_code.equals("Eng 221") && course_creator_iteration.equals(email)) {

                            for (int j = 0; j < students_courses_assignments_leadership[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };

                                students_courses_assignments_leadership[index][j] = assignment_number;
                                logic = 1;

                            }
                        }else if (course_code.equals("112") && course_creator_iteration.equals(email)) {

                            for (int j = 0; j < students_courses_assignments_DS[i].length; j++) {
                                int index = switch (assignment_name) {
                                    case "Homework" -> 1;
                                    case "Project" -> 2;
                                    case "Exam" -> 3;
                                    default -> 0;
                                };

                                students_courses_assignments_leadership[index][j] = assignment_number;
                                logic = 1;

                            }

                        }
                        if (logic == 1) {

                            System.out.println("\nCongratulations " + email + " you have successfully added " + assignment_number + " that is due on " + due_date + "\n. The assignment description is " + description + " \n.");
                        }
                    }
                } else {
                    System.out.println("\nYou cannot add an assignment to the course database because you are not a faculty member\n");
                }
            } else {
                System.out.println("\nYou cannot add an assignment to the course database because you are a student\n");
            }
        }

        public void viewAssignmentsByCourse(String course_code) {

            int null_counter = 0;
            int code = 0;

            if (Objects.equals("Eng 112", course_code)) {

                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;


                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;


                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_MC[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }


            } else if (Objects.equals("Eng 221", course_code)) {

                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_leadership[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }

            } else if (Objects.equals("112", course_code)) {
                code = 1;
                for (int j = 0; j < 4; j++) {

                    if(j==0){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else if(j==1){
                        for(int i=0;i<3;i++) {
                            String assignment = "Homework";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }else if(j==2){
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    } else{
                        for(int i=0;i<3;i++) {
                            String assignment = "Quiz";
                            String item = students_courses_assignments_DS[j][i];
                            if (item != null) {
                                System.out.print("\nThe assignment for the course " + course_code + " is: " + assignment + "- " + item + "\n ");
                                break;

                            } else {
                                null_counter = null_counter + 1;
                            }
                        }
                    }

                }


            }

            if (code==0){
                System.out.println("The course code you entered does not exist in our database");
            }else if(null_counter==3){
                System.out.println("The course "+ course_code +" does not have any assignments posted yet");
            }

        }

        public void viewAssignmentsByEmail(String email,String first_name,String last_name){
            //let's keep pending optional for now till we figure out how to implement it
            //modify the function to take email only

            int logic=0;
            int index=0;
            int i;
            for (i = 0; i < students_courses.length; i++) {
                for (int j = 0; j < students_courses[i].length; j++) {

                    String item = first_name + " - " + last_name + " - " + email;
                    if (Objects.equals(students_courses[i][j], item)) {
                        index = i;
                        logic = 1;
                    }
                }
            }
            for(int k=0;k<4;k++) {

                if (index == 0) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i
                        System.out.print("\n" + email + "'s assignment for Multivariable Calculus is: " + students_courses_assignments_MC[k][m] + " \n");
                    }
                } else if (index == 1) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i

                        System.out.print("\n" + email + "'s assignment for Leadership III is: " + students_courses_assignments_leadership[k][m] + " \n");
                    }


                } else if (index == 2) {
                    for (int m = 0; m < 4; m++) {

                        // Print array element present at index i

                        System.out.print("\n" + email + "'s assignment for Data Structures is: " + students_courses_assignments_DS[k][m] + " \n");
                    }
                }
            }
            if(logic==0){
                System.out.println("\nThe user "+ email+" is not registered in any courses yet\n");
            }
        }

        public void submitAssignment(String first_name,String last_name,String email,String pass,
                                     String course_code,String assignment_name,String assignment_number,String submission){
            int interior_logic=0;

            if(login(email,pass)){
                for(int i=0;i<course_names.length;i++){
                    label:
                    for (int j = 0; j < students_courses[i].length; j++) {
                        String students_iteration = students_courses[i][j];
                        String student = first_name + " - " + last_name + " - " + email;

                        if (Objects.equals(students_iteration, student)) {

                            //to ensure that the index of the registered student links with his/ her submitted assignments
                            switch (course_code) {
                                case "Eng 112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_MC[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }

                                }
                                case "Eng 221" -> {

                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_leadership[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;

                                    }
                                }
                                case "112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;

                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_DS[index][k] = submission;
                                            System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }
                                }
                                default -> System.out.println("\nIncorrect course code details provided\n");
                            }
                        }
                    }

                }
            }
            if(interior_logic==0){
                System.out.println("\nThe assignment name provided is incorrect because it is not found in the assignments' database\n");

            } else{
                System.out.println("\n"+email+" you cannot submit an assignment because you are not a student\n");
            }
        }

        public void viewSubmissions(String email,String pass,String course_code,String assignment_name){

            int logic=0;
            int counter;
            if(!login(email,pass)&&isFaculty(email)) {
                if(course_code.equals("Eng 112") && email.equals("laura.price@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_MC.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_MC[i].length; j++) {
                                    if (students_submitted_assignments_MC[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_MC[i][j] + " \n");
                                    } else if (students_submitted_assignments_MC[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                } else if(course_code.equals("Eng 221") && email.equals("jude.law@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_leadership.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_leadership[i].length; j++) {
                                    if (students_submitted_assignments_leadership[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_leadership[i][j] + " \n");
                                    } else if (students_submitted_assignments_leadership[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                } else if(course_code.equals("112") && email.equals("adams.family@ashesi.edu.gh")){
                    logic=1;
                    switch (assignment_name) {
                        case "Quiz":
                            for (int i = 0; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Homework":
                            for (int i = 1; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Project":
                            for (int i = 2; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                        case "Exam":
                            for (int i = 3; i < students_submitted_assignments_DS.length; i = i + 4) {

                                for (int j = 0; j < students_submitted_assignments_DS[i].length; j++) {
                                    if (students_submitted_assignments_DS[i][j] != null) {

                                        // Print array element present at index i, j
                                        counter = j + 1;
                                        System.out.print("\nsubmission " + counter + " made for Multivariable Calculus is: " + students_submitted_assignments_DS[i][j] + " \n");
                                    } else if (students_submitted_assignments_DS[i][j] == null) {

                                        System.out.println("\nNo submissions made\n");
                                        break;
                                    }
                                }
                            }
                            break;
                    }

                }
            }
            if(logic==0){
                System.out.println("\nIncorrect course code or course creator\n");

            }


        }

        public void scoreAssignment( String faculty_email,String faculty_pass,String course_code,
                                     String assignment_name,String assignment_number, String student_email,
                                     String first_name, String last_name, String score){

            if(!login(faculty_email,faculty_pass)==isFaculty(faculty_email)){

                for(int i=0;i<course_names.length;i++){
                    label:
                    for (int j = 0; j < students_courses[i].length; j++) {
                        String students_iteration = students_courses[i][j];
                        String student = first_name + " - " + last_name + " - " + student_email;

                        if (Objects.equals(students_iteration, student)) {
                            //to ensure that the index of the registered student links with his/ her submitted assignments
                            switch (course_code) {
                                case "Eng 112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_scores_MC[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_scores_MC[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored homework: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_scores_MC[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored project: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_scores_MC[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored exam: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                    }

                                }
                                case "Eng 221" -> {

                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_scores_leadership[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_scores_leadership[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored homework: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_scores_leadership[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored project: " + assignment_number +  ":"+ score + "\n");

                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_scores_leadership[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;

                                    }
                                }
                                case "112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;

                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            students_submitted_assignments_scores_DS[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            students_submitted_assignments_scores_DS[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            students_submitted_assignments_scores_DS[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            students_submitted_assignments_scores_DS[index][k] = score;
                                            System.out.println("congratulations " + faculty_email + " you have successfully scored Quiz: " + assignment_number +" :"+ score + "\n");

                                            break label;
                                    }
                                }
                                default -> System.out.println("\nIncorrect course code details provided\n");
                            }
                        }else{
                            System.out.println("\nThe student does not exist in the student database\n");
                        }
                    }

                }

            }

        }
        public void viewAssignmentScore(String email, String pass,String first_name,String last_name, String course_code,String assignment_name,String assignment_number) {

            int interior_logic=0;

            if(login(email,pass)){
                for(int i=0;i<course_names.length;i++){
                    label:
                    for (int j = 0; j < students_courses[i].length; j++) {
                        String students_iteration = students_courses[i][j];
                        String student = first_name + " - " + last_name + " - " + email;

                        if (Objects.equals(students_iteration, student)) {

                            //to ensure that the index of the registered student links with his/ her submitted assignments
                            switch (course_code) {
                                case "Eng 112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    String score;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            score=students_submitted_assignments_scores_MC[index][k];
                                            System.out.println("\nHello "+ email + " your score for Quiz: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            score =students_submitted_assignments_scores_MC[index][k];
                                            System.out.println("\nHello "+ email + " your score for Homework: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            score =students_submitted_assignments_scores_MC[index][k];
                                            System.out.println("\nHello "+ email + " your score for Project: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            score =students_submitted_assignments_scores_MC[index][k];
                                            System.out.println("\nHello "+ email + " your score for Quiz: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }

                                }
                                case "Eng 221" -> {

                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    String score;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            score =students_submitted_assignments_scores_leadership[index][k];
                                            System.out.println("\nHello "+ email + " your score for Quiz: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            score =students_submitted_assignments_scores_leadership[index][k];
                                            System.out.println("\nHello "+ email + " your score for Homework: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            score =students_submitted_assignments_scores_leadership[index][k];
                                            System.out.println("\nHello "+ email + " your score for Project: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            score =students_submitted_assignments_scores_leadership[index][k];
                                            System.out.println("\nHello "+ email + " your score for Exam: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;

                                    }
                                }
                                case "112" -> {
                                    int index;
                                    int k = Integer.parseInt(assignment_number) - 1;
                                    String score;
                                    switch (assignment_name) {
                                        case "Quiz":
                                            index = (j * 4);
                                            score =students_submitted_assignments_scores_DS[index][k];
                                            System.out.println("\nHello "+ email + " your score for Quiz: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Homework":
                                            index = (j * 4) + 1;
                                            score =students_submitted_assignments_scores_DS[index][k];
                                            System.out.println("\nHello "+ email + " your score for Homework: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Project":
                                            index = (j * 4) + 2;
                                            score =students_submitted_assignments_scores_DS[index][k];
                                            System.out.println("\nHello "+ email + " your score for Project: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                        case "Exam":
                                            index = (j * 4) + 3;
                                            score =students_submitted_assignments_scores_DS[index][k];
                                            System.out.println("\nHello "+ email + " your score for Exam: " + assignment_number +" is:"+ score + "\n");
                                            interior_logic = 1;
                                            break label;
                                    }
                                }
                                default -> System.out.println("\nIncorrect course code details provided\n");
                            }
                        }
                    }

                }
            }
            if(interior_logic==0){
                System.out.println("\nThe assignment name provided is incorrect because it is not found in the assignments' database\n");

            } else{
                System.out.println("\n"+email+" you cannot view an assignment score because you are not a student\n");
            }
        }

    /**
     public static void viewAssignmentScores(String email,String pass,String course_code,String assignment_number,String assignment_type){
     int logic = 0;
     int login_code=0;
     int code = 0;
     if (!login(email, pass)==isFaculty(email)) {
     login_code=1;
     System.out.println("one");
     for (int i = 0; i < students_courses_assignments.length; i++) {
     if (Objects.equals(course_names[i], course_code)&& Objects.equals(course_creators[i], email)) {//course creator
     System.out.println("two");
     code = 1;

     for (int j = 0; j < students_submitted_assignments[i].length; j++) {

     int index = 0;
     if (assignment_type.equals("Quiz")) {
     index = j*4;
     } else if (assignment_type.equals("Homework")) {
     index = (j*4)+1;
     } else if (assignment_type.equals("Project")) {
     index = (j*4)+2;
     } else if (assignment_type.equals("Exam")) {
     index = (j*4)+3;
     }

     if (Integer.parseInt(assignment_number)<=5) {
     System.out.println("three");
     logic = 1;

     int position =Integer.parseInt(assignment_number)-1;
     String score = students_actual_scores[index][position];
     System.out.println("\nThe scoring details for " + email + " are: " + score + " \n");
     break;
     }


     }
     }

     }
     }
     if(code==0){

     System.out.println("\nIncorrect code entered\n");
     }else if(logic==0){
     System.out.println("\nIncorrect assignment name\n");
     }else if(login_code==0){
     System.out.println("\nCannot view student scores because you are not a student\n");
     }
     }

     public static void viewALLAssignmentScores(String email,String pass,String first_name,String last_name,String course_code){

     int logic=0;
     if(login(email,pass)){
     for(int i=0;i< students_submitted_assignments_scores.length;i++) {
     String code=course_names[i];
     if (course_code.equals(code)){
     logic=1;
     for(int j=0;j< students_submitted_assignments[i].length;j++){
     String item = students_courses[i][j];
     String student = first_name + " - " + last_name + " - " + email;
     if(student.equals(item)) {
     for (int k = 0; k < students_submitted_assignments[i][j].length; k++) {
     String index =null;
     if(k==0){
     index ="Quiz";
     }else if(k==1){
     index="Homework";
     }else if(k==2){
     index="Project";
     }else if(k==3){
     index="Exam";
     }
     System.out.println("\nAssignment scoring details for "+ index + "" + students_courses_assignments[i][j][k] +" for "+ course_code +" are "+students_submitted_assignments_scores[i][j][k]+"\n");

     }
     }
     }
     }
     }
     if(logic==0){
     System.out.println("\nIncorrect course code entered\n");
     }
     }else{
     System.out.println("\nUnauthorized access because you are not a student\n");
     }
     }



    public static void viewAssignmentGrade(String email,String pass,String course_code,String assignment_type,String assignment_number){
            int logic = 0;
            int login_code=0;
            int code = 0;
            if (login(email, pass)) {
                login_code=1;
                System.out.println("one");
                for (int i = 0; i < students_courses_assignments.length; i++) {
                    if (Objects.equals(course_names[i], course_code)) {
                        System.out.println("two");
                        code = 1;
                        for (int j = 0; j < students_submitted_assignments[i].length; j++) {
                            for (int k = 0; k < students_submitted_assignments[i][j].length; k++) {

                                int index = 0;
                                if (assignment_type.equals("Quiz")) {
                                    index = j*4;
                                } else if (assignment_type.equals("Homework")) {
                                    index = (j*4)+1;
                                } else if (assignment_type.equals("Project")) {
                                    index = (j*4)+2;
                                } else if (assignment_type.equals("Exam")) {
                                    index = (j*4)+3;
                                }

                                if (Integer.parseInt(assignment_number)<=5) {
                                    System.out.println("three");
                                    logic = 1;

                                    int position =Integer.parseInt(assignment_number)-1;
                                    String score = students_actual_scores[index][position];

                                    int comparing_score=Integer.parseInt(score);

                                    if(comparing_score>=85&&comparing_score<=100){
                                        String grade="A+";
                                        System.out.println("\nThe grading details for " + email + " are: " + score + ":"  +grade + " \n");
                                        break;
                                    }else if(comparing_score>=80&&comparing_score<=84){
                                        String grade="A";
                                        System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                        break;
                                    }else if(comparing_score>=75&&comparing_score<=79){
                                        String grade="B+";
                                        System.out.println("\nThe grading details for " + email + " are: " +  score + ":"  +grade + " \n");
                                        break;
                                    }else if(comparing_score>=70&&comparing_score<=74){
                                        String grade="B";
                                        System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                        break;
                                    }else if(comparing_score>=65&&comparing_score<=69){
                                        String grade="C+";
                                        System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                        break;
                                    }else if(comparing_score>=60&&comparing_score<=64){
                                        String grade="C";
                                        System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                        break;
                                    }else if(comparing_score>=55&&comparing_score<=59){
                                        String grade="D+";
                                        System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                        break;
                                    }else if(comparing_score>=50&&comparing_score<=54){
                                        String grade="D";
                                        System.out.println("\nThe grading details for " + email + " are: " +  score + ":"  +grade + " \n");
                                        break;
                                    }else{
                                        String grade="Fail";
                                        System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                        break;
                                    }

                                }
                            }

                        }
                    }

                }
            }
            if(code==0){

                System.out.println("\nIncorrect code entered\n");
            }else if(logic==0){
                System.out.println("\nIncorrect assignment name\n");
            }else if(login_code==0){
                System.out.println("\nCannot view student scores because you are not a student\n");
            }
        }

        public static void ViewAssignmentGrades(String email,String pass,String course_code,String assignment_number,String assignment_type){
            int logic = 0;
            int login_code=0;
            int code = 0;
            if (!login(email, pass)==isFaculty(email)) {
                login_code=1;
                System.out.println("one");
                for (int i = 0; i < students_courses_assignments.length; i++) {

                    if(Objects.equals(course_names[i], course_code) && Objects.equals(course_creators[i], email)) {

                        System.out.println("two");
                        code = 1;

                        for (int j = 0; j < students_submitted_assignments[i].length; j++) {

                            int index = 0;
                            if (assignment_type.equals("Quiz")) {
                                index = j*4;
                            } else if (assignment_type.equals("Homework")) {
                                index = (j*4)+1;
                            } else if (assignment_type.equals("Project")) {
                                index = (j*4)+2;
                            } else if (assignment_type.equals("Exam")) {
                                index = (j*4)+3;
                            }

                            if (Integer.parseInt(assignment_number)<=5) {
                                System.out.println("three");
                                logic = 1;

                                int position =Integer.parseInt(assignment_number)-1;
                                String score = students_actual_scores[index][position];

                                int comparing_score=Integer.parseInt(score);

                                if(comparing_score>=85&&comparing_score<=100){
                                    String grade="A+";
                                    System.out.println("\nThe grading details for " + email + " are: " +  score + ":"  +grade + " \n");
                                    break;
                                }else if(comparing_score>=80&&comparing_score<=84){
                                    String grade="A";
                                    System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                    break;
                                }else if(comparing_score>=75&&comparing_score<=79){
                                    String grade="B+";
                                    System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                    break;
                                }else if(comparing_score>=70&&comparing_score<=74){
                                    String grade="B";
                                    System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                    break;
                                }else if(comparing_score>=65&&comparing_score<=69){
                                    String grade="C+";
                                    System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                    break;
                                }else if(comparing_score>=60&&comparing_score<=64){
                                    String grade="C";
                                    System.out.println("\nThe grading details for " + email + " are: " +  score + ":"  +grade + " \n");
                                    break;
                                }else if(comparing_score>=55&&comparing_score<=59){
                                    String grade="D+";
                                    System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                    break;
                                }else if(comparing_score>=50&&comparing_score<=54){
                                    String grade="D";
                                    System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                    break;
                                }else{
                                    String grade="Fail";
                                    System.out.println("\nThe grading details for " + email + " are: " + score + ":"  + grade + " \n");
                                    break;
                                }

                            }


                        }
                    }

                }
            }
            if(code==0){

                System.out.println("\nIncorrect code entered\n");
            }else if(logic==0){
                System.out.println("\nIncorrect assignment name\n");
            }else if(login_code==0){
                System.out.println("\nCannot view student scores because you are not a student\n");
            }
        }
        public static void viewAllAssignmentScores(String first_name,String last_name,String email,String pass,String course_code){
            int logic = 0;
            int login_code=0;
            int code = 0;
            if (login(email, pass)) {
                login_code=1;
                System.out.println("one");
                for (int i = 0; i < students_courses_assignments.length; i++) {
                    if (Objects.equals(course_names[i], course_code)) {
                        System.out.println("two");
                        code = 1;
                        for (int j = 0; j < students_submitted_assignments[i].length; j++) {
                            for (int k = 0; k < students_submitted_assignments[i][j].length; k++) {

                                String item = first_name + " - " + last_name + " - " + email;
                                if (Objects.equals(students_courses[i][j], item)) {

                                    System.out.println("three");
                                    logic = 1;
                                    int index = 0;
                                    if (j==0) {
                                        index = j*4;
                                    } else if (j==1) {
                                        index = (j*4)+1;
                                    } else if (j==2) {
                                        index = (j*4)+2;
                                    } else if (j==3) {
                                        index = (j*4)+3;
                                    }
                                    for(int m=0;m<4;m++) {

                                        String score = students_actual_scores[index][m];

                                        int comparing_score = Integer.parseInt(score);
                                        int assignment_num=m+1;
                                        if (comparing_score >= 85 && comparing_score <= 100) {
                                            String grade = "A+";
                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");

                                        } else if (comparing_score >= 80 && comparing_score <= 84) {
                                            String grade = "A";

                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");

                                        } else if (comparing_score >= 75 && comparing_score <= 79) {
                                            String grade = "B+";
                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");

                                        } else if (comparing_score >= 70 && comparing_score <= 74) {
                                            String grade = "B";
                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");
                                        } else if (comparing_score >= 65 && comparing_score <= 69) {
                                            String grade = "C+";
                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");
                                        } else if (comparing_score >= 60 && comparing_score <= 64) {
                                            String grade = "C";
                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");
                                        } else if (comparing_score >= 55 && comparing_score <= 59) {
                                            String grade = "D+";
                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");
                                        } else if (comparing_score >= 50 && comparing_score <= 54) {
                                            String grade = "D";
                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");
                                        } else {
                                            String grade = "Fail";
                                            System.out.println("\nThe grading details for assignment "+assignment_num+ " for: " + email + " are: " + score + ":" + grade + " \n");
                                        }
                                    }
                                }
                            }

                        }
                    }

                }
            }
            if(code==0){

                System.out.println("\nIncorrect code entered\n");
            }else if(logic==0){
                System.out.println("\nIncorrect assignment name\n");
            }else if(login_code==0){
                System.out.println("\nCannot view student scores because you are not a student\n");
            }
        }
    }

    **/
    public static class Main implements main {

        public boolean login(String email, String pass) {


            int size = profiles.length;
            int logic = 0;
            int compare = 0;
            for (int i = 0; i < size; i++) {
                int j = 0;
                String email_iteration = profiles[i][j];
                j = j + 1;
                String pass_iteration = profiles[i][j];


                if (email.equals(email_iteration) && pass.equals(pass_iteration)) {
                    logic = 1;
                    break;
                } else if (email.equals(email_iteration) || pass.equals(pass_iteration)) {
                    compare = 1;
                    break;
                }

            }
            if (logic == 1) {

                System.out.println("\nThe user " + email + " exists from the student database.");
                return true;
            } else if (compare == 1) {
                System.out.println("\nThe user " + email + " does not exist from the student database because provided details are false ");
                return false;

            } else {
                System.out.println("\nThe user " + email + " does not exist from the student database.\nThey might be a faculty member.");
                return false;
            }

        }

        public void setNotificationPreferences(String email,String pass){
            if(login(email,pass)){
                Scanner obj1=new Scanner(System.in);
                System.out.println("Do you want an email sent to you when an assignment is posted. Type Y OR N");
                String answer=obj1.next();
                if(answer.equals("Y")){
                    System.out.println("\nAssignment posted Email notifications: ON\n");
                }else if(answer.equals("N")){
                    System.out.println("\nAssignment posted Email notifications: Off\n");
                }else{
                    System.out.println("\nInvalid input\n");
                }

                Scanner obj2=new Scanner(System.in);
                System.out.println("Do you want an email sent to you when a score is submitted for their assignment. Type Y OR N");
                String answer2=obj2.next();

                if(answer2.equals("Y")){
                    System.out.println("\nAssignment grade posted Email notifications: ON\n");
                }else if(answer2.equals("N")){
                    System.out.println("\nAssignment grade posted Email notifications: Off\n");
                }else{
                    System.out.println("\nInvalid input\n");
                }

                Scanner obj3=new Scanner(System.in);
                System.out.println("Do you want an email sent to you successfully register for a course. Type Y OR N");
                String answer3=obj3.next();

                if(answer3.equals("Y")){
                    System.out.println("\nCourse registration notification: ON\n");
                }else if(answer3.equals("N")){
                    System.out.println("\nCourse registration notification: Off\n");
                }else{
                    System.out.println("\nInvalid input\n");
                }


            }else{
                System.out.println("\nUnauthorized access because you are not a student\n");
            }
        }


    }

    public static void main(String[] args) {
        //Instantiation for outer class ICP_Project_Phase_Two_Three
        ICP_Project_Phase_Two_Three obj0 = new ICP_Project_Phase_Two_Three();
        obj0.createAccount();
        //Instantiation for inner class Req_One
        Req_One obj = new Req_One();

        obj.login("claire.makuyana@ashesi.edu.gh", "7845623");
        obj.login("lorraine.makuyana@ashesi.edu.gh", "Guest1234");
        obj.login("asher.chakupa@ashesi.edu.gh","asher3412");

        //Instantiation for inner class Req_Two
        Req_Two obj2 = new Req_Two();

        obj2.login("claire.makuyana@ashesi.edu.gh", "7845623");
        obj2.login("lorraine.makuyana@ashesi.edu.gh", "Guest1234");
        obj2.login("asher.chakupa@ashesi.edu.gh","asher3412");

        obj2.isAdmin("claire.makuyana@ashesi.edu.gh");
        obj2.isAdmin("mateko.collins@ashesi.edu.gh");


        //Instantiation for inner class Req_Three
        Req_Three obj3 = new Req_Three();

        obj3.login("claire.makuyana@ashesi.edu.gh", "7845623");
        obj3.login("lorraine.makuyana@ashesi.edu.gh", "Guest1234");
        obj3.login("asher.chakupa@ashesi.edu.gh","asher3412");

        obj3.isFaculty("Clive.makuyana@ashesi.edu.gh");

        //Instantiation for inner class Profile
        Profile obj4 = new Profile ();

        obj4.updateProfile("lorraine.makuyana@ashe si.edu.gh","Guest1234","Lorraine","Makuyana","2022", "3.7","1998");
        obj4.updateProfile("asher.chakupa@ashesi.edu.gh","asher3412","Asher","Chakupa","2024","3.9","2000");

        obj4.viewProfile("george.bush@ashesi.edu.gh","ChaseAsher1507");
        obj4.viewProfile("lorraine.makuyana@ashesi.edu.gh", "Guest1234");

        //Instantiation for inner class Course
        Course obj5 = new Course();

        obj5.createCourse("laura.price@ashesi.edu.gh","Winner1234","Eng 112","Multivariable Calculus");
        obj5.createCourse("jude.law@ashesi.edu.gh","Maxy67890","Eng 221","Leadership III");
        obj5.createCourse("adams.family@ashesi.edu.gh","pass1234","112","Data Structures");

        obj5.viewCourses();

        obj5.registerCourse("Claire", "Makuyana","claire.makuyana@ashesi.edu.gh","Book6501","Eng 221");
        obj5.registerCourse("Laura","Price","laura.price@ashesi.edu.gh","Winner1234","Eng 112");
        obj5.registerCourse("Lorraine","Makuyana","lorraine.makuyana@ashesi.edu.gh","Guest1234","Eng 112");
        obj5.registerCourse("Lorraine","Makuyana","lorraine.makuyana@ashesi.edu.gh","Guest1234","112");
        obj5.registerCourse("Sylvie","Lombi","sylvie.lombi@ashesi.edu.gh","Chair3412","112");
        obj5.registerCourse("Sylvie","Lombi","sylvie.lombi@ashesi.edu.gh","Chair3412","Eng 112");

        obj5.viewCourseByCode("Eng 112");
        obj5.viewCourseByCode("112");
        obj5.viewCourseByCode("105");

        obj5.viewCoursesByEmail("Claire","Makuyana","claire.makuyana@ashesi.edu.gh");
        obj5.viewCoursesByEmail("Lorraine","Makuyana","lorraine.makuyana@ashesi.edu.gh");
        obj5.viewCoursesByEmail("Sylvie","Lombi","sylvie.lombi@ashesi.edu.gh");

        //Instantiation for inner class Assignment
        Assignment obj6 = new Assignment();

        obj6.addAssignment("laura.price@ashesi.edu.gh", "Winner1234","Eng 112","First quiz",
                                 "The quiz is out of 30 and is worth 4% of your final grade.","31/01/2022","Quiz");

        obj6.addAssignment("jude.law@ashesi.edu.gh","Maxy67890","Eng 221","Reflection One",
                         "Write a reflective essay from the week 2 reading we did this week." +
                  "\nThe assignment has 20 marks in total","10/02/2022","Homework");

        obj6.addAssignment("adams.family@ashesi.edu.gh","pass1234","112","First quiz",
                         "The quiz is out of 20 and is worth 1% of your final grade.","30/01/2022","Quiz");

        obj6.addAssignment("adams.family@ashesi.edu.gh","pass1234","112","Second quiz",
                         "The quiz is out of 30 and is worth 5% of your final grade.","09/02/2022","Quiz");


        obj6.viewAssignmentsByCourse("Eng 112");
        obj6.viewAssignmentsByCourse("Eng 221");
        obj6.viewAssignmentsByCourse("Eng 331");

        obj6.viewAssignmentsByEmail("claire.makuyana@ashesi.edu.gh","Claire","Makuyana");
        obj6.viewAssignmentsByEmail("lorraine.makuyana@ashesi.edu.gh","Lorraine","Makuyana");
        obj6.viewAssignmentsByEmail("sylvie.lombi@ashesi.edu.gh","Sylvie","Lombi");

        obj6.submitAssignment("Claire","Makuyana","claire.makuyana@ashesi.edu.gh","Book6501","Eng 221","Reflection One","1","claire_makuyana_small_is_beautiful_reflection");
        obj6.submitAssignment("Lorraine","Makuyana","lorraine.makuyana@ashesi.edu.gh", "Guest1234","112","First quiz","1","lorraine_makuyana_quiz_one.java");
        obj6.submitAssignment("Sylvie","Lombi","sylvie.lombi@ashesi.edu.gh","Chair3412","Eng 112","First quiz","1","sylvie_lombi_multivariable_calculus_quiz_one");

        obj6.viewSubmissions("laura.price@ashesi.edu.gh","Winner1234","Eng 112","First quiz");
        obj6.viewSubmissions("jude.law@ashesi.edu.gh","Maxy67890","Eng 221","Reflection One");
        obj6.viewSubmissions("adams.family@ashesi.edu.gh","pass1234","Eng 331",null);

        //instantiation of the inner Assignment_Score class
        Assignment_Score obj7 = new Assignment_Score();

        obj7.scoreAssignment("laura.price@ashesi.edu.gh","Winner1234","Eng 112","First quiz","1","claire.makuyana@ashesi.edu.gh", "Claire","Makuyana","90/100");
        obj7.scoreAssignment("jude.law@ashesi.edu.gh","Maxy67890","Eng 221","Reflection One","1","claire.makuyana@ashesi.edu.gh","Claire","Makuyana","96/100");
        obj7.scoreAssignment("adams.family@ashesi.edu.gh","pass1234","Eng 331",null,"1","sylvie.lombi@ashesi.edu.gh", "Sylvie","Lombi","78/100");


        obj7.viewAssignmentScore("lorraine.makuyana@ashesi.edu.gh","Guest1234","Lorraine","Makuyana","221","First quiz","1");
        obj7.viewAssignmentScore("claire.makuyana@ashesi.edu.gh","Book6501","Claire","Makuyana","Eng 221","Reflection One","1");



    }



}
