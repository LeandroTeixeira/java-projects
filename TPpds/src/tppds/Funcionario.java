/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tppds;

/**
 *
 * @author Usuário
 */
public class Funcionario {
    private double salarioMensal;

    public Funcionario(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }
    
    public double getSalario(){
        return salarioMensal;
    }
    public double getSalarioAnual(){
        return salarioMensal*12;
    }
}
