package com.modul4.TugasStrukdat;
import java.util.*;

public class EncryptDecrypt {

    public static String encrypt(String password) {
        if (password.length() < 8 || password.length() > 15 || !password.matches("[a-zA-Z]+")) {
            return "Password tidak memenuhi syarat";
        }

        char[] charArray = password.toCharArray(); // Konversi Password ke Array Karakter
        for (int i = 0; i < charArray.length; i++) {
            char originalChar = charArray[i];
            char encryptedChar = (char) (originalChar - 5);
            if (encryptedChar < 'a') {
                encryptedChar = (char) ('z' - ('a' - encryptedChar - 1));
            }

            charArray[i] = encryptedChar;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < 3; i++) {
            stack.push(charArray[i]);
        }
        for (int i = 3; i < charArray.length; i++) {
            charArray[i - 3] = charArray[i];
        }
        for (int i = 0; i < 3; i++) {
            charArray[charArray.length - 3 + i] = stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }

        return sb.toString();
    }

    public static String decrypt(String encryptedPassword) {
        char[] charArray = encryptedPassword.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        charArray = sb.toString().toCharArray();

        Queue<Character> queue = new LinkedList<>();
        for (int i = charArray.length - 1; i >= charArray.length - 3; i--) {
            queue.offer(charArray[i]);
        }
        for (int i = charArray.length - 4; i >= 0; i--) {
            charArray[i + 3] = charArray[i];
        }
        for (int i = 0; i < 3; i++) {
            charArray[i] = queue.poll();
        }

        for (int i = 0; i < charArray.length; i++) {
            char originalChar = charArray[i];
            char decryptedChar = (char) (originalChar + 5);

            if (decryptedChar > 'z') {
                decryptedChar = (char) ('a' + (decryptedChar - 'z' - 1));
            }

            charArray[i] = decryptedChar;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan password untuk enkripsi: ");
        String password = scanner.nextLine();

        String encryptedPassword = encrypt(password);
        System.out.println("Password terenkripsi: " + encryptedPassword);

        String decryptedPassword = decrypt(encryptedPassword);
        System.out.println("Password terdekripsi: " + decryptedPassword);

        scanner.close();
    }
}