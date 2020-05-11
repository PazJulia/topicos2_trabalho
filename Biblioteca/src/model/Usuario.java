package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;


@Entity
public class Usuario extends DefaultEntity<Usuario> {

	private static final long serialVersionUID = 8808841694013495869L;

	@Column(length = 100, nullable = false)
	private String nome;

	@CPF(message = "CPF inválido")
	@Column(length = 14, nullable = false)
	private String cpf;

	@Column(length = 256, nullable = false)
	private String senha;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;

	@Column(length = 120)
	private String email;

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
