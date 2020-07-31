package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Telefone extends DefaultEntity<Telefone> {

	private static final long serialVersionUID = 7068330278249761839L;

	private String ddd;

	private String numero;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public Validation<Telefone> getValidation() {
		return null;
	}

}
