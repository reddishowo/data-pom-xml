package org.modul3.strukdat.Tugas1_old;

public class BrowserHistory {
    static class Scanner {
        private final java.io.InputStream in = System.in;
        private final byte[] buffer = new byte[4096];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int readByte() {
            if (hasNextByte()) return buffer[ptr++];
            else return -1;
        }

        private boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Stack {
        private int top;
        private String[] stackArray;
        private int maxSize;

        public Stack(int maxSize) {
            this.maxSize = maxSize;
            stackArray = new String[maxSize];
            top = -1;
        }

        public void push(String item) {
            if (top == maxSize - 1) {
                System.out.println("Stack penuh");
            } else {
                stackArray[++top] = item;
            }
        }

        public String pop() {
            if (top == -1) {
                System.out.println("Stack kosong");
                return null;
            } else {
                return stackArray[top--];
            }
        }

        public String peek() {
            if (top == -1) {
                System.out.println("Stack kosong");
                return null;
            } else {
                return stackArray[top];
            }
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }

    private Stack history;
    private String currentURL;

    public BrowserHistory() {
        history = new Stack(100); // Ukuran maksimal riwayat
        currentURL = "about:blank"; // URL awal
    }

    // Method untuk mengunjungi URL baru dan menyimpannya dalam riwayat navigasi
    public void visitURL(String url) {
        history.push(currentURL); // Menyimpan URL saat ini sebelum mengunjungi yang baru
        currentURL = url; // Mengunjungi URL baru
        System.out.println("Berhasil mengunjungi URL: " + currentURL);
    }

    // Method untuk kembali ke URL sebelumnya dalam riwayat navigasi
    public void back() {
        String previousURL = history.pop(); // Mengambil URL sebelumnya dari stack
        if (previousURL != null) {
            System.out.println("Kembali ke URL sebelumnya: " + previousURL);
            currentURL = previousURL; // Mengatur URL saat ini ke URL sebelumnya
        } else {
            System.out.println("Tidak ada riwayat navigasi yang tersedia untuk dikunjungi.");
        }
    }

    // Method untuk menuju ke URL berikutnya dalam riwayat navigasi
    public void forward() {
        // Tidak ada implementasi forward dalam contoh ini karena Stack hanya dapat digunakan untuk mundur (back)
        System.out.println("Metode forward tidak diimplementasikan dalam program ini.");
    }

    // Method untuk menampilkan URL yang sedang diakses pengguna
    public void getCurrentURL() {
        System.out.println("URL saat ini: " + currentURL);
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner scanner = new Scanner();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Kunjungi URL baru");
            System.out.println("2. Kembali");
            System.out.println("3. Tampilkan URL saat ini");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan URL baru: ");
                    String newURL = scanner.next();
                    browser.visitURL(newURL);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.getCurrentURL();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan browser sederhana ini.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}