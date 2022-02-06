import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Canvas {
	public Canvas() {} // Constructor
	String email, password, f_n, l_n, dob, yr_grp, gpa;
	
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
	Set<String> set = details.keySet();
	
	
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
		boolean check = login();
		if(check == true ) {
			System.out.println(details.get(email));
		}
	}
	
	public boolean isAdmin() {
		takeEmail();
		return(admins.contains(email));
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
	
	
	public static void main(String[] args) {
		Canvas person = new Canvas();
		//person.createAccount();
		//System.out.println(person.details.containsKey(""));
		System.out.println(person.login());
		
		
		
	}

}
