package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Util;
import model.Cliente;
import model.Telefone;
import model.Usuario;

@Named
@ViewScoped
public class ClienteController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = -8195453313820302773L;
	private String filtro;

	@Override
	public Cliente getEntity() {
		if (entity == null) {
			entity = new Cliente();
			entity.setTelefone(new Telefone());
		}
		return (Cliente) entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	@Override
	public void salvar() {
		getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));
		super.salvar();

	}

}
