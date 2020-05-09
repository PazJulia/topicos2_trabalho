package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Usuario;

@Named
@ViewScoped
public class TemplateController implements Serializable {

	private static final long serialVersionUID = -1457991834290264968L;

	Usuario usuarioLogado = null;

	public TemplateController() {
		usuarioLogado = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
	}

	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("/Biblioteca/faces/login.xhtml");
	}

	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}

	/*
	 * public boolean bloquearAcesso(int perfil) {
	 * if(usuarioLogado.getPerfil().getValue() > perfil) return true; else return
	 * false; }
	 */

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}