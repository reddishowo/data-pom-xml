package com.modul5.Praktikum.Kegiatan2_Backup;

import java.util.Scanner;

class Book {
    int isbn;
    String title;
    Book left, right;

    public Book(int isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        left = right = null;
    }
}

class BookBST {
    Book root;

    public void addBook(int isbn, String title) {
        root = addBookRec(root, isbn, title);
    }

    private Book addBookRec(Book root, int isbn, String title) {
        if (root == null) {
            root = new Book(isbn, title);
            return root;
        }

        if (isbn < root.isbn) {
            root.left = addBookRec(root.left, isbn, title);
        } else if (isbn > root.isbn) {
            root.right = addBookRec(root.right, isbn, title);
        }

        return root;
    }

    public Book searchBook(int isbn) {
        return searchBookRec(root, isbn);
    }

    private Book searchBookRec(Book root, int isbn) {
        if (root == null || root.isbn == isbn) {
            return root;
        }

        if (isbn < root.isbn) {
            return searchBookRec(root.left, isbn);
        }

        return searchBookRec(root.right, isbn);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Book root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.isbn + " " + root.title);
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Book root) {
        if (root != null) {
            System.out.println(root.isbn + " " + root.title);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Book root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.isbn + " " + root.title);
        }
    }
}

public class BookInventorySystem {
    public static void main(String[] args) {
        BookBST bookBST = new BookBST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Tambah Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Tampilkan Semua Buku (InOrder)");
            System.out.println("4. Tampilkan Semua Buku (PreOrder)");
            System.out.println("5. Tampilkan Semua Buku (PostOrder)");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ISBN: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Masukkan Judul Buku: ");
                    String title = scanner.nextLine();
                    bookBST.addBook(isbn, title);
                    break;
                case 2:
                    System.out.print("Masukkan ISBN yang dicari: ");
                    isbn = scanner.nextInt();
                    Book foundBook = bookBST.searchBook(isbn);
                    if (foundBook != null) {
                        System.out.println("Buku ditemukan: ISBN " + foundBook.isbn + ", Judul " + foundBook.title);
                    } else {
                        System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("Inventaris Buku (terurut berdasarkan ISBN InOrder):");
                    bookBST.inOrder();
                    break;
                case 4:
                    System.out.println("Inventaris Buku (PreOrder):");
                    bookBST.preOrder();
                    break;
                case 5:
                    System.out.println("Inventaris Buku (PostOrder):");
                    bookBST.postOrder();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}