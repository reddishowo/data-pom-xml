package org.modul2.strukdat.Latihan2;

public class LatihanLinkedListManual {
    public static void main(String[] args) {
        Node head = new Node(5);

        Node second = new Node(10);
        head.next = second;

        Node third = new Node(15);
        second.next = third;

        System.out.println("Daftar Angka : ");
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("Elemen Kedua : " + head.next.data);

        head.data = 25;

        System.out.println("Daftar Angka Setelah Perubahan : ");
        current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }

        head.next = head.next.next;

        System.out.println("Daftar Angka Setelah Penghapusan : ");
        current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}