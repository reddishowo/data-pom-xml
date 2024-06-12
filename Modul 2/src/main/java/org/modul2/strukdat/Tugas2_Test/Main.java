package org.modul2.strukdat.Tugas2_Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ContactManager<String> manajemenKontak = new ContactManager<>();

            while (true) {
                System.out.println("\nSelamat datang di Manajemen Kontak!");
                System.out.println("1. Tambah Kontak");
                System.out.println("2. Tampilkan Kontak");
                System.out.println("3. Cari Kontak");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu (1/2/3/4): ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan nomor telepon: ");
                        String nomorTelepon = scanner.nextLine();
                        manajemenKontak.tambahKontak(nama, nomorTelepon);
                        break;
                    case 2:
                        manajemenKontak.tampilkanKontak();
                        break;
                    case 3:
                        System.out.print("Masukkan nama untuk dicari: ");
                        String namaCari = scanner.nextLine();
                        manajemenKontak.cariKontak(namaCari);
                        break;
                    case 4:
                        System.out.println("Keluar dari program.");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                }
            }
        }
    }
}