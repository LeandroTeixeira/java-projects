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
public class Lagrange implements Interpolacao{
    private Dados d;
    public Lagrange(){d=new Dados();}
    public Lagrange(Dados d){this.d=d;}

    @Override
    public void addPonto(double x, double y) {
        d.addDado(x, y);
    }

    @Override
    public void limpaPontos() {
        d.clear();
    }

    @Override
    public Ponto[] getPontos() {
        return d.getDados();
    }

    @Override
    public String getFormula() throws InterpolacaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPolinomio() throws InterpolacaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMaxErro() throws InterpolacaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getY(double x) throws InterpolacaoException {
        double soma=0;
        Ponto [] data = d.getDados();
        for(int i=0;i<d.getSize();i++){
            double product = data[i].getY();
            for(int j=0;j<d.getSize();j++){
                if(i==j)
                    continue;
                product*=(x-data[j].getX())/(data[i].getX()-data[j].getX());
            }
            soma+=product;
        }
        return soma;
    }

    @Override
    public double getErro(double x, double y) throws InterpolacaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
