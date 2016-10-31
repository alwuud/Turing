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
    
    private ArrayList<Matriz > matrix= new ArrayList();
    private FilesIO fileManager;
    
    private char [] cinta;
    
    
    public Analizador(String ruta){
        
        fileManager= new FilesIO(ruta);
        cinta= new char[99];
        
    }
    
    private void startCinta(){
        for(int i=0; i< cinta.length; i++){
            cinta[i]='b';
        }
    }
    
    public boolean build(){
        String data= fileManager.read();
      
        data=data.replace('[', ' ');
        data=data.replace(']', ' ');
        data= data.replace('(', ' ');
        data= data.trim();
        
       
        
        String[] datos=  data.split("\\)");
        
        
        System.out.println("Filas " +datos.length);
        if(datos.length%3!=0){
            
            return false;
            
        }
        
        
        String aux[][]= new String[3][];
        
        
        int contador=0;
        for(String d: datos){
            
            aux[contador]= d.split(",");
            
            if(aux[contador].length!=3)
                return false;
            

            contador++;
            if(contador==3){
                contador=0;
                matrix.add(new Matriz(aux));
                aux= new String[3][];
            }
            
            
        }
       
       
        
        
        
        return true;
        
        
    }
    
    public void turingSecuence(int initialMatrix){
        int matrixIndex= initialMatrix;
        
        
    }
    
    public void turingSecuence(){
        int matrixCounter= matrix.size();
        int cintaIndex=49;
        
        
        int matrixIndex= (int) (Math.random()*matrixCounter);
        int rowIndex=0;
        String [][] actualMatrix= null;
        
        if(matrixIndex==matrixCounter)
            matrixIndex--;
        
        while(matrixCounter>0){
            
            rowIndex= (int)(Math.random()*3);
            if(rowIndex==3)
                rowIndex--;
            
            actualMatrix= matrix.get(matrixIndex).getMat();
            System.out.println("Matriz Actual " + (matrixIndex+1) +"\n Fila Actual " + (rowIndex+1));
            
            if(actualMatrix[rowIndex][0].contains("0"))
                  cinta[cintaIndex]= '0';
            else
                cinta[cintaIndex]= '1';
            
            System.out.println("Valor Escrito: " + cinta[cintaIndex]);
            
            if(actualMatrix[rowIndex][1].contains("L")){
                cintaIndex++;
            }else if(actualMatrix[rowIndex][1].contains("R")){
                cintaIndex--;
            }
            
            System.out.println("Corrimiento de Cinta: " + actualMatrix[rowIndex][1]);
            
             if(!matrix.get(matrixIndex).isChecked()){
                matrix.get(matrixIndex).setChecked();
                matrixCounter--;
            }
            this.checkedMatrixes(); 
            
            try{
                matrixIndex= Integer.parseInt(actualMatrix[rowIndex][2])-1;
            }catch(Exception e){
                
            }
            
            System.out.println("Cinta Estado Actual: " +new String(cinta).trim());
            
            System.out.println("Siguiente Matriz " + (matrixIndex+1));
            
            
           
                
            
            
            System.out.println("\n\n\n");
        }
        
        System.out.println(new String(cinta).trim());
        
        
        
        
        
        
    }
    
    private void checkedMatrixes(){
        int contador=0;
        for(Matriz m: matrix){
            if(m.isChecked())
                contador++;
            
        }
        System.out.println(contador + " matrices Recorridas de " + matrix.size());
            
    }
    
    
}
