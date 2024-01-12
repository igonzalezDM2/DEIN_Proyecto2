package model;

import java.io.Serializable;
import java.util.Objects;

public class Alumno implements Serializable {
		
	private static final long serialVersionUID = 1055759459211840526L;
	
	private String dni, nombre, apellido1, apellido2;

	public String getDni() {
		return dni;
	}

	public Alumno setDni(String dni) {
		this.dni = dni;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public Alumno setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public String getApellido1() {
		return apellido1;
	}

	public Alumno setApellido1(String apellido1) {
		this.apellido1 = apellido1;
		return this;
	}

	public String getApellido2() {
		return apellido2;
	}

	public Alumno setApellido2(String apellido2) {
		this.apellido2 = apellido2;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return String.format("%s %s, %s", apellido1, apellido2, nombre);
	}
	
	
	
}
