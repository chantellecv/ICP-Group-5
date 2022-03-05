public interface CanvasPersonInterface {

    public void createAccount();
    
    public boolean login();

    public void updateProfile();

    public void viewProfile();

    public boolean isAdmin();

    public boolean isFaculty();

    public void viewCourses();

    public void setNotificationPreferences();

    public void setFirstName(String userFirstName);

    public void setLastName(String userLastName);

    public void setDateOfBirth(String userDateOfBirth);

    public String getFirstName();

    public String getLastName();

    public String getDateOfBirth();
}
