package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.entity.dto.UserDto;




public interface IUserMetier {

	User seConnecter(String email, String password) throws Exception;
	User getUserByEmail(String email) throws Exception;
	User getUserById(Integer id) throws Exception;
	User addUser(UserDto userDto) throws Exception;
	List<User> getUsers() throws Exception;
	void removeUser(Integer id) throws Exception;
	void updateUser (UserDto userDto) throws Exception;
}
