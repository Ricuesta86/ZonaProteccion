/*
 * To change this license header, choose License Headers in Project Properties.
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
public class Block {

    public Block() {
    }

    public void file(BufferedWriter bw) {
        
        String url = System.getProperty("user.dir") + "\\file\\block.txt";

        File file = new File(url);
        
//        File file = new File("C:\\ZonaProteccion\\block.txt");

        FileInputStream is = null;

        InputStreamReader isr = null;

        BufferedReader br = null;

        try {

            is = new FileInputStream(file);

            isr = new InputStreamReader(is);

            br = new BufferedReader(isr);

            String s = br.readLine();

            do {

                bw.newLine();

                bw.write(s);

            } while ((s = br.readLine()) != null);

        } catch (IOException ex) {

            System.out.println("Error durante el proceso de copia");
        }
    }

}
