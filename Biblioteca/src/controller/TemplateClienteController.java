//package controller;
//
//import java.io.Serializable;
//
//import javax.faces.view.ViewScoped;
//import javax.inject.Named;
//
//import application.Session;
//import application.Util;
//import model.Cliente;
//
//@Named
//@ViewScoped
//public class TemplateClienteController implements Serializable {
//
//	private static final long serialVersionUID = 7784074657498887753L;
//
//	private Cliente clienteLogado = null;
//
//	public Cliente getClienteLogado() {
//		if (clienteLogado == null) // buscando o usuario da sessao
//			clienteLogado = (Cliente) Session.getInstance().getAttribute("clienteLogado");
//		return clienteLogado;
//	}
//
//	public void encerrarSessao() {
//		// encerrando a sessao
//		Session.getInstance().invalidateSession();
//		Util.redirect("/faces/home.xhtml");
//		// return "login.xhtml?faces-redirect=true";
//	}
//
//}

package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Cliente;
import model.Livro;
import repository.LivroRepository;

@Named
@ViewScoped
public class TemplateClienteController implements Serializable {

	private static final long serialVersionUID = -626121591165374187L;

	private Cliente clienteLogado = null;

	private List<Livro> list;
	private String filtro;
	private String value = "Entre ou cadastre-se";

	public Cliente getUsuarioLogado() {
		if (clienteLogado == null) // buscando o cliente da sessao
			clienteLogado = (Cliente) Session.getInstance().getAttribute("clienteLogado");
		return clienteLogado;
	}

	public String getValue() {
		if (clienteLogado == null) // buscando o cliente da sessao
			clienteLogado = (Cliente) Session.getInstance().getAttribute("clienteLogado");
		value = "Ol�" + clienteLogado;
		return value;
	}

	public void encerrarSessao() {
		// encerrando a sessao
		Session.getInstance().invalidateSession();
		Util.redirect("/faces/home.xhtml");
		// return "login.xhtml?faces-redirect=true";
	}

	public void pesquisar() {
		LivroRepository repo = new LivroRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public List<Livro> getList() {
		if (list == null)
			list = new ArrayList<Livro>();
		return list;
	}

	public void setList(List<Livro> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
