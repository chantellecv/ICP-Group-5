import java.util.*;

public class Student extends CanvasPerson{

    ArrayList<ArrayList<String>> assignments = new ArrayList<>();
    ArrayList<String> courseNames = new ArrayList<String>();
    ArrayList<ArrayList<String>> completeCourseMembersNames = new ArrayList<>();
    ArrayList<ArrayList<String>> completeCourseMembersEmails = new ArrayList<>();
    ArrayList<ArrayList<ArrayList<String>>> courseAssignments = new ArrayList<>();
    
    @Override
    public void updateProfile(){
        System.out.println("Update Profile");
        if (login() == true){

            System.out.println("Please enter your email: ");
            sc.nextLine();

            System.out.println("Please enter your first name: ");
            firstName.add(sc.nextLine());

            System.out.println("Please enter your last name: ");
            lastName.add(sc.nextLine());

            System.out.println("Please enter your year group: ");
            yearGroup.add(sc.nextInt());

            System.out.println("Please enter your current GPA: ");
            currentGPA.add(sc.nextFloat());

            System.out.println("Please enter your date of birth: ");
            sc.nextLine();   
            dateOfBirth.add(sc.nextLine());  
        }
        else{
            System.out.println("User does not exist. Please try again");
        }
    }

    public void viewCourseByCode(){
        System.out.println("Please enter a course code to view its details:");
        int index = courseCodes.indexOf(sc.nextLine());
        if (index != -1){
            System.out.println("This is course " + courseCodes.get(index) + ": " + courseNames.get(index));
            for (int i = 0; i < completeCourseMembersNames.get(index).size(); i++){
                System.out.println("Students taking this course include:\n" + completeCourseMembersNames.get(index).get(i) + ": " + completeCourseMembersEmails.get(index).get(i));
            }
        }
    }

    public void viewCoursesByEmail(){
        System.out.println("Please enter an email to view its courses:");
        email = sc.nextLine();
        String print = "";

        for (int i = 0; i<completeCourseMembersEmails.size(); i++){
            if (completeCourseMembersEmails.get(i).contains(email)){
                print = courseCodes.get(i) + ": " + courseNames.get(i);
                System.out.println(print);
            }
        }
        if (print == ""){
            System.out.println("This email has not registered for any course.");
        }
    }

    public void viewAssignmentsByCourse(){
        System.out.println("Please enter a course code to view its assignments:");
        int index = courseCodes.indexOf(sc.nextLine());
        if (index != -1){
            System.out.println(courseAssignments.get(index).toString());
        }else{
            System.out.println("This course does not exist."); 
        }
    }

    public void viewAssignmentsByEmail(){
        System.out.println("Please enter an email to view assignments:");
        for (int i = 0; i < courseAssignments.size(); i++){
            for (int j = 0; j < assignments.size(); j++){
                if (courseAssignments.get(i).get(j).contains(sc.nextLine())){
                    System.out.println(courseAssignments.get(i).get(j).toString());
                }
            }
        }
    }

}
