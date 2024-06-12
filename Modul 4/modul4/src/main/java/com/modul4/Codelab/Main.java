package com.modul4.Codelab;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> inventori = new HashMap<>();

        inventori.put("Pensil", 50);
        inventori.put("Buku", 35);
        inventori.put("Penghapus", 25);

        System.out.println("Inventori awal: " + inventori);

        inventori.put("Pensil", inventori.get("Pensil") + 20);

        inventori.remove("Penghapus");

        System.out.println("Inventori setelah update: " + inventori);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama barang yg ingin dicari: ");
        String barang = scanner.nextLine();

        cariBarang(inventori, barang);

    }

    public static void cariBarang(HashMap<String, Integer> inventori, String barang){
        if (inventori.containsKey(barang)) {
            System.out.println("Stok " + barang + ": " + inventori.get(barang) + " unit.");
        }else {
            System.out.println("Barang " + barang + " tidak tersedia di inventori.");
        }

    }
}