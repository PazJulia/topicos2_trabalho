package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	private JPAFactory() {
		// garante que a classe não possa ser instanciada
	}

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Professor");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
