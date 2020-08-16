package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.ClienteValidation;
import model.validation.Validation;

@Entity
public class Cliente extends Usuario {

	private static final long serialVersionUID = 7134203118169711072L;

	@Column
	private String nomePortador;

	@Column
	private int numero;

	@Column
	private String dataValidade;

	@Column
	private String codigoSeguranca;

	public String getNomePortador() {
		return nomePortador;
	}

	public void setNomePortador(String nomePortador) {
		this.nomePortador = nomePortador;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	@Override
	public Validation<Usuario> getValidation() {
		return new ClienteValidation();
	}

}
