package fr.doranco.ecommerce.control;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.CarteDePaiement;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.entity.dto.AdresseDto;
import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.dto.UserDto;
import fr.doranco.ecommerce.model.IUserDao;
import fr.doranco.ecommerce.model.UserDao;
import fr.doranco.ecommerce.utils.Dates;
import fr.doranco.enums.CryptageAlgorithm;
import fr.doranco.metier.cryptage.algo.CryptageDES;
import fr.doranco.metier.cryptage.keys.GenerateKey;


public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();

	@Override
	public User seConnecter(String email, String password) throws Exception {
		User user = userDao.getUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public List<User> getUsers() throws Exception {
		List<User> users = userDao.getUsers();
		if (users != null)
			return users;
		return new ArrayList<User>();
	}

	@Override
	public User getUserById(Integer idUser) throws Exception {

		return userDao.getUserById(idUser);
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		return userDao.getUserByEmail(email);
	}

	@Override
	public User addUser(UserDto userDto) throws Exception {

		User user = new User();
		user.setNom(userDto.getNom().toUpperCase());
		user.setPrenom(userDto.getPrenom().toLowerCase());
		user.setEmail(userDto.getEmail());
		user.setTelephone(userDto.getTelephone());
		user.setDateNaissance((Dates.stringToDateUtil(userDto.getDateNaissance())));
		
		SecretKey secretKey = GenerateKey.getKey(CryptageAlgorithm.DES.toString(), 56);
		byte[] cryptedPassword = CryptageDES.encrypt(userDto.getPassword(), secretKey);
		user.setPassword(cryptedPassword);
		
		
		Adresse adresse = new Adresse();
		AdresseDto adresseDto = userDto.getAdresses().get(0);
		adresse.setNumero(new Integer(adresseDto.getNumero()));
		adresse.setRue(adresseDto.getRue());
		adresse.setVille(adresseDto.getVille());
		adresse.setCodePostal(adresseDto.getCodePostal());
	
		user.getAdresses().add(adresse);
		
		CartePaiementDto cartePaiementDto = userDto.getCartesDePaiementDto().get(0);
		
		CarteDePaiement carteDePaiement = new CarteDePaiement();
		carteDePaiement.setNomProprietaire(cartePaiementDto.getNomProprietaire().toUpperCase());
		carteDePaiement.setPrenomProprietaire(cartePaiementDto.getPrenomProprietaire().toLowerCase());
		carteDePaiement.setDateValidite(Dates.stringToDateUtil(cartePaiementDto.getDateValidite()));
		
		byte[] cryptedCryptogramme = CryptageDES.encrypt(cartePaiementDto.getCryptogramme(), secretKey);
		carteDePaiement.setCryptogramme(cryptedCryptogramme);
		
		byte[] cryptedNumeroCarte = CryptageDES.encrypt(cartePaiementDto.getNumero(), secretKey);
		carteDePaiement.setNumero(cryptedNumeroCarte);
		
		
		user.getCartesDePaiement().add(carteDePaiement);
		
		adresse.setUser(user);
		carteDePaiement.setUser(user);
		
		userDao.add(user);
		
		user.setAdresseFacturationId(user.getAdresses().get(0).getId());
		user.setAdresseLivraisonId(user.getAdresses().get(0).getId());
		user.setCartesPaiementDefaultId(user.getCartesDePaiement().get(0).getId());
		
		userDao.update(user);

		return user;
	}

	@Override
	public void removeUser(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub

	}

}
