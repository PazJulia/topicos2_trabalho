package repository;

import java.util.List;

import javax.persistence.Query;

import model.Cliente;
import model.Usuario;

public class ClienteRepository extends Repository<Usuario> {

	public List<Cliente> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" c ");
		jpql.append("FROM ");
		jpql.append(" Cliente c ");
		jpql.append("WHERE ");
		jpql.append(" upper(c.nome) like upper(:nome)");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

	public boolean containsCpf(Integer id, String cpf) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  count(*) ");
		jpql.append("FROM ");
		jpql.append("  Cliente c ");
		jpql.append("WHERE ");
		jpql.append("  upper(c.cpf) = upper(?) ");
		jpql.append("  AND c.id <> ? ");

		Query query = getEntityManager().createNativeQuery(jpql.toString());

		query.setParameter(1, cpf);
		query.setParameter(2, id == null ? -1 : id);

		long resultado = (long) query.getSingleResult();

		return resultado == 0 ? false : true;
	}

	public boolean containsEmail(Integer id, String email) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  count(*) ");
		jpql.append("FROM ");
		jpql.append("  Cliente c ");
		jpql.append("WHERE ");
		jpql.append("  upper(c.email) = upper(?) ");
		jpql.append("  AND c.id <> ? ");

		Query query = getEntityManager().createNativeQuery(jpql.toString());

		query.setParameter(1, email);
		query.setParameter(2, id == null ? -1 : id);

		long resultado = (long) query.getSingleResult();

		return resultado == 0 ? false : true;
	}
}
