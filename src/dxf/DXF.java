/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dxf;

import java.io.*;
import java.util.List;

/**
 *
 * @author ricuesta
 */
public class DXF {
    
    private String nombreFichero;
    
    private String directorio;
    
    private List<Point> listPoint;
    private List<Point> listLinea;

    public DXF(String nombreFichero, String directorio, List<Point> listPoint, List<Point> listLinea) {
        this.nombreFichero = nombreFichero;
        this.directorio = directorio;
        this.listPoint = listPoint;
        this.listLinea = listLinea;
    }


    

    
    public void crearFichero() throws IOException {
        
        //File f = new File("C:\\" + directorio + "\\" + nombreFichero + ".DXF");
        File f = new File("D:\\Usuarios\\Ricuesta\\Escritorio\\VirtualBox\\AutoCad\\zona.DXF");
        //D:\Usuarios\Ricuesta\Escritorio\VirtualBox\AutoCad
        File f2 = new File("C:\\" + directorio);
        
        if (!f2.isDirectory()) {
            
            f2.mkdirs();
            
        }
        
        if ((f.exists())) {
            
            f.createNewFile();
            
        }
        FileWriter fw = new FileWriter(f);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
        Header h = new Header();
        Point p=new Point(702.602, 240.980);
        h.file(bw,p);        
        
        Table t =new Table();
        
        t.file(bw);
        
        Block b =new Block();
        
        b.file(bw);
        
        Entities e=new Entities(listPoint,listLinea);
        
        e.file(bw);
        
        bw.close();
        
        fw.close();
        
    }
    public void crearFichero(File f) throws IOException {
        
        
        FileWriter fw = new FileWriter(f+".dxf");
        
        BufferedWriter bw = new BufferedWriter(fw);
        
        Header h = new Header();
        Point p=new Point(702.602, 240.980);
        h.file(bw,p);        
        
        Table t =new Table();
        
        t.file(bw);
        
        Block b =new Block();
        
        b.file(bw);
        
        Entities e=new Entities(listPoint,listLinea);
        
        e.file(bw);
        
        bw.close();
        
        fw.close();
        
    }
    
}
