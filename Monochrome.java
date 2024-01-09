/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package photoeditor;

/**
 *
 * @author User
 */
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Monochrome {
    public BufferedImage applyMonochrome(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage monochromeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = originalImage.getRGB(i, j);

                int alpha = (pixel >> 24) & 0xFF;
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;

                // Convert to grayscale
                int grayscale = (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);

                // Create monochrome pixel
                int monochromePixel = (alpha << 24) | (grayscale << 16) | (grayscale << 8) | grayscale;
                monochromeImage.setRGB(i, j, monochromePixel);
            }
        }

        return monochromeImage;
    }
}