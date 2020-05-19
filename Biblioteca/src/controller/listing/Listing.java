package controller.listing;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.primefaces.PrimeFaces;

import factory.JPAFactory;
import model.DefaultEntity;

public abstract class Listing<T extends DefaultEntity<T>> implements Serializable {

	private static final long serialVersionUID = -7070033221351552730L;

	private Class clazz = null;

	public Listing(Class clazz) {
		this.clazz = clazz;
	}

	public void select(int id) {
		EntityManager em = JPAFactory.getEntityManager();
		T entity = (T) em.find(clazz, id);
		PrimeFaces.current().dialog().closeDynamic(entity);
	}
}