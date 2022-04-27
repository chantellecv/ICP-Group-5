#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// Function Prototypes
void createAccount();
bool login();
void updateProfile();
void viewProfile();
void makeFaculty();
bool isFaculty();
void createCourse();
void viewCourses();

class TheClass {
    public:
        TheClass() {
            cout << "This is a constructor." << endl;
        };
        void sayHey() {
            cout << "HEY.";
        }
};
class TheSecondClass {
    public:
        TheSecondClass() {
            cout << "This is another contructor." << endl;
        };
        void sayHey() {
            cout << "heyyo";
        }
}

// Main Function
int main()
{
    cout << "Hello world :). Welcome to Canvas... sort of.";

    TheClass classObject;
    classObject.sayHey();

    TheSecondClass anotherClassObject;
    anotherClassObject.sayHey();


    return 0;
}

// 1 - Create Account Function
void createAccount()
{
    string email, password;
    ofstream accountFile("accounts.txt");

    cout << "Create your account." << endl;

    cout << "Enter your email address below:\n";
    cin >> email;
    cout << "Set a secure password:\n";
    cin >> password;

    cout << "Connecting..."
    if(accountFile.is_open()) {
        cout << "Connected to data store." << endl;
        accountFile << email << ' ' << password << endl;
        cout << "Account created!\n";
    } else {
        cout << "Failed to connect to data store.\n" << endl;
    }
    
    accountFile.close();
}

// 2 - Log In Function
bool logIn()
{
    string email, password;
    string emailData, passwordData;
    ifstream checkFile("accounts.txt");

    cout << "Log In." << endl;

    cout << "Enter your email address below:\n";
    cin >> email;
    cout << "Enter your password below:\n";
    cin >> password;

    while(checkFile >> emailData >> passwordData) {
        if (email == emailData && password == passwordData) {
            cout << "Log In Successful. Welcome, " << email << ".\n";
            return true;
        } else {
            cout << "Your account doesn't exist.\n";
            return false;
        }
    }
}

// 3 - Update Profile Function
void updateProfile()
{
    string name, yearGroup, cGPA, birthday;
    ofstream proFile("profile.txt");

    cout << "Your name:" << endl;
    cin >> name;    
    cout << "Your year group:" << endl;
    cin >> yearGroup;
    cout << "Your current GPA:" << endl;
    cin >> cGPA;
    cout << "Your birthday:" << endl;
    cin >> birthday;

    cout << "Connecting..."
    if(proFile.is_open()) {
        cout << "Connected to data store." << endl;
        proFile << name << ' ' << yearGroup << ' ' << cGPA << ' ' << birthday << endl;
        cout << "Account created!\n";
    } else {
        cout << "Failed to connect to data store.\n" << endl;
    }
    
    proFile.close();
}

// 4 - View Profile Function
void viewProfile()
{
    string name, yearGroup, cGPA, birthday;
    ifstream printProfile("profile.txt");

    cout << "User profiles: \n";

    while (printProfile >> name >> yearGroup >> cGPA >> birthday) {
        cout << name << yearGroup << cGPA << birthday << endl;
    }
    
}

// 5 - Make Faculty Function
void makeFaculty()
{
    string email;

    ofstream makeFacFile("faculty.txt");

    cout << "Let's make you faculty!\n";
        << "Enter your email below:" << endl;
    cin >> email;

    if(makeFacFile.is_open()) {
        makeFacFile << email << endl;
        cout << "You're faculty :)";
    } else {
        cout << "There was an error accessing the database.";
    }

}

// 6 - Check if Faculty Function
bool isFaculty()
{
    string email;
    string emailData;
    ifstream checkFacFile("faculty.txt");

    cout << "Let's see if you're faculty." << endl;

    cout << "Enter your email address below:\n";
    cin >> email;

    while(checkFacFile >> emailData) {
        if (email == emailData) {
            cout << "You're faculty.\n";
            return true;
        } else {
            cout << "You're... unemployed?\n";
            return false;
        }
    }
}

// 7 - Create Course Function
void createCourse()
{
    ofstream courseFile("course.txt");
    ifstream facultyFile("faculty.txt");

    string email, facultyEmail;
    int code;
    string name;

    cout << "Let's verify if you're faculty:\n";
    cin >> email;

    while(facultyFile >> facultyEmail) {
        if(email == facultyEmail) {
            cout << "Access approved." << endl
                << "What's the name of the new course?";
            cin >> name;
            cout << "What's the course code?\n";
            cin >> code;

            courseFile << code << name << endl;

            cout << "Your course has been added.\n";
        } else {
            cout << "Access denied. Who are you?\n";
        }
    }
    courseFile.close();
}

// 8 - View Courses Function
void viewCourses()
{
    string name, code;
    ifstream viewCourse("course.txt");

    cout << "View courses: \n";

    while (viewCourse >> name >> code) {
        cout << name << code << endl;
    }
}