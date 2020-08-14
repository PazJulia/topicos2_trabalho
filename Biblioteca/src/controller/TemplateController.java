package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Funcionario;

@Named
@ViewScoped
public class TemplateController implements Serializable {

	private static final long serialVersionUID = -2759978810312866073L;
	private Funcionario usuarioLogado = null;

	public Funcionario getUsuarioLogado() {
		if (usuarioLogado == null) // buscando o usuario da sessao
			usuarioLogado = (Funcionario) Session.getInstance().getAttribute("usuarioLogado");
		return usuarioLogado;
	}

	public void encerrarSessao() {
		// encerrando a sessao
		Session.getInstance().invalidateSession();
		Util.redirect("/faces/loginfuncionario.xhtml");
		// return "login.xhtml?faces-redirect=true";
	}

}