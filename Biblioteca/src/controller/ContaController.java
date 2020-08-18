package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Cliente;
import model.Usuario;

@Named
@RequestScoped
public class ContaController extends Controller<Usuario> {

	private static final long serialVersionUID = -4599218855297469816L;
	private Cliente clienteLogado;

	public Cliente getclienteLogado() {
		if (clienteLogado == null) // buscando o cliente da sessao
			clienteLogado = (Cliente) Session.getInstance().getAttribute("clienteLogado");
		return clienteLogado;
	}

	@Override
	public Cliente getEntity() {
		// TODO Auto-generated method stub
		return getclienteLogado();
	}

	@Override
	public void salvar() {
		if (getEntity().getCodigoSeguranca() == null) {
			getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));
			super.salvar();
			return;
		}

		getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));
		getEntity().setCodigoSeguranca(Util.hashSHA256(getEntity().getCodigoSeguranca()));
		super.salvar();

	}

}
