package com.moony;

import java.util.Scanner;
import java.util.HashMap;

public class Main {
    // global HashMap
    public static HashMap<String, String> userAccounts = new HashMap <String, String>();

    public static void main(String[] args) {
        System.out.println("Let's get this over with.");

        createAccount();
        System.out.println(userAccounts);

        login();
    }

    public static void createAccount() {
        // saves user's email and password
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your desired email address below:");
        String email = input.nextLine();
        System.out.println("Set a secure password:");
        String password = input.nextLine();

        userAccounts.put(email, password);
        System.out.println("Your account has been created.");
    }

    public static boolean login() {
        // returns True if the user exists
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your email address:");
        String email = input.nextLine();
        System.out.println("Enter your password:");
        String password = input.nextLine();

        if (userAccounts.containsKey(email) && userAccounts.get(email).equals(password)) {
            System.out.println("Logged in successfully. Welcome, " + email);
            return true;
        }
        else {
            System.out.println("Your account doesn't exist.");
            return false;
        }
    }

    public static void updateProfile() {

    }
}
