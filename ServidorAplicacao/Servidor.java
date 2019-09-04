/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author heliojunior
 */
public class Servidor {

    private static int PORTA;
    private static int porta_dados;
    private static String IP;
    private static String ip_dados;

    Servidor() {
        try {
           System.setProperty("java.rmi.server.hostname", IP);
//            LocateRegistry.createRegistry(12345);           
            AplicaFiltroInterface afi = new AplicaFiltro();
            afi.setIPPorta(ip_dados, porta_dados);
//            Naming.bind("AplicaFiltro", (Remote) afi);

        //    AplicaFiltroInterface afi = new AplicaFiltro();
        //    Naming.rebind("rmi://127.0.0.1/FactorialService", afi);

        //    Registry registry = LocateRegistry.createRegistry(12345);
        //    AplicaFiltroInterface obj = new AplicaFiltro();
        //    registry.bind("AplicaFiltro", obj);
        //    System.out.println("Servidor aberto na porta: 12345");

            Registry registry = LocateRegistry.createRegistry(PORTA); // for server
            registry.rebind("AplicaFiltro", afi); // for server
            System.out.println("Servidor aberto na porta: 12345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        IP = args[0];
        PORTA = Integer.parseInt(args[1]);
        ip_dados = args[2];
        porta_dados = Integer.parseInt(args[3]);
        new Servidor();
        // new TelaServidor().setVisible(true);
    }
}
