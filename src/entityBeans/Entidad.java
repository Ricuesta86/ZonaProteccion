/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

/**
 *
 * @author yasel
 */
public class Entidad {

    private String municipio;
    private String equipo;
    private String fecha;

    public String getEquipo() {
        return equipo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMunicipio() {
        return municipio;
    }

    public Entidad(String municipio, String equipo, String fecha) {
        this.municipio = municipio;
        this.equipo = equipo;
        this.fecha = fecha;
    }

    public Entidad() {
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

 
}
