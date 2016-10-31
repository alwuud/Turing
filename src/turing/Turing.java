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
public class Turing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Analizador analizer = new Analizador("/home/alwud/Desktop/MATRIZ.txt");

        
         if (analizer.build()) {
                analizer.turingSecuence();
            }
        try {
           
        } catch (Exception e) {
            System.out.println("Carajooooooooo!!");
        }

    }

}
