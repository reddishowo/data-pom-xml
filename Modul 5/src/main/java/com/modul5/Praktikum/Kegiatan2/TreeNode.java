package com.modul5.Praktikum.Kegiatan2;

// Kelas untuk merepresentasikan node dalam BST
class TreeNode {
    Book book;
    TreeNode left;
    TreeNode right;

    // Konstruktor untuk membuat objek node
    public TreeNode(Book book) {
        this.book = book;
        left = right = null;
    }
}