/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author heliojunior
 */
import java.awt.Color;
import java.awt.image.*;
import java.io.File;

import javax.imageio.ImageIO;

class GrayScale {
    
    // Type instance variables.
    private static String filepath;
    private static String filename;
    private static int red, green, blue, newRGB;
    
    // File I/O
    private static File imageFileIn, imageFileOut;
    private static BufferedImage image;
    
    // Get BufferedImage from imageFileIn.
    private static BufferedImage getImage() {
        try {
            image = ImageIO.read(imageFileIn);
        } catch(Exception e) {
            System.out.println(e);
        }
        return image;
    }
    
    // Run grayscale conversion.
    private static void run() {
        try {
            // First, it gets the image.
            getImage();
            
            // The program loops over each pixel changing its color.
            for(int x=0; x < image.getHeight(); x++) {
                for(int y=0; y < image.getWidth(); y++) {
                    
                    // Get current pixel color.
                    Color color = new Color(image.getRGB(x, y));
                    
                    // Turn red, green, blue into grayscale.
                    red = (int) (color.getRed() * 0.299);
                    green = (int) (color.getGreen() * 0.587);
                    blue = (int) (color.getBlue() * 0.114);
                    
                    // Save grayscale color as a new Color.
                    newRGB = red + green + blue; 
                    Color gray = new Color(newRGB, newRGB, newRGB);
                    
                    // Set new grayscale color.
                    image.setRGB(x, y, gray.getRGB());
                }
            }
            
            // Write grayscale image to a file.
            ImageIO.write(image, "jpg", imageFileOut);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    // Handle initialization and call to run().
    public static void main(String args[]) {
        filepath = "src/grayscale/photo.jpg";
        filename = filepath.split("\\.")[0];
        
        imageFileIn = new File(filepath);
        imageFileOut = new File(filename + "-grayscale" + ".jpg");
        
        run();
    }
    
    
}
