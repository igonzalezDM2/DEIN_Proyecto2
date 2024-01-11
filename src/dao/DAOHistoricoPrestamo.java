package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import excepciones.BibliotecaException;
import model.Alumno;
import model.Libro;
import model.Prestamo;
import utils.StringUtils;

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
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				prestamos.add(DAOPrestamo.mapPrestamo(rs, true));
			}
		} catch (SQLException e) {
			throw new BibliotecaException(e);
		}
		return prestamos;
	}
	
	public static void borrarPorLibro(Libro libro) throws SQLException, BibliotecaException {
		if (libro != null && libro.getCodigo() > 0) {
			String sql = "DELETE FROM Historico_prestamo WHERE codigo_libro = ?";
			Connection con = null;
			try {
				con = UtilConexion.getConexion();
				con.setAutoCommit(false);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, libro.getCodigo());
				ps.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				con.rollback();
				throw new BibliotecaException(e);
			} finally {
				con.close();
			}
		}	
	}
	
	public static void borrarPorAlumno(Alumno alumno) throws SQLException, BibliotecaException {
		if (alumno != null && !StringUtils.isBlank(alumno.getDni())) {
			String sql = "DELETE FROM Historico_prestamo WHERE dni_alumno = ?";
			Connection con = null;
			try {
				con = UtilConexion.getConexion();
				con.setAutoCommit(false);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, alumno.getDni());
				ps.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				con.rollback();
				throw new BibliotecaException(e);
			} finally {
				con.close();
			}
		}
		
	}
}
