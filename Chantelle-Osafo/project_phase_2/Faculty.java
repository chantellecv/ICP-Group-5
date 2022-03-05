import java.util.*;

public class Faculty extends CanvasPerson implements FacultyInterface{

    int score = 0;
    String courseCode;
    String courseName;
    public static String name;

    ArrayList<Integer> scores = new ArrayList<>();

    ArrayList<String> courseCodes = new ArrayList<String>();
    ArrayList<String> courseNames = new ArrayList<String>();
    ArrayList<String> submitterEmails = new ArrayList<String>();

    ArrayList<String> courseMemberNames = new ArrayList<>();
    ArrayList<String> courseMemberEmails = new ArrayList<>();
    ArrayList<String> assignmentSubmissions = new ArrayList<String>();
    ArrayList<ArrayList<String>> assignments = new ArrayList<>();
    ArrayList<ArrayList<String>> courseSubmissions = new ArrayList<>();
    ArrayList<ArrayList<String>> completeCourseMembersNames = new ArrayList<>();
    ArrayList<ArrayList<String>> completeCourseMembersEmails = new ArrayList<>();
    ArrayList<ArrayList<ArrayList<String>>> courseAssignments = new ArrayList<>();
    
    public void createCourse(){

        if (login()==true && isFaculty()==true){
            System.out.println("Please enter your email: ");
            creatorEmails.add(sc.nextLine());

            System.out.println("Please enter your name: ");
            creatorNames.add(sc.nextLine());

            System.out.println("Please enter the course code: ");
            courseCode = sc.nextLine();
            courseCodes.add(courseCode);

            System.out.println("Please enter the course name: ");
            courseName = sc.nextLine();
            courseNames.add(courseName);

            System.out.println("You have successfully created the course " + courseCode + ": " + courseName);
        }
    }
    
    public void viewSubmissions(){
        if (login() == true && isFaculty()==true && creatorEmails.contains(email)){
            System.out.println("Please enter an email address:");
            email = sc.nextLine();

            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();
            int index = courseCodes.indexOf(courseCode);

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            if (index != -1){
                for (int i = 0; i < completeCourseMembersNames.get(index).size(); i++){
                    String user = completeCourseMembersNames.get(index).get(i);

                    for (int j = 0; j < courseAssignments.size(); j++){
                        for (int k = 0; k < assignmentSubmissions.size(); k++){
                            if (courseAssignments.get(i).get(k).contains(user) && courseAssignments.get(i).get(k).contains(assignmentName)){
                                int ind = courseAssignments.get(i).indexOf(courseAssignments.get(i).get(k));
                                System.out.println(courseSubmissions.get(i).get(ind));
                            }
                        }
                    }
                }
            }
        }
    }

    public void scoreAssignment(){
        if (login() == true && isFaculty()==true && creatorEmails.contains(email)){
            System.out.println("Please enter an email address:");
            email = sc.nextLine();

            System.out.println("Please enter the course code:");
            courseCode = sc.nextLine();

            System.out.println("Please enter the assignment name:");
            String assignmentName = sc.nextLine();

            System.out.println("Please enter the a score:");
            score = sc.nextInt();

            if (courseCodes.contains(courseCode) && submitterEmails.contains(email)){
                for (int i = 0; i < courseAssignments.size(); i++){
                    for (int j = 0; j < assignments.size(); j++){
                        int index = courseAssignments.get(i).get(j).indexOf(assignmentName);
                        scores.add(index, score);
                    }
                }
            }
        }
    }

    public void registerCourse(){
        if (login() == true){
            System.out.println("Welcome to the course registration page.\nPlease enter your name:");
            name = sc.nextLine();

            System.out.println("Please enter your email address:");
            email = sc.nextLine();

            System.out.println("Please enter the code of the course you would like to register for:");
            courseCode = sc.nextLine();

            if (courseCodes.contains(courseCode)){
                int index = courseCodes.indexOf(courseCode);
                courseMemberNames.add(name);
                courseMemberEmails.add(email);
                completeCourseMembersNames.add(index, courseMemberNames);
                completeCourseMembersEmails.add(index, courseMemberEmails);
            }else{
                System.out.println("This course does not exist.");
            }
            System.out.println("You have successfully registered for this course.");
        }
    }

    public void addAssignment(){
        if (isFaculty() == true && creatorEmails.contains(email)){
            System.out.println("Please enter your email:");
            assignment.add(sc.nextLine());

            System.out.println("Please enter a course code:");
            courseCode = sc.nextLine();
            assignment.add(courseCode);
            int index = courseCodes.indexOf(courseCode);

            System.out.println("Please enter an assignment name:");
            assignment.add(sc.nextLine());

            System.out.println("Please enter an assignment description:");
            assignment.add(sc.nextLine());

            System.out.println("Please enter a due date:");
            assignment.add(sc.nextLine());

            System.out.println("Please enter the assignment type:");
            assignment.add(sc.nextLine());
            assignments.add(assignment);
            courseAssignments.add(index, assignments);
            System.out.println("You have successfully added this assignment.");
        }else{
            System.out.println("You do not have the permission to do this.");
        }
        
    }

}
