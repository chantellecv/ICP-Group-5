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
    cout << "Let's do this.";
    TheClass classObject;    

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
            cout << "Log In Successful. Welcome, " << email << ".\n"
            return true;
        } else {
            cout << "Your account doesn't exist.\n"
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
    ofstream printProfile("profile.txt");

    cout << "User profiles: \n";

    while (printProfile >> name >> yearGroup >> cGPA >> birthday) {
        cout << name << yearGroup << cGPA << birthday << endl;
    }
    
}

// 5 - Make Faculty Function

// 6 - Check if Faculty Function

// 7 - Create Course Function

// 8 - View Courses Function