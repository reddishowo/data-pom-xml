package org.modul3.strukdat.Tugas1_New;
import java.util.Scanner;

public class HistoryBrowser {
    private String[] stackArray;
    private int top;

    public HistoryBrowser(){
        stackArray = new String[10];
        top = -1;
    }
    public void visitURL(String url) { // push
        if (top == stackArray.length - 1) {
            System.out.println("History sudah penuh, menghapus history terlama...");
            // Menggeser semua elemen ke kiri untuk membuat ruang untuk URL baru
            for (int i = 0; i < top; i++) {
                stackArray[i] = stackArray[i + 1];
            }
            top--; // Kurangi top agar menunjukkan indeks yang benar setelah penghapusan
        }
        stackArray[++top] = url;
        System.out.println("Mengunjungi : " + url);
    }
    public void back() {
        if (top > 0) {
            top--; // Kembali ke URL sebelumnya
            System.out.println("Kembali ke : " + stackArray[top]);
        } else {
            System.out.println("Tidak ada riwayat sebelumnya");
        }
    }
    public void forward() {
        if (top == -1) { // Cek apakah ada history
            System.out.println("Belum ada URL yang dikunjungi");
        } else if (top < stackArray.length - 2) { // Cek apakah kita bisa maju didalam Array
            String nextURL = stackArray[++top];
            System.out.println("Maju ke : " + nextURL);
        } else {
            System.out.println("Tidak bisa maju lagi");
        }
    }

    public void getCurrentURL() { //peek
        if (top < 0) { // Stack kosong, belum ada URL
            System.out.println("Belum ada URL yang dikunjungi");
        } else {
            String currentURL = stackArray[top];
            System.out.println("URL saat ini : " + currentURL);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HistoryBrowser browser = new HistoryBrowser();

        while(true){
            System.out.println("========== Browser ==========");
            System.out.println("1. Kunjungi URL");
            System.out.println("2. Kembali");
            System.out.println("3. Maju");
            System.out.println("4. URL saat ini");
            System.out.println("5. Keluar");
            System.out.print("Silahkan Masukkan : ");
            int command = input.nextInt();
            input.nextLine();

            switch(command){
                case 1:
                    System.out.print("Masukkan URL : ");
                    String url = input.nextLine();
                    browser.visitURL(url);
                    System.out.println();
                    break;
                case 2:
                    browser.back();
                    System.out.println();
                    break;
                case 3:
                    browser.forward();
                    System.out.println();
                    break;
                case 4:
                    browser.getCurrentURL();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    return;
            }
        }
    }
}