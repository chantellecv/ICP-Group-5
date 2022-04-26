#include <iostream>
#include <vector>
#include <string>
using namespace std;

struct Phase6 // declaration of structure containing all variables
{
    string email;
    string password;
    string input;
    int index;
    bool result;
    std::vector<std::string> emailList;
    std::vector<std::string> adminList;
    std::vector<std::string> passwordList;
    std::vector<std::string> facultyList;
    std::vector<std::string> firstName;
    std::vector<std::string> lastName;
    std::vector<std::string> yearGroup;
    std::vector<std::string> currentGPA;
    std::vector<std::string> doB;
};

Phase6 phase; // structure variable

class Canvas // class with all methods
{
public: // access specifier declaring all class members public
    void createAccount();
    bool login();
    void updateProfile();
    void viewProfile();
    bool isAdmin();
    void makeFaculty();
    bool isFaculty();
};

void Canvas::createAccount() // Method to create account
{
    cout << "Hello. Please enter your email address to create an account: ";
    cin >> phase.email;
    cout << "Please enter a password: ";
    cin >> phase.password;

    phase.emailList.push_back(phase.email); // adding an element to the vector
    phase.adminList.push_back(phase.email);
    phase.passwordList.push_back(phase.password);
    cout << "You have successfully created your account." << endl;
}

bool Canvas::login() // login method
{
    cout << "Welcome to the login page. Please enter your email address: " << endl;
    cin >> phase.email;
    cout << "Please enter your password: " << endl;
    cin >> phase.password;

    std::vector<string>::iterator itrEmail = std::find(phase.emailList.begin(), phase.emailList.end(), phase.email);         // iterator to find index of 'email' in the vector 'emailList'
    std::vector<string>::iterator itrPass = std::find(phase.passwordList.begin(), phase.passwordList.end(), phase.password); // iterator to find index of 'password' in the vector 'passwordList'
    if (itrEmail - phase.emailList.begin() == itrPass - phase.passwordList.begin() && itrEmail != phase.emailList.end())     // checking if 'email' and 'password' have the same index in respective vectors
    {
        cout << "You have succesfully logged in." << endl;
        return true;
    }
    else
    {
        cout << "Incorrect email or password." << endl;
        return false;
    }
}

void Canvas::updateProfile() // method to update profile
{
    cout << "Update Profile" << endl;
    if (login() == true)
    {
        cout << "To update your profile, continue." << endl;

        cout << "Please enter your first name(s): " << endl;
        cin.ignore();
        getline(cin, phase.input);              // inbuilt getline method accepts inputs with multiple words
        phase.firstName.push_back(phase.input); // storing first name(s)

        cout << "\nPlease enter your last name: " << endl;
        cin >> phase.input;
        phase.lastName.push_back(phase.input); // storing last name

        cout << "Please enter your year group: " << endl;
        cin >> phase.input;
        phase.yearGroup.push_back(phase.input); // storing year group

        cout << "Please enter your current GPA: " << endl;
        cin >> phase.input;
        phase.currentGPA.push_back(phase.input); // storing GPA

        cout << "Please enter your date of birth: " << endl;
        cin.ignore();
        getline(cin, phase.input);
        phase.doB.push_back(phase.input); // storing date of birth
    }
    else
    {
        cout << "User does not exist. Please try again." << endl;
    }
}

void Canvas::viewProfile() // method to view profile
{
    cout << "View Profile" << endl;
    if (login() == true)
    {
        cout << "To view your profile, continue." << endl;
        cout << "Please enter your email: " << endl;
        cin >> phase.email;

        std::vector<string>::iterator itrEmail = std::find(phase.emailList.begin(), phase.emailList.end(), phase.email); // finding the index of 'email' in the vector 'emailList'
        phase.index = itrEmail - phase.emailList.begin();                                                                // storing index in 'index' variable

        try // exception block
        {
            cout << "Your first name is: " << phase.firstName.at(phase.index) << endl; // print first name of user whose email was provided
        }
        catch (...) // to catch any type of exception
        {
            cerr << "NA" << endl; // print 'NA' if an error occurred
        }
        try
        {
            cout << "Your last name is: " << phase.lastName.at(phase.index) << endl; // print last name of user whose email was provided
        }
        catch (...)
        {
            cerr << "NA" << endl;
        }
        try
        {
            cout << "Your GPA is: " << phase.currentGPA.at(phase.index) << endl; // print GPA of user whose email was provided
        }
        catch (...)
        {
            cerr << "NA" << endl;
        }
        try
        {
            cout << "Your year group is: " << phase.yearGroup.at(phase.index) << endl; // print year group of user whose email was provided
        }
        catch (...)
        {
            cerr << "NA" << endl;
        }
        try
        {
            cout << "Your date of birth is: " << phase.doB.at(phase.index) << endl; // print birth date of user whose email was provided
        }
        catch (...)
        {
            cerr << "NA" << endl;
        }
    }
}

bool Canvas::isAdmin() // method to check for admin
{
    cout << "Check for Admin\nPlease enter an email address: ";
    cin >> phase.email;
    phase.result = false;                                                             // boolean variable initialisation
    if (std::count(phase.adminList.begin(), phase.adminList.end(), phase.email) != 0) // if 'email' is contained in the adminList
    {
        phase.result = true; // setting variable to true
        cout << "User is an admin." << endl;
    }
    else
    {
        cout << "User is NOT an admin." << endl;
    }
    return phase.result; // returning true if user is an admin, false otherwise
}

void Canvas::makeFaculty() // method to make a user faculty
{
    cout << "Make faculty" << endl;
    if (login() == true && isAdmin() == true) // user must be logged in and must be an admin
    {
        cout << "Please enter the email address of the person to be made faculty: " << endl;
        cin >> phase.email;
        phase.facultyList.push_back(phase.email); // adds user to faculty list
        cout << "You have successfully made " << phase.email << " a faculty member." << endl;
    }
    else
    {
        cout << "You do not have the permission to do this." << endl;
    }
}

bool Canvas::isFaculty() // method to check whether a user is faculty
{
    cout << "Please enter the email address to be checked: " << endl;
    cin >> phase.email;
    if (count(phase.facultyList.begin(), phase.facultyList.end(), phase.email) != 0) // if the email is found in the faculty list
    {
        cout << "User is faculty." << endl;
        return true;
    }
    else
    {
        cout << "User is NOT faculty." << endl;
        return false;
    }
}

int main() // main method
{
    Canvas obj;          // creating an object of the Canvas class
    obj.createAccount(); // calling the methods
    obj.login();
    obj.updateProfile();
    obj.viewProfile();
    obj.isAdmin();
    obj.makeFaculty();
    obj.isFaculty();
    return 0;
}