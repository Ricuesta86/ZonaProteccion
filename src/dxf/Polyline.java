/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dxf;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricuesta
 */
public class Polyline {

    private List<Point> listPoint;
    
    public Polyline() {
        
        listPoint=new LinkedList<Point>();
        
    }

    public void setListPoint(List<Point> listPoint) {
        
        this.listPoint = listPoint;
        
    }
    
    

    public void file(BufferedWriter bw) {
        try {

            bw.newLine();//1
            bw.write("0");

            bw.newLine();//2
            bw.write("POLYLINE");

            bw.newLine();//3
            bw.write("5");

            bw.newLine();//4
            bw.write("145");

            bw.newLine();//5
            bw.write("8");

            bw.newLine();//6
            bw.write("ZONA");

            bw.newLine();//7
            bw.write("66");

            bw.newLine();//8
            bw.write("1");

            bw.newLine();//9
            bw.write("10");

            bw.newLine();//10
            bw.write("0.0");

            bw.newLine();//11
            bw.write("20");

            bw.newLine();//12
            bw.write("0.0");

            bw.newLine();//13
            bw.write("30");

            bw.newLine();//14
            bw.write("0.0");
            
            float x=1.00f;
            float y=1.00f;
            
            String idVertex[]= {
                "19B", //0
                "19C", //1
                "19D", //2
                "19E", //3
                "19F", //4
                "1A0", //5
                "1A1", //6
                "1A2", //7
                "1A3", //8
                "1A4", //9
                "1A5", //10
                "1A6", //11
                "1A7", //12
                "1A8", //13
                "1A9", //14
                "1AA"  //15
            };
            
            for (int i = 0; i < listPoint.size()-1; i++) {
                
                Vertex v1 = new Vertex(listPoint.get(i),idVertex[i]);

                v1.file(bw);
                
//                x+=0.5f;
//                y+=0.5f;
                                

            }
            
 
            bw.newLine();//15
            bw.write("0");

            bw.newLine();//16
            bw.write("SEQEND");
            
            bw.newLine();//15
            bw.write("5");

            bw.newLine();//16
            bw.write("1A9");
            
            bw.newLine();//15
            bw.write("8");

            bw.newLine();//16
            bw.write("ZONA");

            
        } catch (IOException ex) {
            Logger.getLogger(Point.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
