package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import application.Session;
import application.Util;
import factory.JPAFactory;
import model.Funcionario;

@Named
@RequestScoped
public class LoginFuncionarioController {

	private Funcionario funcionario;

	public String entrar() {
		String senha = Util.hashSHA256(getFuncionario().getSenha());

//        System.out.println(senha);

		EntityManager em = JPAFactory.getEntityManager();
		Query query = em.createQuery("Select f " + "From Funcionario f " + "Where f.cpf = :cpf AND f.senha = :senha");
		query.setParameter("senha", senha);
		query.setParameter("cpf", getFuncionario().getCpf());
		try {
			funcionario = (Funcionario) query.getSingleResult();

		} catch (NoResultException e) {
			funcionario = null;
		}

		if (funcionario != null) {
			// adicionando um ussuario na sessao
			Session.getInstance().setAttribute("usuarioLogado", funcionario);
			// redirecionando para o template
			System.out.println(
					"--------------------------------------- ENTROU ------------------------------------------");
			System.out.println(getFuncionario().getNome());
			return "pages/livro.xhtml?faces-redirect=true";
		}
		Util.addMessageError("Login ou Senha inválido.");
		return "";
	}

	public Funcionario getFuncionario() {
		if (funcionario == null)
			funcionario = new Funcionario();
		return (Funcionario) funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}