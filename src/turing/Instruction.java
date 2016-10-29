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
public class Instruction {
    
    private int next;
    
    private char  dir;
    
    private  boolean val;
    
    public Instruction(int max, int next, char dir, boolean val){
        if(max>next){
            System.out.println("Error");
            System.exit(0);
        }
        
        this.next= next;
        this.dir=dir;
        this.val=val;
        
        
       
    }
    
    
    
}
