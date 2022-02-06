import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Canvas {
	public Canvas() {} // Constructor
	String email, password, f_n, l_n, dob, yr_grp, gpa, courseName, courseCode, assName;
	String todaysDateis = "04/02/22";
	
//	String getEmail() {
//		return email;
//	}
//	String getPassword() {
//		return password;	
//	}
//	String getFullName() {
//		return f_n;
//	}
//	String getLastName() {
//		return l_n;
//	}
//	String getDOB() {
//		return dob;
//	}
//	int getYearGroup() {
//		return yr_grp;
//	}
//	float getGPA() {
//		return gpa;
//	}
	HashMap<String, ArrayList<String>> details = new HashMap<String, ArrayList<String>>();
	ArrayList<String> updatedProfile = new ArrayList<String>();
	
	ArrayList<String> admins = new ArrayList<String>();
	ArrayList<String> faculty = new ArrayList<String>();
	
	HashMap<String, ArrayList<String>> coursesCreated = new HashMap<String, ArrayList<String>>(); // Creating a course
	ArrayList<String> courseDetails = new ArrayList<String>();//email courseCode firstName lastName
	
	HashMap<String, ArrayList<String>> courseReg = new HashMap<String, ArrayList<String>>(); // Adding a student to a course
	ArrayList<String> studInCourse = new ArrayList<String>();
	
	HashMap<String, ArrayList<String>> courseCodeAss = new HashMap<String, ArrayList<String>>(); // Adding a student to a course
	HashMap<String, ArrayList<String>> studentAss = new HashMap<String, ArrayList<String>>(); // Assigning assignment to student
	HashMap<String, String> submission = new HashMap<String, String>(); // Student submitting assignment

	ArrayList<String> assDetails = new ArrayList<String>();// Assignment name and due date

	public void createAccount() {
		takeEmail();
		takePassword();
		updatedProfile.add(password);
		details.put(email, updatedProfile);
	}
	
	public boolean login() {
		takeEmail();
		takePassword();
		return(details.containsKey(email));
	}
	
	public void updateProfile() {
		boolean check = login();
		if(check == true) {
			Scanner rec = new Scanner(System.in);
			System.out.println("Please enter your first name: ");
			f_n = rec.nextLine();
			updatedProfile.add(f_n);
			System.out.println("Please enter your last name: ");
			l_n = rec.nextLine();
			updatedProfile.add(l_n);
			System.out.println("Enter your year group: ");
			yr_grp = rec.nextLine();
			updatedProfile.add(yr_grp);
			System.out.println("Enter your GPA: ");
			gpa = rec.nextLine();
			updatedProfile.add(gpa);
			System.out.println("Enter your date of birth: ");
			dob = rec.nextLine();
			updatedProfile.add(dob);
			details.put(email, updatedProfile);
			
		}else {
			createAccount();
		}
	}
	
	public void viewProfile() {
		if(login() ) {
			System.out.println(details.get(email));
		}
	}
	
	public boolean isAdmin() {
		takeEmail();
		return(admins.contains(email));
	}
	public void makeFaculty() {
		takeEmail();
		if(admins.contains(email)) {
			faculty.add(email);
		}
	}
	public boolean isFaculty() {
		takeEmail();
		return(faculty.contains(email));
	}
	
	
	void takeEmail() {
		Scanner rec = new Scanner(System.in);
		System.out.println("Please enter your email: ");
		this.email = rec.nextLine();
	}
	void takePassword() {
		Scanner rec = new Scanner(System.in);
		System.out.println("Please enter your password: ");
		this.password = rec.nextLine();
	}
	void takeAssName() {
		Scanner rec = new Scanner(System.in);
		System.out.println("Please enter the name of the assignment: ");
		this.assName = rec.nextLine();
	}
	void takeCourseCode() {
		Scanner rec = new Scanner(System.in);
		System.out.println("Please enter the course code: ");
		this.courseCode = rec.nextLine();
	}
	void createCourse() {
		if(login()) {
			if(isFaculty()) {
				Scanner rec = new Scanner(System.in);
				System.out.println("New course name: ");
				this.courseName = rec.nextLine();
				System.out.println("Assign a course code: ");
				this.courseCode = rec.nextLine();
				courseDetails.add(email);
				courseDetails.add(courseName);
				courseDetails.add(courseCode);
				courseDetails.add(f_n);
				courseDetails.add(l_n);
				coursesCreated.put(courseName,courseDetails);
			}
		}
	}
	void viewCourses() {
		System.out.println(coursesCreated.get(courseName));
	}
	void registerCourse() {
		if(login()) {
			Scanner rec = new Scanner(System.in);
			System.out.println("Enter the course code of the course you'll like to enroll in: ");
			String courseCodeAssign = rec.nextLine();
			coursesCreated.forEach((k, v) -> {
			    if (v.contains(courseCodeAssign)) {
			        String respCourse = k; 
			        studInCourse.add(email);
			        courseReg.put(respCourse, studInCourse);
			    }
			});
			
		}
	}
	
	public void viewCourseByCode() {
		Scanner rec = new Scanner(System.in);
		System.out.println("Enter the course code of the course you'll like to review: ");
		String courseCodeRev = rec.nextLine();
		coursesCreated.forEach((k, v) -> {
		    if (v.contains(courseCodeRev)) {
		    	System.out.println("Course: " + k);
		    	System.out.println("Course code: " + courseCodeRev);
		    	courseReg.forEach((a, b) -> {
		    	    if (a == k) {
		    	       System.out.println(b);
		    	    }
		    	});
		    }
		});
	}
	
	public void viewCourseByEmail() {
		
	}
	
	public void addAssignment() {
		if (login()) {
			if(faculty.contains(email)) {
				coursesCreated.forEach((k, v) -> {
				    if (v.contains(email)) {
				    	takeCourseCode();
				    	takeAssName();
				    	Scanner rec = new Scanner(System.in);
						System.out.println("Enter the email of the student you'll like to assign an assignment: ");
						String studEmail = rec.nextLine();
						System.out.println("Assign a due date for the assignment: ");
						String dueDate = rec.nextLine();
						assDetails.add(assName);
						assDetails.add(dueDate);
						courseCodeAss.put(courseCode, assDetails);
						studentAss.put(studEmail, assDetails);
				    }
				});
			}
		}
	}

	public void viewAssignmentsByCourse() {
		takeCourseCode();
		courseCodeAss.forEach((k, v) -> {
		    if (k == courseCode) {
		    	System.out.println(v);
		    }
		});
	}

	public void viewAssignmentsByEmail() {
		takeEmail();
		studentAss.forEach((k, v) -> {
		    if (k == email) {
		    	System.out.println(v);
		    }
		});
	}

	public void submitAssignment() {
		if(login()) {
			takeEmail();
			takeCourseCode();
			takeAssName();
			Scanner rec = new Scanner(System.in);
			System.out.println("Submit your assignment: ");
			String assignmentSub = rec.nextLine();
			submission.put(email, assignmentSub);
		}
	}
	
	public void viewSubmissions() {
		if (login()) {
			if(faculty.contains(email)) {
				coursesCreated.forEach((k, v) -> {
				    if (v.contains(email)) {
				    	Scanner rec = new Scanner(System.in);
						System.out.println("Enter email of the student: ");
				    	String  studEmail = rec.nextLine();
				    	takeCourseCode();
				    	takeAssName();
				    	submission.forEach((a, b) -> {
				    	    if (studEmail == a) {
				    	    	System.out.println(b);
				    	    }
				    	});
				    	
				    }
				});
			}
		}
	}
	
	public void scoreAssignment() {
		if (login()) {
			if(faculty.contains(email)) {
				coursesCreated.forEach((k, v) -> {
				    if (v.contains(email)) {
				    	takeEmail();
				    	takeCourseCode();
				    	takeAssName();
				    	submission.forEach((a, b) -> {
				    	    if (v.contains(email)) {
				    	    }
				    	});
				    }
				});
			}
		}
	}
	public void viewAssignmentScore() {
		
	}
	
	public void viewAssignmentScores() {
		
	}
	public static void main(String[] args) {
		Canvas person = new Canvas();
		//person.createAccount();
		//System.out.println(person.details.containsKey(""));
		System.out.println(person.login());
		
		
		
	}

}

