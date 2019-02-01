package serverpkm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Slusam extends Thread {

    String prijem = "", prijem1 = "", name1= "",ip="",status="";
    int  brip;
    

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }



    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   


    @Override
    public void run() {

        while (true) {
            try {//soket za slusanje
                DatagramSocket udpServer = new DatagramSocket(1000);
                byte[] data = new byte[32];
                DatagramPacket dPacket = new DatagramPacket(data, data.length);

                dPacket.setData(new byte[42]);
                System.out.println("slusam bajo");
                while (true) {
                    try {
                        udpServer.receive(dPacket);
                    } catch (IOException ex) {
                        Logger.getLogger(Slusam.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    byte[] recData = dPacket.getData();
                    try {//prijemna poruka
                        prijem = new String(recData, "utf-8");
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Slusam.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (prijem != "" || prijem != prijem1) {
                        prijem1 = prijem;
                        System.out.println("primio sam" + prijem1+"j");
                    }
                    //vraca str1,str2,str3 na prazno
                    String str0 = "", str1 = "", str2 = "", str3 = "", str4 = "", str5 = "";
                    //sece prijem na str1(ime ko salje poruku 5 slova)
                    //str1 = prijem1.substring(0, 5);
                    str0 = str0 + prijem1;

                    str1 = str0.substring(0, 2);
                    this.brip = Integer.parseInt(str1, 10);
                    System.out.println(this.brip);
                    //,str2(vrsta promenljive,4 slov mest)

                    str2 = str0.substring(2, 10);
                    System.out.println(str2);
                    //,str3(vrednost promenljive 1 slov mesto deveto u stringu prijem
                    str3 = str0.substring(10, 11+this.brip-1);
                    System.out.println(str3);
                    str4 = str0.substring(11+this.brip-1,11+this.brip-1+6);
                    System.out.println(str4);
                    str5=str0.substring(11+this.brip-1+6, 11+this.brip-1+6+8);
                    System.out.println("str5 = "+str5+"j");

                    switch (str4) {

                        case "server": {System.out.println("uso");this.name1=str2;this.ip=str3; };break;
                        default : System.out.println("default");break;
                    }
                    System.out.println("this  "+this.name1+"j  "+this.ip+"j");
                
                    System.out.println(new String(recData, "utf-8"));
                    dPacket.setData(new byte[32]);
                }
            } catch (SocketException ex) {
                Logger.getLogger(Slusam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Slusam.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
