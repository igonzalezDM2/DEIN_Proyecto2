package model;

import java.io.Serializable;
import java.util.Date;

public class Prestamo implements Serializable {
		
	private static final long serialVersionUID = -5244557243733412845L;
	
	private int id;
	private Alumno alumno;
	private Libro libro;
	private Date fecha, fechaDevolucion;
	public int getId() {
		return id;
	}
	public Prestamo setId(int id) {
		this.id = id;
		return this;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public Prestamo setAlumno(Alumno alumno) {
		this.alumno = alumno;
		return this;
	}
	public Libro getLibro() {
		return libro;
	}
	public Prestamo setLibro(Libro libro) {
		this.libro = libro;
		return this;
	}
	public Date getFecha() {
		return fecha;
	}
	public Prestamo setFecha(Date fecha) {
		this.fecha = fecha;
		return this;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public Prestamo setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
		return this;
	}
	
}
