import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
interface course_interface{
    void createCourse();
    void viewCourses();
    void registerCourse();
    void viewCourseByCode();
    void viewCourseByEmail();

}

public class courses extends User_details implements course_interface{
    Map<String, List<String>> course_details = new HashMap<String, List<String>>();
    Map<String, List<String>> register_course = new HashMap<String, List<String>>();

    // This function should take the email of a user, a course code and course name and create the
    //course.
    @Override
    public void createCourse() {
        List<String> temporary_course = new ArrayList<String>();
        if(getLoginRequired() == true){
            System.out.println("\nYou are about to create a course");
            System.out.println("Enter your email (you must be a faculty member)");
            String email = sc.nextLine();
            if(facultymember.contains(email)){
                System.out.println("What is the course code");
                String course_code = sc.nextLine();
                System.out.println("What is the course name");
                String course_name = sc.nextLine();
                temporary_course.add(course_name);
                temporary_course.add(email);
                course_details.put(course_code,temporary_course);
            }else {
                System.out.println("User is not a faculty member");
            }
        }else {
            System.out.println(" Login required");
            login();
        }
    }
    //This function should display all created courses, showing the course code and course name
    //as well as the email and name of the course creator.
    @Override
    public void viewCourses(){
        System.out.println(course_details);
    }

    //This function should take the email of a user as well as a course code and add the user to
    //the course.
    @Override
    public void registerCourse(){
        if(getLoginRequired()  == true){
            System.out.println("You are about to register for a course");
            System.out.println("Kindly enter the email of the user");
            String email = sc.nextLine();
            System.out.println("Kindly enter the course code you want to register this user under");
            String course_code = sc.nextLine();
            if(course_details.containsKey(course_code)){
                List<String> details = course_details.get(course_code);
                details.add(course_code);
                register_course.put(email, details);
            }else {
                System.out.println("Invalid course code");
            }
        }else{
            System.out.println("Login in required");
            login();
        }
        System.out.println(register_course);

    }

    //This function should take a course code and display the course details including the email
    //and names of all users registered for the course.
    @Override
    public void viewCourseByCode(){
        System.out.println("You are about to view courses but by their codes");
        System.out.println("Kindly type the course code here");
        String course_code = sc.nextLine();
        for (Map.Entry<String, List<String>> me : register_course.entrySet()) {
            String key = me.getKey();
            List<String> values = me.getValue();
            if(values.get(2).equals(course_code)){
                System.out.println(values);

            }
        }
//        for(Map.Entry<String, List<String>> entry  : register_course.entrySet()){
//            if (entry.getValue().contains(course_code)){
//                email = entry.getKey();
//                System.out.println(register_course.get(email));
//            }
//
//        }

    }

    //This function should take a user’s email and display the course codes and names of all
    //courses that the user is registered for.
    @Override
    public void viewCourseByEmail(){
        System.out.println("You are about to view courses but by their email");
        System.out.println("Kindly type your email here to see all courses that you are register to");
        String email = sc.nextLine();
        if(register_course.containsKey(email)){
            System.out.println(register_course.get(email));
        }else{
            System.out.println("Invalid email");
        }
    }

}
