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
	
	public boolean containsCpf(Integer id, String cpf) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  count(*) ");
		jpql.append("FROM ");
		jpql.append("  Usuario u ");
		jpql.append("WHERE ");
		jpql.append("  upper(u.cpf) = upper(?) ");
		jpql.append("  AND u.id <> ? ");
		
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
		jpql.append("  Usuario u ");
		jpql.append("WHERE ");
		jpql.append("  upper(u.cpf) = upper(?) ");
		jpql.append("  AND u.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(jpql.toString());

		query.setParameter(1, email);
		query.setParameter(2, id == null ? -1 : id);
		
		long resultado = (long) query.getSingleResult();
		
		return resultado == 0 ? false : true;
	}

}
