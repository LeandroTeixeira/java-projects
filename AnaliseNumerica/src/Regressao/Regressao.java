/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regressao;

import Interpolacao.Dados;

/**
 *
 * @author Usuário
 */
public interface Regressao {
    
    public void addPonto(double x, double y);
    public void limpaPontos();
    public Dados getPontos();
    public String getFormula();
    public String getPolinomio();
    public double getVarResidual();
    public double getY(double x);
    public double getErro(double x, double y);
}
