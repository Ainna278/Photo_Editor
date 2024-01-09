/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package photoeditor;

/**
 *
 * @author jiks
 */
import java.awt.image.BufferedImage;

public class Brightness {
    public BufferedImage adjustBrightness(BufferedImage originalImage, float factor) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage brightenedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = originalImage.getRGB(i, j);

                int alpha = (pixel >> 24) & 0xFF;
                int red = (int)(((pixel >> 16) & 0xFF)*factor);
                int green = (int)(((pixel >> 8) & 0xFF)*factor);
                int blue = (int)((pixel & 0xFF)*factor);

                // Adjust brightness
                red = clamp((int) (red + factor));
                green = clamp((int) (green + factor));
                blue = clamp((int) (blue + factor));

                int brightenedPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                brightenedImage.setRGB(i, j, brightenedPixel);
            }
        }

        return brightenedImage;
    }
    
    private int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }
}
