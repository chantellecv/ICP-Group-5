import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Properties;



public class Canvas extends Validation implements CanvasFunctions{
	public Canvas() {} // Constructor
	
	

	public void createAccount() {
		System.out.println("-----Create Account-----");
		takeEmail();
		takePassword();
		updatedProfile.add(getEmail());
		updatedProfile.add(getPassword());
		details.put(getEmail(), updatedProfile);
	}
	
	public boolean login() {
		System.out.println("-----Login-----");
		
		try {
			takeEmail();
			
			details.containsKey(getEmail());
			takePassword();
		    } catch (NoSuchElementException e) {
		      System.out.println("You do not have an account!");
		    }
		return(details.containsKey(getEmail()));
	}
	
	public void updateProfile() {
		System.out.println("-----Update Profile-----");
		boolean check = login();
		if(check == true) {
			Scanner rec = new Scanner(System.in);
			System.out.println("Please enter your first name: ");
			String f_n = rec.nextLine();
			setF_n(f_n); // transfers to Validation class
			updatedProfile.add(getF_n());
			System.out.println("Please enter your last name: ");
			String l_n = rec.nextLine(); 
			setL_n(l_n); // transfers to Validation class
			updatedProfile.add(getL_n());
			System.out.println("Enter your year group: ");
			String yr_grp = rec.nextLine();
			setYr_grp(yr_grp);// transfers to Validation class
			updatedProfile.add(getYr_grp());
			System.out.println("Enter your GPA: ");
			String gpa = rec.nextLine();
			updatedProfile.add(getGpa());
			System.out.println("Enter your date of birth (in the format dd/mm/yy): ");
			String dob = rec.nextLine();
			setDob(dob);// transfers to Validation class
			updatedProfile.add(getDob());
			details.put(getEmail(), updatedProfile);
			
		}else {
			createAccount();
		}
	}
	
	public void viewProfile() {
		System.out.println("-----View Profile-----");
		if(login() ) {
			System.out.println("Email--Password--First Name--Last Name--Year Group--GPA--D.O.B.");
			System.out.println(details.get(getEmail()));
		}
	}
	
	public boolean isAdmin() {
		takeEmail();
		return(admins.contains(getEmail()));
	}
	public void makeFaculty() {
		takeEmail();
		if(admins.contains(getEmail())) {
			faculty.add(getEmail());
		}
	}
	public boolean isFaculty() {
		takeEmail();
		return(faculty.contains(getEmail()));
	}
	
	
	

	public void createCourse() {
		System.out.println("-----Create Course----");
		if(login()) {
			if(isFaculty()) {
				Scanner rec = new Scanner(System.in);
				System.out.println("New course name: ");
				String courseName = rec.nextLine();
				setCourseName(courseName); // transfers to Validation class
				System.out.println("Assign a course code: ");
				String courseCode = rec.nextLine();
				setCourseCode(courseCode); // transfers to Validation class
				courseDetails.add(getEmail());
				courseDetails.add(getCourseName());
				courseDetails.add(getCourseCode());
				courseDetails.add(getF_n());
				courseDetails.add(getL_n());
				coursesCreated.put(getCourseName(), courseDetails);
			}else {
				System.out.println("You are not authorized to perform this function.");
			}
		}else {
			System.out.println("You do not have an account. Please create one...");
			createAccount();
		}
	}
	public void viewCourses() {
		System.out.println("-----Showing All Courses-----");
		System.out.println("Email--Course Name--Course Code--Creator's First Name--Creator's Last Name");
		System.out.println(coursesCreated.get(getCourseName()));
	}
	public void registerCourse() {
		if(login()) {
			Scanner rec = new Scanner(System.in);
			System.out.println("Enter the course code of the course you'll like to enroll in: ");
			String courseCodeAssign = rec.nextLine();
			coursesCreated.forEach((k, v) -> {
			    if (v.contains(courseCodeAssign)) {
			        String respCourse = k; 
			        studInCourse.add(getEmail());
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
		System.out.println("-----Add Assignment-----");
		if (login()) {
			if(faculty.contains(getEmail())) {
				coursesCreated.forEach((k, v) -> {
				    if (v.contains(getEmail())) {
				    	takeCourseCode();
				    	takeAssName();
				    	Scanner rec = new Scanner(System.in);
						System.out.println("Enter the email of the student you'll like to assign an assignment: ");
						String studEmail = rec.nextLine();
						System.out.println("Assign a due date for the assignment: ");
						String dueDate = rec.nextLine();
						assDetails.add(getAssName());
						assDetails.add(dueDate);
						courseCodeAss.put(getCourseCode(), assDetails);
						studentAss.put(studEmail, assDetails);
				    }
				});
			}
		}
	}

	public void viewAssignmentsByCourse() {
		System.out.println("-----View Assignment By Course-----");
		takeCourseCode();
		if(courseCodeAss.containsKey(getCourseCode())) {
			System.out.println("These are the assignments...");
			System.out.println(courseCodeAss.get(getCourseCode()));
		}else {
			System.out.println("This course codes has no assignment!");
		}
	}

	public void viewAssignmentsByEmail() {
		takeEmail();
		studentAss.forEach((k, v) -> {
		    if (k == getEmail()) {
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
			setSubAssignment(assignmentSub);
			submission.put(getEmail(), assignmentSub);
		}
	}
	
	public void viewSubmissions() { // NOTETOSELF: Check functionality
		if (login()) {
			if(faculty.contains(getEmail())) {
				takeCourseCode();
				if(coursesCreated.containsKey(getCourseCode())) {
					
					coursesCreated.forEach((k, v) -> {
					    if (v.contains(getEmail())) {
					    	Scanner rec = new Scanner(System.in);
							System.out.println("Enter email of the student: ");
					    	String  studEmail = rec.nextLine();
					    	takeCourseCode();
					    	takeAssName();
					    	if(submission.containsKey(studEmail)) {
					    		System.out.println(submission.get(studEmail));
					    	}
					    }
					});
				}
			}
		}
	}
	
//	public void scoreAssignment() {
//		if (login()) {
//			if(faculty.contains(getEmail())) {
//				coursesCreated.forEach((k, v) -> {
//				    if (v.contains(getEmail())) {
//				    	takeEmail();
//				    	takeCourseCode();
//				    	takeAssName();
//				    	submission.forEach((a, b) -> {
//				    	    if (v.contains(getEmail())) {
//				    	    }
//				    	});
//				    }
//				});
//			}
//		}
//	}
	public void scoreAssignment() {
		if (login()) {
			if(faculty.contains(getEmail())) {
				coursesCreated.forEach((k, v) -> {
				    if (v.contains(getEmail())) {
				    	takeEmail();
				    	takeCourseCode();
				    	takeAssName();
				    	if(submission.containsKey(getEmail())) {
				    		Scanner rec = new Scanner(System.in);
							System.out.println("Score the assignment out of 100: ");
							String assignmentScore = rec.nextLine();
							setAssignmentScore(assignmentScore);
				    	    assignmentAndScore.add(getSubAssignment());
				    	    assignmentAndScore.add(getAssignmentScore());
				    	    assignmentScores.put(getEmail(), assignmentAndScore);
				    	}
				    }
				});
			}
		}
	}
	public void viewAssignmentScore() {
		if(login()) {
			takeEmail();
			takeCourseCode();
			takeAssName();
			if(assignmentScores.containsKey(getEmail())) {
				System.out.println(assignmentScores.get(getEmail()));
			}
		}
	}
	
	public void viewAssignmentScores() {
		if(login()) {
			if(faculty.contains(getEmail())) {
				coursesCreated.forEach((k, v) -> {
				    if (v.contains(getEmail())) {
				    	takeCourseCode();
				    	takeAssName();
				    	assignmentScores.forEach((a, b) -> {
				    		System.out.println(b);
						});
				    }
				});
			}
		}
	}
	
	@Override
	public void viewAllAssignmentScore() {
		if(login()) {
			takeEmail();
			takeCourseCode();
			assignmentScores.get(getEmail());
		}
	}

	@Override
	public void viewAssignmentGrade() {
		if(login()) {
			takeEmail();
			takeCourseCode();
			takeAssName();
			assignmentScores.forEach((k, v) -> {
			    if (k == getEmail()) {
			    	String score = v.get(1);
			    	System.out.println(letterGrades(score));
			    }
			});
		}
	}

	@Override
	public void viewAssignmentGrades() {
		if(login()) {
			if(faculty.contains(getEmail())) {
				coursesCreated.forEach((k, v) -> {
				    if (v.contains(getEmail())) {
				    	takeCourseCode();
				    	takeAssName();
				    	assignmentScores.forEach((a, b) -> {
				    		String score = b.get(1);
				    		System.out.println(letterGrades(score));
						});
				    }
				});
			}
		}
	}

	@Override
	public void viewAllAssignmentGrades() {
		if(login()) {
			takeEmail();
			takeCourseCode();
			assignmentScores.forEach((k, v) -> {
			    if (k == getEmail()) {
			    	String score = v.get(1);
			    	System.out.println(letterGrades(score));
			    }
			});
		}
	}

	@Override
	public void setNotificationPreferences() {
		if(login()){
			takeEmail();
            System.out.println("\nAnswer 'Yes' or 'No'");

            System.out.println("\nWould you like to be notified when assignments are posted?");
            yesOrNo();
            String postNotification = getYesNo().toLowerCase();

            System.out.println("\nWould you like to be notified when assignments are Scored?");
            yesOrNo();
            String scoreNotification = getYesNo().toLowerCase();

            System.out.println("Would you like to be notified when you register for a course?");
            yesOrNo();
            String registrationNotification = getYesNo().toLowerCase();

           

        }
	}
	

	
	public static void main(String[] args) {
	
		
	}

	

}
