package com.modul4.Tugas.Kegiatan2;

import java.util.HashMap;
import java.util.Scanner;

public class Kegiatan2 {

    public static void main(String[] args) {
        HashMap<String, Integer> candidates = new HashMap<>();
        Scanner input = new Scanner(System.in);
        VoterData data = new VoterData();

        data.users.put("farriel@gmail.com", "7904");

        candidates.put("Candidate A", 0);
        candidates.put("Candidate B", 0);
        candidates.put("Candidate C", 0);

        boolean done = false;

        do {
            boolean correct = false;
            while (!correct) {
                System.out.println("\nWelcome to the Online Voting System");
                System.out.println("Choose an option:");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Voting Results");
                System.out.println("4. Exit / Logout");
                System.out.print("Your choice: ");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        data.login();
                        correct = true;
                        break;
                    case 2:
                        data.register();
                        break;
                    case 3:
                        System.out.println("Voting Results:");
                        System.out.println("- Candidate A: " + candidates.get("Candidate A"));
                        System.out.println("- Candidate B: " + candidates.get("Candidate B"));
                        System.out.println("- Candidate C: " + candidates.get("Candidate C"));
                        break;
                    case 4:
                        data.logout();
                }
            }

            do {
                System.out.println("\nWelcome to the Online Voting System");
                System.out.println("Choose the candidate you want to support:");
                System.out.println("- Candidate A");
                System.out.println("- Candidate B");
                System.out.println("- Candidate C");
                System.out.print("Enter the candidate's name (or type 'done' to exit): ");
                String candidate = input.nextLine();
                Boolean hasVoted = data.voting(data.email);

                switch (candidate.toLowerCase()) {
                    case "candidate a":
                        if (!hasVoted) {
                            candidates.put("Candidate A", candidates.get("Candidate A") + 1);
                            done = true;
                            break;
                        } else {
                            System.out.println("You have already voted!");
                            break;
                        }
                    case "candidate b":
                        if (!hasVoted) {
                            candidates.put("Candidate B", candidates.get("Candidate B") + 1);
                            done = true;
                            break;
                        } else {
                            System.out.println("You have already voted!");
                            break;
                        }
                    case "candidate c":
                        if (!hasVoted) {
                            candidates.put("Candidate C", candidates.get("Candidate C") + 1);
                            done = true;
                            break;
                        } else {
                            System.out.println("You have already voted!");
                            break;
                        }
                    case "done":
                        done = true;
                        break;
                }
            } while (!done);
        } while (true);
    }
}