/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zonaproteccion;

import control.Controladora;
import dxf.DXF;
import dxf.Point;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import pozo.Area;
import view.FPrincipal;
import view.FPozo;

/**
 *
 * @author ricuesta
 */
public class ZonaProteccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
//        Se cagar la ventana donde se entruducen los datos de los pozos.
        
        FPozo fpozo=new FPozo();
        fpozo.setVisible(true);
        
        
        
        
        
        
        

//        Convercion de el ángulo a radian
        double angulo = 240 * Math.PI / 180 *-1;
//        calculo de area en metros
//        Multiplicar los valores de Xo, Yo, DPS por menos uno.
//        Area a = new Area(-95.50, 300.01, 1000.08, angulo);
        Area a = new Area(-95.50*1.3, 300.01*1.3, 1000.08, angulo);
//        lista de punto que forman el zona de protección I  
        List<Point> listLinea = a.zonaI();
//        lista de punto que forman el zona de protección II
        List<Point> listPoint = a.zonaII();

        Point pozo = new Point(283.337,515.831);
//        lista de punto que forman el zona de protección I  
        List<Point> listLineaC = a.zonaIConv(listLinea, pozo);
//        lista de punto que forman el zona de protección II
        List<Point> listPointC = a.zonaIIConv(listPoint, pozo);
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat df1 = new DecimalFormat("#.###");
//        int i = 0;
//        while (i < 14) {
//            System.out.println("punto # "+i);
//            System.out.println(""+df.format(listPoint.get(i).getX()));
//            System.out.println(""+df.format(listPoint.get(i).getY()));
//            i++;
//        }
        int i = 0;
        while (i < 14) {
            System.out.println("punto # "+i);
            System.out.println(""+df1.format(listPointC.get(i).getX()));
            System.out.println(""+df1.format(listPointC.get(i).getY()));
            i++;
        }

//        clase que crea los DXF a exportar
//        DXF dx=new DXF("carre", "DXF",listPoint,listLinea);
//        DXF dx=new DXF("carre", "DXF",listPointC,listLineaC);
//        dx.crearFichero();
        //System.out.println(""+Math.pow(3, 2));
//        
//        FPozo f=new FPozo();
//        f.setVisible(true);
//        System.out.println("Abre el sistema.");
//        FPrincipal fPrincipal=new FPrincipal();
//        fPrincipal.setVisible(true);
//        System.out.println(System.getProperty("user.dir"));
    }
}
