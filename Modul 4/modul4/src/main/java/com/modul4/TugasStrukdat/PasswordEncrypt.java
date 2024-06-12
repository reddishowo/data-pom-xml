package com.modul4.TugasStrukdat;
import java.util.*;

public class PasswordEncrypt {

    // Step 1: mengubah setiap karakter dalam password menjadi karakter yang 5 posisi sebelumnya dalam urutan alfabet.
    // Jika karakter adalah huruf kecil dan hasil enkripsi kurang dari 'a', maka geser ke 'z'.
    // Jika karakter adalah huruf besar dan hasil enkripsi kurang dari 'A', maka geser ke 'Z'.
    public static String encryptStep1(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) { // Memastikan karakter adalah HURUF
                char encryptedChar = (char) (c - 5); // Menggeser 5 karakter ke belakang
                if (Character.isLowerCase(c) && encryptedChar < 'a') {
                    encryptedChar = (char) ('z' - ('a' - encryptedChar - 1));
                } else if (Character.isUpperCase(c) && encryptedChar < 'A') {
                    encryptedChar = (char) ('Z' - ('A' - encryptedChar - 1));
                }
                chars[i] = encryptedChar;
            }
        }
        return new String(chars);
    }

    // Step 2: Menggeser 3 karakter pertama ke belakang dan 3 karakter terakhir ke depan.
    // Karakter sisanya tetap berada di tengah.
    public static String encryptStep2(String password) {
        char[] chars = password.toCharArray();
        // Simpan 3 karakter pertama dan 3 karakter terakhir
        char[] firstThree = Arrays.copyOfRange(chars, 0, 3);
        char[] lastThree = Arrays.copyOfRange(chars, chars.length - 3, chars.length);
        // Geser sisanya ke tengah
        char[] middle = Arrays.copyOfRange(chars, 3, chars.length - 3);
        // Gabungkan dalam urutan yang baru
        char[] combined = new char[chars.length];
        System.arraycopy(lastThree, 0, combined, 0, 3);
        System.arraycopy(middle, 0, combined, 3, middle.length);
        System.arraycopy(firstThree, 0, combined, middle.length + 3, 3);
        return new String(combined);
    }

    // Step 3: Membalik urutan seluruh karakter dari Password
    public static String encryptStep3(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input Password
        System.out.print("Masukkan password : ");
        String password = scanner.nextLine();

        // Validate Password Length
        if (password.length() < 8 || password.length() > 15) {
            System.out.println("Panjang password harus antara 8 hingga 15 karakter.");
            return;
        }

        String step1 = encryptStep1(password);
        System.out.println("Step 1: " + step1);
        
        String step2 = encryptStep2(step1);
        System.out.println("Step 2: " + step2);
        
        String step3 = encryptStep3(step2);
        System.out.println("Step 3: " + step3);

        // Password Output
        System.out.println("Password setelah dienkripsi: " + step3);

        scanner.close();
    }
}

/**
 * Farriel Arrianta Akbar Pratama
 * 202210370311077
 * Struktur Data - 4D
 */