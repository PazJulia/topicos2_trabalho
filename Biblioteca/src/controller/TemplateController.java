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

	private static final long serialVersionUID = -1457991834290264968L;

	private Funcionario usuarioLogado = null;

	public Funcionario getUsuarioLogado() {
		if (usuarioLogado == null) // buscando o usuario da sessao
			usuarioLogado = (Funcionario) Session.getInstance().getAttribute("usuarioLogado");
		return usuarioLogado;
	}

	public String encerrarSessao() {
		// encerrando a sessao
		Session.getInstance().invalidateSession();
		return "loginfuncionario.xhtml?faces-redirect=true";
	}

	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}

	/*
	 * public boolean bloquearAcesso(int perfil) {
	 * if(usuarioLogado.getPerfil().getValue() > perfil) return true; else return
	 * false; }
	 */

}