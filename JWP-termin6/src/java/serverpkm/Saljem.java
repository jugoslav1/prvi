/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpkm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author komp
 */
public class Saljem {
    public void pucaj(String ip, String predajem) {

        try {

            InetAddress host = InetAddress.getByName(ip);
            DatagramSocket dsocket = null;
            try {
                dsocket = new DatagramSocket();
            } catch (SocketException ex) {
                Logger.getLogger(Saljem.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] buffer = predajem.getBytes();
            DatagramPacket poruka = new DatagramPacket(buffer, buffer.length, host, 1000);
            try {
                dsocket.send(poruka);
            } catch (IOException ex) {
                Logger.getLogger(Saljem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Saljem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
