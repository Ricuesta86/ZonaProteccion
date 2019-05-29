/*
 * Esta clase es básicamente un proxy entre JasperReports y
 las funciones de hibernación objeto de origen de datos. El único
 poco complicado es el manejo nombre del campo. Por alguna razón,
 JasperReports no acepta nombres de campo que contiene los
 puntos (por ejemplo, "product.code"). Sin embargo, al recuperar
 un conjunto de Hibernate-persistió objetos de negocio, a menudo
 se necesita tener acceso a atributos de los objetos. Para evitar
 esto, se sustituya "." por un "_" en la JasperReport plantilla
 (por ejemplo, "códigoDeProducto" en lugar de "product.code"),
 y volver a convertir a un formato convencional en el
 JavaBean getFieldName () método.
 */

package jasper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author yasel
 */
public class DataManagerReportCommon extends JRAbstractBeanDataSource{

    //private IReportDataSource dataSource;
    private List dataSource;
    protected int index = 0;
    protected Object bean;
    private static Map fieldNameMap = new HashMap();



    public DataManagerReportCommon(List dataSource) {
        super(true);
        this.dataSource = dataSource;
        index = 0;
    }

    public void moveFirst() throws JRException {
         index = 0;
         bean = null;
         if (dataSource != null)
            bean = dataSource.get(index);
    }

    public boolean next() throws JRException {
        bean = null;
        if ((dataSource != null) && (dataSource.size() > index))
              bean = dataSource.get(index++);
         return (bean != null);
    }

    public Object getFieldValue(JRField field)  {

        String nameField = null;
        Object retval = null;

        try {
            nameField = getFieldName(field.getName());
            retval = PropertyUtils.getProperty(bean, nameField);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DataManagerReportCommon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DataManagerReportCommon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(DataManagerReportCommon.class.getName()).log(Level.SEVERE, null, ex);
        }

         return retval;
    }

    private String getFieldName(String fieldName) {
         String filteredFieldName
                = (String) fieldNameMap.get(fieldName);
         if (filteredFieldName == null) {
               filteredFieldName = fieldName.replace('_','.');
               fieldNameMap.put(fieldName,filteredFieldName);
         }
           return filteredFieldName;
       }
}
