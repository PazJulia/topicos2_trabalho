package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Cliente;

@Named
@ViewScoped
public class TemplateClienteController implements Serializable {

	private static final long serialVersionUID = 7784074657498887753L;

	private Cliente clienteLogado = null;

	public Cliente getClienteLogado() {
		if (clienteLogado == null) // buscando o usuario da sessao
			clienteLogado = (Cliente) Session.getInstance().getAttribute("clienteLogado");
		return clienteLogado;
	}

	public void encerrarSessao() {
		// encerrando a sessao
		Session.getInstance().invalidateSession();
		Util.redirect("/faces/home.xhtml");
		// return "login.xhtml?faces-redirect=true";
	}

}
