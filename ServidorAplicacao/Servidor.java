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

    Servidor() {
        try {
//            System.setProperty("java.rmi.server.hostname", "192.168.0.108");
//            LocateRegistry.createRegistry(12345);           
            AplicaFiltroInterface afi = new AplicaFiltro();
//            Naming.bind("AplicaFiltro", (Remote) afi);

//            AplicaFiltroInterface afi = new AplicaFiltro();
//            Naming.rebind("rmi://192.168.0.108/FactorialService", afi);

//            Registry registry = LocateRegistry.createRegistry(12345);
//            AplicaFiltroInterface obj = new AplicaFiltro();
//            registry.bind("AplicaFiltro", obj);

            Registry registry = LocateRegistry.createRegistry(12345); // for server
            registry.rebind("AplicaFiltro", afi); // for server
            System.out.println("Servidor ativo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Servidor();
    }
}
