/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author heliojunior
 */
public class AplicaFiltro extends UnicastRemoteObject implements AplicaFiltroInterface{
    
    
    private static final long serialVersionUID = 1L;
    private static int red, green, blue, newRGB;
    
    protected AplicaFiltro() throws RemoteException{
        super();
        
    }
    
    @Override
    public byte[] aplicaFiltro(byte[] img) throws RemoteException {
        try {

            BufferedImage image = javax.imageio.ImageIO.read(new ByteArrayInputStream(img));

            System.out.println("Imagem recebida");
            for(int x=0; x < image.getHeight() - 1; x++) {
                for(int y=0; y < image.getWidth() - 1; y++) {
                    System.out.println("x = " + x + ", y = " + y);
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
            System.out.println("Imagem convertida");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            javax.imageio.ImageIO.write(image, "jpg", baos);
            return baos.toByteArray(); 
        }  catch (Exception e) {
            System.out.println("Erro ao converter");
            System.out.println(e.getMessage());
            return img;
        }
    }
}
