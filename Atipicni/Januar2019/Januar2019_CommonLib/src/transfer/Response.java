/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Rastko
 */
public class Response implements Serializable{
    private Object data;
    private Exception error;

    public Response() {
    }

    public Response(Object data, Exception error) {
        this.data = data;
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public Exception getError() {
        return error;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setError(Exception error) {
        this.error = error;
    }
    
    
}
