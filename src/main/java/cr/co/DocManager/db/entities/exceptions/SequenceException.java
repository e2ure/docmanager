/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.db.entities.exceptions;

/**
 *
 * @author SOIN
 */
public class SequenceException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    //get, set...
    public SequenceException(String errMsg) {
            this.errMsg = errMsg;
    }
}
