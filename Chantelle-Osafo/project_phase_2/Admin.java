public class Admin extends CanvasPerson implements AdminInterface{

    public void makeFaculty(){
        if (login()==true && isAdmin()==true){
            System.out.println("Please enter the email address of the person to be made faculty.");
            email = sc.nextLine();
            facultyList.add(email);
            System.out.println("You have successfully made " + email + " a faculty member.");
        }else{
            System.out.println("You do not have the permission to do this.");
        }
    }
}