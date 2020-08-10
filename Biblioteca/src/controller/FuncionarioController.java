package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.primefaces.event.SelectEvent;

import application.Util;
import controller.listing.FuncionarioListing;
import factory.JPAFactory;
import model.Telefone;
import model.TipoFuncionario;
import model.Usuario;
import model.Funcionario;

@Named
@ViewScoped
public class FuncionarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = 5133323995601528105L;

	private String filtro;
	private Funcionario funcionario;

	public void abrirFuncionarioListing() {
		FuncionarioListing listing = new FuncionarioListing();
		listing.open();
	}

	public void obterFuncionarioListing(SelectEvent event) {
		Funcionario entity = (Funcionario) event.getObject();
		setEntity(entity);

	}

	@Override
	public Funcionario getEntity() {
		if (entity == null) {
			entity = new Funcionario();
			entity.setTelefone(new Telefone());
		}
		return (Funcionario) entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	public TipoFuncionario[] getListaTipoFuncionario() {
		return TipoFuncionario.values();
	}
	
	@Override
	public void salvar() {
		EntityManager em = JPAFactory.getEntityManager();
		Query query = em.createQuery("Select f " + "From Funcionario f " + "Where f.cpf = :cpf");
		query.setParameter("cpf", getEntity().getCpf());
		try {
			funcionario = (Funcionario) query.getSingleResult();

		} catch (NoResultException e) {
			funcionario = null;
		}

		if (funcionario == null) {
			getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));
			super.salvar();
		} else
			Util.addMessageError("CPF já cadastrado");
	}
	
}