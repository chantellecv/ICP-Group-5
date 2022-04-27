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

// File Stream Object


class TheClass{
    public:
        TheClass(){
            cout << "so this is a constructor." << endl;
        };
        string name;
};

// Main Function
int main()
{
    ofstream testFile("test.txt");

    if(testFile.is_open()) {
        cout << "Connected to data store." << endl;
        testFile << "I want to die.\n";
    } else {
        cout << "Failed to connect to data store." << endl;
    }
    
    testFile.close();


    cout << "Let's do this.";
    TheClass classObject;    
    return 0;
}

// 1 - Create Account Function
void createAccount()
{
    string email;
    string password;
    ofstream accountFile("accounts.txt");

    cout << "Create your account." << endl;
    cout << "Enter your email address below:\n";
    cin >> email;
    cout << "Set a secure password:\n";
    cin >> password;

    if(accountFile.is_open()) {
        cout << "Connected to data store." << endl;
        accountFile << email << ' ' << password << endl;
        cout << "Account created!";
    } else {
        cout << "Failed to connect to data store." << endl;
    }
    
    accountFile.close();


}



// 2 - Log In Function

// 3 - Update Profile Function

// 4 - View Profile Function

// 5 - Make Faculty Function

// 6 - Check if Faculty Function

// 7 - Create Course Function

// 8 - View Courses Function