/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculo;

import dxf.Point;

/**
 *
 * @author ricuesta
 */
public class CalPoint {

    public CalPoint() {
    }

    public double redondear(double valor) {
        valor = valor * 100;
        valor = Math.round(valor);
        return valor / 100;
    }

    public Point point1(double dtd, double Yo, double angulo) {
        double x = dtd;
        double y = Yo;

        return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));

    }

    public Point point2(double Yo, double angulo) {
        double x = Yo * 0.75;
        double y = Yo * 0.75;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point3(double Yo, double angulo) {
        double x = Yo * 0.6439 / 2;
        double y = Yo * 0.6439;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point4(double Yo, double angulo) {

        double x = 0;
        double y = Yo / 2;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo),-x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);

    }

    public Point point5(double Yo, double angulo) {
        double x = -1 * Yo / 4;
        double y = Yo / 4;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo),-x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point6(double Xo, double angulo) {
        double x = Xo * 0.926;
        double y = -1 * Xo * 0.926 / 2;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);

    }

    public Point point7(double Xo, double angulo) {
        double x = Xo;
        double y = 0;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point8(double Xo, double angulo) {
        double x = Xo * 0.926;
        double y = Xo * 0.926 / 2;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point9(double Yo, double angulo) {
        double x = -1 * Yo / 4;
        double y = -1 * Yo / 4;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point10(double Yo, double angulo) {
        double x = 0;
        double y = -1 * Yo / 2;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point11(double Yo, double angulo) {
        double x = Yo * 0.6439 / 2;
        double y = -1 * Yo * 0.6439;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point12(double Yo, double angulo) {
        double x = Yo * 0.75;
        double y = -1 * Yo * 0.75;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point point13(double dtd, double Yo, double angulo) {
        double x = dtd;
        double y = -1 * Yo;
        if (angulo != 0) {
            return new Point(x * Math.cos(angulo) + y * Math.sin(angulo), -x * Math.sin(angulo) + y * Math.cos(angulo));
        }
        return new Point(x, y);
    }

    public Point ubicarPoint(Point pozo, Point point) {
//        Convirtiendo de metros a km los puntos 
        double x = point.getX() / 1000;
        double y = point.getY() / 1000;
        return new Point(pozo.getX() + x, pozo.getY() + y);
    }

}
