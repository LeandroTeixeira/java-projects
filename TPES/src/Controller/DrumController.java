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
import Model.Model.Notas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author Usuário
 */
public class DrumController{
    private Notas bateria;
    private Levada[] levada;
    public DrumController(){
        try {
            bateria=new Notas(Util.DRUM);
        } catch (ModelException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
        levada=new Levada[10];
        for(int i=0;i<levada.length;i++)
            levada[i]=new Levada(bateria);
    }
    
    public String[] getNomes(){
        return bateria.getNomes();
    }

    public int getQtd() {
        return bateria.getQtd();
    }


    public void switchNota(int selec, String text, int j) {
        try {
            levada[selec].switchNota(text, j);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeNota(int selec, String nome, int t) {
        System.out.print("Remove");
        try {
            levada[selec].removeNota(selec, nome);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ModelException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    public int load(int l,JLabel[] notes, JCheckBox[][] tempo) {
        for(int i=0;i<tempo.length;i++){
            String nome=notes[i].getText();
            for(int j=0;j<tempo[i].length;j++){
                tempo[i][j].setSelected(levada[l].contains(nome,j));
            }
        }
        return levada[l].getTamanho();
    }

    public void setMaxTempo(int selec, int maxTempos) {
        try {
            levada[selec].setTamanhoMax(maxTempos+1);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
