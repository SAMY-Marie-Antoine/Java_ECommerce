package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.IEntityDao;



public interface IUserMetier extends IEntity<User>{

	User seConnecter(String email, String password) throws Exception;
	User getUserByEmail(String email) throws Exception;
	User getUserById(Integer id) throws Exception;
	//User addUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
	//void removeUser(Integer id) throws Exception;
	//void updateUser (User user) throws Exception;
}
