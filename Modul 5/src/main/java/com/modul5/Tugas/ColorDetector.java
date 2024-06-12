/**
 * Farriel Arrianta Akbar Pratama
 * 202210370311077
 * Struktur Data - 4D
 */

package com.modul5.Tugas;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ColorDetector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the image path: ");
        String imagePath = scanner.nextLine();

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            if (image == null) {
                System.out.println("Image not found");
                return;
            }

            Map<Integer, Integer> colorFrequencyMap = new HashMap<>();

            for (int x = 0; x < image.getWidth(); x++) {            // Melakukan iterasi sepanjang lebar gambar.
                for (int y = 0; y < image.getHeight(); y++) {       // Melakukan iterasi sepanjang tinggi gambar.
                    int pixelColor = image.getRGB(x, y);            // Mendapatkan warna piksel saat ini.
                    colorFrequencyMap.put(pixelColor, colorFrequencyMap.getOrDefault(pixelColor, 0) + 1);
                }
            }

            int dominantColor = 0;  // Variabel untuk menyimpan warna dominan.
            int maxFrequency = 0;   // Variabel untuk menyimpan frekuensi warna dominan.

            for (Map.Entry<Integer, Integer> entry : colorFrequencyMap.entrySet()) {
                if (entry.getValue() > maxFrequency) {      // Memeriksa apakah frekuensi warna saat ini lebih besar dari frekuensi maksimum.
                    dominantColor = entry.getKey();         // Memperbarui warna dominan.
                    maxFrequency = entry.getValue();        // Memperbarui frekuensi maksimum.
                }
            }

            System.out.println("Colors that appear in the image:");
            for (Map.Entry<Integer, Integer> entry : colorFrequencyMap.entrySet()) {
                System.out.println("Color: #" + String.format("%06X", entry.getKey() & 0xFFFFFF) +
                        ", Frequency: " + entry.getValue());
            }

            System.out.println("Image path : " + imagePath);
            System.out.println("The most dominant color: #" + String.format("%06X", dominantColor & 0xFFFFFF));
            System.out.println("Total Frequency of color #" +  String.format("%06X", dominantColor & 0xFFFFFF) + " : " + maxFrequency + " Pixels");

        } catch (IOException e) {
            System.out.println("An error occurred while loading the image: " + e.getMessage());
        }
    }
}
