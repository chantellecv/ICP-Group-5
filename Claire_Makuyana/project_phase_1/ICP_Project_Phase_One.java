import java.util.Objects;
import java.util.Scanner;

public class ICP_Project_Phase_One {


    static String [] emails = {"claire.makuyana@ashesi.edu.gh","george.bush@ashesi.edu.gh","sylvie.lombi@ashesi.edu.gh","luis.mazondi@ashesi.edu.gh","lorraine.makuyana@ashesi.edu.gh"};

    static String [] passwords = {"Book6501","ChaseAsher1507","Chair3412","Luis23445","Guest1234"};

    static String [] administration = {"mateko.collins@ashesi.edu.gh","george.collins@ashesi.edu.gh","brian.greens@ashesi.edu.gh","mills.greens@ashesi.edu.gh","mitchelle.mashingaidze@ashesi.edu.gh"};

    static String [] course_names = {"Eng 112","Eng 221","Eng 331","112","331"};

    static String [] course_codes_names ={"Multivariable Calculus","Leadership III","Physics II","Data Structures","Statistics"};

    static String [] course_creators = new String [5];

    static String [][] faculty_profiles = new String [10][7];

    static String[][] profiles = new String [10][7];

    static String [][] students_courses = new String [5][10];

    static String[][] students_courses_assignments = new String [5][10];

    static String[][] students_submitted_assignments = new String [5][10];


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

 /**   public static void create_faculty_Account(){
        String email;

        for (int i=0;i<administration.length;i++)
        {
            email= administration[i];
            admin_profiles[i][0] = email;


            System.out.println("\n\nYour email: "+ email + " has been successfully saved");
        }
    }**/
    //Take care of the uppercase and lowercase issue
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
                    int code = int_input.nextInt();

                    if (code == 200322022) {
                        int size = faculty_profiles.length;
                        int i;
                        for (i = 0; i < size; i++) {

                            String admin_iteration_email = faculty_profiles[i][0];
                            String admin_iteration_pass = faculty_profiles[i][1];
                            if ((admin_iteration_email == null) && (admin_iteration_pass == null)) {
                                logic = 1;
                                break;
                            }
                        }
                        if (logic == 1) {
                            faculty_profiles[i][0] = email;
                            faculty_profiles[i][1] = pass;
                            System.out.println("\nThe registration process was successful");
                        }
                    }else {
                        System.out.println("\nThe administration code is incorrect, try again to proceed to the registration process");
                    }

                }
            }
        }

    }

    public static boolean isFaculty(String email){
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

    public static void createCourse( String email, String pass,String code,
                                    String course_name){
        int logic=0;
        if(login(email, pass)==false){
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
    public static void viewCourses(){
        for (int i = 0; i < faculty_profiles.length; i++) {

            for (int j = 0; j < faculty_profiles[i].length; j++) {

                // Print array element present at index i
                System.out.print(faculty_profiles[i][j] + " ");
            }
        }
    }

    public static void registerCourse(String first_name, String last_name,String email,String pass,String course_code){
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

    public static void viewCourseByCode(String course_code){
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

    public static void viewCoursesByEmail(String first_name,String last_name,String email){
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
    //Relook the course creator required thing
    public static void addAssignment(String email,String pass,String course_code,
                                     String assignment_name,String description,
                                     String due_date, String assignment_type){

        int logic=0;
        if(login(email,pass)==false){
            if(isFaculty(email)) {

                for (int i = 0; i < course_names.length; i++) {

                    String code_iteration = course_names[i];

                    if (code_iteration.equals(course_code)) {

                        int j;
                        for (j = 0; j < students_courses_assignments[i].length; j++) {
                            String courses_assignments_iteration = students_courses_assignments[i][j];
                            if (courses_assignments_iteration == null) {

                                logic = 1;
                                break;
                            }
                        }
                        if (logic == 1) {
                            //String item = assignment_name +" - "+assignment_type;
                            students_courses_assignments[i][j] = assignment_name;
                            System.out.println("\nCongratulations " + email + " you have successfully added "+ assignment_name +" that is due on "+ due_date +"\n. The assignment description is " + description + " \n.");
                        }
                    }
                }
            } else {
                System.out.println("\nYou cannot add an assignment to the course database because you are not a faculty member\n");
            }
        } else {
            System.out.println("\nYou cannot add an assignment to the course database because you are a student\n");
        }
    }

    public static void viewAssignmentsByCourse(String course_code){

        int null_counter=0;
        int logic=0;
        int i;
        for (i = 0; i < course_names.length; i++){

            String course_code_iteration = course_names[i];
            if(Objects.equals(course_code_iteration, course_code)) {

                logic = 1;


                for (int j = 0; j < students_courses_assignments[i].length; j++) {

                    if(students_courses_assignments[i][j]!=null) {


                        // Print array element present at index j
                        int count=j+1;
                        System.out.print("\nAssignment number " + count + " in the " + course_code + " course is " + students_courses_assignments[i][j] + "\n ");
                    }else{
                        null_counter = null_counter +1;
                    }
                }
            }
        }
        if (logic==0){
            System.out.println("The course code you entered does not exist in our database");
        }else if(null_counter==10){
            System.out.println("The course "+ course_code +" does not have any assignments posted yet");
        }

    }

    public static void viewAssignmentsByEmail(String email,String first_name,String last_name){
        //let's keep pending optional for now till we figure out how to implement it
        //modify the function to take email only

        int logic=0;
        int null_counter=0;
        int i;
        for (i = 0; i < students_courses.length; i++){

            for(int j=0; j< students_courses[i].length;j++){

                String item = first_name+" - "+last_name+" - "+email;


                if(Objects.equals(students_courses[i][j], item)){

                    logic=1;

                        for (int k = 0; k < students_courses_assignments[i].length; k++) {
                            if(students_courses_assignments[i][k]!=null) {

                                // Print array element present at index i
                                int count =k+1;
                                System.out.print("\n"+email+"'s assignment number "+ count +" in "+course_names[i]+ " is: "+students_courses_assignments[i][k] + " \n");
                            }else{
                                null_counter = null_counter +1;
                            }
                        }
                    }

                }
            }
        if(logic==0){
            System.out.println("\nThe user "+ email+" is not registered in any courses yet\n");
        }
        if(null_counter==10){
        System.out.println("\n"+ email +" does not have any assignments yet\n");
        }
    }

    public static void submitAssignment(String first_name,String last_name,String email,String pass,String course_code,String assignment_name,String submission){
        int logic =0;
        int interior_logic=0;
        if(login(email,pass)){
            for(int i=0;i<course_names.length;i++){
                String course_names_iteration = course_names[i];
                if(Objects.equals(course_names_iteration, course_code)){
                    logic=1;

                   for(int j=0;j< students_courses_assignments[i].length;j++){

                       if(Objects.equals(students_courses_assignments[i][j], assignment_name)) {
                           for (int m = 0; m < students_courses[i].length; m++) {
                               String student =first_name+" - "+last_name+" - "+email;
                               //to ensure that the index of the registered student links with his/ her submitted assignments

                               if(student.equals(students_courses[i][m])) {
                                   students_submitted_assignments[i][m] = submission;
                                   interior_logic = 1;
                                   System.out.println("congratulations " + email + " you have successfully submitted the assignment: " + submission + "\n");
                               }
                           }
                       }
                   }
                }
            }
        if(logic==0){
            System.out.println("\nThe course code provided is incorrect because it is not found in the course codes' database\n");
        }else if(interior_logic==0){
            System.out.println("\nThe assignment name provided is incorrect because it is not found in the assignments' database\n");
        }

        } else{
            System.out.println("\n"+email+" you cannot submit an assignment because you are not a student\n");
        }
    }

    public static void viewSubmissions(String email,String pass,String course_code,String assignment_name){

        int null_counter=0;
        int no_submission=0;
        int count=0;
        int counter;
        int i;
        if(!login(email,pass)&&isFaculty(email)) {

            for (i = 0; i < students_courses_assignments.length; i++) {
                if(Objects.equals(course_names[i], course_code) && Objects.equals(course_creators[i], email)) {

                    count=1;
                    for (int j = 0; j < students_courses_assignments[i].length; j++) {


                        if (Objects.equals(students_courses_assignments[i][j], assignment_name)) {


                            if (students_courses[i][j] != null && students_courses_assignments[i][j] != null) {


                                // Print array element present at index i, j
                                counter = j + 1;
                                System.out.print("\nsubmission "+ counter + " made for " + course_names[i] + " by "+ students_courses[i][j]  + " is: " + students_courses_assignments[i][j] + " \n");
                            } else if (students_courses[i][j] != null && Objects.equals(students_courses_assignments[i][j],null)) {

                                no_submission = 1;
                                break;
                            } else {
                                null_counter = null_counter + 1;
                            }

                        }

                    }
                    if(no_submission==1) {
                        System.out.println("\n No Submission\n");
                        no_submission=0;
                    }
                }
            }
        }
        if(null_counter==10){
            System.out.println("\n No submissions were made for the course \n");

        }else if(count==0){
            System.out.println("\nIncorrect course code or course creator\n");

        }


    }
    public static void scoreAssignment(String faculty_email,String pass,String course_code,String assignment_name,
                                       String student_email, String score){
        int count=0;
        int counter;
        int null_counter=0;
        if(!login(faculty_email,pass)==isFaculty(faculty_email)){
            for (int i = 0; i < students_courses_assignments.length; i++) {
                if(Objects.equals(course_names[i], course_code) && Objects.equals(course_creators[i], faculty_email)) {

                    count=1;
                    for (int j = 0; j < students_courses_assignments[i].length; j++) {


                        if (Objects.equals(students_courses_assignments[i][j], assignment_name)) {


                            if (students_courses_assignments[i][j] != null && Objects.equals(students_courses[i][j], student_email)) {


                                // Print array element present at index i, j
                                counter = j + 1;
                                students_courses_assignments[i][j]=assignment_name + " - " + score;
                                System.out.print("\nsubmission "+ counter + " made for " + course_names[i] + " by "+ students_courses[i][j]  + " is: " + students_courses_assignments[i][j] + " with a score of " + score + "\n");
                            } else {
                                null_counter = null_counter + 1;
                            }

                        }

                    }

                }
            }
        }
        if(null_counter==10){
            System.out.println("\n No scoring because no submissions were made for the course \n");

        }else if(count==0){
            System.out.println("\nIncorrect course code or course creator\n");

        }
    }


    public static void Students_courses_array(){
        for (int i = 0; i < students_courses.length; i++) {

            for (int j = 0; j < students_courses[i].length; j++) {

                // Print array element present at index i
                System.out.print(students_courses[i][j] + " ");
            }
        }
    }
    public static void Students_courses_assignments_array(){
        for (int i = 0; i < students_courses_assignments.length; i++) {

            for (int j = 0; j < students_courses_assignments[i].length; j++) {

                // Print array element present at index i
                System.out.println("\n");
                System.out.print(students_courses_assignments[i][j] + " ");
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

    public static void faculty_profiles_array_elements(){
        for (int i = 0; i < faculty_profiles.length; i++) {

            for (int j = 0; j < faculty_profiles[i].length; j++) {

                // Print array element present at index i
                System.out.print(faculty_profiles[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        createAccount();

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
        makeFaculty("laura.price@ashesi.edu.gh","Winner1234");
        makeFaculty("jude.law@ashesi.edu.gh","Maxy67890");
        makeFaculty("adams.family@ashesi.edu.gh","pass1234");
        //isFaculty("Clive.makuyana@ashesi.edu.gh");
        //faculty passwords: "laura.price@ashesi.edu.gh","Winner1234","jude.law@ashesi.edu.gh","Maxy67890", "adams.family@ashesi.edu.gh","pass1234"
        //student_array_elements();Y
        //admin_array_elements();
        //faculty_profiles_array_elements();

        createCourse("laura.price@ashesi.edu.gh","Winner1234","Eng 112","Multivariable Calculus");
        createCourse("jude.law@ashesi.edu.gh","Maxy67890","Eng 221","Leadership III");
        createCourse("adams.family@ashesi.edu.gh","pass1234","Eng 331","Physics II");
        //coursenames: Calculus II, Leadership III, Physics II, Data Structures, Statistics for Engineers
        //viewCourses();
        registerCourse("Claire", "Makuyana","claire.makuyana@ashesi.edu.gh","Book6501","Eng 221");
        registerCourse("Laura","Price","laura.price@ashesi.edu.gh","Winner1234","Eng 112");

        registerCourse("Lorraine","Makuyana","lorraine.makuyana@ashesi.edu.gh","Guest1234","Eng 112");
        registerCourse("Lorraine","Makuyana","lorraine.makuyana@ashesi.edu.gh","Guest1234","112");

        registerCourse("Sylvie","Lombi","sylvie.lombi@ashesi.edu.gh","Chair3412","112");
        registerCourse("Sylvie","Lombi","sylvie.lombi@ashesi.edu.gh","Chair3412","Eng 112");

        viewCourseByCode("Eng 112");
        viewCourseByCode("112");
        viewCourseByCode("105");

        viewCoursesByEmail("Claire","Makuyana","claire.makuyana@ashesi.edu.gh");
        viewCoursesByEmail("Lorraine","Makuyana","lorraine.makuyana@ashesi.edu.gh");
        viewCoursesByEmail("Sylvie","Lombi","sylvie.lombi@ashesi.edu.gh");

        addAssignment("laura.price@ashesi.edu.gh", "Winner1234","Eng 112","First quiz",
                "The quiz is out of 30 and is worth 4% of your final grade.","31/01/2022","Quiz");

        addAssignment("jude.law@ashesi.edu.gh","Maxy67890","Eng 221","Reflection One",
                "Write a reflective essay from the week 2 reading we did this week." +
                "\nThe assignment has 20 marks in total","10/02/2022","Homework");

        addAssignment("adams.family@ashesi.edu.gh","pass1234","112","First quiz",
                "The quiz is out of 20 and is worth 1% of your final grade.","30/01/2022","Quiz");

        /*
        viewAssignmentsByCourse("Eng 112");
        viewAssignmentsByCourse("Eng 221");
        viewAssignmentsByCourse("Eng 331");



        Students_courses_assignments_array();
        viewAssignmentsByEmail("claire.makuyana@ashesi.edu.gh","Claire","Makuyana");
        viewAssignmentsByEmail("lorraine.makuyana@ashesi.edu.gh","Lorraine","Makuyana");
        viewAssignmentsByEmail("sylvie.lombi@ashesi.edu.gh","Sylvie","Lombi");
        */

        submitAssignment("Claire","Makuyana","claire.makuyana@ashesi.edu.gh","Book6501","Eng 221","Reflection One","claire_makuyana_small_is_beautiful_reflection");
        submitAssignment("Lorraine","Makuyana","lorraine.makuyana@ashesi.edu.gh", "Guest1234","112","First quiz","lorraine_makuyana_quiz_one.java");
        submitAssignment("Sylvie","Lombi","sylvie.lombi@ashesi.edu.gh","Chair3412","Eng 112","First quiz","sylvie_lombi_multivariable_calculus_quiz_one");

        viewSubmissions("laura.price@ashesi.edu.gh","Winner1234","Eng 112","First quiz");
        viewSubmissions("jude.law@ashesi.edu.gh","Maxy67890","Eng 221","Reflection One");
        viewSubmissions("adams.family@ashesi.edu.gh","pass1234","Eng 331",null);

        Students_courses_array();
        //Students_courses_assignments_array();
        scoreAssignment("laura.price@ashesi.edu.gh","Winner1234","Eng 112","First quiz","claire.makuyana@ashesi.edu.gh","90/100");
        scoreAssignment("jude.law@ashesi.edu.gh","Maxy67890","Eng 221","Reflection One","claire.makuyana@ashesi.edu.gh","96/100");
        scoreAssignment("adams.family@ashesi.edu.gh","pass1234","Eng 331",null,"sylvie.lombi@ashesi.edu.gh","78/100");

    }


}

