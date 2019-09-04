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
    private static TelaServidor ta;
    
    protected AplicaFiltro() throws RemoteException{
        super();
        ta = new TelaServidor();
        ta.setVisible(true);
        
    }

    @Override
    public byte[] aplicaFiltro(byte[] img) throws RemoteException {
        try {

            BufferedImage image = javax.imageio.ImageIO.read(new ByteArrayInputStream(img));

            System.out.println("Imagem recebida");
            ta.addMessagem("Imagem recebida");
            // System.out.println(image.getHeight()+" x "+image.getWidth());

            for(int x=0; x < image.getHeight(); x++) {
                for(int y=0; y < image.getWidth(); y++) {
                    // System.out.println("x = " + x + ", y = " + y);
                    // Get current pixel color.
                    Color color = new Color(image.getRGB(y, x));

                    // Turn red, green, blue into grayscale.
                    red = (int) (color.getRed() * 0.299);
                    green = (int) (color.getGreen() * 0.587);
                    blue = (int) (color.getBlue() * 0.114);

                    // Save grayscale color as a new Color.
                    newRGB = red + green + blue; 
                    Color gray = new Color(newRGB, newRGB, newRGB);

                    // Set new grayscale color.
                    image.setRGB(y, x, gray.getRGB());
                }
            }
            System.out.println("Imagem convertida");
            ta.addMessagem("Imagem recebida");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            javax.imageio.ImageIO.write(image, "jpg", baos);
            return baos.toByteArray(); 
        }  catch (Exception e) {
            System.out.println("Erro ao converter");
            ta.addMessagem("Erro ao converter");
            System.out.println(e.getMessage());
            return img;
        }
    }
}
