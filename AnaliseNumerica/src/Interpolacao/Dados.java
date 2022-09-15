/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolacao;

import java.util.LinkedList;

/**
 *
 * @author Usuário
 */
public class Dados {
    private LinkedList<Ponto> pontos;
    public Dados(){
        pontos=new LinkedList<> ();
    }
    
    public void addDado(double i, double v){
        Ponto novo = new Ponto(i,v);
        pontos.addLast(novo);
    }
    
    public Ponto[]getDados(){
        Ponto [] dado = new Ponto[pontos.size()];
        dado=pontos.toArray(dado);
        return dado;
    }
    
    public void clear(){
        pontos.clear();
    }

    public int getSize(){
        return pontos.size();
    }
    
}
