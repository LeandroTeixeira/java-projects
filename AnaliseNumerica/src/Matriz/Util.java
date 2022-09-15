/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import analisenumerica.MatrixException;

/**
 *
 * @author Usuário
 */
public class Util {

    public static final int GENERICA = 0;
    public static final int NULA = 10;
    public static final int LINHA = 20;
    public static final int COLUNA = 30;
    public static final int TINFERIOR = 40;
    public static final int TSUPERIOR = 50;
    public static final int IDENTIDADE = 60;
    public static final int DIAGONAL = 70;
    public static final int SIMETRICA = 80;

    public static final int UPPER = 32;
    public static final int ADJUST = 16;

    
    public static double[][] transposta(Matriz m) {
        double[][] d = m.get();
        double[][] t = new double[m.getC()][m.getL()];
        for (int i = 0; i < m.getL(); i++) {
            for (int j = 0; j < m.getC(); j++) {
                t[j][i] = d[i][j];
            }
        }
        return t;
    }
    //public static double[][]inversa(MatrizQuadrada m1)throws MatrixException{}

    public static double[][] soma(Matriz m1, Matriz m2) throws MatrixException {
        double[][] aux1 = m1.get();
        double[][] aux2 = m2.get();
        if (m1.getC() != m2.getC() || m1.getL() != m2.getL()) {
            throw new MatrixException("As matrizes devem ser do mesmo tamanho para serem somadas!");
        }
        double[][] resul = new double[m1.getL()][m1.getC()];
        for (int i = 0; i < resul.length; i++) {
            for (int j = 0; j < resul[i].length; j++) {
                resul[i][j] = aux1[i][j] + aux2[i][j];
            }
        }
        return resul;
    }

    public static double[][] subtracao(Matriz m1, Matriz m2) throws MatrixException {
        double[][] aux1 = m1.get();
        double[][] aux2 = m2.get();
        if (m1.getC() != m2.getC() || m1.getL() != m2.getL()) {
            throw new MatrixException("As matrizes devem ser do mesmo tamanho para serem somadas!");
        }
        double[][] resul = new double[m1.getL()][m1.getC()];
        for (int i = 0; i < resul.length; i++) {
            for (int j = 0; j < resul[i].length; j++) {
                resul[i][j] = aux1[i][j] - aux2[i][j];
            }
        }
        return resul;
    }
    
    public static double[][]multiplicacao(Matriz m1,Matriz m2)throws MatrixException{
        if (m1.getC() != m2.getL()) {
            throw new MatrixException("Matriz inapropriada para multiplicaçao!");
        }
        double [][] resul=new double[m1.getL()][m2.getC()];
        double som=0;
        double [][] aux1=m1.get();
        double [][] aux2=m2.get();
        for(int i=0;i<resul.length;i++){
            for(int j=0;j<resul[i].length;j++){
                for(int k=0;k<m1.getC();k++){
                    som+=aux1[i][k]*aux2[k][j];
                }
                resul[i][j]=som;
                som=0;
            }
        }
        return resul;
    }

    public static boolean isNula(Matriz m1) {
        double[][] m = m1.get();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSparse(Matriz m1) {
        double[][] aux = m1.get();
        double min = 0.4 * m1.getC() * m1.getL();
        int cont = 0;
        for (double[] aux1 : aux) {
            for (int j = 0; j < aux1.length; j++) {
                if (aux1[j] == 0) {
                    cont++;
                }
            }
        }
        return cont > min;
    }

    public static boolean isDiagonal(MatrizQuadrada m1) {
        double[][] m = m1.get();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i != j && m[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIdentidade(MatrizQuadrada m1) {
        double[][] m = m1.get();
        if (Util.isDiagonal(m1)) {
            for (int i = 0; i < m1.getC(); i++) {
                if (m[i][i] != 1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isSimetrica(MatrizQuadrada m1) {
        double[][] m = m1.get();
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[i].length; j++) {
                if (m[i][j] != m[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isTSuperior(MatrizQuadrada m1) {
        double[][] m = m1.get();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < i; j++) {
                if (m[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isTInferior(MatrizQuadrada m1) {
        double[][] m = m1.get();
        for (int i = 0; i < m.length; i++) {
            for (int j = i+1; j < m[i].length; j++) {
                if (m[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void print (double [][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++)
                System.out.print(m[i][j]+"\t");
            System.out.println();
        }
        System.out.println();
    }
    
}
