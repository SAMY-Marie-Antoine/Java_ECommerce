package fr.doranco.ecommerce.control;

/**
 * Design pattern Fa�ade appliqu� aux entity uniquement pour les m�thodes CRUD.
 * 
 * @author Edouard
 *
 */
public interface IEntity<T> {

	void add(T entity) throws Exception;
	T get(Class<T> entity, Integer id) throws Exception;
	void update(T entity) throws Exception;
	void remove(T entity) throws Exception;
}
