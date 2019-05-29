/*
 * To change this license Header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dxf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ricuesta
 */
public class Header {

    public Header() {
    }

    public void file(BufferedWriter bw, Point p1) {

//        File file = new File("C:\\ZonaProteccion\\header.txt");
        
        String url = System.getProperty("user.dir") + "\\file\\header.txt";

        File file = new File(url);
        FileInputStream is = null;

        InputStreamReader isr = null;

        BufferedReader br = null;

        try {

            is = new FileInputStream(file);

            isr = new InputStreamReader(is);

            br = new BufferedReader(isr);

            String s = br.readLine();

            bw.write(s);

            s = br.readLine();

            do {

                bw.newLine();
                if (s.equals("$EXTMIN")) {
                    bw.write("$EXTMIN");
                    bw.newLine();
                    bw.write("10");

                    bw.newLine();//2
                    bw.write("" + (p1.getX() - 20));

                    bw.newLine();//3
                    bw.write("20");

                    bw.newLine();//4
                    bw.write("" + (p1.getY() - 20));

                    bw.newLine();

                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();

                }
                if (s.equals("$EXTMAX")) {
                    bw.write("$EXTMAX");
                    bw.newLine();
                    bw.write("10");

                    bw.newLine();//2
                    bw.write("" + (p1.getX() + 20));

                    bw.newLine();//3
                    bw.write("20");

                    bw.newLine();//4
                    bw.write("" + (p1.getY() + 20));

                    bw.newLine();

                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                }
                if (s.equals("$LIMMIN")) {
                    bw.write("$LIMMIN");
                    bw.newLine();
                    bw.write("10");

                    bw.newLine();//2
                    bw.write("" + (p1.getX() - 20));

                    bw.newLine();//3
                    bw.write("20");

                    bw.newLine();//4
                    bw.write("" + (p1.getY() - 20));

                    bw.newLine();

                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                }
                if (s.equals("$LIMMAX")) {
                    bw.write("$EXTMAX");
                    bw.newLine();
                    bw.write("10");

                    bw.newLine();//2
                    bw.write("" + (p1.getX() + 20));

                    bw.newLine();//3
                    bw.write("20");

                    bw.newLine();//4
                    bw.write("" + (p1.getY() + 20));

                    bw.newLine();

                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                    s = br.readLine();
                }

                bw.write(s);

            } while ((s = br.readLine()) != null);

        } catch (IOException ex) {

            System.out.println("Error durante el proceso de copia");
        }
    }

}
