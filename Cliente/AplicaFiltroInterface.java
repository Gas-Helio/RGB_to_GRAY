/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author heliojunior
 */
public interface AplicaFiltroInterface extends Remote{
    public byte[] aplicaFiltro(byte[] img) throws RemoteException;
    public void setIPPorta(String ip, int porta) throws RemoteException;
}
