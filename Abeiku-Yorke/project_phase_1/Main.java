//Main Class
public class Main {
  private static User[] users = new User[1000];
  private static Admin[] admins = new Admin[1000];
  private static int userCount = 0;
  private static int adminCount = 0;
  private static boolean loggedIn = false;
  private static String currentUserEmail = "";
  
  
  public static void createAccount(String email, String pass) {
    User user = new User(email, pass, null, null, null, null, null);
    users[userCount] = user;
    userCount++;
  }
  
  public static boolean login(String email, String pass) {
    for(int i = 0; i<userCount; i++){
      if(users[i].email == email && users[i].password == pass){
        loggedIn = true;
        currentUserEmail = email;
        return true;
      }
    }
    return false;
  }
  
  public static void updateProfile(String email, String fname, String lname, String yearGroup, String currentGpa, String dob) {
    if(loggedIn){
      for(int i = 0; i<userCount; i++){
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
      System.out.println("Error: Kindly check your email or password");
    }
    
  }
  
  public static void viewProfile(String email) {
    if(loggedIn){
      for(int i = 0; i<userCount; i++){
        if(users[i].email == email && email == currentUserEmail){
          System.out.println(users[i].fname != null ? users[i].fname : "NA");
          System.out.println(users[i].lname != null ? users[i].lname : "NA");
          System.out.println(users[i].yearGroup != null ? users[i].yearGroup : "NA");
          System.out.println(users[i].currentGpa != null ? users[i].currentGpa : "NA");
          System.out.println(users[i].dob != null ? users[i].dob : "NA");
        }
      }
    }else{
      System.out.println("Error: Kindly check your email or password");
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
//             if uer is found
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
  
  
  public static void main(String[] args) {
    createAccount("abeiku.yorke@ashesi.edu.gh", "abeiku");
    System.out.println(login("abeiku.yorke@ashesi.edu.gh", "abeiku"));
    updateProfile("abeiku.yorke@ashesi.edu.gh", "Abeiku", "Yorke", "2022", "3.0", "05/08/2000");
    viewProfile("abeiku.yorke@ashesi.edu.gh");
    System.out.println(isAdmin("abeiku.yorke@ashesi.edu.gh"));
    
//  create an admin and insert into admins array at index 0
    admins[0] = new Admin("abeiku.yorke@ashesi.edu.gh");
//    increement adminCount
    adminCount++;
    
    System.out.println(isAdmin("abeiku.yorke@ashesi.edu.gh"));
    makeFaculty("abeiku.yorke@ashesi.edu.gh");
    System.out.println(isFaculty("abeiku.yorke@ashesi.edu.gh"));
     
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
  
  // Admin class constructor
  Admin(String email){
    this.email = email;
  }
}
