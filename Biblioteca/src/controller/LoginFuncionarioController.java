package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import application.Session;
import application.Util;
import factory.JPAFactory;
import model.Funcionario;
import model.Usuario;

@Named
@ViewScoped
public class LoginFuncionarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = 5133323995601528105L;

	private String filtro;

	public String entrar() {
		String senha = Util.hashSHA256(getEntity().getSenha());

//        System.out.println(senha);

		EntityManager em = JPAFactory.getEntityManager();
		Query query = em.createQuery("Select f " + "From Funcionario f " + "Where f.cpf = :cpf AND f.senha = :senha");
		query.setParameter("senha", senha);
		query.setParameter("cpf", getEntity().getCpf());
		try {
			entity = (Funcionario) query.getSingleResult();

		} catch (NoResultException e) {
			entity = null;
		}

		if (entity != null) {
			// adicionando um ussuario na sessao
			Session.getInstance().setAttribute("usuarioLogado", entity);
			// redirecionando para o template
			return "livro.xhtml?faces-redirect=true";
		}
		Util.addMessageError("Login ou Senha inválido.");
		return "";
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	@Override
	public Funcionario getEntity() {
		if (entity == null)
			entity = new Funcionario();
		return (Funcionario) entity;
	}

}