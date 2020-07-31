package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.primefaces.event.SelectEvent;

import application.Util;
import controller.listing.UsuarioListing;
import factory.JPAFactory;
import model.Telefone;
import model.Usuario;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = 5133323995601528105L;

	private String filtro;
	private Usuario usuario;

	public void abrirUsuarioListing() {
		UsuarioListing listing = new UsuarioListing();
		listing.open();
	}

	public void obterUsuarioListing(SelectEvent event) {
		Usuario entity = (Usuario) event.getObject();
		setEntity(entity);

	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
			entity.setTelefone(new Telefone());
		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
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