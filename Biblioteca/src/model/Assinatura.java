package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import model.validation.AssinaturaValidation;
import model.validation.Validation;

@Entity
public class Assinatura extends DefaultEntity<Assinatura> {

	private static final long serialVersionUID = 8937249987380812921L;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private double valor;

	@Column(nullable = false)
	private int duracao;

	@Column(nullable = false)
	private int limiteLivros;

	@OneToMany
	@JoinTable(name = "assinatura_livros", joinColumns = { @JoinColumn(name = "assinatura") }, inverseJoinColumns = {
			@JoinColumn(name = "livro") })
	private List<Livro> livro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getLimiteLivros() {
		return limiteLivros;
	}

	public void setLimiteLivros(int limiteLivros) {
		this.limiteLivros = limiteLivros;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

	@Override
	public Validation<Assinatura> getValidation() {
		return new AssinaturaValidation();
	}

}
