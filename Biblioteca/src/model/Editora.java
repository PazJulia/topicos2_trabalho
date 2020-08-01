package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Editora extends DefaultEntity<Editora> {

	private static final long serialVersionUID = 2354921893450594870L;

	@Column(nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Validation<Editora> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
