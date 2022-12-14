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
import fr.eni.projetEncheres.dal.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.CategorieDAO;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.UtilisateurDAO;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO{

	
	private Connection connection;
	
	public Connection getConnection() throws SQLException {
		if (connection == null) {
			String urlConnection = "jdbc:sqlserver://localhost;databasename=ENCHERES_DB";
			connection = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
		}
		return connection;
	}
	
	public ArticleVenduDAOJdbcImpl() {

	}
	
	public void insert(ArticleVendu data) {

		try {
			connection = null;
			getConnection();

			String sqlInsert = "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, data.getNomArticle());
			stmt.setString(2, data.getDescription());
			stmt.setDate(3, data.getDateDebutEncheres());
			stmt.setDate(4, data.getDateFinEncheres());
			stmt.setInt(5, data.getPrixInitial());
			stmt.setInt(6, data.getPrixVente());
			stmt.setInt(7, data.getVendeur().getNoUtilisateur());
			stmt.setInt(8, data.getCategorie().getNoCategorie());
						

			int affectedRows = stmt.executeUpdate();
			if (affectedRows == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					data.setNoArticle(keys.getInt(1));
				}

			}

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void update(ArticleVendu data) {

		try {
			connection = null;
			getConnection();

			String sqlUpdate = "UPDATE ARTICLES_VENDUS SET nom_article=?,description=?,date_debut_encheres=?,date_fin_encheres=?,prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=? WHERE no_article=?";
			PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
			stmt.setString(1, data.getNomArticle());
			stmt.setString(2, data.getDescription());
			stmt.setDate(3, data.getDateDebutEncheres());
			stmt.setDate(4, data.getDateFinEncheres());
			stmt.setInt(5, data.getPrixInitial());
			stmt.setInt(6, data.getPrixVente());
			stmt.setInt(7, data.getVendeur().getNoUtilisateur());
			stmt.setInt(8, data.getCategorie().getNoCategorie());
			stmt.setInt(9, data.getNoArticle());
			
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
			stmt = connection.prepareStatement("DELETE FROM ARTICLES_VENDUS WHERE no_article=?");
			stmt.setInt(1, noArticle);
			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArticleVendu selectByNoArticle(int noArticle) {
		ArticleVendu articleVendu = null;
		connection = null;
		
		try {

			connection = getConnection();

			Statement stmt = null;
			stmt = connection.createStatement();

			String sqlSelectByNoArticle = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, "
					+ "no_utilisateur, no_categorie FROM ARTICLES_VENDUS WHERE no_article="
					+ noArticle;
					
			ResultSet rs = stmt.executeQuery(sqlSelectByNoArticle);
			
			UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
			CategorieDAO categorieDAO = new CategorieDAOJdbcImpl();
			
			if (rs.next()) {
				articleVendu = new ArticleVendu ( rs.getInt("no_article"),rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"),
                        rs.getInt("prix_vente"), utilisateurDAO.selectByNoUtilisateur(rs.getInt("no_utilisateur")),  categorieDAO.selectByNoCategorie(rs.getInt("no_categorie")));
			}
			
			stmt.close();
			connection.close();
		} catch (SQLException | DALException e) {
			e.printStackTrace();
		}

		return articleVendu;
	}

	public List<ArticleVendu> selectByNoCategorie(int noCategorie) {
		connection = null;
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try {

			connection = getConnection();

			Statement stmt = null;
			stmt = connection.createStatement();

			String sqlSelectByNoCategorie = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, "
					+ "no_utilisateur, no_categorie FROM ARTICLES_VENDUS WHERE no_categorie="
					+ noCategorie;
					
			ResultSet rs = stmt.executeQuery(sqlSelectByNoCategorie);
			
			
			ArticleVendu art = null;
			UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
			CategorieDAO categorieDAO = new CategorieDAOJdbcImpl();
			
			while (rs.next()) {
                art = new ArticleVendu ( rs.getInt("no_article"),rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"),
                        rs.getInt("prix_vente"), utilisateurDAO.selectByNoUtilisateur(rs.getInt("no_utilisateur")),  categorieDAO.selectByNoCategorie(rs.getInt("no_categorie")));
           
                liste.add(art);
			}
			
			
			stmt.close();
			connection.close();
		} catch (SQLException | DALException e) {
			e.printStackTrace();
		}

		return liste;
	}

	public List<ArticleVendu> selectAll() {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		connection = null;
		Statement stmt = null;

		try {
			getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ARTICLES_VENDUS");

			ArticleVendu art = null;

			UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
			CategorieDAO categorieDAO = new CategorieDAOJdbcImpl();
			
			while (rs.next()) {
				
			try {
				art = new ArticleVendu ( rs.getInt("no_article"),rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"),
				        rs.getInt("prix_vente"), utilisateurDAO.selectByNoUtilisateur(rs.getInt("no_utilisateur")),  categorieDAO.selectByNoCategorie(rs.getInt("no_categorie")));
			} catch (DALException e) {
				e.printStackTrace();
			}
				liste.add(art);
			}
			connection.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return liste;
	}
	
}