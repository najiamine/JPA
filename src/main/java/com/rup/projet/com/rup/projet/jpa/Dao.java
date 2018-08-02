package com.rup.projet.com.rup.projet.jpa;
import javax.persistence.EntityManager;

public class Dao<T,I> {

	EntityManager em;
	private Class<T> persistentClass;
	
	public Dao(EntityManager entityManagerparam, Class<T> entityClassParam) {
		this.em = entityManagerparam;
		this.persistentClass = entityClassParam;
	}
	
	public void creer (T entity) {
		em.persist(entity);
	}
	
	public void modifier(T entity) {
		em.merge(entity);
	}
	
	public void supprimerByid(int id) {
		T e = em.find(persistentClass, id);
		em.remove(e);
//		em.merge(entity.);
//		em.remove(entity);
	
	}
	public void supprimer(T entity) {
		em.merge(entity);
		em.remove(entity);
	}
	
	public T rechercherParPk(I id) {
		return (T) em.find(persistentClass, id);
	}
}