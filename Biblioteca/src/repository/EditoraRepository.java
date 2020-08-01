package repository;

import java.util.List;

import javax.persistence.Query;

import model.Editora;

public class EditoraRepository extends Repository<Editora> {

	public List<Editora> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Editora e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
	
	public boolean contains(Integer id, String nome) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  count(*) ");
		jpql.append("FROM ");
		jpql.append("  Editora e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) = upper(?) ");
		jpql.append("  AND e.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(jpql.toString());

		query.setParameter(1, nome);
		query.setParameter(2, id == null ? -1 : id);
		
		long resultado = (long) query.getSingleResult();
		
		return resultado == 0 ? false : true;
	}

}