package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.CategorieDAO;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.EncheresDAO;
import fr.eni.projetEncheres.dal.UtilisateurDAO;

public class EncheresDAOJdbcImpl implements EncheresDAO {

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

			String sqlInsert = "INSERT INTO ENCHERES(date_enchere, montant_enchere,no_utilisateur, no_article) VALUES(?,?,?,?) ";
			PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

			stmt.setDate(1, data.getDateEnchere());
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
			stmt.setDate(1, data.getDateEnchere());
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

			String sqlSelectByNoUtilisateurAndArticle = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_utilisateur="
					+ noUtilisateur + "AND no_article=" + noArticle;

			ResultSet rs = stmt.executeQuery(sqlSelectByNoUtilisateurAndArticle);

			UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
			ArticleVenduDAO articleVenduDAO = new ArticleVenduDAOJdbcImpl();

			if (rs.next()) {
				try {
					enchere = new Enchere(rs.getDate("date_enchere"), rs.getInt("montant_enchere"),
							utilisateurDAO.selectByNoUtilisateur(rs.getInt("no_utilisateur")),
							articleVenduDAO.selectByNoArticle(rs.getInt("no_article")));
				} catch (DALException e) {
					e.printStackTrace();
				}
			}

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchere;
	}

	public List<Enchere> selectByNoUtilisateur(int noUtilisateur) {
		List<Enchere> liste = new ArrayList<Enchere>();
		connection = null;
		Statement stmt = null;

		try {
			getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_utilisateur="
							+ noUtilisateur);

			Enchere enchere = null;

			UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
			ArticleVenduDAO articleVenduDAO = new ArticleVenduDAOJdbcImpl();

			while (rs.next()) {

				try {
					enchere = new Enchere(rs.getDate("date_enchere"), rs.getInt("montant_enchere"),
							utilisateurDAO.selectByNoUtilisateur(rs.getInt("no_utilisateur")),
							articleVenduDAO.selectByNoArticle(rs.getInt("no_article")));
				} catch (DALException e) {
					e.printStackTrace();
				}
				liste.add(enchere);
			}
			connection.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return liste;
	}

	public List<Enchere> selectByNoArticle(int noArticle) {
		List<Enchere> liste = new ArrayList<Enchere>();
		connection = null;
		Statement stmt = null;

		try {
			getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_article="
							+ noArticle);

			Enchere enchere = null;

			UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
			ArticleVenduDAO articleVenduDAO = new ArticleVenduDAOJdbcImpl();

			while (rs.next()) {

				try {
					enchere = new Enchere(rs.getDate("date_enchere"), rs.getInt("montant_enchere"),
							utilisateurDAO.selectByNoUtilisateur(rs.getInt("no_utilisateur")),
							articleVenduDAO.selectByNoArticle(rs.getInt("no_article")));
				} catch (DALException e) {
					e.printStackTrace();
				}
				liste.add(enchere);
			}
			connection.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return liste;
	}

}
