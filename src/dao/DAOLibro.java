package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import excepciones.BibliotecaException;
import model.Libro;

public class DAOLibro {
	
	public static Libro mapLibro(ResultSet rs) throws SQLException {
		return new Libro()
				.setCodigo(rs.getInt("codigo"))
				.setTitulo(rs.getString("titulo"))
				.setAutor(rs.getString("autor"))
				.setEditorial(rs.getString("editorial"))
				.setEstado(rs.getString("estado"))
				.setBaja(rs.getBoolean("baja"))
				;
	}
	
	public static List<Libro> getLibros() throws BibliotecaException {
		return getLibros("");
	}
	
	public static List<Libro> getLibros(String busqueda) throws BibliotecaException {
		String like = "%" + busqueda + "%";
		List<Libro> libros= new LinkedList<>();
		String sql = "SELECT * FROM Libro "
				+ "WHERE titulo LIKE ? "
				+ "OR autor LIKE ? "
				+ "OR editorial LIKE ? "
				+ "OR CAST(codigo as CHAR) LIKE ?";
		try(Connection con = UtilConexion.getConexion()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, like);
			st.setString(2, like);
			st.setString(3, like);
			st.setString(4, like);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				libros.add(mapLibro(rs));
			}
		} catch (SQLException e) {
			throw new BibliotecaException(e);
		}
		return libros;
	}
}
