package controller;

import java.sql.SQLException;

import dao.DAOAlumno;
import excepciones.BibliotecaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Alumno;
import utils.StringUtils;
import utils.Utilidades;

public class EditarAlumnoController {

	Alumno alumno = null;
	
	BibliotecaController contexto;
	
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Label lblDni;

    @FXML
    private TextField tfApellido1;

    @FXML
    private TextField tfApellido2;

    @FXML
    private TextField tfDni;

    @FXML
    private TextField tfNombre;

    @FXML
    void cancelar(ActionEvent event) {
    	Utilidades.cerrarVentanaDesdeEvento(event);
    }

    @FXML
    void confirmar(ActionEvent event) {
    	try {
    		String errores = validarAlumno();
        	if (StringUtils.isBlank(errores)) {
        		if (alumno == null) {
        			alumno = construirAlumno();
        			
        			if (DAOAlumno.existe(alumno)) {
        				Utilidades.lanzarError(new BibliotecaException("El alumno con ese DNI ya existe"));
        			} else {        				
        				DAOAlumno.anadirAlumno(alumno);
        				cancelar(event);
        			}
        			
        		} else {
        			DAOAlumno.modificarAlumno(alumno);
        			cancelar(event);
        		}
        			
        		if (contexto != null) {    		
        			contexto.buscarAlumno(event);
        		}
        		if (contexto != null) {
        			contexto.buscarAlumno(event);
        		}
        	} else {
        		Utilidades.lanzarError(new BibliotecaException(errores));
        	}
    	} catch (BibliotecaException | SQLException e) {
    		Utilidades.lanzarError(e);
    	}
    }
    
    private String validarAlumno() {
    	StringBuilder sbErrores = new StringBuilder();
    	sbErrores.append(Utilidades.checkCampoStrNotNullStr(tfDni) + "\n");
    	sbErrores.append(Utilidades.checkCampoStrNotNullStr(tfNombre) + "\n");
    	sbErrores.append(Utilidades.checkCampoStrNotNullStr(tfApellido1) + "\n");
    	sbErrores.append(Utilidades.checkCampoStrNotNullStr(tfApellido2) + "\n");
    	
    	return StringUtils.trimToEmpty(sbErrores.toString());
    }
    
    private Alumno construirAlumno() {
    	return new Alumno()
    			.setDni(StringUtils.trimToEmpty(tfDni.getText()))
    			.setNombre(StringUtils.trimToEmpty(tfNombre.getText()))
    			.setApellido1(StringUtils.trimToEmpty(tfApellido1.getText()))
    			.setApellido2(StringUtils.trimToEmpty(tfApellido2.getText()));
    }
    private void rellenarAlumno() {
    	if (alumno != null) {    		
    		tfDni.setText(alumno.getDni());
    		tfNombre.setText(alumno.getNombre());
    		tfApellido1.setText(alumno.getApellido1());
    		tfApellido2.setText(alumno.getApellido2());
    	}
    }
    
    public EditarAlumnoController setContexto(BibliotecaController controlador) {
    	this.contexto = controlador;
    	return this;
    }
    
    public EditarAlumnoController setAlumno(Alumno alumno) {
    	this.alumno= alumno;
    	rellenarAlumno();
    	return this;
    }

}
