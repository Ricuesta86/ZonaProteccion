/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pozo;

import dxf.Point;

/**
 *
 * @author ricuesta
 */
public class Pozo {

    private int id;
//    Ubicación de la fuente 
//      -Siglas del Pozo 
    private String siglaPozo;
//      -Cuenca Hidrogelógia 
    private String cuencaH;
//      -Punto del Pozo 
    private Point uPozo;
//      -Punto de la Reserva 
    private Point uReserva;

    /**
     * Caracteristicas de la Fuente
     */
//    -Caudal[Q] 
    private double Q;
//    -Radio[Rp] 
    private double Rp;
//    -Tiempo de Bombeo[Tb]
    private double Tb;
//    -abatimiento[S]
////    private double S;
//    -nivel estatico
    private double nivelEstatico;

//    -nivel dinamio
    private double nivelDinamico;

//    -Profundidad total
    private double pto;

    /**
     * Caracteristicas del Acuifero
     */
//    -Permeabilidad[KD] 
//    private double KD;
//    -Espesor inicial[Ho]
//    private double Ho;
//    -Gradiente natural[Gn]
    private double Gn;
//    private double H;
//    private double Hp;
//    private double L;
//    -Almacenamiento[E] 
    private double E;
//    -Dirección del flujo[Rbo]
    private double Rbo;

    /**
     * Caracteristicas del Contaminante
     */
//    -Velocidad inducida[VA]
    private double VA;
//    -Tiempo de Vida[Tv o TD]
    private double Tv;

    public Pozo(String siglaPozo, String cuencaH, Point uPozo, Point uReserva, double Q, double Rp, double Tb, double nivelEstatico, double nivelDinamico, double pto, double Gn, double E, double Rbo, double VA, double Tv) {
        this.siglaPozo = siglaPozo;
        this.cuencaH = cuencaH;
        this.uPozo = uPozo;
        this.uReserva = uReserva;
        this.Q = Q;
        this.Rp = Rp;
        this.Tb = Tb;
        this.nivelEstatico = nivelEstatico;
        this.nivelDinamico = nivelDinamico;
        this.pto = pto;
        this.Gn = Gn;
        this.E = E;
        this.Rbo = Rbo;

        this.VA = VA;
        this.Tv = Tv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    

    public String getSiglaPozo() {
        return siglaPozo;
    }

    public void setSiglaPozo(String siglaPozo) {
        this.siglaPozo = siglaPozo;
    }

    public String getCuencaH() {
        return cuencaH;
    }

    public void setCuencaH(String cuencaH) {
        this.cuencaH = cuencaH;
    }

    public Point getuPozo() {
        return uPozo;
    }

    public void setuPozo(Point uPozo) {
        this.uPozo = uPozo;
    }

    public Point getuReserva() {
        return uReserva;
    }

    public void setuReserva(Point uReserva) {
        this.uReserva = uReserva;
    }

    public double getQ() {
        return Q;
    }

    public void setQ(double Q) {
        this.Q = Q;
    }

    public double getRp() {
        return Rp;
    }

    public void setRp(double Rp) {
        this.Rp = Rp;
    }

    public double getTb() {
        return Tb;
    }

    public void setTb(double Tb) {
        this.Tb = Tb;
    }

    public double getNivelEstatico() {
        return nivelEstatico;
    }

    public void setNivelEstatico(double nivelEstatico) {
        this.nivelEstatico = nivelEstatico;
    }

    public double getNivelDinamico() {
        return nivelDinamico;
    }

    public void setNivelDinamico(double nivelDinamico) {
        this.nivelDinamico = nivelDinamico;
    }

    public double getPto() {
        return pto;
    }

    public void setPto(double pto) {
        this.pto = pto;
    }

    public double getGn() {
        return Gn;
    }

    public void setGn(double Gn) {
        this.Gn = Gn;
    }

    public double getE() {
        return E;
    }

    public void setE(double E) {
        this.E = E;
    }

    public double getRbo() {
        return Rbo;
    }

    public void setRbo(double Rbo) {
        this.Rbo = Rbo;
    }

    public double getVA() {
        return VA;
    }

    public double getTv() {
        return Tv;
    }

    public double QM3D() {
        return Q * 86400 / 1000;
    }

    @Override
    public String toString() {
//        Pozo(String siglaPozo, String cuencaH, Point uPozo, Point uReserva, 
//        double Q, double Rp, double Tb, double nivelEstatico, 
//                double nivelDinamico, double pto, double Gn, double E,
//                        double Rbo, double VA, double Tv) {
        return siglaPozo + " " + cuencaH + " " + uPozo.getX() + " " + uPozo.getY() + " "
                + uReserva.getX() + " " + uReserva.getY() + " " + Q + " " + Rp + " " + Tb + " "
                + nivelEstatico + " " + nivelDinamico + " " + pto + " " + Gn + " " + E + " "
                + Rbo + " " + VA + " " + Tv + ""; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Caso A
     */
    /**
     * La distancia de protección sanitaria (DPS). Se calcula multiplica la
     * Velocidad de circulación de las aguas subterráneas en las inmediaciones
     * del pozo (m/s) por Tiempos de supervivencia de la bateria (d).
     *
     * DPS=VA*TD
     *
     */
    public double DPS() {
        System.out.println("DPS " + (VA * Tv));
        return VA * Tv;

    }

    /**
     * La asíntotas o bordes de la region productiva en sentido perpendiculas al
     * flujo (Y). Se calcula dividiendo a Caudal de extracción de la fuente (Q)
     * entre, la multiplicación de dos veces Conductividad hidráulica de Darcy
     * (KD), por Espesor del acuifero(H0), por Gradiente natural del flujo
     * subterráneo (IN).
     */
    public double Y() {
        System.out.println("Y " + (QM3D() / (2 * KD() * Ho() * Gn)));
        return redondear(QM3D() / (2 * KD() * Ho() * Gn));
    }

    /**
     * El punto de estancamiento (X0). Se calcula multiplicando menos 1, por la
     * divición de la Caudal de extracción de la fuente (Q) entre, la
     * multiplicación de dos veces PI por, Conductividad hidráulica de Darcy
     * (KD), por Espesor del acuifero(H0), por Gradiente natural del flujo
     * subterráneo (IN).
     */
    public double Xo() {
        System.out.println("Xo " + (-1 * (QM3D() / (2 * Math.PI * KD() * Ho() * Gn))));
        return redondear(-1 * (QM3D() / (2 * Math.PI * KD() * Ho() * Gn)));
//        return redondear(-1 * (QM3D() / (2 * 3.14 * KD() * Ho() * Gn)));
    }

    /**
     * Caso B
     */
    /**
     * Calculo del radio de influencia.
     *
     */
    public double Ro() {
        System.out.println("Ro " + 1.5 * (Math.sqrt((KD() * Ho() * Tb) / E)));
        return redondear(1.5 * (Math.sqrt((KD() * Ho() * Tb) / E)));
    }

    public double redondear(double valor) {
        valor = valor * 100;
        valor = Math.round(valor);
        return valor / 100;
    }

    /**
     * Cálculo de H. Altura de agua,medida desde el lecho del acuífero o nivel
     * de referncia, hasta el nivel de las aguas subterraneas(m)
     */
    public double H() {
        double cota = 50;
        return cota - nivelEstatico;
    }

    /**
     * Falta el cálculo de la gradiente crítico(I)
     */
    /**
     * Cálculo para allar el valor de r;
     */
    public double r() {
        double valor = Math.pow(H(), 2) - Math.pow(HP(), 2);
        double r = 0;
        for (int i = 1; i < 1000; i++) {
            double valorR = (Math.pow(Ho(), 2) - Math.pow(HP(), 2)) * (Math.log1p(i / Rp) / Math.log1p(Ro() / Rp));
            if (valor == valorR) {
                r = i;
//            }else if(){
//                
            }
        }
        return r;
    }

    public double i() {
        return (H() - HP()) / r();
    }

    /**
     * Cálculo de (dtd) aguas arriba del pozo * DPS= (KD. IN. Tv) / µ
     */
    public double Dtd() {
        if (VA != 0) {
            return DPS();
        }
        System.out.println("DTD " + (KD() * Gn * Tv) / E);
        return redondear((KD() * Gn * Tv) / E);
    }

    /**
     * Cálculo de la velocidad del flujo
     */
    public double calVA(double H, double Hp, double r) {
        return (KD() / E) * ((H - Hp) / r);
    }

//    Calculo del abatimiento  S;
    public double S() {
        System.out.println("S " + (nivelDinamico - nivelEstatico));
        return nivelDinamico - nivelEstatico;
    }

//    Espesor inicial Ho
    public double Ho() {
        System.out.println("Ho " + (pto - nivelEstatico));
        return pto - nivelEstatico;
    }

//    Transmisibilidad Td
    public double Td() {
        System.out.println("Td " + (Q / S() * 100));
        return Q / S() * 100;
    }

//    Permeabilidad KD
    public double KD() {
        System.out.println("KD " + (Td() / Ho()));
        return Td() / Ho();
    }

//    Cálculo de la gradiente hidráulica crítico
//    Diferencia de altura entre el espesor del acuifero (Ho) menos el abatimiento(S)
    public double HP() {
        return Ho() - S();
    }

}
