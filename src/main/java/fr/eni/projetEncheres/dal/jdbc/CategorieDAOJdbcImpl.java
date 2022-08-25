package fr.eni.projetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    }

    @Override
    public void update(Categorie data) throws DALException {

    }

    @Override
    public void delete(int noCategorie) throws DALException {

    }

    @Override
    public Categorie selectById(int noCategorie) throws DALException {
        return null;
    }
}