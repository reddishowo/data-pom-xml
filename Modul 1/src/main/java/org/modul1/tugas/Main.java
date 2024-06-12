package org.modul1.tugas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Barang : ");
        String Nama = scanner.nextLine();

        System.out.print("Masukkan Harga Barang : ");
        Double Harga = scanner.nextDouble();

        System.out.println("Tipe Barang : ");
        for (Jenis jenis : Jenis.values()){                     // values : isi dari Jenis (enum)
            System.out.println(jenis.ordinal() + ". " + jenis); // ordinal : penomoran otomatis untuk setiap value dari jenis (enum)
        }

        System.out.println("Masukkan Nomor (Jenis Barang) : ");
        int TipeBarang = scanner.nextInt();

        Jenis jenis = Jenis.values()[TipeBarang];

        Barang<String, Double> barang = new Barang<>(Nama, Harga, jenis);

        System.out.println("Nama : " + barang.getNama());
        System.out.println("Harga : " + barang.getHarga());
        System.out.println("Jenis : " + barang.getJenis());
    }
}