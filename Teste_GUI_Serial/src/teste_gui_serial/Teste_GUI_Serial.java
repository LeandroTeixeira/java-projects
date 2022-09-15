/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_gui_serial;

import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Usuário
 */
public class Teste_GUI_Serial{
    static int cont1=0,cont2=0,cont3=0;

    public static int getCont1() {
        if(cont1==10)
            cont1=0;
        return ++cont1;
    }

    public static int getCont2() {
        if(cont2==100)
            cont2=0;
        return ++cont2;
    }

    public static int getCont3() {
        if(cont3==1000)
            cont3=0;
        cont3+=10;
        return cont3;
    }
    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        int shumf=-1;
        Serial serial=new Serial();
        JFrame frame=new JFrame();
        JProgressBar visible=new JProgressBar(500,700);
        JProgressBar invisible=new JProgressBar(50,1000);
        visible.setValue(cont2);
        visible.setStringPainted(true);
        invisible.setValue(cont3);
        JLabel hum=new JLabel(String.valueOf(shumf));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(3,1));
        frame.setSize(800, 800);
        frame.add(hum);
        frame.add(visible);
        frame.add(invisible);
        while(true){
                hum.setText(serial.getStemp2());
                visible.setValue(serial.getTemp1());
                invisible.setValue(serial.getTemp2());
                Thread.sleep(100);
            
        }
    }
    
}
