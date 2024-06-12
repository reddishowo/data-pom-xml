/**
 * Farriel Arrianta Akbar Pratama
 * 202210370311077
 * Struktur Data 4D
 */

package com.modul4.TugasStrukdat;
import java.util.*;
public class EncryptPassword {
    // Step 1: Mengubah masing-masing karakter menjadi 5 karakter sebelumnya
    public static String encryptStep1(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) { // Pastikan karakter adalah huruf
                char encryptedChar = (char) (c - 5); // Geser 5 karakter kebelakang
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
    // Step 2: Geser 3 karakter paling depan ke belakang dan 3 karakter paling belakang ke depan
    public static String encryptStep2(String password) {
        char[] chars = password.toCharArray();
    // Menyimpan 3 karakter pertama dan 3 karakter terakhir
        char[] firstThree = Arrays.copyOfRange(chars, 0, 3);
        char[] lastThree = Arrays.copyOfRange(chars, chars.length - 3,
                chars.length);
    // Geser sisanya ke tengah
        char[] middle = Arrays.copyOfRange(chars, 3, chars.length - 3);
    // Gabungkan dalam urutan yang baru
        char[] combined = new char[chars.length];
        System.arraycopy(lastThree, 0, combined, 0, 3);
        System.arraycopy(middle, 0, combined, 3, middle.length);
        System.arraycopy(firstThree, 0, combined, middle.length + 3, 3);
        return new String(combined);
    }
    // Step 3: Balik urutan seluruh karakter
    public static String encryptStep3(String password) {
        return new StringBuilder(password).reverse().toString();
    }
    public static String decryptPassword(String encryptedPassword) {
    // Langkah 1: Balik urutan seluruh karakter (reversing)
        String step3 = new StringBuilder(encryptedPassword).reverse().toString();
    // Langkah 2: Geser 3 karakter paling depan ke belakang dan 3 karakter paling belakang ke depan
        char[] chars = step3.toCharArray();
        char[] firstThree = Arrays.copyOfRange(chars, 0, 3);
        char[] lastThree = Arrays.copyOfRange(chars, chars.length - 3,
                chars.length);
        char[] middle = Arrays.copyOfRange(chars, 3, chars.length - 3);
        char[] combined = new char[chars.length];
        System.arraycopy(lastThree, 0, combined, 0, 3);
        System.arraycopy(middle, 0, combined, 3, middle.length);
        System.arraycopy(firstThree, 0, combined, middle.length + 3, 3);
        String step2 = new String(combined);
    // Langkah 3: Ubah masing-masing karakter menjadi 5 karakter sebelumnya
        StringBuilder decryptedPassword = new StringBuilder();
        for (int i = 0; i < step2.length(); i++) {
            char c = step2.charAt(i);
            if (Character.isLetter(c)) { // Pastikan karakter adalah huruf
                char decryptedChar = (char) (c + 5); // Geser 5 karakter ke depan
                if (Character.isLowerCase(c) && decryptedChar > 'z') {
                    decryptedChar = (char) ('a' + (decryptedChar - 'z' - 1));
                } else if (Character.isUpperCase(c) && decryptedChar > 'Z') {
                    decryptedChar = (char) ('A' + (decryptedChar - 'Z' - 1));
                }
                decryptedPassword.append(decryptedChar);
            } else {
                decryptedPassword.append(c); // Jika bukan huruf, biarkan karakter tersebut sama
            }
        }
        return decryptedPassword.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    // Input Password
        System.out.print("Masukkan password (hanya huruf abjad, 8-15 karakter): ");
                String password = scanner.nextLine();
    // Password Length Validation
        if (password.length() < 8 || password.length() > 15) {
            System.out.println("Panjang password harus antara 8 hingga 15 karakter.");
            return;
        }
    // Encrypt Output
        String step1 = encryptStep1(password);
        System.out.println("Step 1: " + step1);
        String step2 = encryptStep2(step1);
        System.out.println("Step 2: " + step2);
        String step3 = encryptStep3(step2);
        System.out.println("Step 3: " + step3);
        System.out.println("Password setelah dienkripsi: " + step3);
    // Decrypt Output
        String decryptedPassword = decryptPassword(step3);
        System.out.println("Password setelah didekripsi: " + decryptedPassword);
        scanner.close();
    }
}