/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jasper;



import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;





/*Importando */


/**
 * @author yasel
 */
/*La finalidad del hilo, 
 fue para liberar de carga al evento de un botón
 dado que la obtención
 de la conexión y el llenado del reporte puede
 ser tardado. El hilo debe lanzarse de la siguiente
 manera:*/

public class DataManagerReport {

     private DataManagerReportCommon ds ;
     private InputStream templateStream;
     private JasperReport report;
     private JasperPrint  print;
     private String filename;
     private Map map;
     //private BaseQueryProvider datasource;
     private List datasource;
    
   
     private String namefile;
     private boolean SO;

   

   

    public void initReport(List datasource, Map entries, String templateName){
        try {
            this.datasource = datasource;
            this.map = entries;
            this.filename = templateName;
            
            ds = new DataManagerReportCommon(this.datasource);
            templateStream = this.getClass().getResourceAsStream("/template/" + filename);
          
            report = JasperCompileManager.compileReport(templateStream);
            print = JasperFillManager.fillReport(report, map, ds);

        } catch (JRException ex) {
            Logger.getLogger(DataManagerReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    /*Hay q pasarle el contenedor, para no atar la logica y crear Hard Coded
     Leo ponlo bonito, para convertir el preview en un wizard para reportes
     */
    public void preview(){
        
          /*yovanott, esto cambiarlo por un JInternalframe*/
        
           JFrame fr = new JFrame("Vista previa del reporte");
           fr.setSize(800,600);
           fr.setLocationRelativeTo(null);
           
    // Mostrar el reporte
            JRViewer jrv = new JRViewer(print);
            jrv.revalidate();
            fr.add(jrv);
            fr.setVisible(true);
    
    }

   
        

    public JasperPrint getPrint() {
        return print;
    }

    public void setPrint(JasperPrint print) {
        this.print = print;
    }

    public JasperReport getReport() {
        return report;
    }

    public void setReport(JasperReport report) {
        this.report = report;
    }

    public InputStream getTemplateStream() {
        return templateStream;
    }

    public void setTemplateStream(InputStream templateStream) {
        this.templateStream = templateStream;
    }
     public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setDatasource(List datasource) {
        this.datasource = datasource;
    }
}
