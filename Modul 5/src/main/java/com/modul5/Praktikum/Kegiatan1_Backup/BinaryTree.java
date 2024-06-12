package com.modul5.Praktikum.Kegiatan1_Backup;

import java.util.Scanner;
/**
 * Kelas GameBinaryTree digunakan untuk merepresentasikan binary tree yang berisi nama-nama game.
 * Setiap node dalam binary tree menyimpan sebuah nama game.
 */
public class BinaryTree {
    /**
     * Kelas Node merepresentasikan node dalam binary tree.
     * Setiap node memiliki data berupa nama game, dan dua referensi ke node anak kiri dan anak kanan.
     */
    static class Node {
        String data;
        Node left;
        Node right;
        /**
         * Konstruktor untuk membuat objek Node dengan data yang ditentukan.
         * @param data Data yang akan disimpan dalam node.
         */
        public Node(String data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root;

    /**
     * Konstruktor untuk membuat objek GameBinaryTree baru.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Metode untuk memasukkan data (nama game) ke dalam binary tree.
     * @param data Nama game yang akan dimasukkan.
     */
    public void insert(String data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, String data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);
        return root;
    }

    /**
     * Metode rekursif untuk melakukan traversal PreOrder pada binary tree.
     * @param root Root dari binary tree yang akan ditraverse.
     */
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * Metode rekursif untuk melakukan traversal InOrder pada binary tree.
     * @param root Root dari binary tree yang akan ditraverse.
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    /**
     * Metode rekursif untuk melakukan traversal PostOrder pada binary tree.
     * @param root Root dari binary tree yang akan ditraverse.
     */
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     * Fungsi untuk menampilkan binary tree dalam bentuk teks di konsol.
     * @param root Root dari binary tree yang akan ditampilkan.
     * @param indent Indentasi untuk menampilkan node-node dalam tree.
     * @param isLast Flag yang menunjukkan apakah node ini adalah node terakhir dalam level tertentu.
     */
    public void printTree(Node root, String indent, boolean isLast) {
        if (root != null) {
            System.out.print(indent);
            if (isLast) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }
            System.out.println(root.data);
            printTree(root.left, indent, false);
            printTree(root.right, indent, true);
        }
    }

    /**
     * Fungsi untuk menampilkan keseluruhan binary tree dalam bentuk teks di konsol.
     */
    public void displayTree() {
        printTree(root, "", true);
    }

    /**
     * Metode utama untuk menjalankan program.
     * Meminta pengguna untuk memasukkan nama-nama game, membangun binary tree berdasarkan input, dan menampilkan traversal dari binary tree.
     * @param args Argumen baris perintah (command-line arguments).
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan Nama Game atau Angka (ketik 'selesai' untuk mengakhiri): ");
        String gameName = scanner.nextLine();
        while (!gameName.equalsIgnoreCase("selesai")) {
            tree.insert(gameName);
            gameName = scanner.nextLine();
        }
        System.out.println("\nPreOrder Traversal: ");
        tree.preOrder(tree.root);

        System.out.println("\n\nInOrder Traversal: ");
        tree.inOrder(tree.root);

        System.out.println("\n\nPostOrder Traversal: ");
        tree.postOrder(tree.root);

        System.out.println("\n\nBinary Tree Structure: ");
        tree.displayTree();
    }
}