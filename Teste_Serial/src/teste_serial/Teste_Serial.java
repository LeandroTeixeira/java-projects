/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_serial;

/**
 *
 * @author Usuário
 */
public class Teste_Serial {

    /**
     * @param args the command line arguments
     */
    public static void Rxtx_test() {
        Teste_RXTX rxtx = new Teste_RXTX();
        rxtx.initialize();
        Thread t = new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException ie) {
                }
            }
        };
        t.start();
        System.out.println("Started");

    }

    public static void jSSC_test() {
        Teste_jSSC rxtx = new Teste_jSSC();
        rxtx.initialize();
        System.out.println("Started");

    }
    
    public static void main(String[] args) {
        // TODO code application logic here

        jSSC_test();
    }

}
