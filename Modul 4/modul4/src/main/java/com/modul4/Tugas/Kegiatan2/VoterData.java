package com.modul4.Tugas.Kegiatan2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class VoterData {
    HashMap<String, String> users = new HashMap<>(); // Key = Email ; Value = Password
    HashMap<String, ArrayList<String>> userDetails = new HashMap<>(); // Key = email ; Value = ArrayList that stores Name & NIK

 //   HashMap<String, Boolean> hasVoted = new HashMap<>(); // Key = Email ; Value = Boolean from users that have yet already voted or no
    HashMap<String, Boolean> isVote = new HashMap<>(); // Key = Email ; Value = Boolean that shows if the user is in a voting progress or no
    Scanner input = new Scanner(System.in);
    String email;

    public void register() {
        String email;
        while (true) {
            System.out.print("Enter email: ");
            email = input.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("\nMust end with @gmail.com");
            } else {
                break;
            }
        }

        System.out.print("Enter password: ");
        String pass = input.nextLine();
        System.out.print("Enter name: ");
        String name = input.nextLine();

        String nik;
        while (true) {
            System.out.print("Enter NIK: ");
            nik = input.nextLine();
            if (!isValidNik(nik)) {
                System.out.println("NIK already exists");
            } else {
                break;
            }
        }
        System.out.println("Registration Successful");

        ArrayList<String> nameNik = new ArrayList<>();
        nameNik.add(name);
        nameNik.add(nik);
        users.put(email, pass);
        userDetails.put(email, nameNik);
    }

    boolean isValidEmail(String email) {
        return email.endsWith("@gmail.com");
    }

    boolean isValidNik(String nik) {
        for (ArrayList<String> info : userDetails.values()) {
            if (info.contains(nik)) {
                return false;
            }
        }
        return true;
    }

    public void login() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter email: ");
            String email = input.nextLine();
            System.out.print("Enter Password: ");
            String pass = input.nextLine();

            if (users.containsKey(email) && users.containsValue(pass)) {
                System.out.println("Login Successful");
                this.email = email;
                break;
            } else if (!isValidEmail(email)) {
                System.out.println("Email must end with @gmail.com");
            } else {
                System.out.println("Login Failed, please try again");
            }
        }
    }

    public Boolean voting(String email) {
        if (isVote.containsKey(email)) {
            return true;
        } else {
            isVote.put(email, true);
            return false;
        }
    }

    public void logout() {
        System.exit(0);
    }
}
