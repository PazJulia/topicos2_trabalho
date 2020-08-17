package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Livro;
import repository.LivroRepository;

@Named
@ViewScoped
public class LivroListing extends Listing<Livro> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Livro> list;
	private String filtro;

	private Livro livro;
	private Integer id;

	public LivroListing() {
		super(Livro.class);
	}

	public void open() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", true);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("width", 800);
		options.put("height", 500);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		// ligacao com a pagina xhtml
		PrimeFaces.current().dialog().openDynamic("livrolisting", options, null);
	}

	public void pesquisar() {
		LivroRepository repo = new LivroRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public void carregarLivro() {
		LivroRepository repo = new LivroRepository();
		setLivro(repo.findById(getId()));
	}

//	public List<Livro> getList(int num) {
//		if (list == null) {
//			LivroRepository repo = new LivroRepository();
//			list = repo.findLastResults(num);
//		}
//		return list;
//	}

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

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}