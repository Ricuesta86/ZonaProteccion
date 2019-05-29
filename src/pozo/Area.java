/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pozo;

import calculo.CalPoint;
import dxf.Point;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ricuesta
 */
public class Area {
    
    private double Xo;
    
    private double Yo;    
    
    private double Dtd;
    
    private double angulo;

    public Area(double Xo, double Yo, double Dtd, double angulo) {
        this.Xo = Xo;
        this.Yo = Yo;
        this.Dtd = Dtd;
        this.angulo = angulo;
    }
    public double redondear(double valor) {
        valor = valor * 10;
        valor = Math.round(valor);
        return valor / 10;
    }
    public List<Point> zonaI(){

        Point p1= new Point(7.5, 7.5);
        Point p2= new Point(7.5, -7.5);
        Point p3= new Point(-7.5, -7.5);
        Point p4= new Point(-7.5, 7.5); 
        
        DecimalFormat df = new DecimalFormat("#.###");
        Point p1p= new Point(redondear(p1.getX() * Math.cos(angulo)+ p1.getY() * Math.sin(angulo)),redondear(-p1.getX() * Math.sin(angulo)+ p1.getY() * Math.cos(angulo)));
        Point p2p= new Point(redondear(p2.getX() * Math.cos(angulo)+ p2.getY() * Math.sin(angulo)),redondear(-p2.getX() * Math.sin(angulo)+ p2.getY() * Math.cos(angulo)));
        Point p3p= new Point(redondear(p3.getX() * Math.cos(angulo)+ p3.getY() * Math.sin(angulo)),redondear(-p3.getX() * Math.sin(angulo)+ p3.getY() * Math.cos(angulo)));
        Point p4p= new Point(redondear(p4.getX() * Math.cos(angulo)+ p4.getY() * Math.sin(angulo)),redondear(-p4.getX() * Math.sin(angulo)+ p4.getY() * Math.cos(angulo)));
        
        
        List <Point> zona=new LinkedList<Point>();
        zona.add(p1p);
        zona.add(p2p);
        zona.add(p3p);
        zona.add(p4p);
        return zona;
    }
    
    public List<Point>zonaII(){
        List <Point> zona=new LinkedList<Point>();
        CalPoint cP=new CalPoint();
        zona.add(cP.point1(Dtd, Yo,angulo));
        zona.add(cP.point2(Yo,angulo));
        zona.add(cP.point3(Yo,angulo));
        zona.add(cP.point4(Yo,angulo));
        zona.add(cP.point5(Yo,angulo));
        zona.add(cP.point6(Xo,angulo));
        zona.add(cP.point7(Xo,angulo));        
        zona.add(cP.point8(Xo,angulo));        
        zona.add(cP.point9(Yo,angulo));        
        zona.add(cP.point10(Yo,angulo));        
        zona.add(cP.point11(Yo,angulo));        
        zona.add(cP.point12(Yo,angulo));        
        zona.add(cP.point13(Dtd, Yo,angulo));        
        zona.add(cP.point1(Dtd, Yo,angulo));        
        zona.add(new Point(0, 0));        
        return zona;
    }
    public List<Point> zonaIConv(List <Point> lista,Point pozo){
        
        List <Point> zona=new LinkedList<Point>();
        CalPoint cP=new CalPoint();
        for (int i = 0; i < lista.size(); i++) {
            Point elem = cP.ubicarPoint(pozo, lista.get(i));
            zona.add(elem);
        }
        return zona;
    }
    
    public List<Point>zonaIIConv(List <Point> lista,Point pozo){
        List <Point> zona=new LinkedList<Point>();
        CalPoint cP=new CalPoint();
        for (int i = 0; i < lista.size(); i++) {
            Point elem = cP.ubicarPoint(pozo, lista.get(i));
            zona.add(elem);
        }   
        return zona;
    }
    
}
