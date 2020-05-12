package controller.listing;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.primefaces.PrimeFaces;

import factory.JPAFactory;
import model.DefaultEntity;

public abstract class Listing<T extends DefaultEntity<T>> implements Serializable {

	private static final long serialVersionUID = -7070033221351552730L;

	protected T entity;

	public abstract T getEntity();

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public void select(int id) {
		EntityManager em = JPAFactory.getEntityManager();
		setEntity((T) em.find(getEntity().getClass(), id));
		PrimeFaces.current().dialog().closeDynamic(getEntity());
	}

}