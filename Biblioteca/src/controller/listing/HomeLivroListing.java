package controller.listing;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Livro;
import repository.LivroRepository;

@Named
@ViewScoped
public class HomeLivroListing extends Listing<Livro> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Livro> list;
	private String filtro;

	public HomeLivroListing() {
		super(Livro.class);
	}

	public void pesquisar() {
		LivroRepository repo = new LivroRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public List<Livro> getList() {
		if (list == null)
			list = new ArrayList<Livro>();
		return list;
	}

	public void setList(List<Livro> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
}