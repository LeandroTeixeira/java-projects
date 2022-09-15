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
public interface Interpolacao {
    
    public void addPonto(double x, double y);
    public void limpaPontos();
    public Ponto[] getPontos();
    public String getFormula() throws InterpolacaoException;
    public String getPolinomio() throws InterpolacaoException;
    public double getMaxErro() throws InterpolacaoException;
    public double getY(double x) throws InterpolacaoException;
    public double getErro(double x, double y) throws InterpolacaoException;
}
