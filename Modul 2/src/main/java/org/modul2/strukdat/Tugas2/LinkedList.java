package org.modul2.strukdat.Tugas2;

class LinkedList {
    private Node head;

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        if (head == null) {
            System.out.println("Daftar kontak kosong.");
        } else {
            System.out.println("Daftar kontak:");
            Node current = head;
            int index = 1;
            while (current != null) {
                System.out.println(index + ". " + current.data);
                current = current.next;
                index++;
            }
        }
    }

    public void searchContact(String name) {
        if (head == null) {
            System.out.println("Daftar kontak kosong.");
        } else {
            Node current = head;
            boolean found = false;
            while (current != null) {
                if (current.data.getName().equalsIgnoreCase(name)) {
                    System.out.println("Kontak ditemukan!");
                    System.out.println("Nama: " + current.data.getName());
                    System.out.println("Nomor telepon: " + current.data.getPhoneNumber());
                    found = true;
                    break;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("Kontak tidak ditemukan.");
            }
        }
    }
}
