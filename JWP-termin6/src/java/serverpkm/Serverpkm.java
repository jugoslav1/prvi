
package serverpkm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import serverpkm.Igraci;


public class Serverpkm {

    
    public static void main(String[] args) throws InterruptedException {
        Slusam sl=new Slusam();
        sl.start();
        Thread.sleep(1000);
        Saljem sa=new Saljem();
        sa.pucaj("192.168.0.102", "13Jugoslav192.168.0.102serverrade1234");
        Scanner s=new Scanner(System.in);
        System.out.println("unesi paran broj igraca");
        int a=s.nextInt();
       //List ig=new ArrayList();
         Igraci[] ig=new Igraci[a];
        for (int i=0;i<a;i++)
        {
             ig[i]=new Igraci();
            
            
        }
         ig[0].setId("mica");
         ig[1].setId("pera");
           System.out.println(ig[0].getId()+"   drui  "+ig[1].getId());     
    }
    
}
