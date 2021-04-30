package fr.doranco.ecommerce.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.dto.AdresseDto;
import fr.doranco.ecommerce.model.AdresseDao;
import fr.doranco.ecommerce.model.IAdresseDao;


public class AdresseMetier implements IAdresseMetier {

	private IAdresseDao adresseDao = new AdresseDao();
	
	@Override
	public Adresse addAdresse(AdresseDto adresseDto) throws Exception {
		
//		if(adresseDto==null) {
//			throw new NullPointerException("Attention adresse nulle");
//		}
//		Adresse adresse =new Adresse();
//		if(adresseDto.getNumero()<=0
//				|| adresseDto.getRue()==null || adresseDto.getRue().isEmpty()
//				|| adresseDto.getVille()==null || adresseDto.getVille().isEmpty()
//				|| adresseDto.getCodePostal()==null || adresseDto.getCodePostal().isEmpty()) {
//			throw new IllegalArgumentException("\"Tous les paramètres de l'adresse à ajouter sont obligatoires");
//		}
//		return adresseDao.add(adresse);
		return null;

		
		 
	}

	@Override
	public void updateAdresse(AdresseDto adresseDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAdresse(AdresseDto adresseDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Adresse> getAdresses(Class<Adresse> adresse, Integer UserId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse getAdresseById(AdresseDto adresseDto, Integer UserId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

