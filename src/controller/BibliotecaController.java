package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import dao.DAOAlumno;
import dao.DAOHistoricoPrestamo;
import dao.DAOLibro;
import dao.DAOPrestamo;
import excepciones.BibliotecaException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Alumno;
import model.Libro;
import model.Prestamo;
import utils.StringUtils;

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
    private TableColumn<Libro, Boolean> tcBajaLibro;

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
    	try {
    		String busqueda = StringUtils.trimToEmpty(tfBuscarAlumnos.getText());
    		tvAlumnos.getItems().clear();
    		tvAlumnos.getItems().addAll(DAOAlumno.getAlumnos(busqueda));
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void buscarLibro(ActionEvent event) {
    	try {
    		String busqueda = StringUtils.trimToEmpty(tfBuscarLibros.getText());
    		tvLibros.getItems().clear();
    		tvLibros.getItems().addAll(DAOLibro.getLibros(busqueda));
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void buscarPrestamo(ActionEvent event) {
    	try {
    		String busqueda = StringUtils.trimToEmpty(tfBuscarPrestamos.getText());
    		tvPrestamos.getItems().clear();
    		tvPrestamos.getItems().addAll(DAOPrestamo.getPrestamos(busqueda));
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void buscarHistoricoPrestamo(ActionEvent event) {
    	try {
    		String busqueda = StringUtils.trimToEmpty(tfBuscarHistoricoPrestamos.getText());
    		tvHistoricoPrestamos.getItems().clear();
    		tvHistoricoPrestamos.getItems().addAll(DAOHistoricoPrestamo.getHistoricoPrestamos(busqueda));
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			inicializarAlumnos();
			inicializarLibros();
			inicializarPrestamos();
			inicializarHistoricoPrestamos();
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}
	}
	
	private void inicializarAlumnos() throws BibliotecaException {
		tcDniAlumno.setCellValueFactory(new PropertyValueFactory<Alumno, String>("dni"));
		tcNombreAlumno.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombre"));
		tcApellido1Alumno.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellido1"));
		tcApellido2Alumno.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellido2"));
		buscarAlumno(null);
		
		tfBuscarAlumnos.setOnKeyTyped(event -> {
			buscarAlumno(null);
		});
	}
	
	private void inicializarLibros() throws BibliotecaException {
		tcCodigoLibro.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("codigo"));
		tcTituloLibro.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
		tcAutorLibro.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
		tcEditorialLibro.setCellValueFactory(new PropertyValueFactory<Libro, String>("editorial"));
		tcEstadoLibro.setCellValueFactory(new PropertyValueFactory<Libro, String>("estado"));
		tcBajaLibro.setCellFactory(tc -> new CheckBoxTableCell<Libro, Boolean>());
		buscarLibro(null);
		
		tfBuscarLibros.setOnKeyTyped(evento -> {
			buscarLibro(null);
		});
	}
	
	private void inicializarPrestamos() throws BibliotecaException {
		
		tcCodigoLibroPrestamo.setCellValueFactory(param -> {
            Prestamo prestamo = param.getValue();
            if (prestamo != null && prestamo.getLibro() != null) {
                return new SimpleIntegerProperty(prestamo.getLibro().getCodigo()).asObject();
            }
            return new SimpleIntegerProperty().asObject();
        });
		
		tcTituloLibroPrestamo.setCellValueFactory(param -> {
            Prestamo prestamo = param.getValue();
            if (prestamo != null && prestamo.getLibro() != null) {
                return new SimpleStringProperty(StringUtils.trimToEmpty(prestamo.getLibro().getTitulo()));
            }
            return new SimpleStringProperty();
        });
		
		tcAutorLibroPrestamo.setCellValueFactory(param -> {
			Prestamo prestamo = param.getValue();
			if (prestamo != null && prestamo.getLibro() != null) {
				return new SimpleStringProperty(StringUtils.trimToEmpty(prestamo.getLibro().getAutor()));
			}
			return new SimpleStringProperty();
		});
		
		tcEditorialLibroPrestamo.setCellValueFactory(param -> {
			Prestamo prestamo = param.getValue();
			if (prestamo != null && prestamo.getLibro() != null) {
				return new SimpleStringProperty(StringUtils.trimToEmpty(prestamo.getLibro().getEditorial()));
			}
			return new SimpleStringProperty();
		});
		
		tcDNIAlumnoPrestamo.setCellValueFactory(param -> {
			Prestamo prestamo = param.getValue();
			if (prestamo != null && prestamo.getAlumno() != null) {
				return new SimpleStringProperty(StringUtils.trimToEmpty(prestamo.getAlumno().getDni()));
			}
			return new SimpleStringProperty();
		});
		
		
		tcNombreAlumnoPrestamo.setCellValueFactory(param -> {
			Prestamo prestamo = param.getValue();
			if (prestamo != null && prestamo.getAlumno() != null) {
				String prenom = StringUtils.trimToEmpty(prestamo.getAlumno().getNombre());
				String nom1 = StringUtils.trimToEmpty(prestamo.getAlumno().getApellido1());
				String nom2 = StringUtils.trimToEmpty(prestamo.getAlumno().getApellido2());
				return new SimpleStringProperty(String.format("%s %s, %s", nom1, nom2, prenom));
			}
			return new SimpleStringProperty();
		});
		
		tcFechaPrestamo.setCellValueFactory(new PropertyValueFactory<Prestamo, Date>("fecha"));
		
		buscarPrestamo(null);
		tfBuscarPrestamos.setOnKeyTyped(evento -> {
			buscarPrestamo(null);
		});
		
	}
	
	private void inicializarHistoricoPrestamos() throws BibliotecaException {
		
		tcCodigoLibroHistoricoPrestamo.setCellValueFactory(param -> {
            Prestamo prestamo = param.getValue();
            if (prestamo != null && prestamo.getLibro() != null) {
                return new SimpleIntegerProperty(prestamo.getLibro().getCodigo()).asObject();
            }
            return new SimpleIntegerProperty().asObject();
        });
		
		tcTituloLibroHistoricoPrestamo.setCellValueFactory(param -> {
            Prestamo prestamo = param.getValue();
            if (prestamo != null && prestamo.getLibro() != null) {
                return new SimpleStringProperty(StringUtils.trimToEmpty(prestamo.getLibro().getTitulo()));
            }
            return new SimpleStringProperty();
        });
		
		tcAutorLibroHistoricoPrestamo.setCellValueFactory(param -> {
			Prestamo prestamo = param.getValue();
			if (prestamo != null && prestamo.getLibro() != null) {
				return new SimpleStringProperty(StringUtils.trimToEmpty(prestamo.getLibro().getAutor()));
			}
			return new SimpleStringProperty();
		});
		
		tcEditorialLibroHistoricoPrestamo.setCellValueFactory(param -> {
			Prestamo prestamo = param.getValue();
			if (prestamo != null && prestamo.getLibro() != null) {
				return new SimpleStringProperty(StringUtils.trimToEmpty(prestamo.getLibro().getEditorial()));
			}
			return new SimpleStringProperty();
		});
		
		tcDNIAlumnoHistoricoPrestamo.setCellValueFactory(param -> {
			Prestamo prestamo = param.getValue();
			if (prestamo != null && prestamo.getAlumno() != null) {
				return new SimpleStringProperty(StringUtils.trimToEmpty(prestamo.getAlumno().getDni()));
			}
			return new SimpleStringProperty();
		});
		
		
		tcNombreAlumnoHistoricoPrestamo.setCellValueFactory(param -> {
			Prestamo prestamo = param.getValue();
			if (prestamo != null && prestamo.getAlumno() != null) {
				String prenom = StringUtils.trimToEmpty(prestamo.getAlumno().getNombre());
				String nom1 = StringUtils.trimToEmpty(prestamo.getAlumno().getApellido1());
				String nom2 = StringUtils.trimToEmpty(prestamo.getAlumno().getApellido2());
				return new SimpleStringProperty(String.format("%s %s, %s", nom1, nom2, prenom));
			}
			return new SimpleStringProperty();
		});
		
		tcFechaHistoricoPrestamo.setCellValueFactory(new PropertyValueFactory<Prestamo, Date>("fecha"));
		tcFechaDevolucionHistoricoPrestamo.setCellValueFactory(new PropertyValueFactory<Prestamo, Date>("fechaDevolucion"));
		
		buscarHistoricoPrestamo(null);
		tfBuscarHistoricoPrestamos.setOnKeyTyped(evento -> {
			buscarHistoricoPrestamo(null);
		});
		
	}

}
