//Main Class
public class Main {
//Create an array of type user to keep track of all users
  private static User[] users = new User[1000];
//Create an array of type Admin to keep track of all admins
  private static Admin[] admins = new Admin[1000];
//Create an array of type Course
  private static Course[] courses = new Course[1000];
//This is to keep count of users
  private static int userCount = 0;
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
//if the email matches and it also matches the currentUser, then allow the person to update his/her info
        if(users[i].email == email && email == currentUserEmail){
          users[i].fname = fname;
          users[i].lname = fname;
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
        if(users[i].email == email && email == currentUserEmail){
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
  
  
  public static void main(String[] args) {
    createAccount("abeiku.yorke@ashesi.edu.gh","123");
    System.out.println(login("abeiku.yorke@ashesi.edu.gh","123"));
    createAdminAccount("abeiku.yorke@ashesi.edu.gh","123");
    createAccount("opanaplange@ashesi.edu.gh","123");
    makeFaculty("opanaplange@ashesi.edu.gh");
    createCourse("opanaplange@ashesi.edu.gh","ICP","ICP213");
    viewCourses();
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
    

// Course class constructor
Course(String email,String coursename,String coursecode){
    this.email = email;
    this.coursename = coursename;
    this.coursecode = coursecode;
}

}
