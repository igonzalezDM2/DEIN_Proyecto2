package informes;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Alert;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Creador {
	public static void crearInforme(String ruta, Map<String, Object> parameters) {
	    try {
	    	InputStream jasper = Creador.class
	    		    .getResourceAsStream(ruta);
	    	
	    	
	        
	        Class.forName("org.mariadb.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/libros", "root", "root");
	        
			try {
				JasperReport report = (JasperReport) JRLoader.loadObject(jasper);
		        JasperPrint jprint = JasperFillManager.fillReport(report, parameters, con);
		        JasperViewer viewer = new JasperViewer(jprint, false);
		        viewer.setVisible(true);
			} catch (Exception e) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setTitle("ERROR");
	            alert.setContentText("Ha ocurrido un error");
	            alert.showAndWait();
	            e.printStackTrace();
	        }
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}