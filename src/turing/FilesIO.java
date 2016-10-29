/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;


/**
 *
 * @author alwud
 */
public class FilesIO {
    
    
    BufferedReader reader;
    
    BufferedWriter writer;
    
    
    
    public FilesIO(String ruta){
        
        try{
        
            reader= new BufferedReader(new FileReader(ruta));
            writer= new BufferedWriter(new FileWriter(ruta));
            
        
        }catch(Exception e){
            
        }
        
        
        
        
    }
    
    
    public String read(){
        String retorno="";
        String aux="";
        
        
        try{
            while( (aux=reader.readLine())!=null){
                retorno+=aux;
                

            }
        }catch(Exception e){
            return "";
        }
        System.out.println(retorno);
        return retorno;
        
    }
    
}
