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
	
//	public List<Livro> getAllResults(){
//		StringBuffer jpql = new StringBuffer();
//		jpql.append("SELECT * FROM Livro l");
//		
//		Query query = getEntityManager().createQuery(jpql.toString());
//
//		return query.getResultList();
//		
//	}

	public List<Livro> findLastResults(int num) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT l FROM Livro l ORDER BY l.id desc");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setMaxResults(num).getResultList();
		
		return query.getResultList();

	}

}
