
import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author heliojunior
 */
public interface SalvaImagemInterface extends Remote{
    public boolean salvarImagem(byte[] img) throws RemoteException;
}