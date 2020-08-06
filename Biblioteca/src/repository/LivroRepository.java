package repository;

import java.util.List;

import javax.persistence.Query;

import model.Livro;

public class LivroRepository extends Repository<Livro> {

	public List<Livro> findByNome(String nome) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  l ");
		jpql.append("FROM ");
		jpql.append("  Livro l ");
		jpql.append("WHERE ");
		jpql.append("  upper(l.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

}
