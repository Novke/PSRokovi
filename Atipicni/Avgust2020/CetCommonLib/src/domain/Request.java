/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Rastko
 */
public class Request implements Serializable{
    private Object data;
    private int operation;

    public Request() {
    }

    public Request(Object data, int operation) {
        this.data = data;
        this.operation = operation;
    }

    public Object getData() {
        return data;
    }

    public int getOperation() {
        return operation;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
    
}
