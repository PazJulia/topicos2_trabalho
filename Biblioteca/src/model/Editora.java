package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Editora extends DefaultEntity<Editora> {

	private static final long serialVersionUID = 1471479631201462836L;

	@Column(length = 100, nullable = false)
	private String nome;

	@Override
	public Validation<Editora> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
