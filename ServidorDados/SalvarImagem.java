/**
 * SalvarImagem
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SalvarImagem extends UnicastRemoteObject implements SalvaImagemInterface {
    
    private static TelaServidor ts;
    private static final long serialVersionUID = 1L;
    
    SalvarImagem() throws RemoteException{
        ts = new TelaServidor();
        ts.setVisible(true);
    }
    @Override
    public boolean salvarImagem(byte[] img) throws RemoteException{
        ts.addMessagem("asdasdasdasdas");
        return true;
    }

}