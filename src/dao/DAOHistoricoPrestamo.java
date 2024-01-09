package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import excepciones.BibliotecaException;
import model.Prestamo;

public class DAOHistoricoPrestamo {
	
	public static List<Prestamo> getHistoricoPrestamos() throws BibliotecaException {
		return getHistoricoPrestamos("");
	}
	public static List<Prestamo> getHistoricoPrestamos(String busqueda) throws BibliotecaException {
		String like = "%" + busqueda + "%";
		List<Prestamo> prestamos = new LinkedList<>();
		String sql = "SELECT "
				+ "id_prestamo, "
				+ "dni_alumno, "
				+ "Alumno.nombre as nombre_alumno, "
				+ "Alumno.apellido1 as apellido1_alumno, "
				+ "Alumno.apellido2 as apellido2_alumno, "
				+ "codigo_libro, "
				+ "Libro.titulo as titulo_libro, "
				+ "Libro.autor as autor_libro, "
				+ "Libro.editorial as editorial_libro, "
				+ "Libro.estado as estado_libro, "
				+ "Libro.baja as baja_libro, "
				+ "fecha_prestamo, "
				+ "fecha_devolucion "
				+ "FROM Historico_prestamo "
				+ "INNER JOIN Alumno on Alumno.dni = Historico_prestamo.dni_alumno "
				+ "INNER JOIN Libro on Libro.codigo = Historico_prestamo.codigo_libro "
				+ "WHERE dni_alumno LIKE ? "
				+ "OR Alumno.nombre LIKE ? "
				+ "OR Alumno.apellido1 LIKE ? "
				+ "OR Alumno.apellido2 LIKE ? "
				+ "OR Libro.titulo LIKE ? "
				+ "OR Libro.editorial LIKE ? "
				+ "OR Libro.estado LIKE ? "
				+ "OR CAST(codigo_libro as CHAR) LIKE ? "
				+ "ORDER BY fecha_prestamo";
		try(Connection con = UtilConexion.getConexion()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, like);
			st.setString(2, like);
			st.setString(3, like);
			st.setString(4, like);
			st.setString(5, like);
			st.setString(6, like);
			st.setString(7, like);
			st.setString(8, like);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				prestamos.add(DAOPrestamo.mapPrestamo(rs));
			}
		} catch (SQLException e) {
			throw new BibliotecaException(e);
		}
		return prestamos;
	}
}
