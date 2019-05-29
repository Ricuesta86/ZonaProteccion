/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dxf;

/**
 *
 * @author ricuesta
 */
public class Point {
    
    private double x;
    private double y;
    //private String id;

    public Point(double x, double y/**, String id*/) {
        this.x = x;
        this.y = y;
        //this.id = id;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
/**
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    */

    
    
}
