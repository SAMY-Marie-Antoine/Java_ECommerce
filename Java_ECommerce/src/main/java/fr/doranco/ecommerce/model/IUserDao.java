package fr.doranco.ecommerce.model;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.User;



public interface IUserDao extends IEntityDao<User>{

	List<User> getUsers() throws Exception;

	User getUserByEmail(String email) throws Exception;
	
	User getUserById(Integer id) throws Exception;

	List<User> getUsersOfVille(String ville) throws Exception;

	Map<String, List<User>> getUsersByVille() throws Exception;

	List<User> getUsersWithNoCommand() throws Exception;

	void getUserConnexion() throws Exception;
}
