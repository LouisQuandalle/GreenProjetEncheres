package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fr.eni.projetEncheres.bo.Utilisateur;

public class UtilisateurDAOjdbcImpl {

	private static final int CREDIT_INITIAL = 0;
	private static final boolean ROLE_UTILISATEUR = false;
	
	private Connection connection;
	
	public Connection getConnection() throws SQLException {
		if (connection == null) {
			String urlConnection = "jdbc:sqlserver://localhost;databasename=ENCHERES_DB";
			connection = DriverManager.getConnection(urlConnection, "sa", "Pa$$w0rd");
		}
		return connection;
	}
	
	public UtilisateurDAOjdbcImpl() {

	}
	
	public void insert(Utilisateur data) {

		try {
			connection = null;
			getConnection();

			String sqlInsert = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, data.getPseudo());
			stmt.setString(2, data.getNom());
			stmt.setString(3, data.getPrenom());
			stmt.setString(4, data.getEmail());
			stmt.setString(5, data.getTelephone());
			stmt.setString(6, data.getRue());
			stmt.setString(7, data.getCodePostal());
			stmt.setString(8, data.getVille());
			stmt.setString(9, data.getMotDePasse());
			stmt.setInt(10, CREDIT_INITIAL);
			stmt.setBoolean(11, ROLE_UTILISATEUR);
			
			

			int affectedRows = stmt.executeUpdate();
			if (affectedRows == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					data.setNoUtilisateur(keys.getInt(1));
				}

			}

			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void update(Utilisateur data) {

		try {
			connection = null;
			getConnection();

			String sqlUpdate = "UPDATE UTILISATEURS SET pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de=passe=? WHERE no_utilisateur=?";

			PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
			stmt.setString(1, data.getPseudo());
			stmt.setString(2, data.getNom());
			stmt.setString(3, data.getPrenom());
			stmt.setString(4, data.getEmail());
			stmt.setString(5, data.getTelephone());
			stmt.setString(6, data.getRue());
			stmt.setString(7, data.getCodePostal());
			stmt.setString(8, data.getVille());
			stmt.setString(9, data.getMotDePasse());

			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void delete(int noUtilisateur) {
		try {
			connection = null;
			getConnection();
			PreparedStatement stmt = null;
			stmt = connection.prepareStatement("DELETE FROM Articles WHERE no_Utilisateur=?");
			stmt.setInt(1, noUtilisateur);
			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Utilisateur selectByNoUtilisateur(int noUtilisateur) {
		Utilisateur utilisateur = null;
		connection = null;
		try {

			connection = getConnection();

			Statement stmt = null;
			stmt = connection.createStatement();

			String sqlSelectByNoUtilisateur = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit FROM UTILISATEURS WHERE noUtilisateurs="
					+ noUtilisateur;

			ResultSet rs = stmt.executeQuery(sqlSelectByNoUtilisateur);

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return utilisateur;
	}
}