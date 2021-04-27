package fr.doranco.ecommerce.model;

/**
 * Design pattern Façade appliqué aux entity uniquement pour les méthodes CRUD.
 * 
 * @author Edouard
 *
 */
public interface IEntityDao<T> {

	void add(T entity) throws Exception;
	T get(Class<T> entity, Integer id) throws Exception;
	void update(T entity) throws Exception;
	void remove(T entity) throws Exception;
}
