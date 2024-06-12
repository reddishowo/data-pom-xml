package com.modul5.Praktikum.Kegiatan2;
import java.util.Scanner;

// Kelas utama untuk menjalankan program
class BookInventorySystem {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan buku ke dalam inventaris
        inventory.addBook(new Book("21", "Assassin's Creed: Mirage", "Ubisoft"));
        inventory.addBook(new Book("123", "Assassin's Creed: Origin", "Ubisoft"));
        inventory.addBook(new Book("143", "Assassin's Creed: Odyssey", "Ubisoft"));
        inventory.addBook(new Book("456", "Assassin's Creed: Valhalla", "Ubisoft"));
        inventory.addBook(new Book("789", "Assassin's Creed: Unity", "Ubisoft"));

        int choice = 0;
        while (choice != 4) {
            System.out.println("Menu:");
            System.out.println("1. Search for a Book by ISBN");
            System.out.println("2. Add a Book to Inventory");
            System.out.println("3. Display All Books in Inventory");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter ISBN to search for a book: ");
                    String searchISBN = scanner.nextLine();
                    Book searchedBook = inventory.searchBook(searchISBN);
                    if (searchedBook != null) {
                        System.out.println("Book Found:");
                        searchedBook.displayInfo();
                    } else {
                        System.out.println("Book not found in inventory.");
                    }
                    break;
                case 2:
                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.println("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    inventory.addBook(new Book(isbn, title, author));
                    System.out.println("Book added to inventory.");
                    break;
                case 3:
                    System.out.println("Choose traversal method:");
                    System.out.println("1. PreOrder Traversal");
                    System.out.println("2. InOrder Traversal");
                    System.out.println("3. PostOrder Traversal");
                    int traversalChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character
                    switch (traversalChoice) {
                        case 1:
                            inventory.displayBooksPreOrder();
                            break;
                        case 2:
                            inventory.displayBooksInOrder();
                            break;
                        case 3:
                            inventory.displayBooksPostOrder();
                            break;
                        default:
                            System.out.println("Invalid traversal choice.");
                            break;
                    }
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
    }
}