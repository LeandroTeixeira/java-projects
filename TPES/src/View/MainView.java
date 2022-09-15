package View;


import Controller.MainController;
import Main.Util;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class MainView {
    private final int BPM_MIN=40,BPM_MAX=160,BPM_INIT=100;
    
    private JFrame mainFrame;
    private JPanel control;
    private JButton tocar, parar, pausar,salvar,carregar;
    private JSlider bpmSlider;
    private JLabel test;
    private JTabbedPane conteiner;
    
    private int bpm;
    private MainController controller;
    private DrumTab drum;
    private CordaTab bass,g1,g2;
   
    
    public MainView (){
        controller=new MainController();
        
        mainFrame = new JFrame("Musiquality");
        mainFrame.setLayout(new BorderLayout());
        
        conteiner = new JTabbedPane();
       
        drum = new DrumTab();
        bass = new CordaTab(Util.BASS);
        g1 = new CordaTab(Util.GUITAR1);
        g2 = new CordaTab(Util.GUITAR2);
        
        conteiner.add("Bateria",drum.get());
        conteiner.add("Baixo",bass.get());
        conteiner.add("Guitarra 1",g1.get());
        conteiner.add("Guitarra 2",g2.get());
       
        mainFrame.add(conteiner,BorderLayout.CENTER);
        this.initialize_control();
        this.setListeners();
        mainFrame.setSize(1200, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    
    private void initialize_control(){
        control = new JPanel();
        
        tocar = new JButton("Play");
        pausar = new JButton ("Pause");
        parar = new JButton("Stop");
        
        bpmSlider = new JSlider(JSlider.HORIZONTAL,BPM_MIN,BPM_MAX,BPM_INIT);
        bpmSlider.setMajorTickSpacing((BPM_MAX-BPM_MIN)/5);
        bpmSlider.setMinorTickSpacing((BPM_MAX-BPM_MIN)/10);
        bpmSlider.setPaintTicks(true);
        bpmSlider.setPaintLabels(true);
        
        salvar = new JButton("Salvar Musica");
        carregar = new JButton("Carregar Musica");
        test = new JLabel("Test");
        
        control.add(tocar);
        control.add(pausar);
        control.add(parar);
        control.add(bpmSlider);
        control.add(test);
        
        
        control.add(salvar);
        control.add(carregar);
        mainFrame.add(control,BorderLayout.NORTH);
        
    }

    private void setListeners() {
        
        
        bpmSlider.addChangeListener(
            new ChangeListener(){
                public void stateChanged(ChangeEvent e) {
                    bpm=bpmSlider.getValue();
                    test.setText(String.valueOf(bpm));
                }
            }
        );
        
        tocar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.tocar(drum,bass,g1,g2,bpm);
                }
            }
        );
        
        pausar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.pausar(drum,bass,g1,g2,bpm);
                }
            }
        );
        parar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.parar(drum,bass,g1,g2,bpm);
                }
            }
        );
    }

    
    public int getBpm() {return bpm;}
    
    
}
