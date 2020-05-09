package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import application.Util;
import factory.JPAFactory;
import model.Usuario;
import org.apache.commons.codec.digest.DigestUtils;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = 5133323995601528105L;

	private Usuario usuario;

	private String filtro;

	private List<Usuario> listaUsuario;

	public void pesquisar() {
		EntityManager em = JPAFactory.getEntityManager();
		Query query = em.createQuery("Select a " + "From Usuario a " + "Where upper(a.nome) like upper(:filtro)");
		query.setParameter("filtro", "%" + getFiltro() + "%");
		listaUsuario = query.getResultList();
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null)
			listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	@Override
	public void salvar() {
		EntityManager em = JPAFactory.getEntityManager();
		Query query = em.createQuery("Select a " + "From Usuario a " + "Where a.cpf = :cpf");
		query.setParameter("cpf", getEntity().getCpf());
		try {
			usuario = (Usuario) query.getSingleResult();

		} catch (NoResultException e) {
			usuario = null;
		}

		if (usuario == null) {
			getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));
			super.salvar();
		} else
			Util.addMessageError("CPF já cadastrado");
	}
}