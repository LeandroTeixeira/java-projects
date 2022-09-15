/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpolacao;

/**
 *
 * @author Usuário
 */
public class Linear implements Interpolacao{
    private Ponto prim, ult;
    private double a,b;
    
    //Adiciona um ponto ao final. Visto que só dois pontos são permitidos, o primeiro vira o último e o novo ponto vira o ultimo.
    @Override
    public void addPonto(double x, double y) {
        Ponto novo=new Ponto(x,y);
        prim=ult;
        ult=novo;
    }

    @Override
    public void limpaPontos() {
        prim=ult=null;
    }

    @Override
    public Ponto[] getPontos() {
        Ponto[] data = new Ponto[2];
        data[0]=prim;
        data[1]=ult;
        return data;
    }

    //A formula é ax+b
    @Override
    public String getFormula() throws InterpolacaoException{
        if(prim==null || ult==null)
            throw new InterpolacaoException("Pontos Insuficientes!");
        String f;
        f=prim.getY() + " + " + "(" + String.valueOf(prim.getY()) + " - " + String.valueOf(ult.getY()) +")" + 
           "(" + String.valueOf(prim.getX())+" - " + String.valueOf(ult.getX()) +")" + "( x - " + prim.getX() + " )";
        return f;
    }

    @Override
    public String getPolinomio() {
        this.a=(prim.getY()-ult.getY())/(prim.getX()-ult.getX());
        this.b=prim.getY();
        String pol;
        pol= String.valueOf(b) + " + " + String.valueOf(a) + " ( x - " + ult.getX() + " )";
        return pol;
    }

    @Override
    public double getMaxErro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getY(double x) {
        double y;
        this.getPolinomio();
        y=b+a*(x-prim.getX());
        return y;
    }

    @Override
    public double getErro(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
