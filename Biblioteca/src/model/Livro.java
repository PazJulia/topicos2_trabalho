package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import model.validation.Validation;

@Entity
public class Livro extends DefaultEntity<Livro> {

	private static final long serialVersionUID = 9147264971483299923L;

	@ManyToOne
	@JoinColumn(name = "ideditora"/* , nullable = false */)
	private Editora editora;

	@ManyToMany
	@JoinTable(name = "livro_autores", joinColumns = { @JoinColumn(name = "livro") }, inverseJoinColumns = {
			@JoinColumn(name = "autor") })
	private List<Autor> autor;

	@Column(nullable = false)
	private String isbn;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column
	private String descricao;

	@Column(nullable = false)
	private Double preco;

	@Column(nullable = false)
	private Date dataLancamento;

	@Column(nullable = false)
	private String genero;

	@Column(nullable = false)
	private int classificacaoIndicativa;

	@Column(nullable = false)
	private String edicao;

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public List<Autor> getAutor() {
		return autor;
	}

	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}

	@Override
	public Validation<Livro> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}
}
