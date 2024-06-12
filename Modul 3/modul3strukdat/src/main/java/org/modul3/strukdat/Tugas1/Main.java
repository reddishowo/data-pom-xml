package org.modul3.strukdat.Tugas1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Browser browser = new Browser(5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current URL");
            System.out.println("5. Clear History");
            System.out.println("6. Keluar");


            System.out.print("\nPilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan URL baru: ");
                    String url = scanner.nextLine();
                    browser.visitURL(url);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.forward();
                    break;
                case 4:
                    String currentURL = browser.getCurrentURL();
                    if (currentURL != null) {
                        System.out.println("URL saat ini: " + currentURL);
                    } else {
                        System.out.println("Tidak ada URL yang sedang diakses.");
                    }
                    break;
                case 5:
                    browser.clearHistory();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
