package org.modul2.strukdat.Tugas1;

import java.util.ArrayList;

class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        System.out.println("Daftar kontak:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan!");
                System.out.println("Nama: " + contact.getName());
                System.out.println("Nomor telepon: " + contact.getPhoneNumber());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kontak tidak ditemukan.");
        }
    }
}
