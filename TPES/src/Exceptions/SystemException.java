/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Usuário
 */
public class SystemException extends Exception {

    /**
     * Creates a new instance of <code>SystemException</code> without detail
     * message.
     */
    public SystemException() {
    }

    /**
     * Constructs an instance of <code>SystemException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
        */
       public SystemException(String msg) {
           super(msg);
       }
       
    public SystemException(String msg,Throwable err) {
        super(msg,err);
    }
}
