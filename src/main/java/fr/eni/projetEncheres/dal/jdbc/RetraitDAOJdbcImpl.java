package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.dal.RetraitDAO;
import fr.eni.projetEncheres.dal.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.DALException;


public class RetraitDAOJdbcImpl implements RetraitDAO {

private Connection connection;
	
	public Connection getConnection() throws SQLException {
		if (connection == null) {
			String urlConnection = "jdbc:sqlserver://localhost;databasename=ENCHERES_DB";
			connection = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
		}
		return connection;
	}
	
	public RetraitDAOJdbcImpl() {

	}
	public void insert(Retrait data) {

		try {
			connection = null;
			getConnection();

			String sqlInsert = "INSERT INTO RETRAITS(no_article, rue, code_postal, ville) VALUES(?,?,?,?) ";
			PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, data.getArticleVendu().getNoArticle());
			stmt.setString(2, data.getRue());
			stmt.setString(3, data.getCodePostal());
			stmt.setString(4, data.getVille());
			

			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Retrait data) {

		try {
			connection = null;
			getConnection();

			String sqlUpdate = "UPDATE RETRAITS SET rue=?,code_postal=?,ville=? WHERE no_article=?";

			PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
			stmt.setString(1, data.getRue());
			stmt.setString(2, data.getCodePostal());
			stmt.setString(3, data.getVille());
			stmt.setInt(4, data.getArticleVendu().getNoArticle());

			
			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int noArticle) {
		try {
			connection = null;
			getConnection();
			PreparedStatement stmt = null;
			stmt = connection.prepareStatement("DELETE FROM RETRAITS WHERE no_Article=?");
			stmt.setInt(1, noArticle);
			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Retrait selectByNoArticle(int noArticle) {
		Retrait retrait = null;
		connection = null;
		try {

			connection = getConnection();

			Statement stmt = null;
			stmt = connection.createStatement();

			String selectByNoArticle = "SELECT no_article, rue, code_postal, ville FROM RETRAITS WHERE no_article=" + noArticle;

			ResultSet rs = stmt.executeQuery(selectByNoArticle);

			ArticleVenduDAO articleVenduDAO = new ArticleVenduDAOJdbcImpl();
			
			if (rs.next()) {
				retrait = new Retrait (articleVenduDAO.selectByNoArticle(rs.getInt("no_article")), rs.getString("rue"), rs.getString("code_postal"),
						rs.getString("ville"));
			}
			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retrait;
	}

	public List<Retrait> selectAll() {
		List<Retrait> liste = new ArrayList<Retrait>();
		connection = null;
		Statement stmt = null;

		try {
			getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT no_article, rue, code_postal, ville FROM RETRAITS");

			Retrait r = null;

			ArticleVenduDAO articleVenduDAO = new ArticleVenduDAOJdbcImpl();
			
			while (rs.next()) {

				r = new Retrait(articleVenduDAO.selectByNoArticle(rs.getInt("no_article")), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				liste.add(r);
			}
			connection.close();
			stmt.close();

		} catch (SQLException | DALException e) {
			e.printStackTrace();

		}

		return liste;
	}
	
}