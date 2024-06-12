package org.modul2.strukdat.Latihan1;


import java.util.ArrayList;

public class LatihanArrayList {
    public static void main(String[] args) {
        ArrayList<String> daftarNama = new ArrayList<>();

        daftarNama.add("Farriel");
        daftarNama.add("Arrianta");
        daftarNama.add("Akbar");
        daftarNama.add("Pratama");

        System.out.println("Daftar Nama : ");
        for (String nama : daftarNama) {
            System.out.println(nama);
        }

        System.out.println("Elemen pada Indeks-2 : " + daftarNama.get(2));

        daftarNama.set(2, "Ayenk");

        System.out.println("\nDaftar Nama setelah Perubahan : ");
        for (String nama : daftarNama) {
            System.out.println(nama);
        }

        daftarNama.remove(0);

        System.out.println("\nDaftar Nama setelah Penghapusan : ");
        for (String nama : daftarNama) {
            System.out.println(nama);
        }
        System.out.println("\nJumlah elemen dalam ArrayList : " + daftarNama.size());

        System.out.println("Apakah ArrayList kosong? " + daftarNama.isEmpty());
    }
}