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
public class Instrumento {
    private String nome;
    private String[] notas;
    private String[] URLs;
    private int cont;
    public Instrumento (String nome, int qtd){
        this.nome=nome;
        notas=new String[qtd];
        URLs=new String[qtd];
        cont=0;
    }
    public void addNota(String nome, String url){
        if(cont<notas.length){
            notas[cont]=nome;
            URLs[cont]=url;
            cont++;
        }
    }
    
    public void print(){
        System.out.println("O/A " + nome + " tem " + cont + " notas");
        for(int i=0;i<cont;i++)
            System.out.println(notas[i]+"\t"+URLs[i]);
    }
    
}
