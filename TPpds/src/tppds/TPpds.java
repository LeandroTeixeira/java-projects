/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tppds;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class TPpds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Instrumento[] inst = new Instrumento[2];
        String separator="\\s*,\\s*";
        String lineSeparator="\\s*"+System.getProperty("line.separator");
        String s="";
        try {
            Scanner input;
            input=new Scanner(Paths.get("src/config/cfg.txt"));
            input.useDelimiter(separator+"|"+lineSeparator);
            for(int i=0;i<2;i++){
                String nome=input.next();
                int qtd=Integer.parseInt(input.next());
                inst[i]=new Instrumento(nome,qtd);
                for(int j=0;j<qtd;j++){
                    String nota=input.next();
                    String url=input.next();
                    inst[i].addNota(nota, url);
                }
                inst[i].print();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(TPpds.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
