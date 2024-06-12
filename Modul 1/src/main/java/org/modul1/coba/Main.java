package org.modul1.coba;

import java.util.Scanner;

enum JenisBarang {
    MAKANAN, ELEKTRONIK, PAKAIAN
}

class Barang<T, U> {
    private T nama;
    private U harga;

    public Barang(T nama, U harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public T getNama() {
        return nama;
    }

    public U getHarga() {
        return harga;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan harga barang: ");
        double harga = scanner.nextDouble();

        System.out.println("Pilih jenis barang:");
        System.out.println("1. MAKANAN");
        System.out.println("2. ELEKTRONIK");
        System.out.println("3. PAKAIAN");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();

        JenisBarang jenis = null;
        switch (pilihan) {
            case 1:
                jenis = JenisBarang.MAKANAN;
                break;
            case 2:
                jenis = JenisBarang.ELEKTRONIK;
                break;
            case 3:
                jenis = JenisBarang.PAKAIAN;
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(0);
        }

        Barang<String, Double> barang = new Barang<>(nama, harga);
        System.out.println("\nBarang baru:");
        System.out.println("Nama: " + barang.getNama());
        System.out.println("Harga: " + barang.getHarga());
        System.out.println("Jenis: " + jenis);
    }
}
