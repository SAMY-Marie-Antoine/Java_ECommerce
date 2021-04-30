package fr.doranco.ecommerce.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;

import fr.doranco.ecommerce.entity.CarteDePaiement;
import fr.doranco.ecommerce.utils.Dates;


public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public CarteDePaiement getCartePaiementByUserId(Integer userId) throws Exception {
		
		if (userId == null) {
			throw new NullPointerException("L'id de l'utilisateur est NULL !");
		}
		CarteDePaiement cartePaiement = null;
		Connection connexion = null;
		PreparedStatement ps = null;
		try {
			Session session = HibernateConnector.getSession();
			String query = "SELECT * FROM carte_paiement WHERE user_id = ?";
			 ps = connexion.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cartePaiement = new CarteDePaiement();
				cartePaiement.setId(rs.getInt("id"));
				cartePaiement.setNomProprietaire(rs.getString("nomProprietaire"));
				cartePaiement.setPrenomProprietaire(rs.getString("prenomProprietaire"));
				cartePaiement.setNumero(rs.getBytes("numero"));
				cartePaiement.setCryptogramme(rs.getBytes("cryptogramme"));
				cartePaiement.setDateValidite(Dates.dateSqlToDateUtil(rs.getDate("date_validite")));
			}
		} finally {
			if (ps != null && !ps.isClosed())
				ps.close();
			if (connexion != null && !connexion.isClosed())
				connexion.close();
		}
		return cartePaiement;
	}

	@Override
	public CarteDePaiement addCartePaiement(CarteDePaiement cartePaiement, Integer userId) throws Exception {

		if (cartePaiement == null) {
			throw new NullPointerException("La carte de paiement à insérer dans la BDD est NULL !");
		}
		if (userId == null) {
			throw new NullPointerException("L'id de l'utilisateur est NULL !");
		}

		Connection connexion = null;
		PreparedStatement ps = null;
		try {
			Session session = HibernateConnector.getSession();
			String requete = "INSERT INTO carte_paiement(numero, nom, cle_cryptage, cryptogramme, date_validite, user_id) "
									+ "VALUES(?, ?, ?, ?, ?, ?)";
			ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cartePaiement.getNomProprietaire());
			ps.setString(2, cartePaiement.getPrenomProprietaire());
			ps.setBytes(3, cartePaiement.getNumero());
			ps.setBytes(4, cartePaiement.getCryptogramme());
			ps.setDate(5, Dates.dateUtilToDateSql(cartePaiement.getDateValidite()));
			ps.setInt(6, userId);

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				cartePaiement.setId(id);
			}
		} finally {
			if (ps != null && !ps.isClosed())
				ps.close();
			if (connexion != null && !connexion.isClosed())
				connexion.close();
		}
		return cartePaiement;	}

	

	

}

