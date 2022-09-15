/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exceptions.ModelException;
import Exceptions.SystemException;
import Main.Util;
import Model.Model.Levada;
import Model.Model.Notas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author Usuário
 */
public class CordaController{
    private Notas n;
    private Levada[] l;
    private final int NUM_LEVADAS;
    public CordaController(int tipo){
        try {
            n=new Notas(tipo);
        } catch (ModelException ex) {
            Logger.getLogger(CordaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        NUM_LEVADAS=10;
        l=new Levada[NUM_LEVADAS];
        for(int i=0;i<NUM_LEVADAS;i++)
            l[i]=new Levada(n);
    }

    public String[] getNomes(){
        return n.getNomes();
    }

    public int getQtd() {
        return n.getQtd();
    }


    public void switchNota(int selec, String text, int j) {
        try {
            l[selec].switchNota(text, j);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeNota(int selec, String nome, int t) {
        System.out.print("Remove");
        try {
            l[selec].removeNota(selec, nome);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ModelException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    public int load(int k,JLabel[] notes, JCheckBox[][] tempo) {
        for(int i=0;i<tempo.length;i++){
            String nome=notes[i].getText();
            for(int j=0;j<tempo[i].length;j++){
                tempo[i][j].setSelected(l[k].contains(nome,j));
            }
        }
        return l[k].getTamanho();
    }

    public void setMaxTempo(int selec, int maxTempos) {
        try {
            l[selec].setTamanhoMax(maxTempos+1);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
