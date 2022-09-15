/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import analisenumerica.MatrixException;
import java.util.Random;

/**
 *
 * @author Usuário
 */
public class Matriz {
    protected final double [][]matriz;
    protected final int L,C;
    private final Random random;
    
    
    public Matriz(int l, int c){
        random=new Random();
        this.L=l;
        this.C=c;
        matriz=new double[L][C];
        for(int i=0;i<L;i++){
            for(int j=0;j<C;j++){
                matriz[i][j]=random.nextInt(Util.UPPER)-Util.ADJUST;
            }
        }
    }
    
    public Matriz(double [][] m) throws MatrixException{
        random=new Random();
        L=m.length;
        C=m[0].length;
        matriz=new double[L][C];
        this.set(m);
    }
    
    public Matriz(int [][] m) throws MatrixException{
        random=new Random();
        L=m.length;
        C=m[0].length;
        matriz=new double[L][C];
        this.set(m);
    }
    /*
        Inicializa um tipo específico de matriz aleatoriamente.
    */
    public Matriz(int tipo, int l, int c){
        random=new Random();
        switch(tipo){
            case Util.COLUNA:
                this.L=l;
                this.C=1;
                matriz=new double[L][C];
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++){
                        matriz[i][j]=random.nextInt(Util.UPPER)-Util.ADJUST;
                    }
                }
                break;
            case Util.LINHA:
                this.L=1;
                this.C=c;
                matriz=new double[L][C];
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++){
                        matriz[i][j]=random.nextInt(Util.UPPER)-Util.ADJUST;
                    }
                }
                break;
            case Util.NULA:
                this.L=l;
                this.C=c;
                matriz=new double[L][C];
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++){
                        matriz[i][j]=0;
                    }
                }
                break;
            default:
                this.L=l;
                this.C=c;
                matriz=new double[L][C];
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++){
                        matriz[i][j]=random.nextInt(Util.UPPER)-Util.ADJUST;
                    }
                }
        }
    }
    
    //Inicializa um vetor como uma matriz 1 x n ou n x 1, dependendo do parametro
    public Matriz(double [] m, int tipo) throws MatrixException{
        random=new Random();
        switch(tipo){
            case Util.LINHA:
                this.L=1;
                this.C=m.length;
                matriz=new double[L][C];
                System.arraycopy(m, 0, matriz[0], 0, m.length);
                break;
                
            case Util.COLUNA:
                this.C=1;
                this.L=m.length;
                matriz=new double[L][C];
                for(int i=0;i<m.length;i++)
                    matriz[i][0]=m[i];
                break;
            default:
                throw new MatrixException("A matriz deve ser linha ou coluna!");
        }
    }
    
    //Multiplica uma dada linha/coluna por uma constante
    public void mulL(int l, double cons){
        try{
            for(int j=0;j<C;j++)
                matriz[l][j]*=cons;
        }
        catch(ArrayIndexOutOfBoundsException e){System.out.println("Linha inexistente!");}
    }
    
    public void mulC(int c, double cons){
        try{
            for (double[] matriz1 : matriz) {
                matriz1[c] *= cons;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){System.out.println("Linha inexistente!");}
    }
    
    //Troca duas linhas/colunas
    public void swapL(int l1, int l2){
        try{
            double [] aux=new double[C];
            this.copy(this.getLin(l1),aux);
            this.copy(this.getLin(l2), this.getLin(l1));
            this.copy(aux, this.getLin(l2));
        }
        catch(ArrayIndexOutOfBoundsException e){System.out.println("Linha inexistente!");}
    }
    
    public void swapC(int c1, int c2){
        try{
            double[] aux=new double[L];
            this.copy(this.getCol(c1), aux);
            this.copy(this.getCol(c2), c1);
            this.copy(aux,c2);
        }
        catch(ArrayIndexOutOfBoundsException e){System.out.println("Coluna inexistente!");}
    }
    
    //Soma duas linhas/colunas e quarda o resultado na referente ao segundo parâmetro
    public void somL(int li, int lf){
        try{
            for(int j=0;j<C;j++){matriz[lf][j]+=matriz[li][j];}
        }
        catch(ArrayIndexOutOfBoundsException e){System.out.println("Linha inexistente!");}
    }
    
    public void somC(int ci, int cf){
        try{
            for(int i=0;i<L;i++){matriz[i][cf]+=matriz[i][ci];}
            
        }
        catch(ArrayIndexOutOfBoundsException e){System.out.println("Coluna inexistente!");}
    }

    //Multiplica uma linha e soma com outra linha, sem afetar o valor da linha original
    public void mulSomL(int li, int lf, double c){
        double[]aux=new double[this.C];
        this.copy(matriz[li], aux);
        for (int i=0;i<aux.length;i++){
            aux[i]*=c;
        }
        try{
            for(int j=0;j<C;j++){matriz[lf][j]+=aux[j];}
        }
        catch(ArrayIndexOutOfBoundsException e){System.out.println("Linha inexistente!");}
        
    }
    
    //Funções que retornam a transposta. Possuem tipos diferentes de retorno
    public Matriz getMTransposta() throws MatrixException{
        double [][]m=new double[C][L];
        for(int i=0;i<L;i++){
            for(int j=0;j<C;j++){
                m[j][i]=matriz[i][j];
            }
        }
        Matriz x=new Matriz(m);
        return x;
    }
    public double [][] getTransposta(){
        double [][]m=new double[C][L];
        for(int i=0;i<L;i++){
            for(int j=0;j<C;j++){
                m[j][i]=matriz[i][j];
            }
        }
        return m;
    }
    
    public void print(){
        for(int i=0;i<L;i++){
            for(int j=0;j<C;j++){
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printL(int n){
        for(int j=0;j<C;j++){System.out.print(matriz[n][j]+"\t");}
        System.out.println("\n");
    }
    
    public void printC(int n){
        for(int i=0;i<L;i++){System.out.print(matriz[i][n]+"\n");}
        System.out.println();
    }
    
    public void printV(double [] v){
        for(int i=0; i < v.length; i++){ System.out.print(v[i] + "\t"); }
            System.out.println();
    }
       
    
    //Copia os valores do primeiro vetor para o segundo
    private void copy(double [] in, double [] fi){System.arraycopy(in, 0, fi, 0, in.length);}
    //Copia os valores do vetor para a coluna c da matriz
    private void copy(double [] in, int c){
        for(int i=0; i<L; i++){matriz[i][c]=in[i];}
    }
    
    
    private void set(int[][] l) throws MatrixException {
        double [][]m=new double[l.length][l[0].length];
        
        if(m.length!=matriz.length || m[0].length!=matriz[0].length)
            throw new MatrixException("Dimensoes invalidas!");
        
        for(int i=0;i<l.length;i++){
            for(int j=0;j<l[0].length;j++)
                m[i][j]=(double)l[i][j];
        }
        for (int i=0;i<L;i++)
            System.arraycopy(m[i], 0, matriz[i], 0, C);
    }
    
    private void set(double [][] m) throws MatrixException{
        if(m.length!=matriz.length || m[0].length!=matriz[0].length)
            throw new MatrixException("Dimensoes invalidas!");
        for (int i=0;i<L;i++)
            System.arraycopy(m[i], 0, matriz[i], 0, C);
    }
    
    public int [][] getI(){
        int [][]I=new int[L][C];
        for(int i=0;i<L;i++){
            for(int j=0;j<C;j++){
                I[i][j]=(int) matriz[i][j];
            }
        }
        return I;
    }
    
    
    public double[] getCol(int c){
        double[] aux=new double[C];
        for(int i=0;i<L;i++)
            aux[i]=matriz[i][c];
        return aux;
    }
    public double[] getLin(int l){
        return matriz[l];
    }
    public double[][] get() {return matriz;}
    public double getElement(int i, int j){return matriz[i][j];}
    public int getL() {return L;}
    public int getC() {return C;}
    public Random getRandom() {return random;}
    
}
