/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Model;

/**
 *
 * @author Usuário
 */

    /*
    Elemento básico da música. Pode ser tanto nota musical quanto nome do tambor 
    da bateria responsável pelo som 
    */
public class Nota {
    private final String nome;
    private final String url;
    //Mais variáveis devem ser adicionadas para representar o som da nota
    
    public Nota(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }
    //Nome da nota
    public String getNome(){return this.nome;}
    // Endereço da nota no computado
    public String getURL(){return this.url;}
    //Define a URL da nota. Se ela for inválida, lança exceção
    public void tocar(){
        Som.tocar(url);
    }

}
