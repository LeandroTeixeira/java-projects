/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Model;

import Exceptions.ModelException;
import Exceptions.SystemException;
import Model.Persistencia.Persistencia;

/**
 *
 * @author Usuário
 */
public class NotasGuitarra1 implements Notas{
    private final Persistencia p;
    private final Nota[] notas;
    public NotasGuitarra1(){
        this.p = Persistencia.getPersistencia();
        this.notas = p.getGuitarra1();
    }
    
    /**
     *
     * @param indice
     * Indice referente à nota desejada
     * 
     * @return null se o indice for inválido. O nome da nota desejada caso contrário
     */
    @Override
    public String getNomeNota(int indice) throws SystemException {
        if(indice<0||indice>notas.length)
            throw new SystemException("Índice inválido!");
        return notas[indice].getNome();
    }

    /**
     *
     * @param nome -- O nome da nota que se deseja 
     * 
     * @return indice da nota com o nome desejado. Lança exceção caso ela não seja encontrada
     * @throws Exceptions.ModelException
     */
    @Override
    public int getIndiceNota(String nome) throws ModelException {
        for(int i = 0;i<notas.length;i++){
            if (nome.equals(notas[i].getNome()))
                return i;
        }
        throw new ModelException("Essa nota não existe!");
    }

    @Override
    public int getQtd() {
        return notas.length;
    }

    @Override
    public void tocar(int indice) throws SystemException {
        if(indice<0||indice>notas.length)
            throw new SystemException("Índice inválido!");
        notas[indice].tocar();
    }

    @Override
    public void tocar(String nome) throws ModelException {
        for (Nota nota : notas) {
            if (nome.equals(nota.getNome())) {
                nota.tocar();
                return;
            }
        }
        throw new ModelException("Essa nota não existe!");
    }
     
    @Override
    public String[] getNomes() {
        String[]nomes=new String[notas.length];
        for(int i=0;i<notas.length;i++)
            nomes[i]=notas[i].getNome();
        return nomes;
    }
}
