package org.modul3.strukdat.Tugas1_Coba;

import java.util.Scanner;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class HistoryBrowser {
    private Node head;
    private Node current;
    private Node tail;

    public HistoryBrowser() {
        head = null;
        tail = null;
        current = null;
    }

    public void visitURL(String url) {
        Node newNode = new Node(url);
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            newNode.next = current.next;
            current.next = newNode;
            if (current == tail) {
                tail = newNode;
            }
            current = newNode;
        }
        System.out.println("Mengunjungi : " + url);
    }

    public void back() {
        if (current != head) {
            Node temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }
            current = temp;
            System.out.println("Kembali ke : " + current.data);
        } else {
            System.out.println("Tidak ada riwayat sebelumnya");
        }
    }

    public void forward() {
        if (current != tail) {
            current = current.next;
            System.out.println("Maju ke : " + current.data);
        } else {
            System.out.println("Tidak bisa maju lagi");
        }
    }

    public void getCurrentURL() {
        if (current == null) {
            System.out.println("Belum ada URL yang dikunjungi");
        } else {
            System.out.println("URL saat ini : " + current.data);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HistoryBrowser browser = new HistoryBrowser();

        while (true) {
            System.out.println("========== Browser ==========");
            System.out.println("1. Kunjungi URL");
            System.out.println("2. Kembali");
            System.out.println("3. Maju");
            System.out.println("4. URL saat ini");
            System.out.println("5. Keluar");
            System.out.print("Silahkan Masukkan : ");
            int command = input.nextInt();
            input.nextLine();

            switch (command) {
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
