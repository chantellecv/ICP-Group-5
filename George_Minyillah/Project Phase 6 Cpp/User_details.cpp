#include <iostream>
using namespace std;

/////////////////////////////////////////////////
/// \ICP final project cpp
///
/// \Author Minyillah George Mensah
/// \Date 25th March, 2022
/// \return
///
/////////////////////////////////////////////////





/////////////////////////////////////////////////
/// \brief User_details is a class that contains all the information of the users on the system
/// i accomplished this using a multidimensional array, for the user information, a single array for faculty and admin
/// this is because i only had to save their emails for verification
/// \param login_required, isFaculty,
/// \param isAdmin
/// \return
///
/////////////////////////////////////////////////

class User_details {        // The class
  public:
    int col = 7;
    int row = 7;
    string users[7][7];
    string faculty[3];
    string admin[2] =  {"dennis.owusu@ashesi.edu.gh", "daniel.nattey@ashesi.edu.gh"};
    bool login_required = false;
    bool isFaculty = false;
    bool isAdmin = false;


    /////////////////////////////////////////////////
    /// \brief This function takes the email and password of a user and save it in the user array. first check is the
    /// \brief the current index is empty, if it is, it adds the current user and if not, it moves to the next index
    ///
    /// \param email
    /// \param password
    /// \return nothing, it's a void method
    ///
    /////////////////////////////////////////////////

    void createAccount(string email, string password){
        cout<< "\nyou are about to create an account\n";
        for (int y =0; y<row; y++){
                if(users[0][y] == ""){
                    users[0][y] = email;
                    users[1][y] = password;
                    break;
                }
            }

    }



    /////////////////////////////////////////////////
    /// \brief This function takes the email and password of a
    /// \brief user and return true if the user exists; false otherwise. this function loops through the user array
    /// \brief is the email is found, it then compares the password, if the are the same, the user is logged in
    /// \param email
    /// \param password
    /// \return true if user exist and login was successful and false otherwise
    ///
    /////////////////////////////////////////////////

    bool login(string email, string password){
        cout<< "\nyou are about to login into your account\n";
        for (int y =0; y<row; y++){
            if((users[0][y] == email) & (users[1][y] == password)){
                cout<<"Login successful\n";
                login_required = true;
                return true;
                break;
            }
        }

    }





    /////////////////////////////////////////////////
    /// \brief This function takes the email of a user and then loops through the user array, if the user is found
    /// \brief it the updates the columns with the necessary information that is: first name, last name, year group,
    /// \brief current GPA, and date of birth.
    /// \param email, first name, last name, year group
    /// \param GPA, date of birth
    /// \return nothing. it's a void method
    ///
    /////////////////////////////////////////////////

    void updateProfile(string email, string firstname, string lastname, string year_group, string GPA, string DOB){
        cout<< "\nyou are about to update your profile\n";
        if(login_required == true){
                for (int y =0; y<row; y++){
                if(users[0][y] == email){
                    users[2][y] = firstname;
                    users[3][y] = lastname;
                    users[4][y] = year_group;
                    users[5][y] = GPA;
                    users[6][y] = DOB;
                    break;
                }

            }

        }

    }




    /////////////////////////////////////////////////
    /// \brief This function takes the email of a user,loops through the user array to find the email and then
    /// \brief display their profile details as specified in the previous function. If the user does not
    /// \brief have any of the profile elements, display �NA� for that profile element.
    ///
    /// \param email
    /// \param
    /// \return
    ///
    /////////////////////////////////////////////////

    void viewProfile(string email)
    {
        cout<<"\nYou are about to view your profile\n"<<endl;
        if(login_required == true){
            for (int y =0; y<row; y++){
                    if(users[0][y] == email){
                        if(users[2][y] == ""){
                            cout<<"NA ";
                        }else{
                            cout<<"Email: " + users[0][y] << "\n";
                            cout<<"Password: " + users[1][y] << "\n";
                            cout<<"Firstname: " + users[2][y] << "\n";
                            cout<<"Lastname: " + users[3][y] << "\n";
                            cout<<"Year Group: " + users[4][y] << "\n";
                            cout<<"GPA: " + users[5][y] << "\n";
                            cout<<"Date of Birth: " + users[6][y] << "\n";

                        }
                    }
            }
        }

    }


    /////////////////////////////////////////////////
    /// \brief This function takes the email of a user and iterate through the
    /// \brief admin array, if the email is in the array, return true else return false
    /// \param email
    /// \param
    /// \return true is user is an admin and false if otherwise
    ///
    /////////////////////////////////////////////////

    bool isadmin(string email){
        for (int i = 0; i < 2; i++) {
            if(admin[i] == email){
                cout<<"\nThis user is an admin\n";
                isAdmin = true;
                return true;
                break;
            }
        }
    }





    /////////////////////////////////////////////////
    /// \brief This function takes the email of a user,if the user is in the user array, then we add the
    /// \brief user's email to the faculty array.
    ///
    /// \param email
    /// \param
    /// \return
    ///
    /////////////////////////////////////////////////

    void makeFaculty(string email){
        if(login_required == true){
            for (int i = 0; i < 3; i++) {
                if(faculty[i] == ""){
                    faculty[i] = email;
                    cout << "\nYou have successful made this user a faculty member\n";
                    isFaculty = true;
                    break;
                }else{
                    i++;
                }
            }
        }

    }

};



// using inheritance, where User_details is the parent class and Course_details is the child class
// the public declaration for the user_details class in the parent class is necessary to make the public variables and method accessible in the child class
class Course_details: public User_details {        // The class
  public:
    int size=3;
    int col = 3;
    int row = 3;
    string courses[3][3];



    /////////////////////////////////////////////////
    /// \brief This function takes the email of a user, check if the user is a faculty member and if the
    /// \brief user is logged in, we check if the user is a faulty member by iterating through the faculty table to find the email
    /// \brief if everything is valid, we then create a course with the following details
    /// \brief a course code and course name and create the course.
    ///
    /// \param email, course code
    /// \param  course name
    /// \return
    ///
    /////////////////////////////////////////////////

    void createCourse(string email, string couse_code, string course_name){
        cout<< "you are about to create a course\n";
        if(login_required == true){
            for(int i =0; i < 3; i++){
                if(faculty[i] == email){
                    for (int y =0; y < row; y++){
                        if(courses[0][y] == ""){
                            courses[0][y] = email;
                            courses[1][y] = couse_code;
                            courses[2][y] = course_name;
                            break;
                        }
                    }
                    cout<< "Course creation successful";
                }
            }
        }
    }






    /////////////////////////////////////////////////
    /// \brief This function display all created courses, showing the course code and course name
    /// \brief as well as the email and name of the course creator. it does this by iterating through the
    /// \brief the courses array and since it is a multidimensional array, i used a nested loop to get all the
    /// \brief all the elements.
    /// \param
    /// \param
    /// \return
    ///
    /////////////////////////////////////////////////

    void viewCourses(){
        cout<<"user elements are: "<<endl;
        for (int y =0; y<row; y++){
            for (int x =0; x<3; x++){
                    if(courses[x][y] == ""){
                        cout<<"NA ";
                    }else{
                    cout<<courses[x][y] << " ";
                    }
            }
            cout<<"\n";
        }
    }


};




int main(){
    //Course_details Mensah;
    Course_details George;
    George.createAccount("george.minyillah@ashesi.edu.gh", "Minyillah");
    George.createAccount("georgeminyillah@gmail.com", "George");
    George.createAccount("godslovemensah@gmail.com", "Godslove");
    George.login("george.minyillah@ashesi.edu.gh", "Minyillah");
    //George.login("georgeminyillah@gmail.com", "George");
    George.updateProfile("george.minyillah@ashesi.edu.gh","George", "Minyillah", "2023", "3.5", "10th April 2000");
    George.viewProfile("george.minyillah@ashesi.edu.gh");
    George.isadmin("daniel.nattey@ashesi.edu.gh");
    George.makeFaculty("godslovemensah@gmail.com");
    George.createCourse("godslovemensah@gmail.com", "Math221", "Statistics" );
    George.createCourse("godslovemensah@gmail.com", "CSS221", "Computer programming for engineers" );
    George.createCourse("godslovemensah@gmail.com", "CS313", "ICP" );
    George.viewCourses();
    return 0;
}
