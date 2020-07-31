package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Autor extends DefaultEntity<Autor> {

	private static final long serialVersionUID = 439546259224348118L;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String biografia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	@Override
	public Validation<Autor> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
