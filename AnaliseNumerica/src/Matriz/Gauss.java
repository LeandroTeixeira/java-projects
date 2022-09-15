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
public class Gauss extends MatrizQuadrada{
    protected Matriz b;
    protected double[]x;
    
    public Gauss(int d) {
        super(d);
        b=new Matriz(Util.COLUNA,d,d);
        x=new double[b.getC()];
    }

    public Gauss(double[][] m,double[] b) throws MatrixException {
        super(m);
        if(b.length!=m.length)
            throw new MatrixException("Dimensões inválidas para B!");
        this.b=new Matriz(b,Util.COLUNA);
        x=new double[this.b.getC()];
    }

    public Gauss(int tipo, int d) {
        super(tipo, d);
        b=new Matriz(Util.COLUNA,d,d);
        x=new double[this.b.getC()];
    }
    
    public Gauss(int tipo, int d, double [] b) throws MatrixException {
        super(tipo, d);
        if(b.length!=d)
            throw new MatrixException("Dimensões inválidas para B!");
        this.b=new Matriz(b,Util.COLUNA);
        x=new double[this.b.getC()];
    }
   
    //Executa o processo de Gauss sem pivoteamento nas duas matrizes. O parametro booleano define se o passo a passo será impresso ou não
    //Alexandre é bolsominion Loic é Ptista hahah
    public void completo(boolean c) throws MatrixException{
        double mij;
        for(int j=0;j<this.C;j++){
            for(int i=j+1;i<this.L;i++){
                if(matriz[j][j]==0)
                    throw new MatrixException("Matriz Singular!");
                mij=-matriz[i][j]/matriz[j][j];
                this.mulSomL(j, i, mij);
                b.mulSomL(j, i, mij);
            }
            if(c)
                this.print();
        }
    }
   
    //Executa o processo de Gauss sem pivoteamento apenas na matriz de coeficientes. Usada na decomposicao LU
    public void parcial(boolean c){
        
    }
    public Matriz getResto() throws MatrixException{
        double[][] aux=Util.multiplicacao(this, new Matriz(x,Util.COLUNA));
        Matriz maux=new Matriz(aux);
        return new Matriz(Util.subtracao(b, maux));
    }

    @Override
    public void print() {
        for(int i=0;i<L;i++){
            for(int j=0;j<C;j++){
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<b.getL();i++)
            System.out.print(b.getElement(i, 0)+"\t");
        System.out.println("\n");
    //b.print();
      
    }

    @Override
    public double getDeterminante() throws MatrixException {
        this.completo(false);
        return this.pDiagonal(matriz, L);
    }
    
    public Matriz getB() { return b;  }
    public double[] getX() { return x; }
}
