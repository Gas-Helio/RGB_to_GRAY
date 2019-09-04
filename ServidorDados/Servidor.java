/**
 * Servidor
 */

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    private static int PORTA;
    private static String IP;

    Servidor() {
        try {
           System.setProperty("java.rmi.server.hostname", IP);
            // Registry registry = LocateRegistry.createRegistry(PORTA); // for server
            // registry.rebind("AplicaFiltro", afi); // for server
            System.out.println("Servidor aberto na porta: 12345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        IP = args[0];
        PORTA = Integer.parseInt(args[1]);
        new Servidor();
        new TelaServidor().setVisible(true);
    }
}
