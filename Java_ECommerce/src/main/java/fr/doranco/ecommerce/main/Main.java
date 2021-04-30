package fr.doranco.ecommerce.main;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.IUserDao;
import fr.doranco.ecommerce.model.UserDao;
import fr.doranco.ecommerce.utils.Dates;
import fr.doranco.ecommerce.utils.Profil;


public class Main {

	public static void main(String[] args) {

		try {

			IUserDao userDao = new UserDao();
			
//			User user1 =new User("Chebbat", "Nassima", true, Profil.ADMIN.toString(), "nassima@gmail.com","mdp",
//			Dates.stringToDateUtil("05/06/1991"), "625253621");
			
//			Adresse adresse1 =new Adresse(1,"rue de paris","75000","paris");
//			
//			adresse1.setUser(user1);
//			
//			user1.getAdresses().add(adresse1);
//			
//			userDao.add(user1);
//			
//			user1.setAdresseLivraisonId(user1.getAdresses().get(0).getId());
//			user1.setAdresseFacturationId(user1.getAdresses().get(0).getId());
//			userDao.update(user1);
//			System.out.println(user1);
//			
//			System.exit(0);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
