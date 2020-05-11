package repository;

import java.util.List;

import javax.persistence.Query;

import model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	public List<Usuario> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Usuario u ");
		jpql.append("WHERE ");
		jpql.append(" upper(u.nome) like upper(:nome)");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}

}
