/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dxf.DXF;
import dxf.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pozo.Area;
import pozo.Excel;
import pozo.GPozo;
import pozo.Pozo;

/**
 *
 * @author ricuesta
 */
public class FGCalculo extends javax.swing.JFrame {

    private Pozo pozo;
    private Area area;
    private DXF dxf;
    private FPrincipal fPrincipal;
    private double error;
    private double factor;
    private GPozo gpozo;

    /**
     * Creates new form FGCalculo
     */
    public FGCalculo() {
        initComponents();
        gpozo = new GPozo();
        fPrincipal = new FPrincipal();
        actualizarTabla();

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

    public void setfPrincipal(FPrincipal fPrincipal) {
        this.fPrincipal = fPrincipal;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setDxf(DXF dxf) {
        this.dxf = dxf;
    }

    public void setError(double error) {
        this.error = error;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public Pozo getPozo() {
        return pozo;
    }

    public Area getArea() {
        return area;
    }

    public DXF getDxf() {
        return dxf;
    }

    public FPrincipal getfPrincipal() {
        return fPrincipal;
    }

    public double getError() {
        return error;
    }

    public double getFactor() {
        return factor;
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
            informacion[x][11] = lPozo.get(x).getGn() + "";
            informacion[x][12] = lPozo.get(x).getE() + "";
            informacion[x][13] = lPozo.get(x).getRbo() + "";
            informacion[x][14] = lPozo.get(x).getVA() + "";
            informacion[x][15] = lPozo.get(x).getTv() + "";
        }
        return informacion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Imprimir = new javax.swing.JButton();
        Exportar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Radio de Protección");
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

        Imprimir.setText("Imprimir");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        Exportar.setText("Exportar DXF");
        Exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Exportar a Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Imprimir)
                        .addGap(18, 18, 18)
                        .addComponent(Exportar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Imprimir)
                    .addComponent(Exportar)
                    .addComponent(Cancelar)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
        // TODO add your handling code here:

        if (jTable1.getSelectedRow() >= 0) {
            int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            Pozo pozo = gpozo.obtenerPozo(id);
            FCalculo fCalculo = new FCalculo(pozo, factor, error);
            fCalculo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione un pozo");
        }
    }//GEN-LAST:event_ImprimirActionPerformed

    private void ExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() >= 0) {
            int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            Pozo pozo = gpozo.obtenerPozo(id);
            String nombre = "";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            File guarda = file.getSelectedFile();

            if (guarda != null) {
                /*guardamos el archivo y le damos el formato directamente,
                 * si queremos que se guarde en formato doc lo definimos como .doc*/
                double angulo = pozo.getRbo() * Math.PI / 180 * -1;
//                area = new Area(44.95, -141.20, -249.10, angulo);
                area = new Area(pozo.Xo() * factor * -1, pozo.Y() * factor * -1, pozo.Dtd() * -1, angulo);
                //        lista de punto que forman el zona de protección I  
                List<Point> listLinea = area.zonaI();
//        lista de punto que forman el zona de protección II
                List<Point> listPoint = area.zonaII();
//                Point pozo = new Point(702.620, 240.980);
//        lista de punto que forman el zona de protección I  
                List<Point> listLineaC = area.zonaIConv(listLinea, pozo.getuPozo());
//        lista de punto que forman el zona de protección II
                List<Point> listPointC = area.zonaIIConv(listPoint, pozo.getuPozo());
                dxf = new DXF("hola", "hola", listPointC, listLineaC);
                try {
                    dxf.crearFichero(guarda);
                } catch (IOException ex) {
                    Logger.getLogger(FPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                //                FileWriter save = new FileWriter(guarda + ".txt");
                //                save.write("Hola mundo");
                //                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione un pozo");
        }

    }//GEN-LAST:event_ExportarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        fPrincipal.setEnabled(true);
        this.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() >= 0) {
            int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            Pozo pozo = gpozo.obtenerPozo(id);
            String nombre = "";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            File guarda = file.getSelectedFile();

            if (guarda != null) {
                /*guardamos el archivo y le damos el formato directamente,
                 * si queremos que se guarde en formato doc lo definimos como .doc*/
                double angulo = pozo.getRbo() * Math.PI / 180 * -1;
//                area = new Area(44.95, -141.20, -249.10, angulo);
                area = new Area(pozo.Xo() * factor * -1, pozo.Y() * factor * -1, pozo.Dtd() * factor * -1, angulo);
                //        lista de punto que forman el zona de protección I  
                List<Point> listLinea = area.zonaI();
//        lista de punto que forman el zona de protección II
                List<Point> listPoint = area.zonaII();
//                Point pozo = new Point(702.620, 240.980);
//        lista de punto que forman el zona de protección I  
                List<Point> listLineaC = area.zonaIConv(listLinea, pozo.getuPozo());
//        lista de punto que forman el zona de protección II
                List<Point> listPointC = area.zonaIIConv(listPoint, pozo.getuPozo());
//                dxf = new DXF("hola", "hola", listPointC, listLineaC);
                Excel excel = new Excel(listPointC, listLineaC);
                excel.crearFichero(guarda);
                //                FileWriter save = new FileWriter(guarda + ".txt");
                //                save.write("Hola mundo");
                //                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione un pozo");
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    public void Imprimir(Pozo pozo) {

//        DataManagerReport dataManagerReport = new DataManagerReport();
//        Map parameters = new HashMap();
//
//        String templateName = "cr-09.jrxml";
//        dataManagerReport.initReport(parameters, templateName);
//
//        //this.report.printreport("pdf");
//        dataManagerReport.preview();
    }

    /**
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
            java.util.logging.Logger.getLogger(FGCalculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FGCalculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FGCalculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FGCalculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FGCalculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Exportar;
    private javax.swing.JButton Imprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
