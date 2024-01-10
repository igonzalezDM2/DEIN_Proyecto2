package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import excepciones.BibliotecaException;
import model.Alumno;
import utils.StringUtils;

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
	
	public static void anadirAlumno(Alumno alumno) throws BibliotecaException, SQLException {
		if (alumno != null) {
			
			String sql = "INSERT INTO Alumno ("
					+ "dni, nombre, apellido1, apellido2) "
					+ "VALUES (?, ?, ?, ?)";
			
			Connection con = null;
			try {
				con = UtilConexion.getConexion();
				con.setAutoCommit(false);
				
				try (PreparedStatement ps = con.prepareStatement(sql)) {
					ps.setString(1, alumno.getDni());
					ps.setString(2, alumno.getNombre());
					ps.setString(3, alumno.getApellido1());
					ps.setString(4, alumno.getApellido2());
					
					ps.executeUpdate();
					
				}
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
				throw new BibliotecaException(e);
			} finally {
				con.close();
			}			
		} else {			
			throw new BibliotecaException("Los datos introducidos están incompletos");
		}
	}
	
	public static void modificarAlumno (Alumno alumno) throws BibliotecaException, SQLException {
		if (alumno != null && !StringUtils.isBlank(alumno.getDni())) {
			
			String sql = "UPDATE Alumno SET "
					+ "dni = ?, "
					+ "nombre = ?, "
					+ "apellido1 = ?, "
					+ "apellido2 = ? "
					+ "WHERE dni = ?";
			
			Connection con = null;
			try {
				con = UtilConexion.getConexion();
				con.setAutoCommit(false);
				
				try (PreparedStatement ps = con.prepareStatement(sql)) {
					ps.setString(1, alumno.getDni());
					ps.setString(2, alumno.getNombre());
					ps.setString(3, alumno.getApellido1());
					ps.setString(4, alumno.getApellido2());
					ps.setString(5, alumno.getDni());
					
					ps.executeUpdate();
				}
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
				throw new BibliotecaException(e);
			} finally {
				con.close();
			}			
		} else {			
			throw new BibliotecaException("Los datos introducidos están incompletos");
		}
	}
	
	public static boolean existe(Alumno alumno) throws BibliotecaException {
		if (alumno != null && alumno.getDni() != null) {
			String sql = "SELECT * FROM Alumno WHERE dni = ?";
			try(Connection con = UtilConexion.getConexion()) {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, alumno.getDni());
				ResultSet rs = st.executeQuery();
				return rs.first();
			} catch (SQLException e) {
				throw new BibliotecaException(e);
			}
		}
			
		return false;
	}
	
	
}
