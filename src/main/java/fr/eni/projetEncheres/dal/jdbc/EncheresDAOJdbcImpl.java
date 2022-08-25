package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Utilisateur;

public class EncheresDAOJdbcImpl {

	private Connection connection;

	public Connection getConnection() throws SQLException {
		if (connection == null) {
			String urlConnection = "jdbc:sqlserver://localhost;databasename=ENCHERES_DB";
			connection = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
		}
		return connection;
	}

	public EncheresDAOJdbcImpl() {

	}

	public void insert(Enchere data) {

		try {
			connection = null;
			getConnection();

			String sqlInsert = "INSERT INTO ENCHERES(date_enchere, montant_enchere,noUtilisateur, noArticle) VALUES(?,?,?,?) ";
			PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

			stmt.setTime(1, data.getDateEnchere());
			stmt.setInt(2, data.getMontantEnchere());
			stmt.setInt(3, data.getEncherisseur().getNoUtilisateur());
			stmt.setInt(4, data.getArticleVendu().getNoArticle());

			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Enchere data) {

		try {
			connection = null;
			getConnection();

			String sqlUpdate = "UPDATE ENCHERES SET date_enchere=?,montant_enchere=? WHERE noUtilisateur=?, noArticle=?";

			PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
			stmt.setTime(1, data.getDateEnchere());
			stmt.setInt(2, data.getMontantEnchere());

			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int noUtilisateur, int noArticle) {
		try {
			connection = null;
			getConnection();
			PreparedStatement stmt = null;
			stmt = connection.prepareStatement("DELETE FROM Articles WHERE no_Utilisateur=? , no_Article=?");
			stmt.setInt(1, noUtilisateur);
			stmt.setInt(2, noArticle);
			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Enchere selectByNoUtilisateurAndArticle(int noUtilisateur, int noArticle) {
		Enchere enchere = null;
		connection = null;
		try {

			connection = getConnection();

			Statement stmt = null;
			stmt = connection.createStatement();

			String sqlSelectByNoUtilisateurAndArticle = "SELECT date_enchere, montant_enchere FROM ENCHERES WHERE noUtilisateur="
					+ noUtilisateur + ", noArticle=" + noArticle;

			ResultSet rs = stmt.executeQuery(sqlSelectByNoUtilisateurAndArticle);

			if (rs.next()) {
				enchere = new Enchere (rs.getTime("date_enchere"), rs.getInt("montant_enchere"));
			}
			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchere;
	}

	public Enchere selectByNoUtilisateur(int noUtilisateur) {
		Enchere enchere = null;
		connection = null;
		try {

			connection = getConnection();

			Statement stmt = null;
			stmt = connection.createStatement();

			String sqlSelectByNoUtilisateur = "SELECT date_enchere, montant_enchere,no_article FROM ENCHERES WHERE noUtilisateur="
					+ noUtilisateur;

			ResultSet rs = stmt.executeQuery(sqlSelectByNoUtilisateur);
			
			
			if (rs.next()) {
				
				enchere = new Enchere (rs.getTime("date_enchere"), rs.getInt("montant_enchere"));
			}
			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchere;
	}

	public Enchere selectByNodArticle(int noArticle) {
		Enchere enchere = null;
		connection = null;
		try {

			connection = getConnection();

			Statement stmt = null;
			stmt = connection.createStatement();

			String sqlSelectByNoArticle = "SELECT date_enchere, montant_enchere FROM ENCHERES WHERE noArticle="
					+ noArticle;

			ResultSet rs = stmt.executeQuery(sqlSelectByNoArticle);

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchere;
	}

}
