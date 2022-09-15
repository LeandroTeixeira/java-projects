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
public class ModelException extends Exception {

    /**
     * Creates a new instance of <code>ModelException</code> without detail
     * message.
     */
    public ModelException() {
    }

    /**
     * Constructs an instance of <code>ModelException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ModelException(String msg) {
        super(msg);
    }
    public ModelException(String msg,Throwable err) {
        super(msg,err);
    }
}
