package org.modul3.strukdat.Tugas2;

import java.util.Scanner;

public class PemesananTiket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Tiket> queue = new Queue<>();
        int nomorTiket = 1;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Lihat Antrian Pemesanan");
            System.out.println("3. Proses Pemesanan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    scanner.nextLine(); // Clear the newline
                    System.out.print("Nama Pemesan: ");
                    String namaPemesan = scanner.nextLine();
                    System.out.print("Jumlah Tiket: ");
                    int jumlahTiket = scanner.nextInt();
                    Tiket tiket = new Tiket(namaPemesan, jumlahTiket, nomorTiket++);
                    queue.enqueue(tiket);
                    System.out.println("Tiket berhasil dipesan.");
                    break;
                case 2:
                    System.out.println("Antrian Pemesanan:");
                    System.out.println(queue.toString());
                    break;
                case 3:
                    if (!queue.isEmpty()) {
                        Tiket pemesanan = queue.dequeue();
                        System.out.println("Pemesanan berhasil diproses:");
                        System.out.println(pemesanan.toString());
                    } else {
                        System.out.println("Antrian kosong.");
                    }
                    break;
                case 4:
                    System.out.println("Program selesai.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
