/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import pozo.Pozo;
import view.FPrincipal;

/**
 *
 * @author ricuesta
 */
public class Controladora {
    
    

    public Controladora() {
       
                
    }
    
    public List<Double>  calcularPozo(Pozo p){
        List<Double> calc=new LinkedList<Double>();
        calc.add(p.Ho());
        calc.add(p.KD());
        calc.add(p.S());
        calc.add(p.Td());
        p.DPS();
        return calc;
    }
    
}
