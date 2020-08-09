package repository;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;

import application.RepositoryException;
import application.ValidationException;
import application.VersionException;
import factory.JPAFactory;
import model.DefaultEntity;

public class Repository<T extends DefaultEntity<T>> {

	private EntityManager entityManager;

	public Repository() {
		entityManager = JPAFactory.getEntityManager();
	}

	public Repository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void beginTransaction() throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao iniciar uma transação");
		}
	}

	public void commitTransaction() throws RepositoryException {
		try {
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao comitar uma transação");
		}
	}

	public void rollbackTransaction() {
		try {
			getEntityManager().getTransaction().rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T salvar(T entity) throws RepositoryException, ValidationException, VersionException {
		try {
			if (entity.getValidation() != null)
				entity.getValidation().validate(entity);

			return getEntityManager().merge(entity);
		} catch (ValidationException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;

		} catch (OptimisticLockException e) {
			e.printStackTrace();
			throw new VersionException("Versão antiga. Erro de controle de concorrência.");
		} catch (Exception e) {
			System.out.println("Erro no repositorio " + "ao executar o método merge.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao salvar.");
		}
	}

	public void excluir(T entity) throws RepositoryException {
		try {
			T obj = getEntityManager().merge(entity);
			getEntityManager().remove(obj);
		} catch (Exception e) {
			System.out.println("Erro no repositorio " + "ao executar o método merge.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao salvar.");
		}
	}

	public T findById(Integer id) {
		// obtendo o tipo da classe de forma generica (a classe deve ser publica)
		final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		Class<T> theType = (Class<T>) (type).getActualTypeArguments()[0];

		// pesquisando pelo id no banco
		T t = (T) getEntityManager().find(theType, id);

		return t;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
