package model;

import javax.persistence.Column;
import javax.persistence.Entity;

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

}
