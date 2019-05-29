/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dxf.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pozo.GPozo;
import pozo.Pozo;

/**
 *
 * @author ricuesta
 */
public class FGPozo extends javax.swing.JFrame {

    private GPozo gpozo;
    private FPrincipal fPrincipal;

    /**
     * Creates new form FGPozo
     */
    public FGPozo() {
        System.out.println("Carga la vista de gestinar pozo.");
        initComponents();
        gpozo = new GPozo();
//        gpozo.cargarListaPozo();
        System.out.println("Carga la tabla.");
        actualizarTabla();
        /**
         * this.addWindowListener(new WindowAdapter() {
         *
         * @Override public void windowClosing(WindowEvent e) {
         * gpozo.salvarListaPozo(); setVisible(false);
         * fPrincipal.setVisible(true); fPrincipal.setEnabled(true); }
         *
         * });
         *
         */

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                gpozo.salvarListaPozo();
                setVisible(false);
                fPrincipal.setVisible(true);
                fPrincipal.setEnabled(true);
            }
        });

    }

    public void setGpozo(GPozo gpozo) {
        this.gpozo = gpozo;
    }

    public GPozo getGpozo() {
        return gpozo;
    }

    public void actualizarTabla() {
        String titulos[] = {"id", "Nombre", "Cuenca", "Norte", "Este", "Q",
            "Prof.", "N. Est.", "N. Din.", "Rp",
            "Tb", "Gn", "E", "Rbo", "Va", "Tv"};

        String información[][] = obtieneMariz(gpozo.listaPozo());

        DefaultTableModel dtm = new DefaultTableModel(información, titulos);
        jTable1.setModel(dtm);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(18);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(18);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(18);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(18);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(25);
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(15).setPreferredWidth(15);
    }

    private String[][] obtieneMariz(List<Pozo> lPozo) {

        String informacion[][] = new String[lPozo.size()][16];

        for (int x = 0; x < lPozo.size(); x++) {

            informacion[x][0] = lPozo.get(x).getId() + "";
            informacion[x][1] = lPozo.get(x).getSiglaPozo() + "";
            informacion[x][2] = lPozo.get(x).getCuencaH() + "";
            informacion[x][3] = lPozo.get(x).getuPozo().getY() + "";
            informacion[x][4] = lPozo.get(x).getuPozo().getX() + "";
            informacion[x][5] = lPozo.get(x).getQ() + "";
            informacion[x][6] = lPozo.get(x).getPto() + "";
            informacion[x][7] = lPozo.get(x).getNivelEstatico() + "";
            informacion[x][8] = lPozo.get(x).getNivelDinamico() + "";
            informacion[x][9] = lPozo.get(x).getRp() + "";
            informacion[x][10] = lPozo.get(x).getTb() + "";
            informacion[x][11] = lPozo.get(x).getGn()+ "";
            informacion[x][12] = lPozo.get(x).getE() + "";
            informacion[x][13] = lPozo.get(x).getRbo() + "";
            informacion[x][14] = lPozo.get(x).getVA()+ "";
            informacion[x][15] = lPozo.get(x).getTv() + "";
        }
        return informacion;
    }

    public void setfPrincipal(FPrincipal fPrincipal) {
        this.fPrincipal = fPrincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Adicionar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de Pozo");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adicionar)
                    .addComponent(Modificar)
                    .addComponent(Eliminar)
                    .addComponent(Cancelar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() >= 0) {
            int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            System.out.println(" Extracion de la " + id);
            Pozo pozo = gpozo.obtenerPozo(id);
            System.out.println("Nombre del pozo: " + pozo.getSiglaPozo());
//            FPozo fp = new FPozo(this, "Modificar", pozo, id);
//            fp.setGpozo(gpozo);
//            fp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione el pozo a modificar.");
        }

    }//GEN-LAST:event_ModificarActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        // TODO add your handling code here:
//        FPozo fp = new FPozo(this, "Adicionar", null, -1);
//        fp.setGpozo(gpozo);
//        fp.setVisible(true);

    }//GEN-LAST:event_AdicionarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        System.out.println("Boton cancelar");
//        gpozo.salvarListaPozo();

        this.setVisible(false);
        fPrincipal.setVisible(true);
        fPrincipal.setEnabled(true);

    }//GEN-LAST:event_CancelarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() >= 0) {
            int num = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar el pozo?");
            if (num == 0) {
                JOptionPane.showMessageDialog(this, "Se elimino el pozo correctamente");
                int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                System.out.println(" Extracion de la " + id);
                Pozo pozo = gpozo.obtenerPozo(id);
                gpozo.eliminarPozo(gpozo.obtenerPozo(id));
                actualizarTabla();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Selecione el pozo a eliminar.");
        }
    }//GEN-LAST:event_EliminarActionPerformed

    /**
     * ñ
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FGPozo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FGPozo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FGPozo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FGPozo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FGPozo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}