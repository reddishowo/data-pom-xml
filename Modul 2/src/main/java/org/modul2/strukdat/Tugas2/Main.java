package org.modul2.strukdat.Tugas2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList contactList = new LinkedList();

        System.out.println("\nWelcome to Contact Management : ");
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah kontak");
            System.out.println("2. Tampilkan kontak");
            System.out.println("3. Cari kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1/2/3/4): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama kontak: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon: ");
                    String phoneNumber = scanner.nextLine();
                    contactList.addContact(new Contact(name, phoneNumber));
                    break;
                case 2:
                    contactList.displayContacts();
                    break;
                case 3:
                    System.out.print("Masukkan nama kontak yang ingin dicari: ");
                    String searchName = scanner.nextLine();
                    contactList.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
