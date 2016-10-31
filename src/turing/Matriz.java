/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;

/**
 *
 * @author alwud
 */
public class Matriz {
   
    
    private String[][]mat;
    private boolean checked;
    
    public Matriz(String [][] mat){
        this.mat= mat;
        checked=false;
        
        
    }
    
    public String[][] getMat(){
        return mat;
        
    }
    
    public void setChecked(){
        checked= true;
    }
    
    public boolean isChecked(){
        return checked;
    }
}
