/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisenumerica;

import Interpolacao.*;

import Matriz.Gauss;
import Matriz.GaussJordan;
import Matriz.Util;
import Matriz.Matriz;
import Matriz.MatrizQuadrada;

/**
 *
 * @author Usuário
 */
public class AnaliseNumerica {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Interpolacao l=new Lagrange();
        l.addPonto(0.3, 1.3499);
        l.addPonto(0.4, 1.4918);
        l.addPonto(0.5, 1.6487);
        System.out.print(l.getY(0.45));
    }
    
}
