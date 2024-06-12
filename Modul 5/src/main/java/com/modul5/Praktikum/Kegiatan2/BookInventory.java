package com.modul5.Praktikum.Kegiatan2;

// Kelas untuk merepresentasikan Binary Search Tree (BST)
class BookInventory {
    private TreeNode root;
    public BookInventory() {
        root = null;
    }

    public void addBook(Book book) {
        root = insert(root, book);
    }

    // Metode rekursif untuk memasukkan buku ke dalam BST
    private TreeNode insert(TreeNode root, Book book) {
        if (root == null) {
            root = new TreeNode(book);
            return root;
        }

        // Bandingkan ISBN untuk menentukan posisi buku dalam BST
        if (book.isbn.compareTo(root.book.isbn) < 0) //Jika book.isbn < root.book.isbn
            root.left = insert(root.left, book);
        else if (book.isbn.compareTo(root.book.isbn) > 0) //Jika book.isbn > root.book.isbn
            root.right = insert(root.right, book);

        return root;
    }

    // Metode untuk mencari buku berdasarkan ISBN dalam BST
    public Book searchBook(String isbn) {
        TreeNode result = search(root, isbn);
        if (result != null)
            return result.book;
        else
            return null;
    }

    // Metode rekursif untuk mencari buku berdasarkan ISBN dalam BST
    private TreeNode search(TreeNode root, String isbn) {
        if (root == null || root.book.isbn.equals(isbn))
            return root;

        // Bandingkan ISBN untuk mencari buku dalam BST
        if (isbn.compareTo(root.book.isbn) < 0)
            return search(root.left, isbn);
        else
            return search(root.right, isbn);
    }

    // Metode untuk menampilkan semua buku dalam BST secara terurut menggunakan PreOrder Traversal
    public void displayBooksPreOrder() {
        System.out.println("Books in Inventory (PreOrder Traversal):");
        displayPreOrder(root);
    }

    // Metode untuk menampilkan semua buku dalam BST secara terurut menggunakan InOrder Traversal
    public void displayBooksInOrder() {
        System.out.println("Books in Inventory (InOrder Traversal):");
        displayInOrder(root);
    }

    // Metode untuk menampilkan semua buku dalam BST secara terurut menggunakan PostOrder Traversal
    public void displayBooksPostOrder() {
        System.out.println("Books in Inventory (PostOrder Traversal):");
        displayPostOrder(root);
    }

    // Metode rekursif untuk menampilkan semua buku dalam BST secara terurut menggunakan PreOrder Traversal
    private void displayPreOrder(TreeNode root) {
        if (root != null) {
            root.book.displayInfo();
            displayPreOrder(root.left);
            displayPreOrder(root.right);
        }
    }

    // Metode rekursif untuk menampilkan semua buku dalam BST secara terurut menggunakan InOrder Traversal
    private void displayInOrder(TreeNode root) {
        if (root != null) {
            displayInOrder(root.left);
            root.book.displayInfo();
            displayInOrder(root.right);
        }
    }

// Metode rekursif untuk menampilkan semua buku dalam BST secara terurut menggunakan PostOrder Traversal
    private void displayPostOrder(TreeNode root) {
    if (root != null) {
        displayPostOrder(root.left);
        displayPostOrder(root.right);
        root.book.displayInfo();
    }
}
}