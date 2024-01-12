package model;

import java.io.Serializable;
import java.util.Objects;

import enums.EstadoLibro;

public class Libro implements Serializable {
	
	private static final long serialVersionUID = -5576585320895867104L;
	
	private int codigo;
	private String titulo, autor, editorial;
	private boolean baja;
	private EstadoLibro estado;
	
	public int getCodigo() {
		return codigo;
	}
	public Libro setCodigo(int codigo) {
		this.codigo = codigo;
		return this;
	}
	public String getTitulo() {
		return titulo;
	}
	public Libro setTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public String getAutor() {
		return autor;
	}
	public Libro setAutor(String autor) {
		this.autor = autor;
		return this;
	}
	public String getEditorial() {
		return editorial;
	}
	public Libro setEditorial(String editorial) {
		this.editorial = editorial;
		return this;
	}
	public EstadoLibro getEstado() {
		return estado;
	}
	public Libro setEstado(EstadoLibro estado) {
		this.estado = estado;
		return this;
	}
	public boolean isBaja() {
		return baja;
	}
	public Libro setBaja(boolean baja) {
		this.baja = baja;
		return this;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return codigo == other.codigo;
	}
	@Override
	public String toString() {
		return titulo;
	}
	
	
	
}
