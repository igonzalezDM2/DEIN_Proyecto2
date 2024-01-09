package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import excepciones.BibliotecaException;
import model.Alumno;

public class DAOAlumno {
	
	public static Alumno mapAlumno(ResultSet rs) throws SQLException {
		return new Alumno()
				.setDni(rs.getString("dni"))
				.setNombre(rs.getString("nombre"))
				.setApellido1(rs.getString("apellido1"))
				.setApellido2(rs.getString("apellido2"));
	}
	
	public static List<Alumno> getAlumnos() throws BibliotecaException {
		return getAlumnos("");
	}
	
	public static List<Alumno> getAlumnos(String busqueda) throws BibliotecaException {
		String like = "%" + busqueda + "%";
		List<Alumno> alumnos = new LinkedList<>();
		String sql = "SELECT * FROM Alumno "
				+ "WHERE dni like ? "
				+ "OR nombre like ? "
				+ "OR apellido1 like ? "
				+ "OR apellido2 like ?";
		try(Connection con = UtilConexion.getConexion()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, like);
			st.setString(2, like);
			st.setString(3, like);
			st.setString(4, like);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				alumnos.add(mapAlumno(rs));
			}
		} catch (SQLException e) {
			throw new BibliotecaException(e);
		}
		return alumnos;
	}
}
