/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;

import java.util.ArrayList;

/**
 *
 * @author alwud
 */
public class Analizador {
    
    private ArrayList<String [][] > matrix= new ArrayList();
    FilesIO fileManager;
    
    
    public Analizador(String ruta){
        
        fileManager= new FilesIO(ruta);
        
        
    }
    
    public boolean build(){
        String data= fileManager.read();
        data.replace('[', ' ');
        data.replace(']', ' ');
        data.replace('(', ' ');
        data.trim();
        
     
        
        String[] datos=  data.split(")");
        
        
        
        if(datos.length%3==0){
            return false;
            
        }
        
        
        String aux[][]= new String[3][];
        
        
        int contador=0;
        for(String d: datos){
            aux[contador]= d.split(",");

            contador++;
            if(contador==3){
                contador=0;
                matrix.add(aux);
                aux= new String[3][];
            }
            
            
        }
       
       
        
        
        
        return true;
        
        
    }
    
    
    
}
