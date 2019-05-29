/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dxf;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricuesta
 */
public class Line {
    
    private Point pB;  //punto de comienzo de la Linea
    
    private Point pE; //punto final de la linea. 
    
    private String id; //Identificador de la linea.

    public Line(Point pB, Point pE, String id) {
        this.pB = pB;
        this.pE = pE;
        this.id=id;
    }
    
     public void file(BufferedWriter bw) {
        try {

            bw.newLine();//1
            bw.write("0");

            bw.newLine();//2
            bw.write("LINE");

            bw.newLine();//3
            bw.write("5");

            bw.newLine();//4
            bw.write(id);

            bw.newLine();//5
            bw.write("8");

            bw.newLine();//6
            bw.write("ZONA");

            bw.newLine();//7
            bw.write("10");

            bw.newLine();//8
            bw.write("" + pB.getX());

            bw.newLine();//9
            bw.write("20");

            bw.newLine();//10
            bw.write("" + pB.getY());

            bw.newLine();//11
            bw.write("30");

            bw.newLine();//12
            bw.write("0.0");
            
            
            bw.newLine();//13
            bw.write("11");

            bw.newLine();//14
            bw.write("" + pE.getX());

            bw.newLine();//15
            bw.write("21");

            bw.newLine();//16
            bw.write("" + pE.getY());

            bw.newLine();//17
            bw.write("31");

            bw.newLine();//18
            bw.write("0.0");

        } catch (IOException ex) {
            Logger.getLogger(Point.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
