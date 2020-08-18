package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import model.Cliente;

@Named
@ViewScoped
public class TemplateClienteController implements Serializable {

	private static final long serialVersionUID = -626121591165374187L;

	private Cliente clienteLogado = null;
	private String filtro;
	private String valueMenu;
	private String buttonLogin;

	public Cliente getclienteLogado() {
		if (clienteLogado == null) // buscando o cliente da sessao
			clienteLogado = (Cliente) Session.getInstance().getAttribute("clienteLogado");
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
		if (getClienteLogado() == null) {
			return "logincliente.xhtml?faces-redirect=true";
		}
		// encerrando a sessao
		Session.getInstance().invalidateSession();
		return "home.xhtml?faces-redirect=true";
	}

//	public String pesquisar() {
////		LivroRepository repo = new LivroRepository();
////		setList(repo.findByNome(getFiltro()));
//		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
//		flash.put("buscaLivroFlash", getFiltro());
//		System.out.println("-------------------------------------------------------" + getFiltro()
//				+ "----------------------------------------");
//		return "buscalivros.xhtml?faces-redirect=true";
////		Util.redirect("/buscalivros.xhtml");
//	}

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
