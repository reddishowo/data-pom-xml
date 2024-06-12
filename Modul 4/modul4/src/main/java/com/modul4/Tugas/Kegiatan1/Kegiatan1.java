package com.modul4.Tugas.Kegiatan1;
import java.util.*;

public class Kegiatan1 {
    public static void main(String[] args) {
        HashMap<String, Integer> candidates = new HashMap<>();
        Scanner input = new Scanner(System.in);

        candidates.put("Candidate A", 0);
        candidates.put("Candidate B", 0);
        candidates.put("Candidate C", 0);

        boolean done = false;

        do {
            System.out.println("\nWelcome to the Online Voting System");
            System.out.println("Choose the candidate you want to support:");
            System.out.println("- Candidate A");
            System.out.println("- Candidate B");
            System.out.println("- Candidate C");
            System.out.print("Enter the candidate's name (or type 'done' to exit): ");
            String candidate = input.nextLine();

            switch (candidate.toLowerCase()) {
                case "candidate a":
                    candidates.put("Candidate A", candidates.get("Candidate A") + 1);
                    break;
                case "candidate b":
                    candidates.put("Candidate B", candidates.get("Candidate B") + 1);
                    break;
                case "candidate c":
                    candidates.put("Candidate C", candidates.get("Candidate C") + 1);
                    break;
                case "done":
                    System.out.println("Voting Results:");
                    System.out.println("- Candidate A: " + candidates.get("Candidate A"));
                    System.out.println("- Candidate B: " + candidates.get("Candidate B"));
                    System.out.println("- Candidate C: " + candidates.get("Candidate C"));
                    done = true;
                    break;
            }
        } while (!done);
    }
}
