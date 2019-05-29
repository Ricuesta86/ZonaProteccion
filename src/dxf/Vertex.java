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
public class Vertex {

    private Point p;
    private String id;

    public Vertex(Point p,String id) {
        this.p = p;
        this.id=id;
    }

    public void file(BufferedWriter bw) {
        try {

            bw.newLine();//1
            bw.write("0");

            bw.newLine();//2
            bw.write("VERTEX");

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
            bw.write("" + p.getX());

            bw.newLine();//9
            bw.write("20");

            bw.newLine();//10
            bw.write("" + p.getY());

            bw.newLine();//11
            bw.write("30");

            bw.newLine();//12
            bw.write("0.0");

        } catch (IOException ex) {
            Logger.getLogger(Point.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
