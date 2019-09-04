/**
 * SalvarImagem
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.*;

public class SalvarImagem extends UnicastRemoteObject implements SalvaImagemInterface {
    
    private static TelaServidor ts;
    private static final long serialVersionUID = 1L;
    private static int cont = 0;

    private static String path = "../imagens/";
    
    SalvarImagem() throws RemoteException{
        ts = new TelaServidor();
        ts.setVisible(true);
    }
    @Override
    public boolean salvarImagem(byte[] img) throws RemoteException{
        try {
            ts.addMessagem("Imagem recebida do servidor de APLICACAO");
            BufferedImage image = javax.imageio.ImageIO.read(new ByteArrayInputStream(img));
            File outputfile = new File(path+"image"+cont+".png");
            cont += 1;
            ImageIO.write(image, "png", outputfile);
            ts.addMessagem("Imagem salva em: "+path+"image"+cont+".png");
            return true;
        } catch (Exception e) {
            ts.addMessagem("Erro ao salvar imagem");
            return false;
        }
        
    }

}