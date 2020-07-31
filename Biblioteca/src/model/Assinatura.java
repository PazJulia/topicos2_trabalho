package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import model.validation.AssinaturaValidation;
import model.validation.Validation;

@Entity
public class Assinatura extends DefaultEntity<Assinatura> {

	private static final long serialVersionUID = -8635505795159660447L;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private double valor;

	@Column(nullable = false)
	private int duracao;

	@Column(nullable = false)
	private int limiteLivros;

	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(nullable = false) private List<Livro> livros;
	 */

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

	/*
	 * public List<Livro> getLivros() { return livros; }
	 * 
	 * public void setLivros(List<Livro> livros) { this.livros = livros; }
	 */

	@Override
	public Validation<Assinatura> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}



}
