/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pozo;

import dxf.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import zonaproteccion.Conector;

/**
 *
 * @author ricuesta
 */
public class GPozo {

//    private List<Pozo> lPozo;
    private Conector conector;

    public GPozo() {
//        cargarListaPozo();
        conector=new Conector();
    }


    public boolean adicionarPozo(Pozo pozo) {
        if (!buscarPozo(pozo)) {
            conector.connect();
            try {

                PreparedStatement st = conector.getConnect().prepareStatement(
                        "INSERT INTO pozo (sigla, cuenca, norte, este, r_norte, "
                        + "r_este, gradiente, almacenamiento, direccion, caudal,"
                        + " radio, tiem_bom, n_estatico, n_dinamico,"
                        + " profundida, vel_inducida, tiem_vida) VALUES"
                        + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                st.setString(1, pozo.getSiglaPozo());
                st.setString(2, pozo.getCuencaH());
                st.setDouble(3, pozo.getuPozo().getY());
                st.setDouble(4, pozo.getuPozo().getX());
                st.setDouble(5, pozo.getuReserva().getY());
                st.setDouble(6, pozo.getuReserva().getX());
                st.setDouble(7, pozo.getGn());
                st.setDouble(8, pozo.getE());
                st.setDouble(9, pozo.getRbo());
                st.setDouble(10, pozo.getQ());
                st.setDouble(11, pozo.getRp());
                st.setDouble(12, pozo.getTb());
                st.setDouble(13, pozo.getNivelEstatico());
                st.setDouble(14, pozo.getNivelDinamico());
                st.setDouble(15, pozo.getPto());
                st.setDouble(16, pozo.getVA());
                st.setDouble(17, pozo.getTv());
                st.execute();
                boolean valor = true;
                System.out.println("" + valor);
                st.close();
                conector.close();
                return valor;
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
//            lPozo.add(pozo);
//            System.out.println("Se adicion");
//            for (int i = 0; i < lPozo.size(); i++) {
//                System.out.println(lPozo.get(i).toString());
//
//            }
            return true;

        }
        return false;
    }

    public boolean eliminarPozo(Pozo Pozo) {
        try {
            conector.connect();
            PreparedStatement st = conector.getConnect().prepareStatement("DELETE from pozo where id=?");
            st.setInt(1, Pozo.getId());
            st.execute();
            st.close();
            conector.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(GPozo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean modificarPozo(Pozo pozo,int id) {
       try {
            conector.connect();
            PreparedStatement st = conector.getConnect().prepareStatement(""
                    + "UPDATE pozo set sigla=?, cuenca=?, norte=?, este=?, r_norte=?, "
                        + "r_este=?, gradiente=?, almacenamiento=?, direccion=?, caudal=?,"
                        + " radio=?, tiem_bom=?, n_estatico=?, n_dinamico=?,"
                        + " profundida=?, vel_inducida=?, tiem_vida=? where id=?");
            st.setString(1, pozo.getSiglaPozo());
            st.setString(2, pozo.getCuencaH());
            st.setDouble(3, pozo.getuPozo().getY());
            st.setDouble(4, pozo.getuPozo().getX());
            st.setDouble(5, pozo.getuPozo().getY());
            st.setDouble(6, pozo.getuPozo().getX());
            st.setDouble(7, pozo.getGn());
            st.setDouble(8, pozo.getE());
            st.setDouble(9, pozo.getRbo());
            st.setDouble(10, pozo.getQ());
            st.setDouble(11, pozo.getRp());
            st.setDouble(12, pozo.getTb());
            st.setDouble(13, pozo.getNivelEstatico());
            st.setDouble(14, pozo.getNivelDinamico());
            st.setDouble(15, pozo.getPto());
            st.setDouble(16, pozo.getVA());
            st.setDouble(17, pozo.getTv());
            st.setInt(18, id);
            st.execute();
            boolean valor = true;
            st.close();
            conector.close();
            return valor;
        } catch (SQLException ex) {
            Logger.getLogger(GPozo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Pozo> listaPozo() {
        List<Pozo> lista = new ArrayList<>();
        ResultSet result = null;
        conector.connect();
        try {
            PreparedStatement st = conector.getConnect().prepareStatement("select * from pozo");
            result = st.executeQuery();
            while (result.next()) {
//                , , , , , , , , , , , , , , , , 
                int id = result.getInt("id");
                String sigla = result.getString("sigla");
                String cuenca = result.getString("cuenca");
                double norte = result.getDouble("norte");
                double este = result.getDouble("este");
                double r_norte = result.getDouble("r_norte");
                double r_este = result.getDouble("r_este");
                double gradiente = result.getDouble("gradiente");
                double almacenamiento = result.getDouble("almacenamiento");
                double direccion = result.getDouble("direccion");
                double caudal = result.getDouble("caudal");
                double radio = result.getDouble("radio");
                double tiem_bom = result.getDouble("tiem_bom");
                double n_estatico = result.getDouble("n_estatico");
                double n_dinamico = result.getDouble("n_dinamico");
                double profundida = result.getDouble("profundida");
                double vel_inducida = result.getDouble("vel_inducida");
                double tiem_vida = result.getDouble("tiem_vida");

                Point ubicacion = new Point(este, norte);
                Point reserva = new Point(r_este, r_norte);
                Pozo pozo = new Pozo(sigla, cuenca, ubicacion, reserva, caudal, radio, tiem_bom, n_estatico, n_dinamico, profundida, gradiente, almacenamiento, direccion, vel_inducida, tiem_vida);
                pozo.setId(id);
                lista.add(pozo);
            }

            st.close();
            result.close();
            conector.close();
            return lista;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return lista ;
    }

    
    public boolean buscarPozo(Pozo pozo) {
        ResultSet result = null;
        conector.connect();
        try {
            PreparedStatement st = conector.getConnect().prepareStatement(""
                    + "select * from pozo where sigla=? and cuenca=? and "
                    + "norte=? and este=?");

            st.setString(1, pozo.getSiglaPozo());
            st.setString(2, pozo.getCuencaH());
            st.setDouble(3, pozo.getuPozo().getY());
            st.setDouble(4, pozo.getuPozo().getX());
            result = st.executeQuery();
            boolean valor = result.next();

            st.close();
            result.close();
            conector.close();
            if (valor) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
    
 public Pozo obtenerPozo(int iden){
     Pozo pozo=null;
     ResultSet result = null;
        conector.connect();
        try {
            PreparedStatement st = conector.getConnect().prepareStatement("select * from pozo where id=?");
            st.setInt(1, iden);
            result = st.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String sigla = result.getString("sigla");
                String cuenca = result.getString("cuenca");
                double norte = result.getDouble("norte");
                double este = result.getDouble("este");
                double r_norte = result.getDouble("r_norte");
                double r_este = result.getDouble("r_este");
                double gradiente = result.getDouble("gradiente");
                double almacenamiento = result.getDouble("almacenamiento");
                double direccion = result.getDouble("direccion");
                double caudal = result.getDouble("caudal");
                double radio = result.getDouble("radio");
                double tiem_bom = result.getDouble("tiem_bom");
                double n_estatico = result.getDouble("n_estatico");
                double n_dinamico = result.getDouble("n_dinamico");
                double profundida = result.getDouble("profundida");
                double vel_inducida = result.getDouble("vel_inducida");
                double tiem_vida = result.getDouble("tiem_vida");

                Point ubicacion = new Point(este, norte);
                Point reserva = new Point(r_este, r_norte);
                 pozo = new Pozo(sigla, cuenca, ubicacion, reserva, caudal, radio, tiem_bom, n_estatico, n_dinamico, profundida, gradiente, almacenamiento, direccion, vel_inducida, tiem_vida);
                pozo.setId(id);
            }

            st.close();
            result.close();
            conector.close();
            return pozo;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return pozo ;
 }
}
