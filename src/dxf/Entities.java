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
public class Entities {

    private List<Point> listPoint;
    private List<Point> listLinea;

    public Entities(List<Point> listPoint, List<Point> listLinea) {
        this.listPoint = listPoint;
        this.listLinea = listLinea;
    }

    public void file(BufferedWriter bw) {

        try {

            bw.newLine();//1
            bw.write("0");

            bw.newLine();//2
            bw.write("SECTION");

            bw.newLine();//3
            bw.write("2");

            bw.newLine();//4
            bw.write("ENTITIES");

            float x = 1.00f;
            float y = 1.00f;

            String idPoint[] = {
                "93", //0
                "B1", //1
                "B2", //2
                "B3", //3
                "B4", //4
                "B5", //5
                "B6", //6
                "B7", //7
                "B8", //8
                "B9", //9
                "BA", //10
                "BB", //11
                "BC", //12
                "BD", //13
                "BE", //14
                "BF", //15
            };
            /**
             * for (int i = 0; i < 13; i++) {
             *
             * pointD p1 = new pointD(new point(x, y), idPoint[i]);
             *
             * p1.file(bw);
             *
             * x += 1f;
             *
             * y += 1f;
             *
             * }
             */
            /**
             * for (int i = 0; i < listPoint.size(); i++) {
             *
             *
             *
             * }
             */
//            pointD p1 = new pointD(listPoint.get(listPoint.size() - 1), idPoint[listPoint.size() - 1]);
//
//            p1.file(bw);

            Polyline po = new Polyline();

            po.setListPoint(listPoint);

            po.file(bw);


            Line l = new Line(listLinea.get(0), listLinea.get(1), "191");
            Line l1 = new Line(listLinea.get(1), listLinea.get(2), "192");
            Line l2 = new Line(listLinea.get(2), listLinea.get(3), "193");
            Line l3 = new Line(listLinea.get(3), listLinea.get(0), "194");

            l.file(bw);
            l1.file(bw);
            l2.file(bw);
            l3.file(bw);

            bw.newLine();//5
            bw.write("0");

            bw.newLine();//6
            bw.write("ENDSEC");

            bw.newLine();//7
            bw.write("0");

            bw.newLine();//8
            bw.write("EOF");

        } catch (IOException ex) {
            Logger.getLogger(Entities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
