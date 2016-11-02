/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author alwud
 */
public class Analizador implements Runnable {
    
    private Matriz[] matrix;
    private FilesIO fileManager;
    private String reporte;
    private int indiceMatrices=0;
    
    private char [] cinta;
    
    private boolean builded=false;
    
    
    
    
    public Analizador(String ruta){
        
        fileManager= new FilesIO(ruta);
        cinta= new char[99];
        
        
    }
    
    public Analizador(File f){
        fileManager= new FilesIO(f);
        cinta= new char[99];
        reporteInterno="";
    }
    
    
    public char[] getCinta(){
        return cinta;
    }
    private void startCinta(){
        for(int i=0; i< cinta.length; i++){
            cinta[i]='b';
        }
    }
    
    public boolean build(){
        String data= fileManager.read();
        
        this.indiceMatrices=0;
      
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
        matrix= new Matriz[datos.length/3];
        
        int contador=0;
        for(String d: datos){
            
            aux[contador]= d.split(",");
            
            if(aux[contador].length!=3)
                return false;
            

            contador++;
            if(contador==3){
                contador=0;
                add(new Matriz(aux));
                aux= new String[3][];
            }
            
            
        }
       
       
        
        
        builded=true;
        return true;
        
        
    }
    
    
    public boolean isBuild(){
        return builded;
    }
    
    private void add(Matriz m){
        
        matrix[this.indiceMatrices++]= m;
    }
    
    private JTextArea txtArea;
    public void setTextArea(JTextArea txtArea){
        this.txtArea= txtArea;
    }
    public void turingSecuence(int initialMatrix){
        int matrixIndex= initialMatrix;
        
        
    }
    
    
    
    private void resetMatrixes(){
        if(matrix==null)
            return;
                    
        for(Matriz m: matrix){
            if(m==null)
                return;
            m.setUnchecked();
            
        }
        cinta= new char[99];
    }
    String reporteInterno;
    public void turingSecuence(JTextArea txtArea){
        resetMatrixes();
        this.reporte="";
        
        
        int matrixCounter= matrix.length;
        int cintaIndex=49;
        
        
        int matrixIndex= (int) (Math.random()*matrixCounter);
        int rowIndex=0;
        String [][] actualMatrix= null;
        
        if(matrixIndex==matrixCounter)
            matrixIndex--;
        
        while(matrixCounter>0){
            reporteInterno="";
            
            rowIndex= (int)(Math.random()*3);
            if(rowIndex==3)
                rowIndex--;
            
            actualMatrix= matrix[matrixIndex].getMat();
            
            reporteInterno+=("Matriz Actual " + (matrixIndex+1) +"\n Fila Actual " + (rowIndex+1) + "\n");
            
            //System.out.println("Matriz Actual " + (matrixIndex+1) +"\n Fila Actual " + (rowIndex+1));
            
            if(actualMatrix[rowIndex][0].contains("0"))
                  cinta[cintaIndex]= '0';
            else
                cinta[cintaIndex]= '1';
            
            
            reporteInterno+="Valor Escrito en Cinta: " + cinta[cintaIndex] + "\n";
            //System.out.println("Valor Escrito en Cinta: " + cinta[cintaIndex]);
            
            if(actualMatrix[rowIndex][1].contains("L")){
                cintaIndex++;
            }else if(actualMatrix[rowIndex][1].contains("R")){
                cintaIndex--;
            }
            
             reporteInterno+="Corrimiento de Cinta: " + actualMatrix[rowIndex][1] + "\n";
            System.out.println("Corrimiento de Cinta: " + actualMatrix[rowIndex][1]);
            
             if(!matrix[matrixIndex].isChecked()){
                matrix[matrixIndex].setChecked();
                matrixCounter--;
            }
            reporteInterno+=this.checkedMatrixes()+"\n"; 
            
            try{
                matrixIndex= Integer.parseInt(actualMatrix[rowIndex][2])-1;
            }catch(Exception e){
                
            }
            
            
            reporteInterno+= "Estado Actual Cinta: " +new String(cinta).trim() + "\n";
            System.out.println("Cinta Estado Actual: " +new String(cinta).trim());
            
            
             reporteInterno+="Siguiente Matriz " + (matrixIndex+1)+ "\n";
            System.out.println("Siguiente Matriz " + (matrixIndex+1));
            
            
           
            this.reporte+= reporteInterno+ "\n\n";
            
           
           
            System.out.println("\n\n\n");
        }
        
        this.txtArea.setText(reporte);
        
        System.out.println(new String(cinta).trim());
        
       
        
        
        
        
    }
    
    private String checkedMatrixes(){
        int contador=0;
        for(Matriz m: matrix){
           
            if(m.isChecked())
                contador++;
            
        }
        return (contador + " matrices Recorridas de " + matrix.length);
            
    }

    @Override
    public void run() {
        this.turingSecuence(txtArea);//To change body of generated methods, choose Tools | Templates.
    }
    
    
}
