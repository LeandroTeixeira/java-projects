/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisenumerica;

/**
 *
 * @author Usuário
 */
public class MatrixException extends Exception {

    /**
     * Creates a new instance of <code>MatrixException</code> without detail
     * message.
     */
    public MatrixException() {
    }

    /**
     * Constructs an instance of <code>MatrixException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MatrixException(String msg) {
        super(msg);
    }
}
