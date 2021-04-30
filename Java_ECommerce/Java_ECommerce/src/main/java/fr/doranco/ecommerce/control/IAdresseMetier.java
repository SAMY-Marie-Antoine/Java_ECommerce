package fr.doranco.ecommerce.control;

import java.sql.SQLException;
import java.util.List;
import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.dto.AdresseDto;

public interface IAdresseMetier {
	Adresse addAdresse(AdresseDto adresseDto) throws Exception;
	//List<Adresse> getAdresses(Adresse adresse,Integer UserId)throws Exception;
	void updateAdresse(AdresseDto adresseDto)throws Exception;
	void removeAdresse(AdresseDto adresseDto)throws Exception;
	List<Adresse> getAdresses(Class<Adresse> adresse, Integer UserId) throws Exception;
	Adresse getAdresseById(AdresseDto adresseDto,Integer UserId)throws SQLException;

}

