package repository;

import java.util.List;

import javax.persistence.Query;

import model.Editora;

public class EditoraRepository extends Repository<Editora> {

	public List<Editora> findByNome(String nome) {
		return findByNome(nome, null);
	}
	
	public List<Editora> findByNome(String nome, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Editora e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) like upper(:nome) ");
		jpql.append("ORDER BY e.nome ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		if (maxResults != null && maxResults > 0 )
			query.setMaxResults(maxResults);

		return query.getResultList();
	}
	
}
