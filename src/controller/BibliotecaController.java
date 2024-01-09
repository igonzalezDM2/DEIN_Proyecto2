package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Alumno;
import model.Libro;
import model.Prestamo;

public class BibliotecaController implements Initializable {

    @FXML
    private Button btnAnadirAlumno;

    @FXML
    private Button btnAnadirHistoricoPrestamo;

    @FXML
    private Button btnAnadirLibro;

    @FXML
    private Button btnAnadirPrestamo;

    @FXML
    private Tab tabAlumnos;

    @FXML
    private Tab tabHistoricoPrestamos;

    @FXML
    private Tab tabLibros;

    @FXML
    private Tab tabPrestamos;

    @FXML
    private TableColumn<Alumno, String> tcApellido1Alumno;

    @FXML
    private TableColumn<Alumno, String> tcApellido2Alumno;

    @FXML
    private TableColumn<Libro, String> tcAutorLibro;

    @FXML
    private TableColumn<Prestamo, String> tcAutorLibroHistoricoPrestamo;

    @FXML
    private TableColumn<Prestamo, String> tcAutorLibroPrestamo;

    @FXML
    private TableColumn<Libro, Integer> tcBajaLibro;

    @FXML
    private TableColumn<Libro, Integer> tcCodigoLibro;

    @FXML
    private TableColumn<Prestamo, Integer> tcCodigoLibroHistoricoPrestamo;

    @FXML
    private TableColumn<Prestamo, Integer> tcCodigoLibroPrestamo;

    @FXML
    private TableColumn<Prestamo, String> tcDNIAlumnoHistoricoPrestamo;

    @FXML
    private TableColumn<Prestamo, String> tcDNIAlumnoPrestamo;

    @FXML
    private TableColumn<Alumno, String> tcDniAlumno;

    @FXML
    private TableColumn<Libro, String> tcEditorialLibro;

    @FXML
    private TableColumn<Prestamo, String> tcEditorialLibroHistoricoPrestamo;

    @FXML
    private TableColumn<Prestamo, String> tcEditorialLibroPrestamo;

    @FXML
    private TableColumn<Libro, String> tcEstadoLibro;

    @FXML
    private TableColumn<Prestamo, Date> tcFechaDevolucionHistoricoPrestamo;

    @FXML
    private TableColumn<Prestamo, Date> tcFechaHistoricoPrestamo;

    @FXML
    private TableColumn<Prestamo, Date> tcFechaPrestamo;

    @FXML
    private TableColumn<Alumno, String> tcNombreAlumno;

    @FXML
    private TableColumn<Prestamo, String> tcNombreAlumnoHistoricoPrestamo;

    @FXML
    private TableColumn<Prestamo, String> tcNombreAlumnoPrestamo;

    @FXML
    private TableColumn<Libro, String> tcTituloLibro;

    @FXML
    private TableColumn<Prestamo, String> tcTituloLibroHistoricoPrestamo;

    @FXML
    private TableColumn<Prestamo, String> tcTituloLibroPrestamo;

    @FXML
    private TextField tfBuscarAlumnos;

    @FXML
    private TextField tfBuscarHistoricoPrestamos;

    @FXML
    private TextField tfBuscarLibros;

    @FXML
    private TextField tfBuscarPrestamos;

    @FXML
    private TableView<Alumno> tvAlumnos;

    @FXML
    private TableView<Prestamo> tvHistoricoPrestamos;

    @FXML
    private TableView<Libro> tvLibros;

    @FXML
    private TableView<Prestamo> tvPrestamos;
    
    @FXML
    void anadirAlumno(ActionEvent event) {

    }
    
    @FXML
    void anadirLibro(ActionEvent event) {

    }
    
    @FXML
    void anadirPrestamo(ActionEvent event) {

    }
    
    @FXML
    void anadirHistoricoPrestamo(ActionEvent event) {

    }

    @FXML
    void buscarAlumno(ActionEvent event) {

    }

    @FXML
    void buscarLibro(ActionEvent event) {

    }
    
    @FXML
    void buscarPrestamo(ActionEvent event) {
    	
    }
    
    @FXML
    void buscarHistoricoPrestamo(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}

}
