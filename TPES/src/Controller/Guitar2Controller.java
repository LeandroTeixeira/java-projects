/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model.Levada;
import Model.Model.Notas;
import Model.Model.NotasGuitarra2;

/**
 *
 * @author Usuário
 */
public class Guitar2Controller implements Controller{
    private Notas n;
    private Levada[] l;
    private final int NUM_LEVADAS;
    public Guitar2Controller(){
        n=new NotasGuitarra2();
        NUM_LEVADAS=10;
        l=new Levada[NUM_LEVADAS];
    }

    public int getNUM_LEVADAS() {
        return NUM_LEVADAS;
    }
    
    
    
}
