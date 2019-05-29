/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pozo;

import dxf.Point;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import jxl.*;
import jxl.write.*;
import jxl.write.Boolean;
import jxl.write.Number;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import jxl.write.biff.RowsExceededException;

/**
 *
 * @author ricuesta
 */
public class Excel {
//
    private List<Point> listPoint;
    private List<Point> listLinea;

    public Excel(List<Point> listPoint, List<Point> listLinea) {
        this.listPoint = listPoint;
        this.listLinea = listLinea;
    }

    public void crearFichero(File f) {
        try {
           System.out.println( f.getPath());
           File excel=new File(f.getPath()+".xls");
            
           WritableWorkbook writableWorkbook = Workbook
                    .createWorkbook(excel);

            WritableSheet writableSheet = writableWorkbook.createSheet(
                    "Sheet1", 0);

            //Create Cells with contents of different data types.
            //Also specify the Cell coordinates in the constructor
            
            int id=0;
            Iterator<Point> iterador=listPoint.iterator();
            while (iterador.hasNext()) {
                Point point = iterador.next();
                Number numX = new Number(0,id, point.getX());
                Number numY = new Number(1,id, point.getY());
                writableSheet.addCell(numX);
                writableSheet.addCell(numY);
                id++;
            }
            iterador=listLinea.iterator();
            while (iterador.hasNext()) {
                Point point = iterador.next();
                Number numX = new Number(0,id, point.getX());
                Number numY = new Number(1,id, point.getY());
                writableSheet.addCell(numX);
                writableSheet.addCell(numY);
                id++;
            }
            
            
            
            //Add the created Cells to the sheet
            

            //Write and close the workbook
            writableWorkbook.write();
            writableWorkbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }

    }
}
