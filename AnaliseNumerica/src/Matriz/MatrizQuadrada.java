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
public class MatrizQuadrada extends Matriz{
    
    public MatrizQuadrada(int d){super(d,d);}
    public MatrizQuadrada(int [][] m) throws MatrixException{super(m);}
    public MatrizQuadrada(double [][] m) throws MatrixException{super(m);}
    
    public MatrizQuadrada(int tipo, int d){
        super(d,d);
        switch(tipo){
            case Util.IDENTIDADE:
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++){
                        if(i==j)
                            matriz[i][j]=1;
                        else
                            matriz[i][j]=0;
                    }
                }
                break;
            case Util.DIAGONAL:
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++){
                        if(i==j)
                            matriz[i][j]=super.getRandom().nextInt(Util.UPPER)-Util.ADJUST;
                        else
                            matriz[i][j]=0;
                    }
                }
                break;
            
            case Util.TINFERIOR:
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++){
                        if(i<j)
                            matriz[i][j]=0;
                        else
                            matriz[i][j]=super.getRandom().nextInt(Util.UPPER)-Util.ADJUST;
                    }
                }
                break;
            case Util.TSUPERIOR:
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++){
                        if(i>j)
                            matriz[i][j]=0;
                        else
                            matriz[i][j]=super.getRandom().nextInt(Util.UPPER)-Util.ADJUST;
                    }
                }
                break;
            case Util.NULA:
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++)
                        matriz[i][j]=0;
                }
                break;
            case Util.SIMETRICA:
                for(int i=0;i<L;i++){
                    for(int j=i;j<C;j++){
                        matriz[i][j]=matriz[j][i]=super.getRandom().nextInt(Util.UPPER)-Util.ADJUST;
                    }
                }
                break;
            
            default:
                for(int i=0;i<L;i++){
                    for(int j=0;j<C;j++)
                        matriz[i][j]=super.getRandom().nextInt(Util.UPPER)-Util.ADJUST;
                }
        }
    }
    public double getPosto(){
        double posto=0;
        for(int i=0;i<C;i++)
            posto+=matriz[i][i];
        return posto;
    }
    
    public boolean isSingular() throws MatrixException{return getDeterminante()==0;}
    
    public double getDeterminante() throws MatrixException{
        if(matriz.length==1)
            return matriz[0][0];
        double resul=0;
        double [][] aux;
        for(int i=0;i<matriz[0].length;i++){
            aux=remove(matriz,0,i);
            
            resul+=Math.pow(-1, i)*matriz[0][i]*getDeterminante(aux);
        }
        return resul;
    }
    
    private double getDeterminante(double [][] m){
        if(m.length==1)
            return m[0][0];
        double resul=0;
        double [][] aux;
        for(int i=0;i<m[0].length;i++){
            aux=remove(m,0,i);
            resul+=Math.pow(-1, i)*m[0][i]*getDeterminante(aux);
        }
        return resul;
    }
    
    //Retorna uma matriz sem a linha L e a coluna C da matriz original
    private double [][] remove(double [][] m, int L, int C){
        double [][] resul=new double[m.length-1][m.length-1];
        for (int i=0,i1=0;i<m.length;i++){
            if(i==L)
                continue;
            for(int j=0,j1=0;j<m.length;j++){
                if(j==C)
                    continue;
                resul[i1][j1]=m[i][j];
                j1++;
            }
            i1++;
        }
        return resul;
    }
    
    public int pDiagonal(double[][]m, int d){
        int resul=1;
        try{
            for(int i=0,j=d;i<m.length;i++,j++){
                if(j==m.length)
                    j=0;
                resul*=m[i][j];
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Posicao invalida do array!");
        }
        return resul;
    }
    
    public int pDiagonalI(double[][]m, int d){
        int resul=1;
        try{
            for(int i=0,j=d;i<m.length;i++,j--){
                if(j==-1)
                    j=m.length-1;
                resul*=m[i][j];
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Posicao invalida do array!");
        }
        return resul;
    }

    public void printProperties() {
        System.out.println("Nula: "+Util.isNula(this));
        System.out.println("Esparsa: "+Util.isSparse(this));
        System.out.println("Diagonal: "+Util.isDiagonal(this));
        System.out.println("Identidade: "+Util.isIdentidade(this));
        System.out.println("Triangular Superior: "+Util.isTSuperior(this));
        System.out.println("Triangular Inferior: "+Util.isTInferior(this));
        System.out.println("Simetrica: "+Util.isSimetrica(this));
    }
    
}
