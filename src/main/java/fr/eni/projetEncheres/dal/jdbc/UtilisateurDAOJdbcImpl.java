package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

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

	public UtilisateurDAOJdbcImpl() {

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

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Utilisateur data) {

		connection = null;
		PreparedStatement stmt =null;
		try {
			
			connection = getConnection();
			String sqlUpdate = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";
			stmt = connection.prepareStatement(sqlUpdate);

			stmt.setString(1, data.getPseudo());
			stmt.setString(2, data.getNom());
			stmt.setString(3, data.getPrenom());
			stmt.setString(4, data.getEmail());
			stmt.setString(5, data.getTelephone());
			stmt.setString(6, data.getRue());
			stmt.setString(7, data.getCodePostal());
			stmt.setString(8, data.getVille());
			stmt.setString(9, data.getMotDePasse());
			stmt.setInt(10, data.getNoUtilisateur());

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
			stmt = connection.prepareStatement("DELETE FROM UTILISATEURS WHERE no_utilisateur=?");
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

			String sqlSelectByNoUtilisateur = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit FROM UTILISATEURS WHERE no_utilisateur="
					+ noUtilisateur;

			ResultSet rs = stmt.executeQuery(sqlSelectByNoUtilisateur);

			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("credit"));
			}

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return utilisateur;
	}

	public List<Utilisateur> selectAll() {
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		connection = null;
		Statement stmt = null;

		try {
			getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit FROM UTILISATEURS");

			Utilisateur u = null;

			while (rs.next()) {

				u = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getInt("credit"));
				liste.add(u);
			}
			connection.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return liste;
	}

}
