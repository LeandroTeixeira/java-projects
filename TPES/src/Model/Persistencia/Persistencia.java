/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistencia;

import Model.Model.Nota;

/**
 *
 * @author Usuário
 */

/*
Classe responsável por salvar e carregar os dados. É feita em forma de Singleton
*/
public class Persistencia{
    private static Persistencia persist;
    //URL onde serão salvos dados de configuração do programa. Isso inclui 
    //os nomes dos arquivos e das notas referentes a cada um dos instrumentos,
    //assim como as músicas criadas e similares.
    private final String urlCfg;
    
    private Nota[] bateria;
    private Nota[] baixo;
    private Nota[] guitarra1;
    private Nota[] guitarra2;
    
    private Persistencia(){
        this.urlCfg="";
        this.setNotas();
    }
    
    public static Persistencia getPersistencia(){
        if(persist==null)
            persist=new Persistencia();
        return persist;
    }
    
    /*
    Funções relacionadas à persistência de dados deverão ser implementadas
    */
    
    public Nota[] getBateria(){return bateria;}    
    public Nota[] getBaixo(){return baixo;}    
    public Nota[] getGuitarra1(){return guitarra1;}    
    public Nota[] getGuitarra2(){return guitarra2;}    

        
    private void setNotas() {
        bateria = new Nota[9];
        bateria[0]= new Nota("Closed HH","");
        bateria[1]= new Nota("Open HH","");
        bateria[2]=new Nota("Snare","");
        bateria[3]=new Nota("Tom Hi","");
        bateria[4]=new Nota("Tom Mid","");
        bateria[5]=new Nota("Tom Low","");
        bateria[6]=new Nota ("Kick","");
        bateria[7]=new Nota("Ride","");
        bateria[8]=new Nota("Crash","");
        
        
        //guitarra1 = new Nota
    }
}
