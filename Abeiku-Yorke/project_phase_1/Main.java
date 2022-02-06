//Main Class
public class Main{
    //Create an array of type user to keep track of all users
      private static User[] users = new User[1000];
    //Create an array of type Admin to keep track of all admins
      private static Admin[] admins = new Admin[1000];
    //Create an array of type Course
      private static Course[] courses = new Course[1000];
    //This is to keep count of users
      public static int userCount = 0;
    //This is to keep count of admins
      private static int adminCount = 0;
    //This is to keep count of courses
      private static int courseCount = 0;
    //This is to check whether a user or admin is logged in, it has been set default to false
      private static boolean loggedIn = false;
    // when the user logins, currentUserEmail is set to the person's email.
      private static String currentUserEmail = "";
      
      
      
      
    //This is the createAccount function. It is made void because, it doesnt return anything.
      public static void createAccount(String email, String pass) {
    //Create a user instance, and since it was specified that we want only email and password, the rest of the parameters for the user constructior is made null
        User user = new User(email, pass, null, null, null, null, null);
    //This is where you add the user to the users array @ index"Usercount"  
        users[userCount] = user;
    //When a user is added the "UserCount" is incremented.
        userCount++;
      }
      
      
      
    //This is the createAccount function. It is made void because, it doesnt return anything.
      public static void createAdminAccount(String email, String pass) {
        boolean userExists = false;
        for(int i = 0; i < userCount; i++){
          if(users[i].email == email){
            userExists = true;
          }
        }
        
        if(userExists == false){
          //Create a user instance, and since it was specified that we want only email and password, the rest of the parameters for the user constructior is made null
          User user = new User(email, pass, null, null, null, null, null);
          //This is where you add the user to the users array @ index"Usercount"  
          users[userCount] = user;
          //When a user is added the "UserCount" is incremented.
          userCount++;
        }
        
        Admin admin = new Admin(email,pass);
        admins[adminCount] = admin;
        adminCount++;
      }
      
      
      
      
    //This is to check whether a User exists. As such it should return a boolean value.
      public static boolean login(String email, String pass) {
    //This for loop is used to go through the user array.
        for(int i = 0; i<userCount; i++){
    // Checking if email and password are the same 
          if(users[i].email == email && users[i].password == pass){
    //If they are you set it to true
            loggedIn = true;
    //You keep track of the user email
            currentUserEmail = email;
    //Return true
            return true;
          }
        }
        return false;
      }
      
      
      
      
    //Create the UpdateProfile. it is not returning anything so it is void. 
      public static void updateProfile(String email, String fname, String lname, String yearGroup, String currentGpa, String dob) {
    //If the user is logged, in
        if(loggedIn){
    //A for loop is created to run through the user array
          for(int i = 0; i<userCount; i++){
    //if the email matches, then allow the person to update his/her info
            if(users[i].email == email){
              users[i].fname = fname;
              users[i].lname = lname;
              users[i].yearGroup = yearGroup;
              users[i].currentGpa = currentGpa;
              users[i].dob = dob;
              
              System.out.println("Profile Updated Successfully");
            }
          }
        }else{
          System.out.println("Error: Kindly login first");
        }
        
      }
      
      
      
      public static void viewProfile(String email) {
        //If logged in
        if(loggedIn){
          // loop through user array
          for(int i = 0; i<userCount; i++){
            //if the email is the same
            if(users[i].email == email){
              //If the users fname is not equal to null, print the user name else, print NA
              System.out.println(users[i].fname != null ? users[i].fname : "NA");
              System.out.println(users[i].lname != null ? users[i].lname : "NA");
              System.out.println(users[i].yearGroup != null ? users[i].yearGroup : "NA");
              System.out.println(users[i].currentGpa != null ? users[i].currentGpa : "NA");
              System.out.println(users[i].dob != null ? users[i].dob : "NA");
            }
          }
        }else{
          System.out.println("Error: Kindly login");
        }
      }
      
      
      
      public static boolean isAdmin(String email) {
        for(int i = 0; i<adminCount; i++){
          if(admins[i].email == email){
            return true;
          }
        }
        return false;
      }
      
      
      
      public static void makeFaculty(String email) {
        if(loggedIn){
    //      loop through admins array
          for(int i = 0; i<adminCount; i++){
    //          if current user is an admin
            if(admins[i].email == currentUserEmail){
    //           loop through users array
              for(int j = 0; j<userCount; j++){
    //             if user is found
                if(users[j].email == email){
    //               make user faculty
                  users[j].isFaculty = true;
                  break;
                }
              }
            }
          }
          
        }
      }
      
      
      
      public static boolean isFaculty(String email) {
        for(int i = 0; i<userCount; i++){
          if(users[i].email == email && users[i].isFaculty == true){
            return true;
          }
        }
        return false;
      }
      
      
      
      
      public static void createCourse(String email,String coursename,String coursecode){
        if(loggedIn){
          if(isFaculty(email)){
            Course course = new Course(email,coursename,coursecode);
            courses[courseCount] = course;
            courseCount++;
            System.out.println("The course has been created successfully");
          }
          else{
            System.out.println("You are not a Faculty");
          }
        } else{
          System.out.println("Error:Kindly login");
        }
      }
      
      
      
      public static void viewCourses(){
        for (int i = 0; i < courseCount; i++){
          for(int j = 0; j < userCount; j++){
            if(courses[i].email == users[j].email){
              System.out.println("Course Code: " +courses[i].coursecode + " || Course Name: " + courses[i].coursename + " || Email: " + courses[i].email + " || Instructor Name: " + users[j].fname);
            }
          }
          
        }
      }
      
      
      
      
    // To register a person to a particular course
      public static void registerCourse(String email, String coursecode){
        for(int i=0; i<courseCount; i++){
          if(courses[i].coursecode == coursecode){
            courses[i].addUser(email, users, userCount);
          }
        }
      }
      
      
      
      
      public static void viewCourseByCode(String coursecode){
        for (int i = 0; i < courseCount; i++){
          if(courses[i].coursecode==coursecode){
            System.out.println("Course name: " + courses[i].coursename);
            System.out.println("Course code: " + courses[i].coursecode);
            
            for(int j = 0; j< courses[i].usersCount; j++){
              System.out.println("Student name: " + courses[i].users[j].fname + " " + courses[i].users[j].lname + " || Student email: " + courses[i].users[j].email);
            }
          }    
        }
      }
      
      
      
      public static void viewCourseByEmail(String email){
        for (int i = 0; i < courseCount; i++){
          for(int j = 0; j<courses[i].usersCount; j++){
            if(courses[i].users[j].email == email){
              System.out.println("Course name: " + courses[i].coursename + " || Course code: " + courses[i].coursecode);
            }
          }
        }
      }

    public static void addAssignment(String email,String coursecode,String assignmentname, String assignmentdesc, String assignmenttype, String assignmentdate){
        if(loggedIn){
            if(isFaculty(email)){
                for (int i=0; i < courseCount; i++){
                    if(courses[i].coursecode == coursecode){
                        courses[i].addAssign(assignmentname,assignmentdesc,assignmenttype,assignmentdate);
                        System.out.println(assignmentname + "  has been created successfully");
                    }
                }
            }
        }
    }

    public static void viewAssignmentsByCourse(String coursecode){
        for (int i = 0; i < courseCount; i++){
            if(courses[i].coursecode == coursecode){
                System.out.println("Course name: "+ courses[i].coursename);
                System.out.println("Course code: "+ courses[i].coursecode);
                for (int j = 0; j < courses[i].assCount; j++){
                    System.out.println("Assignment name: "+ courses[i].assignments[j].assignmentname + "|| Assignment Description: "+ courses[i].assignments[j].assignmentdesc + " || Assignment Due Date: "+ courses[i].assignments[j].assignmentddate + " || Assignment Type: "+courses[i].assignments[j].assignmenttype);

                }
            }
        }
    }
    
    public static void viewAssignmentsByEmail(String email){
        for(int i = 0; i < courseCount; i++){
            for (int j = 0; j< courses[i].usersCount; j++){
                if(courses[i].users[j].email == email){
                    for(int k = 0; k< courses[i].assCount; k++){
                        System.out.println("Assignment name "+courses[i].assignments[k].assignmentname);
                    }
                }
            }
        }
    }

      
      
      
      public static void main(String[] args) {
        createAccount("abeiku.yorke@ashesi.edu.gh","123");
        createAccount("senior.yorke@ashesi.edu.gh","123");
        createAccount("opana@ashesi.edu.gh","123");
        
        login("abeiku.yorke@ashesi.edu.gh","123");
        
        updateProfile("abeiku.yorke@ashesi.edu.gh", "abeiku", "yorke", null, null, null);
        updateProfile("senior.yorke@ashesi.edu.gh", "senior", "yorke", null, null, null);
        
        createAdminAccount("abeiku.yorke@ashesi.edu.gh","123");
        
        
        makeFaculty("opana@ashesi.edu.gh");
        
        createCourse("opana@ashesi.edu.gh","ICP","ICP213");
        createCourse("opana@ashesi.edu.gh","OS","OS213");
        createCourse("opana@ashesi.edu.gh","Networks","N213");
        
        viewCourses();
        
        registerCourse("abeiku.yorke@ashesi.edu.gh", "ICP213");
        registerCourse("senior.yorke@ashesi.edu.gh", "ICP213");
        registerCourse("senior.yorke@ashesi.edu.gh", "OS213");
        
        viewCourseByCode("ICP213");
        
        viewCourseByEmail("senior.yorke@ashesi.edu.gh");
        addAssignment("opana@ashesi.edu.gh","N213","Assignment 1","Study hard and do this assignment","Homework","12/01/2022");
        viewAssignmentsByCourse("N213");
        viewAssignmentsByEmail("opana@ashesi.edu.gh");
      }
      
    }
    
    
    //class for User
    class User{
      public String fname;
      public String lname;
      public String yearGroup;
      public String currentGpa;
      public String dob;
      public String email;
      public String password;
      public boolean isFaculty;
      
      // User class constructor
      User(String email, String password, String fname, String lname, String yearGroup, String currentGpa, String dob)
      {
        this.fname = fname;
        this.lname = lname;
        this.yearGroup = yearGroup;
        this.currentGpa = currentGpa;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.isFaculty= false;
      }
    }
    
    
    
    
    //class for Admin
    class Admin{
      public String email;
      public String password;
      
      // Admin class constructor
      Admin(String email,String password){
        this.email = email;
        this.password = password;
      }
    }
    
    
    
    
    //class for Course
    class Course{
      public String email;
      public String coursename;
      public String coursecode;
      
      public User[] users;
      public int usersCount = 0;
      public Assignment[] assignments;
      public int assCount = 0;
    
      
      
    // Course class constructor
      Course(String email,String coursename,String coursecode){
        this.email = email;
        this.coursename = coursename;
        this.coursecode = coursecode;
        this.users = new User[1000];
        this.assignments = new Assignment[1000];
        

      }
      
      public void addUser(String email, User[] users, int userCount){
        for(int i = 0; i<userCount; i++){ 
    //      if email matches
          if(users[i].email == email){
    //        create an instance of the User with the same details 
            User user = new User(email, users[i].password, users[i].fname, users[i].lname, users[i].yearGroup, users[i].currentGpa, users[i].dob);
    //          add to array and increment
            this.users[usersCount] = user;
            this.usersCount++;
          }
        }
        
      }
      public void addAssign(String assignmentname,String assignmentdesc,String assignmenttype,String assignmentddate){
          Assignment assignment = new Assignment(assignmentname,assignmentdesc,assignmenttype,assignmentddate);
          this.assignments[assCount]= assignment;
          this.assCount++;
      }
    }

// Assignemnt class
class Assignment{
    public String assignmentname;
    public String assignmentdesc;
    public String assignmenttype;
    public String assignmentddate;

    Assignment(String assignmentname,String assignmentdesc, String assignmenttype,String assignmentddate){
        this.assignmentname = assignmentname;
        this.assignmentdesc = assignmentdesc;
        this.assignmenttype = assignmenttype;
        this.assignmentddate = assignmentddate;
    }
}