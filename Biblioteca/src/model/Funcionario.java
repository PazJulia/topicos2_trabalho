package model;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Usuario {

	private static final long serialVersionUID = 2401472471190987126L;

	private TipoFuncionario tipoFuncionario;

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

}
