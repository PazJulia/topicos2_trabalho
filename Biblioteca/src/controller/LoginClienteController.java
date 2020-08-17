package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import application.Session;
import application.Util;
import factory.JPAFactory;
import model.Cliente;

@Named
@RequestScoped
public class LoginClienteController {

	private Cliente cliente;

	public String entrar() {
		String senha = Util.hashSHA256(getCliente().getSenha());

//        System.out.println(senha);

		EntityManager em = JPAFactory.getEntityManager();
		Query query = em.createQuery("Select c " + "From Cliente c " + "Where c.email = :email AND f.senha = :senha");
		query.setParameter("senha", senha);
		query.setParameter("email", getCliente().getEmail());
		try {
			cliente = (Cliente) query.getSingleResult();

		} catch (NoResultException e) {
			cliente = null;
		}

		if (cliente != null) {
			// adicionando um ussuario na sessao
			Session.getInstance().setAttribute("clienteLogado", cliente);
			// redirecionando para o template
			System.out.println(
					"--------------------------------------- ENTROU ------------------------------------------");
			System.out.println(getCliente().getNome());
			return "pages/home.xhtml?faces-redirect=true";
		}
		Util.addMessageError("Login ou Senha inválido.");
		return "";
	}

	public Cliente getCliente() {
		if (cliente == null)
			cliente = new Cliente();
		return (Cliente) cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}