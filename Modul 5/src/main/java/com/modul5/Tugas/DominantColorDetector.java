package com.modul5.Tugas;
                                            //Nizam Avif Anhari
import java.awt.image.BufferedImage;        //202210370311071
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class DominantColorDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di Program Deteksi Warna Dominan pada Gambar!");
        System.out.print("Masukkan path gambar: ");
        String imagePath = scanner.nextLine();
        scanner.close();

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            Map<String, Integer> colorFrequency = new HashMap<>();

            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int rgb = image.getRGB(x, y);
                    String hexColor = String.format("#%06X", (0xFFFFFF & rgb));
                    colorFrequency.put(hexColor, colorFrequency.getOrDefault(hexColor, 0) + 1);
                }
            }

            String dominantColor = null;
            int maxFrequency = 0;

            for (Map.Entry<String, Integer> entry : colorFrequency.entrySet()) {
                if (entry.getValue() > maxFrequency) {
                    dominantColor = entry.getKey();
                    maxFrequency = entry.getValue();
                }
            }

            System.out.println("Warna yang ada pada gambar:");
            for (String color : colorFrequency.keySet()) {
                System.out.println(color);
            }

            if (dominantColor != null) {
                System.out.println("Warna dominan pada gambar adalah: " + dominantColor);
                System.out.println("Jumlah frekuensi warna " + dominantColor + ": " + maxFrequency + " Pixel");
            } else {
                System.out.println("Tidak ada warna yang terdeteksi pada gambar.");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat memuat gambar: " + e.getMessage());
        }
    }
}