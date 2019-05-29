/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zonaproteccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricuesta
 */
public class Conector {
    
    String url = System.getProperty("user.dir") + "\\db\\pozo.db";
    private Connection connect;

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public Connection getConnect() {
        return connect;
    }
    

    public void connect() {
        try {
//            System.out.println(""+url);
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
//            System.out.println(""+url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            System.out.println("Desconectado");
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
    public void adicionarCliente(Cliente cliente) {
        try {
            PreparedStatement st = connect.prepareStatement("INSERT INTO Cliente"
                    + " (nombre, apellido_1, apellido_2, ruta, calle, avenida,"
                    + " numero, apto, consejo, municipio, provincia)"
                    + " 	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");

            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getApellido1());
            st.setString(3, cliente.getApellido2());
            st.setString(4, cliente.getRuta());
            st.setString(5, cliente.getCalle());
            st.setString(6, cliente.getAvenida());
            st.setString(7, cliente.getNumero());
            st.setString(8, cliente.getApto());
            st.setString(9, cliente.getConsejoPopular());
            st.setString(10, cliente.getMunicipio());
            st.setString(11, cliente.getProvincia());

            st.execute();            
            st.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

     public void mostrarClientes(){
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from Cliente");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));
 
                System.out.print("Nombre: ");
                System.out.println(result.getString("nombre"));
 
                System.out.print("Apellidos: ");
                System.out.println(result.getString("apellido_1"));
 
                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

*/
}
