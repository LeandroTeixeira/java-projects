/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DrumController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuário
 */
public class DrumTab {
    private JPanel mainTab,top,bot;
    private JPanel auxTop1,auxTop2; 
    private JPanel auxBot1,auxBot2;
    private JLabel tLabel;
    private JLabel[] notes, nTempo;
    private JCheckBox[][] tempo;
    
    private JComboBox c1;
    
    private JCheckBox[][] rhythms;
    private JButton[] rhythmList;
    
    private int selec;
    private DrumController controller;
    
    
    public DrumTab(){
        selec=0;
        controller=new DrumController();
        this.iniialize();
        this.setListeners();
    }

    private void iniialize() {
        this.initializeComponents();
        mainTab.setLayout(new GridLayout(2,1));
        this.iniializeTop();
        
        this.iniializeBot();
        
       mainTab.add(top);
       mainTab.add(bot);
    }

    JPanel get() {
        return mainTab;
    }

    private void iniializeTop() {
        top.setLayout(new BorderLayout());
        
        auxTop1 = new JPanel();
        auxTop1.setLayout(new GridLayout(10,1));
        
        rhythms = new JCheckBox[10][50];
        
        auxTop2 = new JPanel();
        auxTop2.setLayout(new GridLayout(rhythms.length,rhythms[0].length));
        
        rhythmList = new JButton[10];
        for(int i=0;i<rhythms.length;i++){
            for(int j=0;j<rhythms[i].length;j++){
                rhythms[i][j] = new JCheckBox();
                auxTop2.add(rhythms[i][j]);
            }
            rhythmList[i] = new JButton("Ritmo " + (i+1));
            auxTop1.add(rhythmList[i]);
        }
        top.add(auxTop1,BorderLayout.WEST);
        top.add(auxTop2,BorderLayout.CENTER);
    }

    private void iniializeBot() {
        bot.setLayout(new BorderLayout());
        auxBot1.setLayout(new GridLayout(10,17));
        auxBot2.setLayout(new GridLayout(4,2));
        String[] labelNome=controller.getNomes();
        
        double p=0;
        nTempo[0]=new JLabel();
        for(int i = 1;i<nTempo.length;i++,p+=0.25)
            nTempo[i]=new JLabel(String.valueOf(p));
       
        for(int i=0;i<17;i++)
           auxBot1.add(nTempo[i]);
       
        for(int i = 0;i<9;i++){
            notes[i]=new JLabel(labelNome[i]);
            auxBot1.add(notes[i]);
            for(int j=0;j<16;j++){
               tempo[i][j]=new JCheckBox();
               auxBot1.add(tempo[i][j]);
            }
        }
        auxBot2.add(tLabel);
        auxBot2.add(c1);
        
        bot.add(auxBot1,BorderLayout.CENTER);
        bot.add(auxBot2,BorderLayout.EAST);
    }

    private void initializeComponents() {
        mainTab = new JPanel();
        String[] s={"0.25","0.5","0.75","1","1.25","1.5","1.75","2","2.25","2.5","2.75","3","3.25","3.5","3.75","4"};
        c1=new JComboBox(s);
        c1.setSelectedIndex(s.length-1);
        top=new JPanel();
        bot=new JPanel();
        auxBot1=new JPanel();
        auxBot2=new JPanel();
        tLabel=new JLabel("Tempo");
        nTempo=new JLabel[17];
        tempo=new JCheckBox[controller.getQtd()][16];
        notes=new JLabel[controller.getQtd()];
        
   }
    
    
    private void setListeners() {
        c1.addItemListener(new ItemListener(){
               public void itemStateChanged(ItemEvent e) {
                   if (e.getStateChange() == ItemEvent.SELECTED) {
                        int maxTempos = c1.getSelectedIndex();
                         controller.setMaxTempo(selec,maxTempos);
                         for (JCheckBox[] tempo1 : tempo) {
                             for (int j = 0; j<=maxTempos; j++) {
                                 tempo1[j].setEnabled(true);
                             }
                         }
                         for (JCheckBox[] tempo1 : tempo) {
                             for (int j = maxTempos+1; j<tempo1.length; j++) {
                                 tempo1[j].setEnabled(false);
                                 tempo1[j].setSelected(false);
                             }
                         }
                     }
                    }    
        });
        for(int i=0;i<tempo.length;i++){
            String nome=notes[i].getText();
            for(int j=0;j<tempo[i].length;j++){
                int t=j;
                tempo[i][j].addActionListener(new ActionListener(
                ) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.switchNota(selec,nome,t);
                    }
                });
            }
        }
        
        for(int i=0;i<rhythmList.length;i++){
            int j=i;
            rhythmList[i].addActionListener(new ActionListener(
            ) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selec=j;
                    int t = controller.load(selec,notes,tempo);
                    System.out.println(t);
                    c1.setSelectedIndex(t-1);
                }
            });
        }
        
    }
    
}
