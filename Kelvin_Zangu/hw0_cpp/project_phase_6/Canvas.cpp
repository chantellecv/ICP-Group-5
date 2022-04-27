#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Validations { // Holds sensitive user data
    private:
        string email, password, f_n, l_n, dob, yr_grp, gpa; //Users personal details hidden from multiple access

    public:
        vector<string> updatedProfile; // keeps details of users
        map<string,vector<string>> details; // links details of user to their email
        vector<string> admins; // keeps emails with admin privileges
        vector<string> faculty; // keeps email of faculty members
        
        // Setters and getters for user's personal details
        void setEmail(string e){
            email = e;
        }
        string getEmail(){
            return email;
        }
        void setPassword(string p){
            password = p;
        }
        string getPassword(){
            return password;
        }
        void setF_n(string f){
            f_n = f;
        }
        string getF_n(){
            return f_n;
        }
        void setL_n(string l){
            l_n = l;
        }
        string getL_n(){
            return l_n;
        }
        void setD0b(string d){
            dob = d;
        }
        string getDob(){
            return dob;
        }
        void setYr_grp(string y){
            yr_grp = y;
        }
        string getYr_grp(){
            return yr_grp;
        }
        void setGpa(string g){
            gpa = g;
        }
        string getGpa(){
            return gpa;
        }
        
        // Receiving email with user input
        void takeEmail(){
            cout << "Enter your email: ";
            getline(cin, email);
        }
        // Receiving password with user input
        void takePassword(){
            cout << "Enter your password: ";
            getline(cin, password);
        }

};

class Canvas : public Validations{ // Canvas functions inheriting Validations class
    public:
        bool login(){
            cout << "------Login------" << endl;
            takeEmail();
            takePassword();
            cout << details.count(getEmail()) << endl;
            int check = details.count(getEmail()); // Checks if system has the email entered
            std::cout <<std::boolalpha; // Makes sure the returned boolean is a true/false not a 1/0
            return details.count(getEmail());
            
        }
        void createAccount(){
            cout << "------Create Account------" << endl;
            takeEmail();
            takePassword();
            updatedProfile.push_back(getEmail());
            details[getEmail()] = updatedProfile; // Assigns a pair containing a user's email and password to the map

        }
        void updateProfile(){
            cout << "------Update Profile------" << endl;
            if(login() == true){ // After a user successfully logs in
                string f, l, y, g, d; // Temporary storage variables

                // Updates user information with a series of user input ...(start)
                cout << "Please enter your first name:";
                getline(cin, f);
                setF_n(f);
                updatedProfile.push_back(getF_n()); // transfers to Validations class

                cout << "Please enter your last name:";
                getline(cin, l);
                setL_n(l);
                updatedProfile.push_back(getL_n()); // transfers to Validations class

                cout << "Please enter your year group:";
                getline(cin, y);
                setYr_grp(y);
                updatedProfile.push_back(getYr_grp()); // transfers to Validations class

                cout << "Please enter your GPA:";
                getline(cin, g);
                setGpa(g);
                updatedProfile.push_back(getGpa()); // transfers to Validations class

                cout << "Please enter your date of birth (format: dd/mm/yy):";
                getline(cin, d);
                setD0b(d);
                updatedProfile.push_back(getDob()); // transfers to Validations class
                // ...(end)

                details[getEmail()] = updatedProfile;
            }else{
                createAccount();
            }
        }
        bool isAdmin() {
            takeEmail();
            bool exists; // holds confirmation of the availability of an email
            for(auto itr : admins) { // Iterates through admin vector in search of an email
                if (itr == getEmail()) {
                    exists = true;
                }else{
                    exists = false;
                }
            }
            std::cout <<std::boolalpha;
            return exists;
        }
        void viewProfile(){
            map<string, vector<string>>::iterator pos; // map iterator to move through map
            if(login() == true){
                for (pos = details.begin(); pos != details.end(); pos++) { // Goes through 'details' map

                if (pos -> first == getEmail()) { // Finds email being used as the map key
                    for(auto itr : updatedProfile) { // Prints out corresponding value of that key
                        cout << itr << endl;
                    }
                }
            }
            }else{
                createAccount();
            }
        }
        
        void makeFaculty(){
            cout << "------Make Faculty------" << endl;
            if(login() == true){ // Checks for an account
                if(isAdmin()==true){ // Checks if account has an admin privilege
                    faculty.push_back(getEmail());
                    cout << "Deal done" << endl;
                }else{
                    cout << "Your account is not eligible!" << endl;
                }
            }else{
                createAccount();
            }
        }
        bool isFaculty() {
            takeEmail();
            bool exists;
            for(auto itr : faculty) {
                if (itr == getEmail()) {
                    exists = true;
                }else{
                    exists = false;
                }
            std::cout <<std::boolalpha;
               
          }
          return exists; 
            // if (std::find(faculty.begin(), faculty.end(), getEmail())!=faculty.end()){
            //     std::cout <<std::boolalpha;
            //     return true;
            // }else{
            //     std::cout <<std::boolalpha;
            //     return false;
            // }
        }
};

int main(){
    Canvas student;
    
    student.createAccount();
    student.updateProfile();
    student.admins.push_back("kelvin.zangu");
    student.makeFaculty();
    student.viewProfile();
    
    return 0;
}
