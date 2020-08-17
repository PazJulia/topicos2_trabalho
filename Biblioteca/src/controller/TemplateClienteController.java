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
	private String valueMenu;
//	private String conta;
//	private String assinatura;
//	private String livros;
	private String buttonLogin;

	public Cliente getclienteLogado() {
		if (clienteLogado == null) // buscando o cliente da sessao
			clienteLogado = (Cliente) Session.getInstance().getAttribute("usuarioLogado");
		return clienteLogado;
	}

	public String getValueMenu() {
		if (getclienteLogado() == null) // buscando o cliente da sessao
		{
			setButtonLogin("Login ou cadastro");
			return "Entre ou cadastre-se";
		}
		setButtonLogin("Sair");
		return getclienteLogado().getNome();
	}

	public String buttonAction() {
		if(getClienteLogado() == null) {
			return "logincliente.xhtml?faces-redirect=true";
		}
		// encerrando a sessao
		Session.getInstance().invalidateSession();
		return "home.xhtml?faces-redirect=true";

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

	public Cliente getClienteLogado() {
		return clienteLogado;
	}

	public void setClienteLogado(Cliente clienteLogado) {
		this.clienteLogado = clienteLogado;
	}

	public String getButtonLogin() {
		return buttonLogin;
	}

	public void setButtonLogin(String buttonLogin) {
		this.buttonLogin = buttonLogin;
	}

}
