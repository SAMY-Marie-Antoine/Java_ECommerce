package fr.doranco.ecommerce.main;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.model.AdresseDao;
import fr.doranco.ecommerce.model.ArticleDao;
import fr.doranco.ecommerce.model.IAdresseDao;
import fr.doranco.ecommerce.model.IArticleDao;

public class Main {

	public static void main(String[] args) {

		try {

			IArticleDao articleDao = new ArticleDao();
			
			Adresse a =new Adresse(1,"rue de paris","75000","paris");
			
			IAdresseDao adr=new AdresseDao();
			adr.add(a);
			
			System.out.println(a);
			
			System.exit(0);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
