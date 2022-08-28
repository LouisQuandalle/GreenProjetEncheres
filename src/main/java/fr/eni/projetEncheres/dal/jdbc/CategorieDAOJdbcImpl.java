package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.dal.CategorieDAO;
import fr.eni.projetEncheres.dal.DALException;

public class CategorieDAOJdbcImpl implements CategorieDAO{

private Connection connection;
	
	public Connection getConnection() throws SQLException {
		if (connection == null) {
			String urlConnection = "jdbc:sqlserver://localhost;databasename=ENCHERES_DB";
			connection = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
		}
		return connection;
	}
	
	public CategorieDAOJdbcImpl() {

	}

	@Override
	public void insert(Categorie data) throws DALException {
		try {
			connection = null;
			getConnection();

			String sqlInsert = "insert into CATEGORIES(libelle) values(?);";
			PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, data.getLibelle());
									

			int affectedRows = stmt.executeUpdate();
			if (affectedRows == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					data.setNoCategorie(keys.getInt(1));
				}

			}

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void update(Categorie data) {

		try {
			connection = null;
			getConnection();

			String sqlUpdate = "UPDATE CATEGORIES SET libelle=? WHERE no_categorie=?";
			PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
			stmt.setString(1, data.getLibelle());

			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void delete(int noCategorie) {
		try {
			connection = null;
			getConnection();
			PreparedStatement stmt = null;
			stmt = connection.prepareStatement("DELETE FROM CATEGORIES WHERE no_categorie=?");
			stmt.setInt(1, noCategorie);
			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Categorie selectByNoCategorie(int noCategorie) throws DALException {
		Categorie categorie = null;
		connection = null;
		
		try {

			connection = getConnection();

			Statement stmt = null;
			stmt = connection.createStatement();

			String sqlSelectByNoCategorie = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie="
					+ noCategorie;
					
			ResultSet rs = stmt.executeQuery(sqlSelectByNoCategorie);
			if (rs.next()) {
				categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
			}
						
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categorie;
	}

}